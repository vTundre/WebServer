package server;

import entity.HttpResponseStatus;
import entity.Request;
import util.RequestParser;
import util.ResourceWriter;
import exception.ServerException;

import java.io.*;
import java.net.Socket;

public class RequestHandler {
    private Socket socket;
    private String webAppPath;

    RequestHandler(Socket socket, String webAppPath) {
        this.socket = socket;
        this.webAppPath = webAppPath;
    }

    public void run() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream())
        ) {
            try {
                //read and parse request
                RequestParser requestParser = new RequestParser();
                Request request = requestParser.parse(bufferedReader);
                System.out.println(request);

                //prepare and write response
                bufferedWriter.write(HttpResponseStatus.OK.getResponseStatus());
                ResourceWriter resourceWriter = new ResourceWriter(bufferedOutputStream);
                resourceWriter.writeContent(webAppPath + request.getUri());

            } catch (ServerException e) {
                bufferedWriter.write(e.getMessage());
            } catch (Exception e) {
                bufferedWriter.write(HttpResponseStatus.INTERNAL_SERVER_ERROR.getResponseStatus());
            } finally {
                bufferedWriter.flush();
                bufferedOutputStream.close();
                bufferedWriter.close();
            }
        } catch (
                Exception e) {
            e.printStackTrace();
        }

    }
}
