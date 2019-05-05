package Url;

import ConfigurationManagement.impl.ConfigFile.JsonClassAdapter;
import ResponseModels.Login;
import ResponseModels.LoginStatus;
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

    public Url() {
        logger.debug("Creating new Url class");
        this.httpUrlMap = new HashMap<>();
        this.base_url = BaseUrl.REMOTE;
    }

    private Map<String, Http> httpUrlMap;
    private BaseUrl base_url;

    public String get(String key) throws UrlNotDefinedException {
        validateUrlNotNull(this.base_url.getUrl());
        validateNotNull(key, this.httpUrlMap.get(key));
        String url = this.httpUrlMap.get(key).url;
        validateUrlNotNull(url);
        return this.base_url.getUrl().concat(url);
    }

    public Class getResponseClass(String key) {
        validateNotNull(key, this.httpUrlMap.get(key));
        return this.httpUrlMap.get(key).response;
    }

    public void changeBaseUrl(BaseUrl newBaseUrl) {
        logger.warn("Changing baseUrl to: {}", newBaseUrl.name());
        this.base_url = newBaseUrl;
    }

    public void updateUrl(String urlName, String url, Class responseClass) {
        logger.warn("Url {} is updated. New urlString: {}, responseClass: {}", urlName, url, responseClass.getSimpleName());
        Http http = new Http();
        http.url = url;
        http.response = responseClass;

        this.httpUrlMap.put(urlName, http);
    }

    private void validateUrlNotNull(String url) throws UrlNotDefinedException {
        if (url == null || url.length() == 0) {
            throw new UrlNotDefinedException(url);
        }
    }

    private void validateNotNull(String key, Http http) {
        if (http == null) {
            throw new NullPointerException(String.format("Object associated with key %s is null/empty", key));
        }
    }

    public static Url getDefault() {
        Url url = new Url();

        url.updateUrl("login", "/login", Login.class);
        url.updateUrl("logout", "/logout", Login.class);
        url.updateUrl("loggedInUser", "/getLoggedInUser", LoginStatus.class);

        url.changeBaseUrl(BaseUrl.REMOTE);

        return url;
    }
}
