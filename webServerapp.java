public class webServerapp {
    public static void main(String[] args) {
        int port = 80;
        WebServer webServer = new WebServer(port);
        webServer.run();
    }
}
