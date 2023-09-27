package edu.uclm.esi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.IdGeneratorType;
import org.springframework.util.DigestUtils;

import java.util.UUID;

@Data
@Entity
public class User {
    @Size(min = 4, max = 200, message = "Name must be at least 2 and max 10 characters")
    private String name;

    @NotBlank
    private String password;


    @NotBlank
    private String email;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    public void setPassword1(String pwd){
        //password1 = DigestUtils.sh
    }

}
