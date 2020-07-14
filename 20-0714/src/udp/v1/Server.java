package udp.v1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class Server {
    public static void main(String[] args) throws IOException {
        //1.创建server的socket
        //内部会进行本地IP——port的绑定
        //饭店开张
        //ip虽然没穿，内部会自动处理，把所有IP绑定
        DatagramSocket socket = new DatagramSocket(9939);

        //2.开张迎客，通过循环，处理事务
        while(true){
            //3.处理一个要求
            action(socket);
        }
    }

    //处理要求
    private static void action(DatagramSocket socket) throws IOException {
        //1.读取客户端发来的请求
        //准备一个字节数组，存一会要读到的数据
        byte[] receiveBuffer = new byte[8192];
        //把buffer封装成datagram
        DatagramPacket receiverPacket = new DatagramPacket(receiveBuffer,8192);
        //读取请求
        socket.receive(receiverPacket);
        //从receive中返回，意味着有人发送请求
        System.out.println(Arrays.toString(Arrays.copyOfRange(receiveBuffer,0,receiverPacket.getLength())));
        //2.进行服务：根据请求处理业务，并生成响应

        //3.发送响应回去
    }
}
