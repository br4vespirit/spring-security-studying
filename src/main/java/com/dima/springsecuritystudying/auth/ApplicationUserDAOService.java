package com.dima.springsecuritystudying.auth;

import com.google.common.collect.Lists;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.dima.springsecuritystudying.security.UserRole.*;

@Repository("database")
public class ApplicationUserDAOService implements ApplicationUserDAO {

    private final PasswordEncoder passwordEncoder;

    public ApplicationUserDAOService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getUsers().stream().filter(applicationUser -> username.equals(applicationUser.getUsername())).findFirst();
    }

    public List<ApplicationUser> getUsers() {
        List<ApplicationUser> users = Lists.newArrayList(
                new ApplicationUser(
                        STUDENT.getGrantedAuthorities(),
                        passwordEncoder.encode("pass1"),
                        "anna",
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        ADMIN.getGrantedAuthorities(),
                        passwordEncoder.encode("pass2"),
                        "alex",
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        ADMIN_TRAINEE.getGrantedAuthorities(),
                        passwordEncoder.encode("pass321"),
                        "tom123",
                        true,
                        true,
                        true,
                        true
                )
        );

        return users;
    }
}
