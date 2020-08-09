package info.bill_tracker.users.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class UserDto {

    private final String id;

    @NotBlank(message = "Username must be set!")
    @NotNull(message = "Username must not be null!")
    @Size(min = 5, max = 50)
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
