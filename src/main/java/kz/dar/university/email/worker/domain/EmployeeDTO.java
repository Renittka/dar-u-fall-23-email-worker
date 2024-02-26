package kz.dar.university.email.worker.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EmployeeDTO {

    private String employeeId;
    private String fullName;
    private String department;
    private String position;
    private String email;
    private double salary;

}
