/**
 * @Author:YWQ
 * @Date :2023/12/10 - 18:39
 * @Desc : NULL
 **/
public class HomeWorkMain {
    public static void main(String[] args) {
        //通过set方法给我们成员属性赋值
        HomeWork h1 = new HomeWork();
        h1.setName("lisi");
        h1.setAge(19);
        String toString = h1.toString();
        System.out.println(toString);
        System.out.println("===========第二种==========");
        //通过有参数的构造方法赋值
        HomeWork h2 = new HomeWork("zhangsan",99);
        System.out.println(h2.toString());
    }
}
