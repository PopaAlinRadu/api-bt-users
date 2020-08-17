package info.bill_tracker.users.services;

import info.bill_tracker.users.exceptions.BadRequestException;
import info.bill_tracker.users.handlers.CustomError;
import info.bill_tracker.users.models.UserDto;
import info.bill_tracker.users.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final UserRepository userRepository;

    public UserDto registerUser(UserDto userDto) {
        if (userDto.hasId()) {
            throw new BadRequestException(new CustomError("id", "not allowed to set id"));
        }
        if (userDto.hasCreatedTime()){
            throw new BadRequestException(new CustomError("created", "not allowed to set created time"));
        }
        if (userDto.hasUpdatedTime()){
            throw new BadRequestException(new CustomError("updated", "not allowed to set updated time"));
        }
        return userRepository.registerUser(userDto);
    }

}
