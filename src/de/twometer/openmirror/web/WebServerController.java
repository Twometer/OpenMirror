package de.twometer.openmirror.web;

import java.io.IOException;

public class WebServerController {

    private WebConfig config = new WebConfig();
    private WebServer server;

    public boolean start() {
        try {
            config.load();
            server = new WebServer(config.getNetworkPort());
            server.start();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean stop() {
        try {
            config.save();
            server.stop();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
