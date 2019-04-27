package com.dazhaung.family;


import com.dazhaung.family.base.common.BoyThreadPoolExecutor;
import com.dazhaung.family.base.server.service.WebServer;
import com.dazhaung.family.base.server.service.impl.WebServerImpl;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class StrongBoyApplication {

    public static void main(String[] args) {

        try {
            WebServer webServer = new WebServerImpl();
            webServer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
