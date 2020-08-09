package info.bill_tracker.users.repository;

import info.bill_tracker.users.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

    @Override
    User save(User user);


}
