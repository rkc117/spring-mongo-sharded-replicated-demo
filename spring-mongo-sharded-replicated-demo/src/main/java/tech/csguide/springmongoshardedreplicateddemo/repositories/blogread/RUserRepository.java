package tech.csguide.springmongoshardedreplicateddemo.repositories.blogread;


import org.springframework.data.mongodb.repository.MongoRepository;
import tech.csguide.springmongoshardedreplicateddemo.models.User;

public interface RUserRepository extends MongoRepository<User,String> {
}
