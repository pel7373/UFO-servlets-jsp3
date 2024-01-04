package ufo.answers;

public class Answer {
    private String message;
    private String page;

    public Answer(String message, String page) {
        this.message = message;
        this.page = page;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
