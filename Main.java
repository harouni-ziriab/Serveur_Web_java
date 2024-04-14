import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        ServerSocket serverSocket = new ServerSocket(80);
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                RequestProcessor requestProcessor= new RequestProcessor(socket);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}