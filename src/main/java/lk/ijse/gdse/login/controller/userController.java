package lk.ijse.gdse.login.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class userController {

    @GetMapping("/health")
    public String health(){
        return "OK";
    }
}