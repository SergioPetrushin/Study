package ru.study.study.entity.task;

public enum TaskStatusEnum {

    CREATED,
    CHANGED,
    ISSUED,
    IN_WORK,
    QUESTION,
    ON_CHECK,
    COMPLETED,
    REJECTED;

    public static TaskStatusEnum getById (Long id) {
        return TaskStatusEnum.values()[id.intValue()];
    }

    public Long getId() {
        return (long) this.ordinal();
    }

    }
