package lk.ijse.gdse.login.Service.Impl;

import lk.ijse.gdse.login.DAO.UserDAO;
import lk.ijse.gdse.login.DTO.UserDTO;
import lk.ijse.gdse.login.Entity.User;
import lk.ijse.gdse.login.Service.AuthenticationService;
import lk.ijse.gdse.login.Service.JWTService;
import lk.ijse.gdse.login.conversion.Mapping;
import lk.ijse.gdse.login.reqAndresp.response.JwtAuthResponse;
import lk.ijse.gdse.login.reqAndresp.secure.SignIn;
import lk.ijse.gdse.login.reqAndresp.secure.SignUp;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private  final UserDAO userDAO;
    private final Mapping mapping;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthResponse signIn(SignIn signIn) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signIn.getEmail(), signIn.getPassword()));
        var userByEmail = userDAO.findByEmail(signIn.getEmail()).orElseThrow(() -> new UsernameNotFoundException("Email not found"));
        String token = jwtService.generateToken(userByEmail);
        return JwtAuthResponse.builder().token(token).build();
    }

    @Override
    public JwtAuthResponse signUp(SignUp signUp) {
        UserDTO build = UserDTO.builder()
                .userId(UUID.randomUUID().toString())
                .name(signUp.getName())
                .email(signUp.getEmail())
                .password(passwordEncoder.encode(signUp.getPassword()))
                .build();

        User user = userDAO.save(mapping.toUser(build));
        String generateToken = jwtService.generateToken(user);
        return JwtAuthResponse.builder().token(generateToken).build();
    }
}
