import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        String request = "你好";
        if(args.length >1){
            request = args[0];
        }
        Socket socket = new Socket("127.0.0.1",9898);

        OutputStream os = socket.getOutputStream();
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(os,"UTF-8"));
        writer.println(request);
        writer.flush();

        InputStream is = socket.getInputStream();
        Scanner sc = new Scanner(is,"UTF-8");

        String response = sc.nextLine();
        System.out.println(response);

        socket.close();
    }
}
