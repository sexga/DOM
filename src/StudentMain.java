/**
 * @Author:YWQ
 * @Date :2023/12/10 - 14:26
 * @Desc : NULL
 **/
public class StudentMain {
    public static void main(String[] args) {
        Student s = new Student();
        s.name="zhanhgsna ";
        s.setAge(21);//获取set方法中的成员变量
        System.out.println(s.name);
        System.out.println(s.getAge()); //通过get方法获取 成员变量
        s.work(s.name);

    }

}
