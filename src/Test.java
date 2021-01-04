import java.awt.*;
import java.io.File;
import java.util.Scanner;

public class Test {
    static Scanner sc=new Scanner(System.in);
    static Product carts[]=new Product[3];
    public static void main(String[] args)
    {
        boolean flag=true;
        while(flag){
            System.out.println("请输入你的用户名:");
            String username=sc.next();

            System.out.println("请输入你的密码：");
            String password=sc.next();

            File file=new File("C:\\Users\\lenovo\\IdeaProjects\\CmdShopInClass\\src\\users.xlsx");
            ReadExcel re=new ReadExcel();

            User[] users=null;
            users=re.readExcel(file);
            int count=0;

            for(int i=0;i<users.length;i++)
            {
                if(username.equals(users[i].getUsername())&&password.equals(users[i].getPassword())){
                    System.out.println("登录成功");
                    flag=false;
                    while(true)
                    {
                        System.out.println("购买商品请按1");
                        System.out.println("查看购物车请按2");
                        System.out.println("结账请按3");
                        System.out.println("退出请按4");
                        int choose=sc.nextInt();
                        if(choose==1)
                        {
                           shopping();
                        }else if(choose==2)
                        {
                            System.out.println("当前购物车商品如下：");

                            for(Product pro:carts)
                            {
                                System.out.print("\t"+pro.getPID());
                                System.out.println("\t"+pro.getPname());
                                System.out.println("\t"+pro.getPrice());
                                System.out.println("\t"+pro.getIntro());
                            }
                        }else if(choose==3)
                        {

                        }else if(choose==4)
                        {
                            break;
                        }
                    }
                    break;
                }else
                {
                    System.out.println("登录失败！");
                }
            }
        }

    }

    public static void shopping()
    {
        File file1=new File("C:\\Users\\lenovo\\IdeaProjects\\CmdShopInClass\\src\\Products.xlsx");
        ReadProductExcel rpe=new ReadProductExcel();
        Product all[]=rpe.getAllProducts(file1);
        for(Product p:all)
        {
            System.out.print("\t"+p.getPID());
            System.out.print("\t"+p.getPname());
            System.out.print("\t"+p.getPrice());
            System.out.println("\t"+p.getIntro());
        }
        System.out.println("请输入你想要购买商品的ID,把它加入购物车");

        String sid=sc.next();
        int count=0;
        Product result=rpe.getProductById(sid,file1);
        System.out.println("要购买的商品价格："+result.getPrice());
        if(result!=null)
        {
            carts[count++]=result;
        }

    }
}
