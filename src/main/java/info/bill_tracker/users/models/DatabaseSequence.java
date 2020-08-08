package info.bill_tracker.users.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "database_sequence")
public class DatabaseSequence {

    @Id
    private String id;

    private long sequence;

}
