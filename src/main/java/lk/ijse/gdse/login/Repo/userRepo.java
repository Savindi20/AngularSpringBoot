package lk.ijse.gdse.login.Repo;

import lk.ijse.gdse.login.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface userRepo extends JpaRepository<user, Integer> {
}
