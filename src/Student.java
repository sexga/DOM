/**
 * @Author:YWQ
 * @Date :2023/12/10 - 13:59
 * @Desc : NULL
 **/
public class Student {
    String name;
    private int age;
    public void work(String name){
        System.out.println(name+"start work");
    }
/**
 * 自动生成--右键--Generate--getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
**/
//生成SET方法
    public void setAge(int age) {
        if (age < 0 || age > 120) {
            System.out.println("输入年龄error");
            return;
        }
        this.age = age;
    }
    //生成get方法
    public int getAge(){
        return this.age;
    }
}
