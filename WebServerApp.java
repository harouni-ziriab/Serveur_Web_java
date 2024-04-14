public class WebServerApp {
    public static void main(String[] args) {
        // Create an instance of WebServer with port 80
        WebServer server = new WebServer(80);
        // Start the server
        server.run();
    }
}