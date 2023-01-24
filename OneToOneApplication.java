package com.gloify.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gloify.OneToOne.Entity.Employee;
import com.gloify.OneToOne.Entity.EmployeeContact;
import com.gloify.OneToOne.Repository.EmployeeRepository;

@SpringBootApplication
public class OneToOneApplication implements CommandLineRunner {
	@Autowired
	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(OneToOneApplication.class, args);
	}
	@Override
    public void run(String... args) throws Exception {
        Employee employee = new Employee();
        employee.setName("mohan");
        employee.setSalary(24000);
        EmployeeContact contact = new EmployeeContact();
        contact.setPhoneNo(111111111111l);
        employee.setEmployeeContact(contact);
        employeeRepository.save(employee);
   }
}
