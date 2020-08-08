package info.bill_tracker.users.services;

import info.bill_tracker.users.models.User;
import info.bill_tracker.users.models.UserDto;
import info.bill_tracker.users.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final MongoOperations mongoOperations;

    public UserDto registerUser(UserDto userDto){
        User userToSave = userDto.convertToUser();
        User savedUser = userRepository.save(userToSave);
        return userDto.convertToUserDto(savedUser);
    }
}
