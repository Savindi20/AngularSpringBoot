package lk.ijse.gdse.login.DAO;

import lk.ijse.gdse.login.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDAO extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);
}
