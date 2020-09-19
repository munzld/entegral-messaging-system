package com.example.entegralmessagingsystem;

import com.example.entegralmessagingsystem.model.CommunicationType;
import com.example.entegralmessagingsystem.model.Company;
import com.example.entegralmessagingsystem.model.Employee;
import com.example.entegralmessagingsystem.model.EmployeeType;
import com.example.entegralmessagingsystem.repository.CompanyRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class EntegralMessagingSystemApplication implements CommandLineRunner {

	private CompanyRepository companyRepository;

	public EntegralMessagingSystemApplication(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(EntegralMessagingSystemApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		companyRepository.deleteAll();

		List<Employee> employees = new ArrayList<>();
		employees.add(Employee.builder()
			.firstName("Lucas")
			.lastName("Munns")
			.email("munnsld@gmail.com")
			.phoneNumber("7155584560")
			.communicationType(CommunicationType.EMAIL)
			.employeeType(EmployeeType.DEVELOPER)
			.build()
		);

		companyRepository.save(Company.builder()
				.id("1")
				.name("Entegral")
				.employees(employees)
				.build()
		);
	}

}
