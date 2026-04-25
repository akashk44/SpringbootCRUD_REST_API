package in.akash.repository;

import in.akash.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<in.akash.entity.Employee, Integer> {

    @Query(value = "UPDATE EMPLOYEE WHERE empno = ?", nativeQuery = true)
    @Modifying
    @Transactional
    Employee updateSal(Integer empno, Double sal);
}
