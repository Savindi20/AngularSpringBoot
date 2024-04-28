package lk.ijse.gdse.login.Service;


import lk.ijse.gdse.login.reqAndresp.response.JwtAuthResponse;
import lk.ijse.gdse.login.reqAndresp.secure.SignIn;
import lk.ijse.gdse.login.reqAndresp.secure.SignUp;

public interface AuthenticationService {
    JwtAuthResponse signIn(SignIn signIn);
    JwtAuthResponse signUp(SignUp signUp);
}
