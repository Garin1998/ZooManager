package zoomanager.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zoomanager.controllers.requests.AuthReq;
import zoomanager.controllers.requests.RegisterReq;
import zoomanager.controllers.responses.AuthResponse;
import zoomanager.controllers.services.AuthService;

@RestController
@RequestMapping("/zoo_manager/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterReq request) {

        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> authenticate(@RequestBody AuthReq request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }

}
