package mts.services.help.view;

public class SupportRequest {

    private String supportPhrase;

    public SupportRequest(String supportPhrase) {
        this.supportPhrase = supportPhrase;
    }

    public String getSupportPhrase() {
        return supportPhrase;
    }

    public void setSupportPhrase(String supportPhrase) {
        this.supportPhrase = supportPhrase;
    }

}
