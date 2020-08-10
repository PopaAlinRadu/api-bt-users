package info.bill_tracker.users.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import info.bill_tracker.users.exceptions.BadRequestException;
import info.bill_tracker.users.exceptions.BaseRuntimeException;
import info.bill_tracker.users.handlers.CustomError;
import info.bill_tracker.users.models.User;
import info.bill_tracker.users.models.UserDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
public class UserService {

    private final MongoOperations mongoOperations;
    private final DatabaseSequenceGeneratorService databaseSequenceGeneratorService;

    public UserDto registerUser(UserDto userDto){
        if (userDto.hasId()){
            throw new BadRequestException(new CustomError("id", "not allowed to set id"));
        }
        User userToSave = userDto.convertToUser();
        long id = getIdFromDatabaseSequence(userToSave);
        userToSave.setId(id);
        User savedUser = mongoOperations.save(userToSave);
        return userDto.convertToUserDto(savedUser);
    }

    private long getIdFromDatabaseSequence(User userToSave) {
        return databaseSequenceGeneratorService.generateUserSequence(userToSave.getClass().getSimpleName());
    }
}
