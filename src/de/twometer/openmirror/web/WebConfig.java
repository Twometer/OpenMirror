package de.twometer.openmirror.web;

import de.twometer.openmirror.io.ResourceLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class WebConfig {

    private Properties properties = new Properties();

    public void load() throws IOException {
        Path path = getConfigPath();
        if (!Files.exists(path))
            Files.copy(ResourceLoader.getResourceAsStream("conf/default.properties"), path);

        properties.load(Files.newInputStream(path));
    }

    public void save() throws IOException {
        properties.store(Files.newOutputStream(getConfigPath()), "OpenMirror configuration file");
    }

    private Path getConfigPath() {
        return Paths.get("./config.properties");
    }

    public int getNetworkPort() {
        return Integer.parseInt(properties.getProperty("admin.port"));
    }

    public String getAdminUser() {
        return properties.getProperty("admin.user");
    }

    public String getAdminPassword() {
        return properties.getProperty("admin.pass1");
    }

}
