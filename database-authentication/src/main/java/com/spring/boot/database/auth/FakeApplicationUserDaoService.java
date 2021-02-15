package com.spring.boot.database.auth;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.spring.boot.database.model.ApplicationUserRole.ADMIN;
import static com.spring.boot.database.model.ApplicationUserRole.STUDENT;

@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDAO {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUserName(String userName) {
        return getApplicationsUsers()
                .stream()
                .filter(applicationUser -> userName.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationsUsers() {
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
                new ApplicationUser(
                        "admin",
                        passwordEncoder.encode("admin"),
                        ADMIN.getGrantedAuthorities(),
                        true, true, true, true
                ),
                new ApplicationUser(
                        "student",
                        passwordEncoder.encode("12345"),
                        STUDENT.getGrantedAuthorities(),
                        true, true, true, true
                ),
                new ApplicationUser(
                        "intern",
                        passwordEncoder.encode("intern"),
                        STUDENT.getGrantedAuthorities(),
                        true, true, true, true
                )
        );
        return applicationUsers;
    }

}
