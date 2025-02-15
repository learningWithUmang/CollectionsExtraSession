public class Student implements Comparable<Student> {
    String name;
    int age;

    Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student st2) {
        return this.name.compareTo(st2.name);
    }
}
