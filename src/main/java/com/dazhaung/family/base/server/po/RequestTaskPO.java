package com.dazhaung.family.base.server.po;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class RequestTaskPO implements Runnable{

    public Socket socket;
    public RequestTaskPO(Socket socket) {
        this.socket = socket;
    }

    public void run() {

//        try {
            String str = null;
            str.toString();

//
//            // TODO: 2019-04-21 调用业务处理方法
//            String reponse = "<html><body><h1>李大壮</h1></body></html>";
//            String str = "HTTP/1.0 200 OK\n" +
//                    "Content-Type: text/html; charset=utf-8\n" +
////                        "Content-Encoding: gzip\n" +
//                    "Content-Length: " + reponse.length() + "\n"+
//                    "Cache-Control: no-cache\n"+"\n"+reponse+"\n";
//
//            System.out.println(str);
//
//            byte[] bytes = new byte[10000];
//            DataInputStream inputStream1 = new DataInputStream(socket.getInputStream());
//            inputStream1.read(bytes);
//
//            System.out.println(new String(bytes));
//
//            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
//
//
//            outputStream.write(str.getBytes());
////                outputStream.writeUTF(reponse);
//
//            outputStream.flush();
//            outputStream.close();
//            socket.close();
//        } catch (Exception e) {
//            System.out.printf("异常捕捉");
//            e.printStackTrace();
//            throw e;
//        }

    }
}
