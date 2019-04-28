package Url;

public enum BaseUrl {
    REMOTE("https://saikat.app"),
    LOCAL("http://192.168.100.2"),
    SELF("https://127.0.0.1");

    private final String url;

    BaseUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }
}
