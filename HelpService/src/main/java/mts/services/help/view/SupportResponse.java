package mts.services.help.view;

public class SupportResponse {

    private String supportPhrase;
    private String error;

    public SupportResponse(String supportPhrase) {
        this.supportPhrase = supportPhrase;
    }

    public void setSupportPhrase(String supportPhrase) {
        this.supportPhrase = supportPhrase;
    }

    public void setError(String error) {
        this.error = error;
    }
}
