// package com.example;

// public class Helloworld {
//     public static void main(String[] args) {
//         System.out.println("Hello from Nexus JAR!");
//     }
// }
package com.example;

import java.io.IOException;
import com.sun.net.httpserver.*;

public class Helloworld {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new java.net.InetSocketAddress(8085), 0);
        server.createContext("/", exchange -> {
            String response = "Hello from Nexus JAR!";
            exchange.sendResponseHeaders(200, response.length());
            exchange.getResponseBody().write(response.getBytes());
            exchange.close();
        });
        server.start();
        System.out.println("Server started on port 8085");
    }
}
