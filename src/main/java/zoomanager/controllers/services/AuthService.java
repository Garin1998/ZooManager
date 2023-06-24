package zoomanager.controllers.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import zoomanager.controllers.requests.RegisterReq;
import zoomanager.controllers.requests.AuthReq;
import zoomanager.controllers.responses.AuthResponse;
import zoomanager.jpa.RoleRepository;
import zoomanager.jpa.UserRepository;
import zoomanager.models.ERole;
import zoomanager.models.entities.Role;
import zoomanager.models.entities.User;
import zoomanager.models.mappers.UserMapper;
import zoomanager.security.services.JwtService;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authManager;
    private final UserMapper userMapper;

    public AuthResponse register(RegisterReq request) {
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository
                .findByRoleName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Role not Found"));
        roles.add(userRole);

        User user = User.builder()
                .name(request.name())
                .password(passwordEncoder.encode(request.password()))
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .userRoles(roles)
                .build();
        userRepository.save(user);
        String token = jwtService.generateToken(userMapper.entityToDto(user));
        return new AuthResponse(token);
    }

    public AuthResponse authenticate(AuthReq request) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.name(),
                        request.password()
                )
        );

        User user = userRepository.findByName(
                request.name()).orElseThrow(() -> new UsernameNotFoundException("User not found")
        );
        String token = jwtService.generateToken(userMapper.entityToDto(user));
        return new AuthResponse(token);
    }
}
