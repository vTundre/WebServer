package exception;
import entity.HttpResponseStatus;

public class ServerException extends RuntimeException {
    private HttpResponseStatus httpResponseStatus;

    public ServerException(HttpResponseStatus httpResponseStatus) {
        this.httpResponseStatus = httpResponseStatus;
    }

    @Override
    public String getMessage() {
        return httpResponseStatus.getResponseStatus();
    }
}
