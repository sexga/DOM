/**
 * @Author:YWQ
 * @Date :2023/12/10 - 17:23
 * @Desc : NULL
 **/
public class DemoClassMain {
    public static void main(String[] args) {
        DemoClass d = new DemoClass();
       // new 回执行到构造方法 我们可以在构造方法中做初始化操作
        d.show();
        System.out.println(d.show());//null-----0
        DemoClass d1 = new DemoClass("zhangsan");//demo01
        System.out.println(d1.show());
        DemoClass d2 = new DemoClass("lisi",11);//demo02
        System.out.println(d2.show());
        DemoClass d3 = new DemoClass(99);//demo03
        System.out.println(d3.show());

    }
}
