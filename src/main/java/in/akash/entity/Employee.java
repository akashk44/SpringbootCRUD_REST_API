package in.akash.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "EMPLOYEE")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(description = "Employee entity representing an employee record in the database")
public class Employee {

    @Id
    @Positive(message = "{emp.empno.not.negative}")
    @Schema(description = "employee number, must be a positive integer", example = "123")
    private Integer empno;

    @NotBlank(message = "{emp.name.not.blank}")
    @Schema(description = "employee name, cannot be blank", example = "John Doe")
    private String name;

    @Positive(message = "Salary must be positive")
    @NotNull(message = "Salary cannot be null")
    @Schema(description = "employee salary, must be a positive number", example = "50000.0")
    private Double sal;

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSal() {
        return sal;
    }

    public void setSal(Double sal) {
        this.sal = sal;
    }
}
