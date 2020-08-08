package info.bill_tracker.users.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@Document(collation = "users")
public class User {

    @Id
//    @Indexed(unique = true)
    private String id;

    @NotBlank(message = "Username must be set!")
    @Size(max = 50)
    private String username;

}
