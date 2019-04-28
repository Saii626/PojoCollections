# UrlManagement
Submodule for managing urls

### How to use:
1. This is a very simple module. Initialize a default Url instance or provide one yourself
    ```java
    Url url = Url.getDefault();
    Url url = anotherUrlInstance;
    ```

2. No need to pass the Url instance through out project. Can access the instance from *Url.instance*
    ```java
    Url.instance.get("login");
    ```

3. Where it really shines is when used together with ConfigurationManager
    ```java
    ConfigurationManager configurationManager = configurationManagerComponent.getConfigurationManager();
    configurationManager.<Url>get("url").orElseGet(() -> {
                try {
                    configurationManager.put("url", Url.getDefault());
                    return configurationManager.getOrThrow("url");
                } catch (MissingConfigurationValue missingConfigurationValue) {
                    missingConfigurationValue.printStackTrace();
                }
                return null;
            });
    
    url.updateUrl("example", "/example", Example.class);
    configurationManager.syncConfiguratuions();
    ```
