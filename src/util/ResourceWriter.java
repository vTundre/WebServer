package util;

import entity.HttpResponseStatus;
import exception.ServerException;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;

public class ResourceWriter {
    BufferedOutputStream bufferedOutputStream;

    public ResourceWriter(BufferedOutputStream bufferedOutputStream) {
        this.bufferedOutputStream = bufferedOutputStream;
    }

    public void writeContent(String uri) {
        try (FileInputStream inputStream = new FileInputStream(uri)) {
            inputStream.transferTo(bufferedOutputStream);
        } catch (Exception e) {
            throw new ServerException(HttpResponseStatus.NOT_FOUND);
        }
    }

}
