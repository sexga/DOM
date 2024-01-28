/**
 * @Author:YWQ
 * @Date :2023/12/10 - 18:31
 * @Desc : NULL
 **/
public class HomeWork {
    //1.定义成员变量
    private String name;
    private int age;

    //2.定义无参/有参构造方法
    public HomeWork() {
        System.out.println("无参构造方法");
    }

    public HomeWork(String name, int age) {
        this.name = name;
        this.age = age;

    }

    //3.get/set方法
    public String getName() {
        return name;//不用写this ,默认返回成员变量
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;//不用写this ,默认返回成员变量
    }

    public void setAge(int age) {
        this.age = age;
    }
    //toString方法 :返回homework类中所有的成员变量
    public String toString(){
        return name+"今年"+age+"岁!";
    }

/*
    构造过程自动生成 ---cenerate---constructor

    public HomeWork(int age) {
        this.age = age;
    }*/
}
