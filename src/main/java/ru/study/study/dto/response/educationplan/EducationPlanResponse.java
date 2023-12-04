package ru.study.study.dto.response.educationplan;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import ru.study.study.entity.user.User;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
@ToString
@EqualsAndHashCode

public class EducationPlanResponse {
    private Long planId;
    private String name;
    private String description;
    private User userId;
    private LocalDateTime created;
    private LocalDateTime modified;

}
