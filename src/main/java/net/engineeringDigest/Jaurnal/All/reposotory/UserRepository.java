package net.engineeringDigest.Jaurnal.All.reposotory;

import net.engineeringDigest.Jaurnal.All.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    User findByUserName(String userName);
}
