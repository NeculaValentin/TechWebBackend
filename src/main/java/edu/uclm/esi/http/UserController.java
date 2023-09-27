package edu.uclm.esi.http;

import edu.uclm.esi.entities.User;
import edu.uclm.esi.models.UserRegistration;
import edu.uclm.esi.repositorios.UserRepository;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
@Validated
public class UserController {

    @PostMapping("/register")
    public User register(
            @RequestBody @Valid UserRegistration move
    ) {
        System.out.println();
        return null;
    }
}
