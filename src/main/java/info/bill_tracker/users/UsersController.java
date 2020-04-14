package info.bill_tracker.users;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/users")
@CrossOrigin
@Slf4j
@AllArgsConstructor
public class UsersController {

    @GetMapping(value = "")
    public ResponseEntity<?> getUsers(){
        String getString = "[GET] Users";
        return new ResponseEntity<>(getString, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<?> createUsers() {
        String postString = "[POST] Users";
        return new ResponseEntity<>(postString, HttpStatus.OK);
    }

}
