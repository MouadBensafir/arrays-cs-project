package samplearrays;

import java.util.Arrays;
import java.util.Comparator;

public class ManageStudent {

    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        if (students.length == 0) return null;
        Student oldest = students[0];
        for (Student s : students) {
            if (s.getAge() > oldest.getAge()) oldest = s;
        }
        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        if (students == null) return 0;
        int count = 0;
        for (Student s : students) {
            if (s.getAge() >= 18) count++;
        }
        return count;
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        if (students == null || students.length == 0) return Double.NaN;
        double grade = 0.0;
        for (Student s : students) {
            if (s.getGrade() >= 0)
                grade += s.getGrade();
        }
        return  grade / students.length;
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) return s;
        }
        return null;
    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        Arrays.sort(students, Comparator.comparing(Student::getGrade).reversed());
    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        for (Student s : students) {
            if (s.getGrade() >= 15) System.out.println(s.getName());
        }
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setGrade(newGrade);
                return true;
            }
        }
        return false;
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        for (Student s1 : students) {
            for (Student s2 : students) {
                if (s1.getName().equalsIgnoreCase(s2.getName()) && s1 != s2) {
                    return true;
                }
            }
        }
        return false;
    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        Student[] studentsNew = Arrays.copyOf(students, students.length + 1);
        studentsNew[students.length] = newStudent;
        return studentsNew;
    }

    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student[] arr = {
                new Student(1, "Arin", 20, 15),
                new Student(2, "Sora", 21, 19),
                new Student(3, "Wyldfyre", 20, 5),
                new Student(4, "Frak", 19, 9),
                new Student(5, "Riyu", 19, 16)
        };

        // Print all
        System.out.println("== All Students ==");
        for (Student s : arr) System.out.println(s);
        System.out.println("\n- Total created: " + Student.getNumStudent());

        // 2) Oldest
        System.out.println("- Oldest student : " + findOldest(arr).toString());

        // 3) Count adults
        System.out.println("- Number of Adults : " + countAdults(arr));

        // 4) Average grade
        System.out.println("- Average grade : " + averageGrade(arr));

        // 5) Find by name
        System.out.println("- Arin's info : "+ findStudentByName(arr, "arin"));

        // 6) Sort by grade desc
        sortByGradeDesc(arr);
        System.out.println("\n== Sorted by grade (desc) ==");
        for (Student s : arr) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\n- High achievers:");
        printHighAchievers(arr);

        // 8) Update grade by id
        updateGrade(arr, 3, 20);
        System.out.print("\n- Updated id=3? : ");
        System.out.println(findStudentByName(arr, "Wyldfyre"));

        // 9) Duplicate names
        System.out.println("- Are there any duplicates? " + hasDuplicateNames(arr));

        // 10) Append new student
        appendStudent(arr, new Student(6, "Lloyd", 22, 17));

        // 11) Representation of a school
        Student[] class1 = {
                new Student(1, "Arin", 19, 18),
                new Student(2, "Sora", 19, 20),
                new Student(3, "Lloyd", 22, 19)
        };

        Student[] class2 = {
                new Student(1, "Cinder", 21, 18),
                new Student(2, "Jordana", 19, 20),
                new Student(3, "Ras", 19, 19)
        };
        Student[][] classes = { class1, class2 };

        // Print the names of all students
        for (int i=1; i<=classes.length; i++) {
            System.out.println("\n== Students of class " + i + " ==");
            for (Student student : classes[i-1]) {
                System.out.println(student.getName());
            }
        }

        // Print the top student of each class
        System.out.println("\n== Top student of each class ==");
        for (int i = 0; i < classes.length; i++) {
            Student[] cls = classes[i];

            // Find the top student (highest grade)
            Student top = cls[0];
            for (Student s : cls) {
                if (s.getGrade() > top.getGrade()) {
                    top = s;
                }
            }

            System.out.println("Class " + (i + 1) + " top: " + top.getName() + " with grade (" + top.getGrade() + ")");
        }

    }
}

