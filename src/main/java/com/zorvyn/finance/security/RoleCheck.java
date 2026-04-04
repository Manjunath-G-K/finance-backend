package com.zorvyn.finance.security;

import com.zorvyn.finance.model.Role;
import com.zorvyn.finance.model.User;

public class RoleCheck {

    public static void checkAdmin(User user) {
        if (user.getRole() != Role.ADMIN) {
            throw new RuntimeException("Access denied: Admin only");
        }
    }
}