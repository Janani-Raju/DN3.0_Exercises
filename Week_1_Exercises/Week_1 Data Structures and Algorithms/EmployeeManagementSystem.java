class Employee {
    private int employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", name=" + name + 
               ", position=" + position + ", salary=" + salary + "]";
    }
}

public class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    // Add a new employee
    public boolean addEmployee(Employee employee) {
        if (size >= employees.length) {
            System.out.println("Array is full. Cannot add more employees.");
            return false;
        }
        employees[size++] = employee;
        return true;
    }

    // Search for an employee by employeeId
    public Employee searchEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse and print all employees
    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete an employee by employeeId
    public boolean deleteEmployee(int employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId() == employeeId) {
                employees[i] = employees[size - 1]; // Replace with the last employee
                employees[--size] = null; // Decrease size and nullify the last element
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(10);

        // Adding employees
        ems.addEmployee(new Employee(1, "John Doe", "Manager", 75000));
        ems.addEmployee(new Employee(2, "Jane Smith", "Developer", 60000));
        ems.addEmployee(new Employee(3, "Peter Johnson", "Analyst", 55000));

        // Traversing employees
        System.out.println("Employee List:");
        ems.traverseEmployees();

        // Searching for an employee
        System.out.println("\nSearch Result:");
        System.out.println(ems.searchEmployee(2));

        // Deleting an employee
        ems.deleteEmployee(2);

        // Traversing employees after deletion
        System.out.println("\nEmployee List after Deletion:");
        ems.traverseEmployees();
    }
}
