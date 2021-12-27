package com.badalovaraz.testProjectBank.testprojectbank.confiq.role;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.badalovaraz.testProjectBank.testprojectbank.confiq.role.UserPermission.USER_READ;
import static com.badalovaraz.testProjectBank.testprojectbank.confiq.role.UserPermission.USER_WRITE;

public enum UserRole {
    USER(Sets.newHashSet(USER_READ, USER_WRITE)),
    ADMIN(Sets.newHashSet());

    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }
}
