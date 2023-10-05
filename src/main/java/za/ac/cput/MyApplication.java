package za.ac.cput;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.User;
import za.ac.cput.domain.Role;
import za.ac.cput.domain.RoleName;
import za.ac.cput.repository.RoleRepository;
import za.ac.cput.repository.UserRepository;
import za.ac.cput.service.UserService;

import java.util.ArrayList;

@RestController
@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }


    @Bean
    CommandLineRunner run(UserService iUserService, RoleRepository iRoleRepository, UserRepository iUserRepository, PasswordEncoder passwordEncoder) {
        return args ->
        {
            Role guestRole = iRoleRepository.findByRoleName(RoleName.CUSTOMER);
            if (guestRole == null) {
                iRoleRepository.save(new Role(RoleName.CUSTOMER));
                Role role = iRoleRepository.findByRoleName(RoleName.CUSTOMER);
                User user = (User) iUserRepository.findByEmail("customer@gmail.com").orElse(null);
                user.getRole().add(role);
                iUserService.create(user);
            }

            Role userRole = iRoleRepository.findByRoleName(RoleName.EMPLOYEE);
            if (userRole == null) {
                iRoleRepository.save(new Role(RoleName.EMPLOYEE));
                Role role = iRoleRepository.findByRoleName(RoleName.EMPLOYEE);
                User user = (User) iUserRepository.findByEmail("employee@extraTecha.com").orElse(null);
                user.getRole().add(role);
                iUserService.create(user);

            }

            Role supportRole = iRoleRepository.findByRoleName(RoleName.ADMIN);
            if (supportRole == null) {
                iRoleRepository.save(new Role(RoleName.ADMIN));
                Role role = iRoleRepository.findByRoleName(RoleName.ADMIN);
                User user = (User) iUserRepository.findByEmail("admin@admin.com").orElse(null);
                user.getRole().add(role);
                iUserService.create(user);

            }
        };
    }

}
