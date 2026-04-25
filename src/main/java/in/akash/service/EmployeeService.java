package in.akash.service;

import in.akash.entity.Employee;
import in.akash.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    public String deleteById(Integer id)
    {
        employeeRepository.deleteById(id);
        return "Employee Deleted Successfully";
    }

    public Employee fetchById(Integer id)
    {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> fetchAllEmployees()
    {
        return employeeRepository.findAll();
    }

    public Employee updateSalById(Integer empno, Double sal)
    {
        employeeRepository.updateSal(empno, sal);
        return fetchById(empno);
    }
}

