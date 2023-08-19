package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClient {
    private Socket socket = null;

    public TcpEchoClient(String ServerIP,int ServerPort) throws IOException {
        this.socket = new Socket(ServerIP,ServerPort);
    }
    public void start() {
        System.out.println("客户端启动!");
        Scanner scanner = new Scanner(System.in);
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()){
            while (true) {
                //1,先从键盘上读取用户输入的内容
                System.out.println("输入");
                String request = scanner.next();
                if (request.equals("eixt")) {
                    System.out.println("byby");
                    break;
                }
                //2,把读到的内容构造成请求,发送给服务器
                PrintWriter printWriter = new PrintWriter(outputStream);
                //此处使用println来写入,让结果中带入一个\n换行,方便对端来解析
                printWriter.println(request);
                //flush用来刷新缓冲区,保证当前写入的数据,确实是发送出去了
                printWriter.flush();
                //3,读取服务器的响应
                Scanner respScanner = new Scanner(inputStream);
                String response = respScanner.next();
                //4,把响应内容显示到界面上
                System.out.println(response);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient tcpEchoClient = new TcpEchoClient("111.124.55.164",9000);
        tcpEchoClient.start();
    }
}
