import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class CalculatorHttpHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String query = exchange.getRequestURI().getQuery();
        Map<String, String> parameters = new HashMap<>();
        String[] split = query.split("&");
        for (String s : split) {
            String[] split1 = s.split("=");
            parameters.put(split1[0], split1[1]);
        }
        int num1 = Integer.parseInt(parameters.get("num1"));
        int num2 = Integer.parseInt(parameters.get("num2"));
        String type = parameters.get("type");
        int result = 0;

        switch (type) {
            case "SUM":
                result = num1 + num2;
        }

        String res = "<!doctype html>\n" +
                "<html lang=\"en\">\n" +
                "  <head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "    <title>Bootstrap demo</title>\n" +
                "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD\" crossorigin=\"anonymous\">\n" +
                "  </head>\n" +
                "  <body>\n" +
                "<div class=\"card\" style=\"width: 18rem;\">\n" +
                "  <img src=\"...\" class=\"card-img-top\" alt=\"...\">\n" +
                "  <div class=\"card-body\">\n" +
                "    <h5 class=\"card-title\">Card title</h5>\n" +
                "    <p class=\"card-text\">Some quick example text to build on the card title and make up the bulk of the card's content.</p>\n" +
                "    <a href=\"#\" class=\"btn btn-primary\">Result = " + result +"</a>\n" +
                "  </div>\n" +
                "</div>" +
                "    <h1>Hello, world!</h1>\n" +
                "    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN\" crossorigin=\"anonymous\"></script>\n" +
                "  </body>\n" +
                "</html>\n" + result;

        exchange.sendResponseHeaders(200, res.length());

        Writer writer = new OutputStreamWriter(exchange.getResponseBody(), StandardCharsets.UTF_8);

        writer.write(res);

        writer.close();

		writer.close();

		exchange.close();
    }
}
