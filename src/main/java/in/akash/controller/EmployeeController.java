package in.akash.controller;

import in.akash.entity.Employee;
import in.akash.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.SSLEngineResult;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping(value = "/Employee/{id}", produces = "application/json")
    public ResponseEntity<Employee> GetEmployee(@PathVariable Integer id) {
        Employee e = employeeService.fetchById(id);
        if (e == null)
            return ResponseEntity.notFound().build();
        else
            return new ResponseEntity<Employee>(e, HttpStatus.OK);
    }

    @PostMapping(value = "/save", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Employee> EmployeeSave( @Valid @RequestBody Employee employee) {
        try {
            Employee e = employeeService.saveEmployee(employee);
            return new ResponseEntity<Employee>(e, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping(value = "/update", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Employee> EmployeeUpdate(@RequestBody Employee employee) {
        if (employeeService.fetchById(employee.getEmpno()) == null)
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        else {
            Employee e = employeeService.saveEmployee(employee);
            return new ResponseEntity<Employee>(e, HttpStatus.OK);
        }
    }

    @PatchMapping(value = "/updateSal/{empno}",
            consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<Employee> EmployeeUpdateSal(@PathVariable Integer empno, @RequestBody Double sal) {
        if (employeeService.fetchById(empno) == null)
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        else {
            Employee e = employeeService.updateSalById(empno, (double)sal);
            return new ResponseEntity<Employee>(e, HttpStatus.OK);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> EmployeeDelete(@PathVariable Integer id) {
        if(employeeService.fetchById(id) == null)
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        else {
            String str = employeeService.deleteById(id);
            return new ResponseEntity<String>(str,HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping(value = "/employees" , produces = "application/json")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> list = employeeService.fetchAllEmployees();
        if(list.isEmpty())
            return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
    }



}
