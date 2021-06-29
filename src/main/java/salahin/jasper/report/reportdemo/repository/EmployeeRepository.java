package salahin.jasper.report.reportdemo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import salahin.jasper.report.reportdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
