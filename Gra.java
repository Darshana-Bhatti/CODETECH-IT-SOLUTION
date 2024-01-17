import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Student {
    String name;
    int rollNumber;
    Map<String, Integer> subjectMarks;

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.subjectMarks = new HashMap<>();
    }

    public void addSubjectMark(String subject, int mark) {
        subjectMarks.put(subject, mark);
    }

    public double calculatePercentage() {
        if (subjectMarks.isEmpty()) {
            return 0.0;
        }

        int totalMarks = subjectMarks.values().stream().mapToInt(Integer::intValue).sum();
        return (double) totalMarks / subjectMarks.size();
    }

    public String calculateGrade() {
        double percentage = calculatePercentage();

        if (percentage >= 90) {
            return "A";
        } else if (percentage >= 80) {
            return "B";
        } else if (percentage >= 70) {
            return "C";
        } else if (percentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber +
                ", Percentage: " + calculatePercentage() + ", Grade: " + calculateGrade();
    }
}

public class Gra{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Student> students = new HashMap<>();

        while (true) {
            System.out.println("1. Add Student\n2. Update Student\n3. Delete Student\n4. View All Students\n5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.next();
                    System.out.print("Enter roll number: ");
                    int rollNumber = scanner.nextInt();

                    Student student = new Student(name, rollNumber);

                    System.out.print("Enter number of subjects: ");
                    int numSubjects = scanner.nextInt();

                    for (int i = 0; i < numSubjects; i++) {
                        System.out.print("Enter subject name: ");
                        String subject = scanner.next();
                        System.out.print("Enter marks for " + subject + ": ");
                        int marks = scanner.nextInt();

                        student.addSubjectMark(subject, marks);
                    }

                    students.put(rollNumber, student);
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    System.out.print("Enter the roll number of the student to update: ");
                    int updateRollNumber = scanner.nextInt();

                    if (students.containsKey(updateRollNumber)) {
                        Student updateStudent = students.get(updateRollNumber);

                        System.out.print("Enter new number of subjects: ");
                        int newNumSubjects = scanner.nextInt();

                        updateStudent.subjectMarks.clear(); // Clear existing subjects

                        for (int i = 0; i < newNumSubjects; i++) {
                            System.out.print("Enter subject name: ");
                            String subject = scanner.next();
                            System.out.print("Enter marks for " + subject + ": ");
                            int marks = scanner.nextInt();

                            updateStudent.addSubjectMark(subject, marks);
                        }

                        System.out.println("Student information updated successfully!");
                    } else {
                        System.out.println("Student not found with roll number: " + updateRollNumber);
                    }
                    break;

                case 3:
                    System.out.print("Enter the roll number of the student to delete: ");
                    int deleteRollNumber = scanner.nextInt();

                    if (students.containsKey(deleteRollNumber)) {
                        students.remove(deleteRollNumber);
                        System.out.println("Student deleted successfully!");
                    } else {
                        System.out.println("Student not found with roll number: " + deleteRollNumber);
                    }
                    break;

                case 4:
                    System.out.println("All Students:");
                    for (Student currentstudent : students.values()) {
                        System.out.println(currentstudent);
                    }
                    break;

                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
