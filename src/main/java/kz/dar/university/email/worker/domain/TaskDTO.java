package kz.dar.university.email.worker.domain;

import kz.dar.university.email.worker.util.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskDTO {

    private String taskId;
    private EmployeeDTO employee;
    private String title;
    private Status status;

}
