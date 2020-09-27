package reflect;

public class Student {
    private String name;
    private int age;

    public Student() {
    }
    public static void test(){}
    public Student(String name) {
        this.name = name;
    }

    class liuxing
    {

        String name;

        public liuxing(String name) {
            this.name = name;
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }


}
