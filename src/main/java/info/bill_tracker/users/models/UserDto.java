package info.bill_tracker.users.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UserDto {

    private final long id;

    @NotBlank(message = "Username must be set!")
    @NotNull(message = "Username must not be null!")
    @Size(min = 5, max = 50)
    private final String username;

    @NotBlank(message = "Password must be set!")
    @NotNull(message = "Password must not be null!")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,50}$", message = "Password must contain :: letters, numbers and size between 6 and 50!")
    private final String password;

    private final LocalDateTime created;
    private final LocalDateTime updated;

    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.created = user.getCreated();
        this.updated = user.getUpdated();
    }

    public User convertToUser() {
        return User.builder()
                .id(id)
                .username(username)
                .password(password)
                .build();
    }

    public UserDto convertToUserDto(User savedUser) {
        return new UserDto(savedUser);
    }

    public boolean hasId() {
        return id != 0;
    }

    public boolean hasCreatedTime (){
        return created != null;
    }

    public boolean hasUpdatedTime (){
        return updated != null;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + "hidden" + '\'' +
                '}';
    }

}
