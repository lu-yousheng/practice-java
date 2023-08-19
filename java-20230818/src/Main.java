import network.UdpEchoClient;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        UdpEchoClient udpEchoClient = new UdpEchoClient("192.168.2.7",9000);
        udpEchoClient.start();
        //System.out.println("hello");
    }
}