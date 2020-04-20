package hoangytm.reddit_clone.controller;

import hoangytm.reddit_clone.model.User;
import hoangytm.reddit_clone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author PhanHoang
 * 4/20/2020
 */
@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    @GetMapping("user")
    public void getUser(){
        Optional<User> user = userRepository.findByUsername("hoang");
        System.out.println("success");
    }
}
