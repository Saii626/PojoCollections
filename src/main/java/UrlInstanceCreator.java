import ConfigurationManagement.Interfaces.ConfigurationManager;
import Url.Url;

import java.io.IOException;

public class UrlInstanceCreator {

    public static Url createInstance(ConfigurationManager configurationManager) throws IOException {

        Url url = configurationManager.<Url>getRaw("url");

        if (url == null) {
            url = Url.getDefault();
            configurationManager.put("url", url);
            configurationManager.syncConfigurations();
        }

        return url;
    }
}
