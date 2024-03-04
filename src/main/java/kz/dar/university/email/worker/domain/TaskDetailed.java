package kz.dar.university.email.worker.domain;

import kz.dar.university.email.worker.util.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskDetailed {

    private String taskId;
    private EmployeeDTO employee;
    private String title;
    private Status status;
    private Map<String, String> files;

}
