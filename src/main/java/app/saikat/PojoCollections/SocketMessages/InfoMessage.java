package app.saikat.PojoCollections.SocketMessages;

public class InfoMessage {

    private Context context;
    private String title;
    private String message;


    public InfoMessage() {
    }

    public InfoMessage(Context context, String title, String message) {
        this.context = context;
        this.title = title;
        this.message = message;
    }

    public Context getContext() {
        return this.context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public InfoMessage context(Context context) {
        this.context = context;
        return this;
    }

    public InfoMessage title(String title) {
        this.title = title;
        return this;
    }

    public InfoMessage message(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " context='" + getContext() + "'" +
            ", title='" + getTitle() + "'" +
            ", message='" + getMessage() + "'" +
            "}";
    }

}