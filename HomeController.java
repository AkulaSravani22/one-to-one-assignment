package com.gloify.OneToOne.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gloify.OneToOne.Entity.Employee;
import com.gloify.OneToOne.Repository.EmployeeRepository;
@RestController
@RequestMapping("employeedetails")
public class HomeController {
	  @Autowired
	    EmployeeRepository employeeRepository;
	  
	  Logger log= LoggerFactory.getLogger(HomeController.class);

	    @GetMapping
	    public List<Employee> findAll() {
	        return employeeRepository.findAll();

	    }

	    @PostMapping
	    public Employee saveEmployee(@RequestBody Employee employee) {
	    	try {
	    		log.info("saving employee");
	    	}catch (Exception e) {
	    		
	    	}
	    	
	        return employeeRepository.save(employee);

	    }

	    @GetMapping("/{employeeName}")
	    public List<Employee> findByName(@PathVariable("employeeName") 
	                              String employeeName) {
	        return employeeRepository.findByName(employeeName);

	    }

	    @DeleteMapping("/{id}")
	    public String deleteEmployee(@PathVariable("id") Integer id) {
	        try {
	            employeeRepository.deleteById(id);
	            return "Deleted successfully";
	        } catch (Exception e) {
	            return "Failed to delete";
	        }
	    }
	

	
}
