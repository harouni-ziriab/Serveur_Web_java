import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class HttpResponse {
    private BufferedWriter Output;

    public  HttpResponse(Socket socket) throws IOException {
        Output = new BufferedWriter
                (new OutputStreamWriter
                        (socket.getOutputStream()));
    }

    public void ok(String message) throws IOException {
        Output.write("HTTP/1.1 200"+message+"\r\n");
        Output.flush();
    }

    public void notFound(String message) throws IOException {
        Output.write("HTTP/1.1 404 "+message+"\r\n");
        Output.flush();
    }

}
