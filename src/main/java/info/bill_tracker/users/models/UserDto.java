package info.bill_tracker.users.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {

    private final String id;

    private final String username;

    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
    }

    public User convertToUser() {
        return new User(this.id, this.username);
    }

    public UserDto convertToUserDto(User savedUser) {
        return new UserDto(savedUser);
    }

}
