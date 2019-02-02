package entity;

import entity.HttpMethod;

import java.util.Map;

public class Request {
    private HttpMethod method;
    private String uri;
    private Map<String, String> headers;

    public Request() {
    }

    public Request(HttpMethod method, String uri, Map<String, String> headers) {
        this.method = method;
        this.uri = uri;
        this.headers = headers;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("entity.Request{");
        stringBuilder.append("method='").append(method).append('\'');
        stringBuilder.append(", uri='").append(uri).append('\'');
        stringBuilder.append("}\n").append(headers).append("\n");
        return stringBuilder.toString();
    }
}