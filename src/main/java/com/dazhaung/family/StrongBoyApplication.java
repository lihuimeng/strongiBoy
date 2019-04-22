package com.dazhaung.family;


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


//            ServerSocket serverSocket = new ServerSocket(8080);

//             InputStream inputStream = socket.getInputStream();

            /*while (true) {
                String reponse = "<html><body><h1>李大壮</h1></body></html>";
                String str = "HTTP/1.0 200 OK\n" +
                        "Content-Type: text/html; charset=utf-8\n" +
//                        "Content-Encoding: gzip\n" +
                        "Content-Length: " + reponse.length() + "\n"+
                        "Cache-Control: no-cache\n"+"\n"+reponse+"\n";

                System.out.println(str);

                Socket socket = serverSocket.accept();
                byte[] bytes = new byte[10000];
                DataInputStream inputStream1 = new DataInputStream(socket.getInputStream());
                inputStream1.read(bytes);

                System.out.println(new String(bytes));

                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());


                outputStream.write(str.getBytes());
//                outputStream.writeUTF(reponse);

                outputStream.flush();
                outputStream.close();
                socket.close();

                System.out.println("接收到请求" + serverSocket.getInetAddress());

            }*/


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
