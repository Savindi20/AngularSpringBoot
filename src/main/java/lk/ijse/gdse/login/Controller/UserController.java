package lk.ijse.gdse.login.Controller;

import lk.ijse.gdse.login.Service.AuthenticationService;
import lk.ijse.gdse.login.reqAndresp.response.JwtAuthResponse;
import lk.ijse.gdse.login.reqAndresp.secure.SignIn;
import lk.ijse.gdse.login.reqAndresp.secure.SignUp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
    private final AuthenticationService authenticationService;

    @GetMapping("/health")
    public String health(){
        return "OK";
    }

    @PostMapping("/signup")
    public ResponseEntity<JwtAuthResponse> signUp(@RequestBody SignUp signUp) {
        System.out.println(signUp.getName());
        System.out.println(signUp.getEmail());
        System.out.println(signUp.getPassword());

        return ResponseEntity.ok(authenticationService.signUp(signUp));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthResponse> signIn(@RequestBody SignIn signInReq) {
        return ResponseEntity.ok(authenticationService.signIn(signInReq));
    }
}