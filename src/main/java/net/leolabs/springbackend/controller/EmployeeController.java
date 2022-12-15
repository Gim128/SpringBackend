package net.leolabs.springbackend.controller;

import net.leolabs.springbackend.execption.ResourceNotFoundException;
import net.leolabs.springbackend.model.Employee;
import net.leolabs.springbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

//    build create employee REST API
    @PostMapping
    public Employee createEMployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

//    create get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with this id" + id));
        return  ResponseEntity.ok(employee);
    }

//    update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Employee> updatedEMployee(@PathVariable("id") long id,@RequestBody Employee employeeDetails){
        Employee updateEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exists with id" + id));
        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());

        employeeRepository.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);
    }

//    delete Employee REST API
    @DeleteMapping("{id}")
    public  ResponseEntity<Employee> deleteEmployee(@PathVariable long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exixstys with id" + id));

        employeeRepository.delete(employee);

        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
