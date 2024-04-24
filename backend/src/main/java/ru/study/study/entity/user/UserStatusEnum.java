package ru.study.study.entity.user;

public enum UserStatusEnum {
    ACTIVE,
    BLOCKED,
    ARCHIVED;


    public static UserStatusEnum getById(Long id) {
        return UserStatusEnum.values()[id.intValue()];
    }

    public Long getId() { return (long) this.ordinal(); }
}
