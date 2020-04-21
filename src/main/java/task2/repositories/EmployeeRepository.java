package task2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import task2.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
