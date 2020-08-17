package info.bill_tracker.users.repository;

import info.bill_tracker.users.services.DatabaseSequenceGeneratorService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserRepository.class)
@TestPropertySource(locations = "classpath:application-dev.properties")
//@ContextConfiguration(classes = UserRepository.class)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @MockBean
    private MongoTemplate mongoTemplate;
    @MockBean
    private DatabaseSequenceGeneratorService databaseSequenceGeneratorService;

    @Test
    void get_current_offset_date_time_test() {
    }

}
