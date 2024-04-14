import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class HttpRequest {

    public  HttpRequest(Socket socket) throws IOException {
        readClient(socket);
    }

    private String method;
    private String url;
    private void readClient(Socket socket) throws IOException {
        BufferedReader reader = new BufferedReader
                (new InputStreamReader
                        (socket.getInputStream()));
        BufferedReader input = new BufferedReader(reader);

        String response = "";
        int line=0;
        while((response = input.readLine()) != null){
            if(line == 0) {
                String[] requestLineParts = response.split(" ");
                if(requestLineParts.length >= 2) {
                    method = requestLineParts[0];
                    url = requestLineParts[1];
                }
                System.out.println("Method: " + method + " Url : " + url);
            }
            line ++;
        }

    }

    public String getURL(){
        return this.url;
    }
    public String getMethod(){
        return this.method;
    }

}
