package network;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class TcpEchoServer {
    private ServerSocket serverSocket = null;
    public TcpEchoServer(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
    }
    public void start() throws IOException {
        System.out.println("启动服务器!");
        while (true) {
            //使用这个对象和具体的客户端交流.
            Socket clientSocket = serverSocket.accept();
            //多线程版本.1,使用Thread
//            Thread thread = new Thread(()->{
//                processConnection(clientSocket);
//            });
//            thread.start();
            //使用线程池
            ExecutorService threadPool = Executors.newCachedThreadPool();
            threadPool.submit(()->{
                processConnection(clientSocket);
            });

        }
    }
    private void processConnection(Socket clientSocket) {
        System.out.printf("[%s :%d] 客户端上线! \n",clientSocket.getInetAddress(),clientSocket.getPort());
        //基于上述socket对象和客户端进行通信
        try (InputStream inputStream = clientSocket.getInputStream();
             OutputStream outputStream = clientSocket.getOutputStream()){
            //由于要处理多个对象,也是使用循环来进行
            while (true) {
                Scanner scanner = new Scanner(inputStream);
                if (!scanner.hasNext()) {
                    System.out.printf("[%s:%d] 客户端下线!\n",clientSocket.getInetAddress().toString(),clientSocket.getPort());
                    break;
                }
                //此处使用next是一只读取到换行符/空格/其他空白符结束,但是最终返回结果不包含上述空白符.
                String request = scanner.next();
                //2,根据请求构造响应
                String response = process(request);
                //3,返回响应结果.
                //OutputStream没有write String这样的功能,可以把String里的字节数组拿出来
                //也可以用字符流来转换一下
                PrintWriter printWriter = new PrintWriter(outputStream);
                //此处使用println来写入,让结果中带入一个\n换行,方便对端来解析
                printWriter.println(response);
                //flush用来刷新缓冲区,保证当前写入的数据,确实是发送出去了
                printWriter.flush();
                System.out.printf("[%s:%d]:%s \n",clientSocket.getInetAddress().toString(),clientSocket.getPort(),request);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String process(String request) {
        return request+"lalal";
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer tcpEchoServer = new TcpEchoServer(9000);
        tcpEchoServer.start();
    }

}
