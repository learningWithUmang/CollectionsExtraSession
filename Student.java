public class Student implements Comparable<Student>{
    String name;
    int age;
    int roll;

    Student(String name, int age, int roll){
        this.name = name;
        this.age = age;
        this.roll = roll;
    }

    @Override
    public int compareTo(Student st2) {
        return this.name.compareTo(st2.name);
    }
}
