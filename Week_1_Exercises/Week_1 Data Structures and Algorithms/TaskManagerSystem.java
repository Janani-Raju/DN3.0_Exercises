public class TaskManagerSystem {

    // Task class
    public static class Task {
        int taskId;
        String taskName;
        String status; // or boolean status, depending on requirements

        // Constructor
        public Task(int taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
        }
    }

    // Node class for singly linked list
    private static class Node {
        Task task;
        Node next;

        // Constructor
        public Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    // TaskManager class
    public static class TaskManager {
        private Node head;

        // Constructor
        public TaskManager() {
            this.head = null;
        }

        // Add task
        public void addTask(Task task) {
            Node newNode = new Node(task);
            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }

        // Search task by ID
        public Task searchTask(int taskId) {
            Node temp = head;
            while (temp != null) {
                if (temp.task.taskId == taskId) {
                    return temp.task;
                }
                temp = temp.next;
            }
            return null; // Task not found
        }

        // Traverse and print tasks
        public void traverseTasks() {
            Node temp = head;
            while (temp != null) {
                System.out.println("Task ID: " + temp.task.taskId + ", Name: " + temp.task.taskName + ", Status: " + temp.task.status);
                temp = temp.next;
            }
        }

        // Delete task by ID
        public void deleteTask(int taskId) {
            if (head == null) return;

            if (head.task.taskId == taskId) {
                head = head.next;
                return;
            }

            Node temp = head;
            while (temp.next != null && temp.next.task.taskId != taskId) {
                temp = temp.next;
            }

            if (temp.next != null) {
                temp.next = temp.next.next;
            }
        }
    }

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        // Adding tasks
        manager.addTask(new Task(1, "Task One", "Incomplete"));
        manager.addTask(new Task(2, "Task Two", "Incomplete"));
        manager.addTask(new Task(3, "Task Three", "Complete"));

        // Traversing tasks
        System.out.println("All tasks:");
        manager.traverseTasks();

        // Searching for a task
        System.out.println("\nSearching for task with ID 2:");
        Task task = manager.searchTask(2);
        if (task != null) {
            System.out.println("Found Task - ID: " + task.taskId + ", Name: " + task.taskName + ", Status: " + task.status);
        } else {
            System.out.println("Task not found");
        }

        // Deleting a task
        System.out.println("\nDeleting task with ID 2:");
        manager.deleteTask(2);

        // Traversing tasks again to verify deletion
        System.out.println("\nAll tasks after deletion:");
        manager.traverseTasks();
    }
}
