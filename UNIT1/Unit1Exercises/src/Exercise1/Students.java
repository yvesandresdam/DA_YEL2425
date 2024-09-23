package Exercise1;

import java.util.ArrayList;
import java.util.List;

public class Students {
    private List<Student> studentsList = new ArrayList<Student>();

    public void addStudent(Student student) {
        if (student == null)
            return;
        studentsList.add(student);
    }

    public Student getStudentAtIndex(int index) {
        if (index < 0 || index > studentsList.size())
            return null;
        return studentsList.get(index);
    }

    public double getAverageMark(){
        if(studentsList.size() == 0)
            return 0.0;

        double mark = 0;
        double numberStudents = studentsList.size();

        for(Student student : studentsList){
            mark += student.getMark();
        }
        return mark / numberStudents;
    }
}
