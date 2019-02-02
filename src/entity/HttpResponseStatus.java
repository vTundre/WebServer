package entity;

public enum HttpResponseStatus {
    OK(200, "OK"),
    NOT_FOUND(404, "Not Found"),
    BAD_REQUEST(400, "Bad Request"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private static final String PROTOCOL = "HTTP/1.1";
    private final int code;
    private final String status;

    HttpResponseStatus(int code, String status){
        this.code = code;
        this.status = status;
    }

    public String getResponseStatus(){
        return PROTOCOL + " " + code + " " + status + "\n\n";
    }

    public int getCode(){
        return code;
    }

    public String getStatus(){
        return status;
    }
}
