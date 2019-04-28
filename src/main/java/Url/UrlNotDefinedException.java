package Url;

public class UrlNotDefinedException extends Exception{

    public UrlNotDefinedException(String url) {
        super(String.format("%s url is not defined.", url));
    }
}
