import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        //开店
        //创建了一个Server Socket
        ServerSocket serverSocket = new ServerSocket(9898);

        //循环处理业务
        //通过建立连接后，得到一个通信用的Socket；
        //每有一个client连接上来，就会有一个socket
        while (true){
            Socket socket = serverSocket.accept();
            //获取输入流
            InputStream is = socket.getInputStream();
            //封装成Scanner
            Scanner scanner = new Scanner(is,"UTF-8");
            //使用\r\n进行分割，读取请求
            String request = scanner.nextLine();//把\r\n去掉了
            System.out.println("收到请求："+request);

            //业务处理
            String response = request;

            //发送响应，也要用\r\n在后面，进行分割
            OutputStream os = socket.getOutputStream();
            //封装成PrintWriter
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(os,"utf-8"));
            //发送响应
            writer.println(response);//println会在后面加\r\n
            writer.flush();

            socket.close();
        }
    }
}
