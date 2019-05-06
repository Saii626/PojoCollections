package app.saikat.UrlManagement;

public class UrlNotDefinedException extends Exception{

    public UrlNotDefinedException(String url) {
        super(String.format("%s url is not defined.", url));
    }
}
