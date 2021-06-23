package edu.pet.vkazakov.controller;

import edu.pet.vkazakov.entity.Role;
import edu.pet.vkazakov.entity.RoleName;
import edu.pet.vkazakov.entity.User;
import edu.pet.vkazakov.message.request.LoginForm;
import edu.pet.vkazakov.message.request.SignUpForm;
import edu.pet.vkazakov.message.response.JwtResponse;
import edu.pet.vkazakov.message.response.ResponseMessage;
import edu.pet.vkazakov.repository.RoleRepository;
import edu.pet.vkazakov.repository.UserRepository;
import edu.pet.vkazakov.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

	@Autowired
    AuthenticationManager authenticationManager;
	@Autowired
    UserRepository userRepository;
	@Autowired
    RoleRepository roleRepository;
	@Autowired
    PasswordEncoder encoder;
	@Autowired
    JwtProvider jwtProvider;

	@GetMapping("/role")
	public String makeRoles() {
		roleRepository.saveByRole();

		return "Roles are created!";
	}
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
														loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(),
													userDetails.getAuthorities()));
	}
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
					HttpStatus.BAD_REQUEST);
		}
		if (userRepository.existsByPhone(signUpRequest.getPhone())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Phone is already in use!"),
					HttpStatus.BAD_REQUEST);
		}
		// Creating user's account
		User user = new User(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getPhone(),
				encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		strRoles.forEach(role -> {
			switch (role) {
			case "admin":
				Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(adminRole);
				break;
			case "accountant":
				Role accountantRole = roleRepository.findByName(RoleName.ROLE_ACCOUNTANT)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(accountantRole);
				break;
			default:
				Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(userRole);
			}
		});

		user.setRoles(roles);
		userRepository.save(user);

		return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
	}
}
