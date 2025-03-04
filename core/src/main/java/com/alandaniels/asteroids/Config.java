package com.alandaniels.asteroids;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;


public class Config {
    private int screen_width;
    private int screen_height;

    /**
     * Constructor.
     */
    public Config() {
        // Start with some reasonable defaults.
        screen_width = 1024;
        screen_height = 768;

        // Read the config file.
        try {
            URL configFile = getClass().getResource("./config.properties");
            InputStream stream = configFile.openStream();
            Properties p = new Properties();
            p.load(stream);
            stream.close();

            String val;
            val = (String) p.get("screen_width");
            if (val != null) {
                screen_width = Integer.parseInt(val);
            }
            val = (String) p.get("screen_height");
            if (val != null) {
                screen_height = Integer.parseInt(val);
            }
        }

        // Any issues? Never mind then.
        catch (Exception ex) {
            System.out.println("Could not read config.properties: " + ex.getMessage());
        }
    }

    public int getScreenWidth() {
        return screen_width;
    }

    public int getScreenHeight() {
        return screen_height;
    }
}
