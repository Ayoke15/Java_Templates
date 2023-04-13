import java.util.*;

public class ex1{
    public static void main(String[] args){
        Student[][] students = {
                {new Student("Alice", "Group A"), new Student("Bob", "Group A")},
                {new Student("Charlie", "Group B"), new Student("Dave", "Group B")},
                {new Student("Eve", "Group C"), new Student("Frank", "Group C")}
        };
        Map<String, List<Student>> groups = GroupStudents.groupStudents(students);
        System.out.println(groups);
    }
}

class GroupStudents {
    public static Map<String, List<Student>> groupStudents(Student[][] students) {
        Map<String, List<Student>> groups = new HashMap<>();
        for (Student[] group : students) {
            String groupName = group[0].getGroup();
            List<Student> studentList = new ArrayList<>();
            for (Student student : group) {
                studentList.add(student);
            }
            groups.put(groupName, studentList);
        }
        return groups;
    }
}

class Student {
    private String name;
    private String group;

    public Student(String name, String group) {
        this.name = name;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }
}
