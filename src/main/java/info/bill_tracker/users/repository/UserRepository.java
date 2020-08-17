package info.bill_tracker.users.repository;

import info.bill_tracker.users.models.User;
import info.bill_tracker.users.models.UserDto;
import info.bill_tracker.users.services.DatabaseSequenceGeneratorService;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
@AllArgsConstructor
public class UserRepository implements IUserRepository<UserDto, User>{

    private final MongoTemplate mongoTemplate;
    private final DatabaseSequenceGeneratorService databaseSequenceGeneratorService;

    public UserDto registerUser(UserDto userDto) {
        User userToSave = userDto.convertToUser();
        long id = getIdFromDatabaseSequence(userToSave);
        userToSave.setId(id);
        LocalDateTime now = LocalDateTime.now();
        userToSave.setCreated(now);
        userToSave.setUpdated(now);
        User savedUser = mongoTemplate.save(userToSave, User.COLLECTION_NAME);
        return userDto.convertToUserDto(savedUser);
    }

    public long getIdFromDatabaseSequence(User userToSave) {
        return databaseSequenceGeneratorService.generateUserSequence(userToSave.getClass().getSimpleName());
    }

}
