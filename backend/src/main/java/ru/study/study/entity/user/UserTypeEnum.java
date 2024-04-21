package ru.study.study.entity.user;

public enum UserTypeEnum {
    ADMIN,
    TEACHER,
    STUDENT;

   public static UserTypeEnum getById(Long id) {
        return UserTypeEnum.values()[id.intValue()];
    }

    public Long getId() { return (long) this.ordinal(); }
}
