package edu.uclm.esi.services;

import edu.uclm.esi.entities.User;
import edu.uclm.esi.repositorios.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void register(User u){
        //userRepository.add();
    }

}
