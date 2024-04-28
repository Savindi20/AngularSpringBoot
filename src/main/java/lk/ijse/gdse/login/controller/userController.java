package lk.ijse.gdse.login.controller;

import lk.ijse.gdse.login.DTO.userDTO;
import lk.ijse.gdse.login.service.userService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class userController {

    @Autowired
    private userService UserService;

    @PostMapping(path = "/save")
    public String saveUser(@RequestBody userDTO UserDTO){
        String id = UserService.addUser(UserDTO);
        return id;
    }
}