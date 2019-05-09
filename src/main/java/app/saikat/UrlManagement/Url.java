package app.saikat.UrlManagement;

import app.saikat.ConfigurationManagement.impl.ConfigFile.JsonClassAdapter;
import app.saikat.UrlManagement.ResponseModels.*;
import com.google.gson.annotations.JsonAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class Url {

    private static Logger logger = LoggerFactory.getLogger(Url.class.getSimpleName());

    private static class Http {
        String url;

        @JsonAdapter(JsonClassAdapter.class)
        Class response;
    }

    private Map<String, Http> httpUrlList;
    private Map<String, String> baseHttpList;
    private Map<String, String> baseSocketList;
    private String baseHttpUrl;
    private String baseSocketUrl;

    Url() {
        this.httpUrlList = new HashMap<>();
        this.baseHttpList = new HashMap<>();
        this.baseSocketList = new HashMap<>();
    }

    public String get(String key) throws UrlNotDefinedException {
        validateUrlNotNull(this.baseHttpUrl);
        validateValueNotNull(key, "Url, response", httpUrlList);
        validateValueNotNull(this.baseHttpUrl, "Base http url", baseHttpList);
        String url = this.httpUrlList.get(key).url;
        String baseUrl = this.baseHttpList.get(this.baseHttpUrl);
        validateUrlNotNull(url);
        return baseUrl.concat(url);
    }

    public Class getResponseClass(String key) {
        validateValueNotNull(key, "Url, response", httpUrlList);
        return this.httpUrlList.get(key).response;
    }

    public String getbaseSocketUrl() throws UrlNotDefinedException {
        validateUrlNotNull(this.baseSocketUrl);
        validateValueNotNull(baseSocketUrl, "Socket base url", baseSocketList);
        return this.baseSocketList.get(baseSocketUrl);
    }

    public void changeHttpBaseUrl(String newBaseUrl) {
        logger.warn("Changing http baseUrl to: {}", newBaseUrl);
        validateValueNotNull(newBaseUrl, "Http base url", baseHttpList);
        this.baseHttpUrl = newBaseUrl;
    }

    public void changeBaseSocketUrl(String baseSocketUrl) {
        logger.warn("Changing websocket baseUrl to: {}", baseSocketUrl);
        validateValueNotNull(baseSocketUrl, "Websocket base url", baseSocketList);
        this.baseSocketUrl = baseSocketUrl;
    }

    public void updateUrl(String urlName, String url, Class responseClass) {
        logger.warn("Url {} is updated. New urlString: {}, responseClass: {}", urlName, url, responseClass.getSimpleName());
        Http http = new Http();
        http.url = url;
        http.response = responseClass;

        this.httpUrlList.put(urlName, http);
    }

    private void validateUrlNotNull(String url) throws UrlNotDefinedException {
        if (url == null || url.length() == 0) {
            throw new UrlNotDefinedException(url);
        }
    }

    private void validateValueNotNull(String key, String objectName, Map<String, ?> map) {
        if (map.get(key) == null) {
            throw new NullPointerException(String.format("%s associated with key %s is null/empty", 
            objectName, key));
        }
    }

    public static Url getDefault() {
        Url url = new Url();

        url.baseHttpList.put("REMOTE", "https://saikat.app");
        url.baseHttpList.put("LOCAL", "http://192.168.100.2");
        url.baseHttpList.put("SELF", "http://127.0.0.1");

        url.baseSocketList.put("REMOTE", "wss://saikat.app");
        url.baseSocketList.put("LOCAL", "ws://192.168.100.2");
        url.baseSocketList.put("SELF", "ws://127.0.0.1");

        url.baseHttpUrl = "REMOTE";
        url.baseSocketUrl = "REMOTE";

        url.updateUrl("login", "/login", Login.class);
        url.updateUrl("logout", "/logout", Login.class);
        url.updateUrl("loggedInUser", "/getLoggedInUser", LoginStatus.class);
        return url;
    }
}
