import network.UdpEchoClient;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        UdpEchoClient udpEchoClient = new UdpEchoClient("192.168.2.7",9000);
//        udpEchoClient.start();
        JOptionPane.showMessageDialog(null, "康文迪请求与你对话!", "提示", JOptionPane.INFORMATION_MESSAGE);
        Object[] options = {"同意",
                "没时间"};
        int n = JOptionPane.showOptionDialog(null,
                "你是否同意与康文迪对话?",
                "对话通知",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,     //do not use a custom Icon
                options,  //the titles of buttons
                options[0]); //default button title
        System.out.println(n);

    }
}