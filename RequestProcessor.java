import java.io.IOException;
import java.net.Socket;

public class RequestProcessor {
    public RequestProcessor(Socket socket) throws IOException {
        context = new HttpContext(socket);
        this.process();
    }
    private HttpContext context;
    private void process(){
        String url=context.getRequest().getURL();
        System.out.println("URL récupéré dans la classe RequestProcessor: "+url);
        try {
            if ("/".equals(url)) {
                context.getResponse().ok("OK");
                context.close();
            } else {
                context.getResponse().notFound("Not Found");
                context.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
