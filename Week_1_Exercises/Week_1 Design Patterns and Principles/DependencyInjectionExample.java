// DependencyInjectionExample.java

// Define the Repository Interface
interface CustomerRepository {
    String findCustomerById(int id);
}

// Implement the Concrete Repository
class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(int id) {
        // Simulating a database lookup
        return "Customer with ID " + id;
    }
}

// Define the Service Class
class CustomerService {
    private final CustomerRepository customerRepository;

    // Constructor Injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public String getCustomerDetails(int id) {
        return customerRepository.findCustomerById(id);
    }
}

// Main Class to Test Dependency Injection
public class DependencyInjectionExample {
    public static void main(String[] args) {
        // Create an instance of CustomerRepositoryImpl
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        // Inject the repository into CustomerService
        CustomerService customerService = new CustomerService(customerRepository);

        // Use the service to find and display a customer
        String customerDetails = customerService.getCustomerDetails(1);
        System.out.println(customerDetails);
    }
}
