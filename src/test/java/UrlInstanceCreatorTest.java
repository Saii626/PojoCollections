import ConfigurationManagement.ConfigurationManagerInstanceCreator;
import ConfigurationManagement.Interfaces.ConfigurationManager;
import Url.Url;
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

        ConfigurationManager configurationManager = ConfigurationManagerInstanceCreator
                .createInstance(new File(System.getProperty("user.home")+"/url.conf"), gson);

        Url url = UrlInstanceCreator.createInstance(configurationManager);

        assert url!=null;
    }
}