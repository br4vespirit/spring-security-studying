package com.dima.springsecuritystudying.security;

import com.google.common.collect.Sets;
import lombok.Getter;

import java.util.Set;

import static com.dima.springsecuritystudying.security.UserPermission.*;

public enum UserRole {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(COURSE_READ, COURSE_WRITE, STUDENT_READ, STUDENT_WRITE));

    @Getter
    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }
}
