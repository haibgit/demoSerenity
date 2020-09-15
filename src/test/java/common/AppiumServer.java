package common;

import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class AppiumServer {
    static AppiumDriverLocalService service;

    public static void start() throws IOException {
        if (!appiumIsRunning(4723)) {
            System.out.println("->>>>>>> start appium by java code");
            service = AppiumDriverLocalService.buildDefaultService();
            service.start();
        }
        else System.out.println("->>>> appium server is running... ");
    }

    private static boolean appiumIsRunning(int port) {

        try {
            ServerSocket socket = new ServerSocket(port);
            socket.close();
            return false;
        } catch (Exception e) {
            return true;
        }


    }

    public static void stop() {
        if (service.isRunning())
            service.stop();

    }


}
