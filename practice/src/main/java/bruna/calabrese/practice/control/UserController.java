package bruna.calabrese.practice.control;

import bruna.calabrese.practice.model.UserDTO;
import bruna.calabrese.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {


    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity create(@RequestBody UserDTO userDTO) {

        int id = userService.createUser(userDTO);

        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(1);
    }


    @GetMapping("/{id}")
    public ResponseEntity create(@PathVariable int id) {

        UserDTO user = userService.getUser(id);
        if (user != null) {
            return ResponseEntity.status(HttpStatus.CREATED)
                                 .body(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                                 .build();
        }
    }


}
