package app.saikat.UrlManagement;

import java.util.HashMap;
import java.util.Map;

import app.saikat.ConfigurationManagement.Gson.Exclude;
import app.saikat.ConfigurationManagement.Gson.PostProcessable;

public class UrlManager implements PostProcessable {

    private Map<String, String> baseHttpUrls;
    private Map<String, String> baseSocketUrls;
    private String baseHttpUrl;
    private String baseSocketUrl;

    @Exclude
    private String base_http_url;

    @Exclude
    private String base_socket_url;

    public String getHttpUrl(Url url) {
        return base_http_url.concat(url.getPath());
    }

    public String getSocketUrl(String url) throws UrlNotDefinedException {
        return base_socket_url.concat(url);
    }

    private String checkedGet(String base, Map<String, String> map) throws UrlNotDefinedException {
        if (base != null) {
            String val = map.get(base);
            if (val != null) {
                return val;
            }
        }
        throw new UrlNotDefinedException(base);
    }

    public static UrlManager getDefault() {
        UrlManager url = new UrlManager();

        url.baseHttpUrls = new HashMap<>();
        url.baseHttpUrls.put("REMOTE", "https://saikat.app");
        url.baseHttpUrls.put("LOCAL", "http://192.168.100.2");
        url.baseHttpUrls.put("SELF", "http://127.0.0.1");

        url.baseSocketUrls = new HashMap<>();
        url.baseSocketUrls.put("REMOTE", "wss://saikat.app");
        url.baseSocketUrls.put("LOCAL", "ws://192.168.100.2");
        url.baseSocketUrls.put("SELF", "ws://127.0.0.1");

        url.baseHttpUrl = "REMOTE";
        url.baseSocketUrl = "REMOTE";

        url.postProcess();

        return url;
    }

    @Override
    public void postProcess() {
        try {
            base_http_url = checkedGet(baseHttpUrl, baseHttpUrls);
            base_socket_url = checkedGet(baseSocketUrl, baseSocketUrls);
        } catch (UrlNotDefinedException e) {
            e.printStackTrace();
        }
    }
}