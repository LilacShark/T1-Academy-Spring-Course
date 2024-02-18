package mts.actual.services.help.view;

public class SupportResponse {

    private String supportPhrase;
    private String status;

    public SupportResponse(String supportPhrase, String status) {
        this.supportPhrase = supportPhrase;
        this.status = status;
    }

    public void setSupportPhrase(String supportPhrase) {
        this.supportPhrase = supportPhrase;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSupportPhrase() {
        return supportPhrase;
    }

    public String getStatus() {
        return status;
    }
}
