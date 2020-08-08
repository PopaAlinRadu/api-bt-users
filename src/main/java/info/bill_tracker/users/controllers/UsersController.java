package info.bill_tracker.users.controllers;

import info.bill_tracker.users.models.UserDto;
import info.bill_tracker.users.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RestController()
@CrossOrigin
public class UsersController implements IUsersController {

    private final UserService userService;

    @Override
    public ResponseEntity<?> registerUser(UserDto userDto) {
        log.debug("Saving... {}", userDto);
        UserDto registerUser = userService.registerUser(userDto);
        log.debug("Saved... {}", registerUser);
        return new ResponseEntity<>(registerUser, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> authenticate() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @GetMapping(value = "")
    public ResponseEntity<?> getUsers() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<?> getUserById(long userId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<?> deleteUserById(long userId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
