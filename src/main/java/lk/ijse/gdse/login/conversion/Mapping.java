package lk.ijse.gdse.login.conversion;

import lk.ijse.gdse.login.DTO.UserDTO;
import lk.ijse.gdse.login.Entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
@Component
public class Mapping {
    final private ModelMapper mapper;

    public Mapping(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public UserDTO toUserDTO(User user) {
        return  mapper.map(user, UserDTO.class);
    }

    public User toUser(UserDTO userDTO) {
        return  mapper.map(userDTO, User.class);
    }

}
