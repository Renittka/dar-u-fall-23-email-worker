package kz.dar.university.email.worker.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {

    TO_DO("TO_DO"),
    IN_PROGRESS("IN_PROGRESS"),
    DONE("Done");

    private final String title;
}
