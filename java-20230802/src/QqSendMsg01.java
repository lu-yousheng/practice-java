import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
public class QqSendMsg01 {
    public static void main(String[] args) {
        try {
            Robot robot = new Robot();
            robot.delay(3000);
            for (int i = 0; i < 100; i++) {
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection("666666" +
                        ""), null);
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_V);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                robot.keyRelease(KeyEvent.VK_V);
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                robot.delay(300);}
//                //无限炸，这个快
//                while (true) {
//                    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection("我是恋爱脑"), null);
//                    robot.keyPress(KeyEvent.VK_CONTROL);
//                    robot.keyPress(KeyEvent.VK_V);
//                    robot.keyRelease(KeyEvent.VK_CONTROL);
//                    robot.keyRelease(KeyEvent.VK_V);
//                    robot.keyPress(KeyEvent.VK_ENTER);
//                    robot.keyRelease(KeyEvent.VK_ENTER);
//                    robot.delay(100);
//                }
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}