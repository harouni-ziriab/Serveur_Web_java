public class WebServerApp {
    public static void main(String[] args) {
        WebServer server = new WebServer(80);
        server.run();
    }
}
