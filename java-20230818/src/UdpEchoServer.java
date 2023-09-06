import javax.swing.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Scanner;

//UDP版本的回显服务器
public class UdpEchoServer {
    //网络编程,本质上是要操作网卡
    //但是网卡不方便操作,在操作系统内核中,使用了一种特殊的叫做"socket的文件
    //来抽象表示网卡,因此进行网络通信,是必须要先有一个socket对象
    private DatagramSocket socket = null;
    //对于服务器来说,创建socket对象的同时,要让它绑定上一个具体的端口号
    //服务器一定要关联上一个端口号!!!!
    //服务器是网络传输中,被动的一方,如果是操作系统随机分配的端口,此时客户端就不知道这个
    //端口号是啥了,无法进项通信
    public UdpEchoServer(int port) throws SocketException {
        socket = new DatagramSocket(port);

    }
    public void start() throws IOException {
        System.out.println("服务器启动!");
        while (true) {
            //只有要客户端访问,就可以提供服务
            //1,读取客户端发来的请求是什么
            //receive方法的参数是一个输出型参数,
            DatagramPacket requestPacket = new DatagramPacket(new byte[4096],4096);
            socket.receive(requestPacket);
            //此时这个DatagramPacket是一个特殊的对象,并不方便直接处理,可以把里面的数据拿出来,构造成一个字符串
            String request = new String(requestPacket.getData(),0,requestPacket.getLength(),"UTF-8");
            //2,根据请求计算响应,由于此处是回显服务器,响应和请求相同
            String response = process(request,requestPacket);
            //3.把响应返回客服端,send的参数也是Datagrampacket
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),response.getBytes().length,
                    requestPacket.getAddress(),requestPacket.getPort());
            socket.send(responsePacket);
            System.out.printf("[%s:%d] req: %s; resq: %s\n",requestPacket.getAddress().toString(),
                    requestPacket.getPort(),request,response);
        }
    }
    public String process(String request,DatagramPacket requestPacket) throws IOException {
        if (request.contains("宝贝")) {
            if (request.contains("在干嘛")) {
                return "在想你呀!!!!";
            } else if (request.contains("我爱你")) {
                return "嘻嘻嘻,人家也爱你呀!";

            }else if (request.contains("想你")){
                //此处与客户端直接进行对话
                return "宝贝要和人家聊天啦嘛";
            }
            else {
                return "怎么啦,人家在学习捏";
            }
        }else if (request.contains("yes")) {
            return onlineConnection(requestPacket);
        }else {
            return "跟人家说话要叫人家宝贝!!!";
        }
    }

    private String onlineConnection(DatagramPacket requestPacket) throws IOException {
        if (onlineServer() == 0) {
            
            while (true) {
                //发送消息
                Scanner scanner = new Scanner(System.in);
                String response = scanner.next();
                if (response.equals("exit")) break;
                DatagramPacket responsePacket = new DatagramPacket(response.getBytes(),response.getBytes().length,
                        requestPacket.getAddress(),requestPacket.getPort());
                socket.send(responsePacket);
                System.out.println("<<<等候消息中>>>>");
                //接受消息
                DatagramPacket requestPacket1 = new DatagramPacket(new byte[4096],4096);
                socket.receive(requestPacket1);
                //此时这个DatagramPacket是一个特殊的对象,并不方便直接处理,可以把里面的数据拿出来,构造成一个字符串
                String request1 = new String(requestPacket1.getData(),0,requestPacket1.getLength(),"UTF-8");
                System.out.printf("%s %d : %s\n",requestPacket.getAddress(),requestPacket.getPort(),request1);
                if (request1.equals("exit")) break;

            }
        }
        return "人家学习去啦";
    }

    private int onlineServer() {
        JOptionPane.showMessageDialog(null, "康文迪请求与你对话!", "提示", JOptionPane.INFORMATION_MESSAGE);
        Object[] options = {"同意",
                "没时间"};
        int optionServer = JOptionPane.showOptionDialog(null,
                "你是否同意与康文迪对话?",
                "对话通知",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,     //do not use a custom Icon
                options,  //the titles of buttons
                options[0]); //default button title
        return optionServer;
    }

    public static void main(String[] args) throws IOException {
        //端口号1024->65535之间随便指定
        UdpEchoServer server = new UdpEchoServer(9000);
        server.start();
    }
}
