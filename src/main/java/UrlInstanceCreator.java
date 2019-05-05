import ConfigurationManagement.Interfaces.ConfigurationManager;
import Url.Url;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UrlInstanceCreator {

    private static Logger logger = LoggerFactory.getLogger(UrlInstanceCreator.class.getSimpleName());

    public static Url createInstance(ConfigurationManager configurationManager) throws IOException {

        Url url = configurationManager.<Url>get("url").orElseGet(() -> {
            logger.debug("no url configuration. Initializing a default instance");
            Url defaultUrl = Url.getDefault();
            configurationManager.put("url", defaultUrl);
            try {
                configurationManager.syncConfigurations();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return defaultUrl;
        });

        return url;
    }
}
