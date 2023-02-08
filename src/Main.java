import java.io.IOException;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.concurrent.ThreadPoolExecutor;
public class Main {
    public static void main(String[] args) throws IOException {

		HttpServer httpServer = HttpServer
				.create(new InetSocketAddress("localhost", 8080), 0);
		httpServer.createContext("/test", new TestHttpHandler());
		httpServer.createContext("/calc", new CalculatorHttpHandler());
		httpServer.start();

            }
        }

