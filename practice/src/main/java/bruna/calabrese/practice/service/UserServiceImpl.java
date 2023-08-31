package bruna.calabrese.practice.service;

import bruna.calabrese.practice.model.UserDTO;
import bruna.calabrese.practice.model.UserEntity;
import bruna.calabrese.practice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public int createUser(UserDTO userDTO) {
        UserEntity user = new UserEntity();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setAge(userDTO.getAge());

        user = userRepository.save(user);

        return user.getId();
    }

    public UserDTO getUser(int id) {
        UserEntity userEntity = userRepository.findById(id)
                                              .orElse(null);
        if (userEntity == null) {
            return null;
        }
        return convertUserEntity(userEntity);

    }

    private UserDTO convertUserEntity(UserEntity userEntity) {
        return new UserDTO(userEntity.getId(), userEntity.getName(), userEntity.getEmail(), userEntity.getAge());
    }
}
