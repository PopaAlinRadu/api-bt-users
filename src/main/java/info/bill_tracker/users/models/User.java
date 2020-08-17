package info.bill_tracker.users.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Document(collection = User.COLLECTION_NAME)
@Builder
public class User {

    public static final String COLLECTION_NAME = "users";

    public static final String KEY_CREATED = "created";
    public static final String KEY_UPDATED = "updated";

    @Id
    private long id;

    private String username;

    private String password;

    private LocalDateTime created;

    private LocalDateTime updated;

}
