import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class
Start {
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
        System.out.println("Welcome to the Classroom");
        int option;
        do {
            System.out.println("Menu");
            System.out.println("1. Students");
            System.out.println("2. Teachers");
            System.out.println("3. Subjects");
            System.out.println("4. View Saved Data");
            System.out.println("5. Exit");
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
                        viewSavedData();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        break;
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

    private void manageStudents() {
        int option;
        do {
            System.out.println("Student Management");
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
                        updateStudent();
                        break;
                    case 4:
                        deleteStudent();
                        break;
                    case 5:
                        return; // Back to the main menu
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
            System.out.println("Teacher Management");
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
                        updateTeacher();
                        break;
                    case 4:
                        deleteTeacher();
                        break;
                    case 5:
                        return; // Back to the main menu
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
            System.out.println("Subject Management");
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
                        updateSubject();
                        break;
                    case 4:
                        deleteSubject();
                        break;
                    case 5:
                        return; // Back to the main menu
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
            return;
        }

        System.out.println("Students:");
        for (Student student : students) {
            System.out.println(student.getName() + " (Age: " + student.getAge() + ", Gender: " + (student.isMale() ? "Male" : "Female") + ")");
        }
    }

    private void addStudent() {
        System.out.print("Enter the student's name: ");
        String studentName = scanner.nextLine();
        int studentAge = Util.readInt("Enter the student's age: ", "Invalid input. Please enter a valid age.", 5, 18);
        boolean isMale = Util.readGender("Enter the student's gender (M/F): ");

        Student newStudent = new Student(studentName, studentAge, isMale);
        students.add(newStudent);
        System.out.println("Student added successfully!");
    }

    private void updateStudent() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.print("Enter the name of the student you want to update: ");
        String studentName = scanner.nextLine();

        boolean found = false;
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(studentName)) {
                System.out.print("Enter the new name for " + studentName + ": ");
                String newStudentName = scanner.nextLine();
                int newStudentAge = Util.readInt("Enter the new age for " + studentName + ": ", "Invalid input. Please enter a valid age.", 5, 18);
                boolean newIsMale = Util.readGender("Enter the new gender (M/F) for " + studentName + ": ");

                student.setName(newStudentName);
                student.setAge(newStudentAge);
                student.setMale(newIsMale);

                System.out.println("Student updated successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    private void deleteStudent() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.print("Enter the name of the student you want to delete: ");
        String studentName = scanner.nextLine();

        boolean found = false;
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(studentName)) {
                students.remove(student);
                System.out.println("Student deleted successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    private void viewTeachers() {
        if (teachers.isEmpty()) {
            System.out.println("No teachers found.");
            return;
        }

        System.out.println("Teachers:");
        for (Teacher teacher : teachers) {
            System.out.println(teacher.getName() + " (Age: " + teacher.getAge() + ", Gender: " + (teacher.isMale() ? "Male" : "Female") + ")");
        }
    }

    private void addTeacher() {
        System.out.print("Enter the teacher's name: ");
        String teacherName = scanner.nextLine();
        int teacherAge = Util.readInt("Enter the teacher's age: ", "Invalid input. Please enter a valid age.", 18, 100);
        boolean isMale = Util.readGender("Enter the teacher's gender (M/F): ");

        Teacher newTeacher = new Teacher(teacherName, teacherAge, isMale);
        teachers.add(newTeacher);
        System.out.println("Teacher added successfully!");
    }

    private void updateTeacher() {
        if (teachers.isEmpty()) {
            System.out.println("No teachers found.");
            return;
        }

        System.out.print("Enter the name of the teacher you want to update: ");
        String teacherName = scanner.nextLine();

        boolean found = false;
        for (Teacher teacher : teachers) {
            if (teacher.getName().equalsIgnoreCase(teacherName)) {
                System.out.print("Enter the new name for " + teacherName + ": ");
                String newTeacherName = scanner.nextLine();
                int newTeacherAge = Util.readInt("Enter the new age for " + teacherName + ": ", "Invalid input. Please enter a valid age.", 18, 100);
                boolean newIsMale = Util.readGender("Enter the new gender (M/F) for " + teacherName + ": ");

                teacher.setName(newTeacherName);
                teacher.setAge(newTeacherAge);
                teacher.setMale(newIsMale);

                System.out.println("Teacher updated successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Teacher not found.");
        }
    }

    private void deleteTeacher() {
        if (teachers.isEmpty()) {
            System.out.println("No teachers found.");
            return;
        }

        System.out.print("Enter the name of the teacher you want to delete: ");
        String teacherName = scanner.nextLine();

        boolean found = false;
        for (Teacher teacher : teachers) {
            if (teacher.getName().equalsIgnoreCase(teacherName)) {
                teachers.remove(teacher);
                System.out.println("Teacher deleted successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Teacher not found.");
        }
    }

    private void viewSubjects() {
        if (subjects.isEmpty()) {
            System.out.println("No subjects found.");
            return;
        }

        System.out.println("Subjects:");
        for (Subject subject : subjects) {
            System.out.println(subject.getSubjectName());
        }

        String subjectName = Util.readString("Enter the subject name to view details (or type 'back' to return to the main menu): ", "Subject name cannot be empty.");

        if (subjectName.equalsIgnoreCase("back")) {
            return;
        }

        boolean found = false;
        for (Subject subject : subjects) {
            if (subject.getSubjectName().equalsIgnoreCase(subjectName)) {
                System.out.println(subject);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Subject not found.");
        }
    }

    private void addSubject() {
        System.out.print("Enter the subject name: ");
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

        boolean addStudents = Util.readYesOrNo("Do you want to add students for " + subjectName + "? (yes/no)", "Please enter ' yes' or 'no'.");

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

    private void updateSubject() {
        if (subjects.isEmpty()) {
            System.out.println("No subjects found.");
            return;
        }

        System.out.print("Enter the name of the subject you want to update: ");
        String subjectName = scanner.nextLine();

        boolean found = false;
        for (Subject subject : subjects) {
            if (subject.getSubjectName().equalsIgnoreCase(subjectName)) {
                System.out.print("Enter the new name for " + subjectName + ": ");
                String newSubjectName = scanner.nextLine();
                subject.setSubjectName(newSubjectName);

                System.out.println("Subject updated successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Subject not found.");
        }
    }

    private void deleteSubject() {
        if (subjects.isEmpty()) {
            System.out.println("No subjects found.");
            return;
        }

        System.out.print("Enter the name of the subject you want to delete: ");
        String subjectName = scanner.nextLine();

        boolean found = false;
        for (Subject subject : subjects) {
            if (subject.getSubjectName().equalsIgnoreCase(subjectName)) {
                subjects.remove(subject);
                System.out.println("Subject deleted successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Subject not found.");
        }
    }

    private void viewSavedData() {
        System.out.println("Saved Data:");
        System.out.println("Students:");
        for (Student student : students) {
            System.out.println(student.getName() + " (Age: " + student.getAge() + ", Gender: " + (student.isMale() ? "Male" : "Female") + ")");
        }

        System.out.println("Teachers:");
        for (Teacher teacher : teachers) {
            System.out.println(teacher.getName() + " (Age: " + teacher.getAge() + ", Gender: " + (teacher.isMale() ? "Male" : "Female") + ")");
        }

        System.out.println("Subjects:");
        for (Subject subject : subjects) {
            System.out.println(subject.getSubjectName());
        }
    }
}