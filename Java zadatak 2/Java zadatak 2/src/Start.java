import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Start {
    private List<Subject> subjects;
    private List<Student> students;
    private List<Teacher> teachers;

    private Scanner scanner;

    public static void main(String[] args) {
        Start main = new Start();
        main.initializeData();
        main.displayMenu();
    }

    public Start() {
        subjects = new ArrayList<>();
        students = new ArrayList<>();
        teachers = new ArrayList<>();

        scanner = new Scanner(System.in);
    }

    private void initializeData() {
        // For demonstration purposes, let's add some initial data
        // Students
        Student student1 = new Student("Alice", 16, false);
        Student student2 = new Student("Bob", 15, true);
        students.add(student1);
        students.add(student2);

        // Teachers
        Teacher teacher1 = new Teacher("John Doe", 35, true);
        Teacher teacher2 = new Teacher("Jane Smith", 40, false);
        teachers.add(teacher1);
        teachers.add(teacher2);

        // Subjects
        Subject math = new Subject("Math");
        math.addTeacher(teacher1);
        math.addStudent(student1);
        math.addStudent(student2);
        subjects.add(math);

        Subject history = new Subject("History");
        history.addTeacher(teacher2);
        history.addStudent(student1);
        history.addStudent(student2);
        subjects.add(history);
    }

    private void displayMenu() {
        int option;
        do {
            System.out.println("Welcome to the School Management System");
            System.out.println("Menu");
            System.out.println("1. Manage Students");
            System.out.println("2. Manage Teachers");
            System.out.println("3. Manage Subjects");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                option = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (option) {
                    case 1:
                        manageStudents();
                        break;
                    case 2:
                        manageTeachers();
                        break;
                    case 3:
                        manageSubjects();
                        break;
                    case 4:
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option (1 to 4).");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid option (1 to 4).");
                scanner.nextLine(); // Clear the invalid input
                option = 0; // Reset the option to re-prompt the user
            }

            System.out.println();
        } while (option != 4);
    }

    private void manageStudents() {
        int option;
        do {
            System.out.println("Students Menu");
            System.out.println("1. View Students");
            System.out.println("2. Add Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");

            try {
                option = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (option) {
                    case 1:
                        viewStudents();
                        break;
                    case 2:
                        addStudent();
                        break;
                    case 3:
                        // Implement update student
                        break;
                    case 4:
                        // Implement delete student
                        break;
                    case 5:
                        return; // Back to main menu
                    default:
                        System.out.println("Invalid choice. Please enter a valid option (1 to 5).");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid option (1 to 5).");
                scanner.nextLine(); // Clear the invalid input
                option = 0; // Reset the option to re-prompt the user
            }

            System.out.println();
        } while (option != 5);
    }

    private void manageTeachers() {
        int option;
        do {
            System.out.println("Teachers Menu");
            System.out.println("1. View Teachers");
            System.out.println("2. Add Teacher");
            System.out.println("3. Update Teacher");
            System.out.println("4. Delete Teacher");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");

            try {
                option = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (option) {
                    case 1:
                        viewTeachers();
                        break;
                    case 2:
                        addTeacher();
                        break;
                    case 3:
                        // Implement update teacher
                        break;
                    case 4:
                        // Implement delete teacher
                        break;
                    case 5:
                        return; // Back to main menu
                    default:
                        System.out.println("Invalid choice. Please enter a valid option (1 to 5).");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid option (1 to 5).");
                scanner.nextLine(); // Clear the invalid input
                option = 0; // Reset the option to re-prompt the user
            }

            System.out.println();
        } while (option != 5);
    }

    private void manageSubjects() {
        int option;
        do {
            System.out.println("Subjects Menu");
            System.out.println("1. View Subjects");
            System.out.println("2. Add Subject");
            System.out.println("3. Update Subject");
            System.out.println("4. Delete Subject");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");

            try {
                option = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (option) {
                    case 1:
                        viewSubjects();
                        break;
                    case 2:
                        addSubject();
                        break;
                    case 3:
                        // Implement update subject
                        break;
                    case 4:
                        // Implement delete subject
                        break;
                    case 5:
                        return; // Back to main menu
                    default:
                        System.out.println("Invalid choice. Please enter a valid option (1 to 5).");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid option (1 to 5).");
                scanner.nextLine(); // Clear the invalid input
                option = 0; // Reset the option to re-prompt the user
            }

            System.out.println();
        } while (option != 5);
    }

    private void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("Students:");
            for (Student student : students) {
                System.out.println("Name: " + student.getName() + ", Age: " + student.getAge() + ", Gender: " + (student.isMale() ? "Male" : "Female"));
            }
        }
    }

    private void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        int age = Util.readInt("Enter student age: ", "Invalid age. Please enter a valid age.", 1, 150);
        boolean isMale = Util.readGender("Enter student gender (M/F): ");

        Student newStudent = new Student(name, age, isMale);
        students.add(newStudent);

        System.out.println("Student added successfully!");
    }

    private void viewTeachers() {
        if (teachers.isEmpty()) {
            System.out.println("No teachers found.");
        } else {
            System.out.println("Teachers:");
            for (Teacher teacher : teachers) {
                System.out.println("Name: " + teacher.getName() + ", Age: " + teacher.getAge() + ", Gender: " + (teacher.isMale() ? "Male" : "Female"));
            }
        }
    }

    private void addTeacher() {
        System.out.print("Enter teacher name: ");
        String name = scanner.nextLine();
        int age = Util.readInt("Enter teacher age: ", "Invalid age. Please enter a valid age.", 1, 150);
        boolean isMale = Util.readGender("Enter teacher gender (M/F): ");

        Teacher newTeacher = new Teacher(name, age, isMale);
        teachers.add(newTeacher);

        System.out.println("Teacher added successfully!");
    }

    private void viewSubjects() {
        if (subjects.isEmpty()) {
            System.out.println("No subjects found.");
        } else {
            System.out.println("Subjects:");
            for (Subject subject : subjects) {
                System.out.println("Subject: " + subject.getSubjectName());
                System.out.println("Teachers:");
                for (Teacher teacher : subject.getTeachers()) {
                    System.out.println("  - Name: " + teacher.getName() + ", Age: " + teacher.getAge() + ", Gender: " + (teacher.isMale() ? "Male" : "Female"));
                }
                System.out.println("Students:");
                for (Student student : subject.getStudents()) {
                    System.out.println("  - Name: " + student.getName() + ", Age: " + student.getAge() + ", Gender: " + (student.isMale() ? "Male" : "Female"));
                }
                System.out.println();
            }
        }
    }

    private void addSubject() {
        System.out.print("Enter subject name: ");
        String subjectName = scanner.nextLine();

        Subject newSubject = new Subject(subjectName);

        boolean addTeacher = Util.readYesOrNo("Do you want to add a teacher for " + subjectName + "? (yes/no)", "Please enter 'yes' or 'no'.");

        while (addTeacher) {
            String teacherName = Util.readString("Enter the teacher's name: ", "Teacher's name cannot be empty.");
            int teacherAge = Util.readInt("Enter the teacher's age: ", "Invalid input. Please enter a valid age.", 18, 100);
            boolean isMale = Util.readGender("Enter the teacher's gender (M/F): ");
            newSubject.addTeacher(new Teacher(teacherName, teacherAge, isMale));

            addTeacher = Util.readYesOrNo("Do you want to add another teacher for " + subjectName + "? (yes/no)", "Please enter 'yes' or 'no'.");
        }

        boolean addStudents = Util.readYesOrNo("Do you want to add students for " + subjectName + "? (yes/no)", "Please enter 'yes' or 'no'.");

        while (addStudents) {
            String studentName = Util.readString("Enter the student's name: ", "Student's name cannot be empty.");
            int studentAge = Util.readInt("Enter the student's age: ", "Invalid input. Please enter a valid age.", 5, 18);

            boolean isMale = Util.readGender("Enter the student's gender (M/F): ");
            newSubject.addStudent(new Student(studentName, studentAge, isMale));

            addStudents = Util.readYesOrNo("Do you want to add another student for " + subjectName + "? (yes/no)", "Please enter 'yes' or 'no'.");
        }

        subjects.add(newSubject);
        System.out.println("Subject added successfully!");
    }
}