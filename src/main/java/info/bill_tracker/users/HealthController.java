package info.bill_tracker.users;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@CrossOrigin
@Slf4j
@AllArgsConstructor
public class HealthController {

    @GetMapping(value = "")
    public ResponseEntity<?> getHealth(){
        String getString = "[GET] Health => Users microservice is HEALTHY";
        return new ResponseEntity<>(getString, HttpStatus.OK);
    }

}
