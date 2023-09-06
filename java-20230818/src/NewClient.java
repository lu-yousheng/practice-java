import javax.swing.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;



public class NewClient {
    private DatagramSocket socket = null;
    private String serverIP = null;
    private int serverPort = 0;

    //让操作系统自动分配一个没有别的进程在使用的端口,端口用来标识/区分一个进程的,不能一个端口被多个进程使用

    public NewClient(String serverIP,int serverPort) throws SocketException {
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
            String Data = scanner.next();
            //2,构造UDP请求,并发送
            DatagramPacket sendData = new DatagramPacket(Data.getBytes(),Data.getBytes().length,InetAddress.getByName(this.serverIP),this.serverPort);
            socket.send(sendData);
            //3,读取服务器的UDP响应,并解析
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096],4096);
            socket.receive(requestPacket);
            String response = new String(requestPacket.getData(),0,requestPacket.getLength(),"UTF-8");
            //4,根据服务器返回的消息进行选择
            //String isTrue = new String("聊天");
            if (response.contains("聊天")) {
                process(response);
            }
            //5,把解析好的结果显示出来
            System.out.println(response);
        }
    }

    private void process(String request) throws IOException {
        //1,获取选择
        if (optionClient() == 0) {
            String op = "yes";
            DatagramPacket sendData1 = new DatagramPacket(op.getBytes(),op.getBytes().length,InetAddress.getByName(this.serverIP),this.serverPort);
            socket.send(sendData1);
            System.out.println("稍等呀,人家正在上线中>>>");
            //等待服务器响应
            while (true) {
                DatagramPacket requestPacket = new DatagramPacket(new byte[4096],4096);
                socket.receive(requestPacket);
                String request1 = new String(requestPacket.getData(),0,requestPacket.getLength(),"UTF-8");
                if (request1.equals("exit")) break;
                System.out.printf("%s %d (老婆大人): %s\n",this.serverIP,this.serverPort,request1);
                System.out.println("请输入你要发送的信息->");
                Scanner scanner = new Scanner(System.in);
                String Data = scanner.next();
                if (Data.equals("exit")) break;
                //2,构造UDP请求,并发送
                DatagramPacket sendData = new DatagramPacket(Data.getBytes(),Data.getBytes().length,InetAddress.getByName(this.serverIP),this.serverPort);
                socket.send(sendData);
                System.out.println("<<<等候消息中>>>>");
            }

        }
        return;
    }

    private int optionClient() {
        Object[] options = {"对呀对呀",
                "不打扰宝贝学习啦"};
        int optionServer = JOptionPane.showOptionDialog(null,
                "宝贝想要和人家聊天嘛",
                "对话通知",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,     //do not use a custom Icon
                options,  //the titles of buttons
                options[0]); //default button title
        return optionServer;
    }

    public static void main(String[] args) throws IOException {
        NewClient newClient = new NewClient("25.42.138.194",9000);
        newClient.start();
    }
}