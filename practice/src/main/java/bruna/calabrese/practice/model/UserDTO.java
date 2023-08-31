package bruna.calabrese.practice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserDTO {

    private int id;
    private String name;
    private String email;
    private int age;

}
