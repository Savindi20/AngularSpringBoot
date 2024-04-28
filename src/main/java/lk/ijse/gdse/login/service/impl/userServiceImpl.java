package lk.ijse.gdse.login.service.impl;

import lk.ijse.gdse.login.DTO.userDTO;
import lk.ijse.gdse.login.Repo.userRepo;
import lk.ijse.gdse.login.entity.user;
import lk.ijse.gdse.login.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl implements userService {

    @Autowired
    private userRepo UserRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addUser(userDTO UserDTO) {

        user User = new user(
                UserDTO.getUserid(),
                UserDTO.getUsername(),
                UserDTO.getEmail(),
                this.passwordEncoder.encode(UserDTO.getPassword())
        );

        UserRepo.save(User);

        return User.getUsername();
    }
}
