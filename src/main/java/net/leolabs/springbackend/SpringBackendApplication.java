package net.leolabs.springbackend;

import net.leolabs.springbackend.model.Employee;
import net.leolabs.springbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBackendApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
		Employee employee = new Employee();
		employee.setFirstName("Gimhan");
		employee.setLastName("pabasara");
		employee.setEmailId("gimhanpabasarar4@gmail.com");
		employeeRepository.save(employee);

		Employee employee1 = new Employee();
		employee1.setFirstName("pabsaraa");
		employee1.setLastName("mung");
		employee1.setEmailId("pabasaramung94@gmail.com");
		employeeRepository.save(employee1);


	}
}
