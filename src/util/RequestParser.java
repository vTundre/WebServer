package util;

import entity.HttpMethod;
import entity.HttpResponseStatus;
import entity.Request;
import exception.ServerException;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RequestParser {

    public Request parse(BufferedReader bufferedReader) {
        try {
            Request request = new Request();
            String requestStartingLine = bufferedReader.readLine();
            injectUriAndMethod(request, requestStartingLine);
            injectHeaders(request, bufferedReader);
            return request;
        } catch (Exception e) {
            throw new ServerException(HttpResponseStatus.BAD_REQUEST);
        }
    }

    private void injectUriAndMethod(Request request, String requestStartingLine) {
        String[] split = requestStartingLine.split(" ");
        request.setMethod(HttpMethod.getByName(split[0]));
        request.setUri(split[1]);
    }

    private void injectHeaders(Request request, BufferedReader bufferedReader) throws IOException {
        Map<String, String> headers = new HashMap();
        String nextLine;
        while (!(nextLine = bufferedReader.readLine()).isEmpty()) {
            String[] split = nextLine.split(":");
            headers.put(split[0], split[1]);
        }
        request.setHeaders(headers);
    }
}