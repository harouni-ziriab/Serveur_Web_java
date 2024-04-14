import java.io.*;
import java.net.*;


class WebServer {
    private int port;

    public WebServer(int port) {
        this.port = port;
    }

    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Web server started on port " + port + ".");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connection from " + clientSocket.getInetAddress());

                readRequest(clientSocket);
                sendResponse(clientSocket);

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readRequest(Socket clientSocket) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String requestLine = in.readLine();
            if (requestLine != null) {
                System.out.println("Request received: " + requestLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendResponse(Socket clientSocket) {
        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("HTTP/1.1 200 OK\r\n\r\n Slt Harouni Ziriab ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        System.out.println("Web server stopped.");
    }
}

