package net.leolabs.springbackend.repository;

import net.leolabs.springbackend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//    crud methods

}
