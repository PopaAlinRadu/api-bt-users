package info.bill_tracker.users.configurations;

import info.bill_tracker.users.models.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.index.IndexField;
import org.springframework.data.mongodb.core.index.IndexInfo;
import org.springframework.data.mongodb.core.index.IndexOperations;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
@AllArgsConstructor
@Slf4j
public class IndexConfig {

    private final MongoOperations mongoOperations;

    @EventListener(ApplicationReadyEvent.class)
    public void initIndicesAfterStartup() {
        mongoOperations.indexOps(User.class).ensureIndex(new Index().unique().on("username", Sort.Direction.ASC));
        IndexOperations indexOps = mongoOperations.indexOps(User.class);
        List<IndexField> indexFields = indexOps.getIndexInfo()
                .stream()
                .map(IndexInfo::getIndexFields)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        log.debug("Set up indexes for :: {}", indexFields);
    }

}
