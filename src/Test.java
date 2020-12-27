import java.awt.*;
import java.io.File;
import java.util.Scanner;

public class Test {
    public static void main(String[] args)
    {
        System.out.println("请输入你的用户名:");
        Scanner sc=new Scanner(System.in);
        String username=sc.next();
        System.out.println("你输入的用户名是:"+username);
        System.out.println("请输入你的密码：");
        String password=sc.next();
        System.out.println("你输入的密码是："+password);
        File file=new File("C:\\Users\\lenovo\\IdeaProjects\\CmdShopInClass\\src\\users.xlsx");
        ReadExcel re=new ReadExcel();

        User[] users=null;
        users=re.readExcel(file);



        for(int i=1;i<users.length;i++)
        {
            if(username.equals(users[i].getUsername())&&password.equals(users[i].getPassword()))
            {
                System.out.println("登陆成功！");
                break;
            }else
            {
                System.out.println("登录失败！");
            }
        }
    }
}
