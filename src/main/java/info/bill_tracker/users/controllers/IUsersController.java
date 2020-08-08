package info.bill_tracker.users.controllers;

import info.bill_tracker.users.models.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/users")
public interface IUsersController {

    @PostMapping(value = "/register")
    ResponseEntity<?> registerUser(@Valid @RequestBody UserDto userDto);

    @PostMapping(value = "/authenticate")
    ResponseEntity<?> authenticate();

    @GetMapping(value = "")
    ResponseEntity<?> getUsers();

    @GetMapping(value = "/{userId}")
    ResponseEntity<?> getUserById(@PathVariable long userId);

    @DeleteMapping(value = "/{userId}")
    ResponseEntity<?> deleteUserById(@PathVariable long userId);
}
