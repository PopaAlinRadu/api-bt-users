package info.bill_tracker.users.services;

import info.bill_tracker.users.models.DatabaseSequence;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;


@Service
@AllArgsConstructor
public class DatabaseSequenceGeneratorService {

    private final MongoOperations mongoOperations;

    public long generateUserSequence(String classSeqName) {

        Query query = Query.query(Criteria.where("_id").is(classSeqName));
        Update update = new Update().inc("sequence", 1);
        FindAndModifyOptions upsert = options().returnNew(true).upsert(true);

        DatabaseSequence andModify = mongoOperations.findAndModify(query, update, upsert, DatabaseSequence.class);
        return Objects.nonNull(andModify) ? andModify.getSequence() : 1;
    }

}
