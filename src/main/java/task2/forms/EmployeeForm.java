package task2.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import task2.models.Employee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeForm {
    private String name;
    private String job;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate hireDate;
    private Double salary;
    private Double comm;

    public static Employee formToEmployee(EmployeeForm employeeForm){
        return Employee.builder()
                .name(employeeForm.getName())
                .job(employeeForm.getJob())
                .hireDate(employeeForm.getHireDate())
                .salary(employeeForm.getSalary())
                .build();
    }

}
