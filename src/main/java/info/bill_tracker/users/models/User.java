package info.bill_tracker.users.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collation = "users")
public class User {

    @Id
//    @Indexed(unique = true)
    private String id;

    private String username;

}
