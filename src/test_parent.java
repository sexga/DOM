/**
 * @Author:YWQ
 * @Date :2023/12/24 - 16:23
 * @Desc : NULL
 **/
public class test_parent {
    public static void main(String[] args) {
        zi01 z1 = new zi01();
        z1.setName("zhangsan");
        z1.setAge(12);
        System.out.println(z1.getName()+","+z1.getAge());
        z1.work();
        zi02 z2 = new zi02();
        z2.setName("lisi");
        z2.setAge(18);
        System.out.println(z2.getName()+","+z2.getAge());
        z2.todo();

    }


}
