package salahin.jasper.report.reportdemo.controller;

import net.sf.jasperreports.engine.JRException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import salahin.jasper.report.reportdemo.entity.Employee;
import salahin.jasper.report.reportdemo.repository.EmployeeRepository;
import salahin.jasper.report.reportdemo.service.ReportService;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
public class ReportController {
	
	private final EmployeeRepository repository;
	private final ReportService service;
	
	public ReportController(EmployeeRepository repository, ReportService service) {
		this.repository = repository;
		this.service = service;
	}
	
	@GetMapping("/getEmployees")
	public List<Employee> getEmployees() {
		
		return repository.findAll();
	}
	
	@GetMapping("/report/{format}")
	public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
		return service.exportReport(format);
	}
}
