package lk.ijse.gdse.login.Service;

import lk.ijse.gdse.login.DTO.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    void save(UserDTO userDTO);
    UserDetailsService userDetailsService();
}
