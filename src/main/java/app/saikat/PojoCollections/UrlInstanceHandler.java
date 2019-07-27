package app.saikat.PojoCollections;

import app.saikat.ConfigurationManagement.interfaces.ConfigurationManager;

import java.io.IOException;

public class UrlInstanceHandler {

    public static UrlManager createInstance(ConfigurationManager configurationManager) throws IOException {
        return configurationManager.getOrSetDefault("url", UrlManager.getDefault());
    }
}
