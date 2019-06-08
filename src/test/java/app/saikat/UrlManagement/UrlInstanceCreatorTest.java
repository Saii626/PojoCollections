package app.saikat.UrlManagement;

import app.saikat.ConfigurationManagement.ConfigurationManagerInstanceHandler;
import app.saikat.ConfigurationManagement.interfaces.ConfigurationManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class UrlInstanceCreatorTest {

    @Test
    public void createInstance() throws IOException {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .setPrettyPrinting()
                .create();

        ConfigurationManager configurationManager = ConfigurationManagerInstanceHandler
                .createInstance(new File(System.getProperty("user.home")+"/test/url.conf"));

        UrlManager urlManager = UrlInstanceHandler.createInstance(configurationManager);

        assert urlManager.getHttpUrl(Url.values()[0]) != null;
    }
}