/**
 * @Author:YWQ
 * @Date :2023/12/10 - 13:57
 * @Desc : NULL
 **/
public class dome03_main {
    //      主程序入口
    public static void main(String[] args) {
        /**
         * 1.创建对象
         * 类名 对象名 = new 类名
         * 2.使用对象
         * 2.1 使用成员变量
         * 对象名称.变量
         * 2.2 使用成员方法
         * 对象名称.方法名
         */
        //1.创建对象
        dome03 phone1 = new dome03();
        phone1.brand = "小米";
        phone1.price = 2999;
        System.out.println(phone1.brand);
        System.out.println(phone1.price);
        phone1.call(phone1.brand);
        //2.new 第二個對象
        System.out.println("=============");
        dome03 phone2 = new dome03();
        phone2.brand="iPhone 15 Plus";
        phone2.price=5789.985;
        System.out.println(phone2.brand);
        System.out.println(phone2.price);
        phone2.sendMsg(phone2.price);


    }
}
