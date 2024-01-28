/**
 * @Author:YWQ
 * @Date :2023/12/10 - 17:16
 * @Desc : NULL
 **/
public class DemoClass {
    private String Student;
    private int grass;

    /**
     * 构造方法:有参/无参
     * 构造方法名必须和类名一致
     * 构造方法初始默认是public
     */
    public DemoClass() {
        System.out.println("测试构造方法");
    }

    //有参构造方法_demo01
    public DemoClass(String Student) {
        this.Student = Student;
    }
    //demo02
    public DemoClass(String Student, int grass) {
        this.Student = Student;
        this.grass = grass;
    }
    //demo03
    public DemoClass( int grass) {
        this.grass = grass;
    }

    public String show() {
        return Student + "-----" + grass;
    }


}
