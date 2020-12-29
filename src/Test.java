import java.awt.*;
import java.io.File;
import java.util.Scanner;

public class Test {
    public static void main(String[] args)
    {
        boolean flag=true;
        while(flag){
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
            int count=0;
            File file1=new File("C:\\Users\\lenovo\\IdeaProjects\\CmdShopInClass\\src\\Products.xlsx");
            Product cart[]=new Product[3];
            for(int i=0;i<users.length;i++)
            {
                flag=false;
                if(username.equals(users[i].getUsername())&&password.equals(users[i].getPassword()))
                {
                    ReadProductExcel rpe=new ReadProductExcel();
                    Product all[]=rpe.getAllProducts(file1);
                    for(Product pro:all)
                    {
                        System.out.print("\t"+pro.getPID());
                        System.out.println("\t"+pro.getPname());
                        System.out.println("\t"+pro.getPrice());
                        System.out.println("\t"+pro.getIntro());
                    }
                    System.out.println("请输入你想要购买商品的ID");
                    Scanner in=new Scanner(System.in);
                    String sid=in.next();

                    Product result=rpe.getProductById(sid,file1);
                    if(result!=null)
                    {
                        cart[count++]=result;
                        System.out.println("购买成功！");
                    }
                }else
                {
                    System.out.println("登录失败！");
                }
            }
        }

    }
}
