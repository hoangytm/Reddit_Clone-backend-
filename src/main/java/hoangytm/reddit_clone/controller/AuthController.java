package hoangytm.reddit_clone.controller;

import hoangytm.reddit_clone.model.LoginRequest;
import hoangytm.reddit_clone.model.RegisterRequest;
import hoangytm.reddit_clone.model.response.AuthenticationResponse;
import hoangytm.reddit_clone.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

/**
 * @author PhanHoang
 * 4/20/2020
 */
@RestController
@RequestMapping("/api/auth")
public class AuthController {
@Autowired
AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody RegisterRequest registerRequest) {
        authService.signup(registerRequest);
        return new ResponseEntity(OK);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @GetMapping("accountVerification/{token}")
    public ResponseEntity<String> verifyAccount(@PathVariable String token) {
        authService.verifyAccount(token);
        return new ResponseEntity<>("Account Activated Successully", OK);
    }
}
