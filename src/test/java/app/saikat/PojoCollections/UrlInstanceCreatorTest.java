package app.saikat.PojoCollections;

import app.saikat.ConfigurationManagement.ConfigurationManagerInstanceHandler;
import app.saikat.ConfigurationManagement.interfaces.ConfigurationManager;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class UrlInstanceCreatorTest {

    @Test
    public void createInstance() throws IOException {
        ConfigurationManager configurationManager = ConfigurationManagerInstanceHandler
                .createInstance(new File(System.getProperty("user.home")+"/test/url.conf"));

        UrlManager urlManager = UrlInstanceHandler.createInstance(configurationManager);

        assert urlManager.getHttpUrl(Url.values()[0]) != null;
    }
}