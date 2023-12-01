package tech.csguide.springmongoshardedreplicateddemo.repositories.blogwrite;

import org.springframework.data.mongodb.repository.MongoRepository;
import tech.csguide.springmongoshardedreplicateddemo.models.User;

public interface WUserRepository  extends MongoRepository<User,String> {
}
