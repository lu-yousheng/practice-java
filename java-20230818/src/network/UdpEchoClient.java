package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UdpEchoClient {
    private DatagramSocket socket = null;
    private String serverIP = null;
    private int serverPort = 0;

    //让操作系统自动分配一个没有别的进程在使用的端口,端口用来标识/区分一个进程的,不能一个端口被多个进程使用

    public UdpEchoClient(String serverIP,int serverPort) throws SocketException {
        socket = new DatagramSocket();
        this.serverIP = serverIP;
        this.serverPort = serverPort;

    }
    public void start() throws IOException {
        System.out.println("客户端启动!");
        while (true) {
            //1,从控制台读取要发送的数据
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入你要发送的数据");
            String Data = scanner.nextLine();
            //2,构造UDP请求,并发送
            DatagramPacket sendData = new DatagramPacket(Data.getBytes(),Data.getBytes().length,InetAddress.getByName(this.serverIP),this.serverPort);
            socket.send(sendData);
            //3,读取服务器的UDP响应,并解析
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096],4096);
            socket.receive(requestPacket);
            String request = new String(requestPacket.getData(),0,requestPacket.getLength());
            //4,把解析好的结果显示出来
            System.out.println(request);
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("请输入你要发送的数据");
//            String request = scanner.next();
//            if (request.equals("exit")) {
//                System.out.println("byby");
//                break;
//            }
//            DatagramPacket requestpacket = new DatagramPacket(request.getBytes())
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient udpEchoClient = new UdpEchoClient("25.42.138.194",9000);
        udpEchoClient.start();
    }
}
