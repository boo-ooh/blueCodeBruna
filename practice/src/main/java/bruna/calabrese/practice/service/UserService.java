package bruna.calabrese.practice.service;


import bruna.calabrese.practice.model.UserDTO;

public interface UserService {

    int createUser(UserDTO userDTO);

    UserDTO getUser(int id);
}
