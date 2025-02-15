import java.util.Comparator;

public class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student st1, Student st2) {
        if(st1.age < st2.age) {
            return -1;
        }else return 1;
    }
}
