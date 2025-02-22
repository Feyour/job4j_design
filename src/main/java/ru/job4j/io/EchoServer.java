package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream output = socket.getOutputStream();
                     BufferedReader input = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String firstLine = input.readLine();
                    System.out.println(firstLine);

                    if (firstLine != null && firstLine.contains("msg=Bye")) {
                        output.flush();
                        server.close();
                        break;
                    } else {
                        output.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    }

                    String line;
                    while ((line = input.readLine()) != null && !line.isEmpty()) {
                        System.out.println(line);
                    }

                    output.flush();
                }
            }
        }
    }
}