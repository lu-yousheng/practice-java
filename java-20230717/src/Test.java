import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws UserNameException{
        System.out.println("请输入你的用户名！");
        String username = "myz";
        Scanner scanner = new Scanner(System.in);
        try{
            String name = scanner.nextLine();
            if(!name.equals(username)){
                throw new UserNameException();
            }
        }catch (UserNameException e){
            e.printStackTrace();
            System.out.println("用户名异常！");
        }finally {
            scanner.close();
        }
        //System.out.println("用户名成功！");
    }
}
