package app.saikat.PojoCollections;

public class UrlNotDefinedException extends Exception{

    private static final long serialVersionUID = 1L;

    public UrlNotDefinedException(String url) {
        super(String.format("%s url is not defined.", url));
    }
}
