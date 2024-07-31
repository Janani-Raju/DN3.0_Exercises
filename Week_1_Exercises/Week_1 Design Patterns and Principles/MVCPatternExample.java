// MVCPatternExample.java
public class MVCPatternExample {

    // Model Class
    static class Student {
        private String name;
        private int id;
        private String grade;

        // Constructor
        public Student(String name, int id, String grade) {
            this.name = name;
            this.id = id;
            this.grade = grade;
        }

        // Getters and Setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }
    }

    // View Class
    static class StudentView {
        public void displayStudentDetails(String name, int id, String grade) {
            System.out.println("Student Details:");
            System.out.println("Name: " + name);
            System.out.println("ID: " + id);
            System.out.println("Grade: " + grade);
        }
    }

    // Controller Class
    static class StudentController {
        private Student model;
        private StudentView view;

        // Constructor
        public StudentController(Student model, StudentView view) {
            this.model = model;
            this.view = view;
        }

        // Update model details
        public void setStudentName(String name) {
            model.setName(name);
        }

        public String getStudentName() {
            return model.getName();
        }

        public void setStudentId(int id) {
            model.setId(id);
        }

        public int getStudentId() {
            return model.getId();
        }

        public void setStudentGrade(String grade) {
            model.setGrade(grade);
        }

        public String getStudentGrade() {
            return model.getGrade();
        }

        // Update view with model details
        public void updateView() {
            view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
        }
    }

    // Main Class
    public static void main(String[] args) {
        // Create model
        Student student = new Student("John Doe", 1, "A");

        // Create view
        StudentView view = new StudentView();

        // Create controller
        StudentController controller = new StudentController(student, view);

        // Display initial student details
        System.out.println("Initial Student Details:");
        controller.updateView();

        // Update student details
        controller.setStudentName("Jane Smith");
        controller.setStudentId(2);
        controller.setStudentGrade("B");

        // Display updated student details
        System.out.println("\nUpdated Student Details:");
        controller.updateView();
    }
}
