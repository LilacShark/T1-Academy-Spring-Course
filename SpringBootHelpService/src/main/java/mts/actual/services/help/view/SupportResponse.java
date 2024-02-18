package mts.actual.services.help.view;

import org.springframework.http.HttpStatus;

public class SupportResponse {

    private String response;
    private HttpStatus status;

    public SupportResponse(String response, HttpStatus status) {
        this.response = response;
        this.status = status;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getResponse() {
        return response;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
