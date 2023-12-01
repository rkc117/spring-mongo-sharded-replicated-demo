package tech.csguide.springmongoshardedreplicateddemo.services;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import tech.csguide.springmongoshardedreplicateddemo.models.User;
import tech.csguide.springmongoshardedreplicateddemo.payloads.CreateUserRequestPayload;
import tech.csguide.springmongoshardedreplicateddemo.payloads.ResponsePayload;
import tech.csguide.springmongoshardedreplicateddemo.repositories.blogread.RUserRepository;
import tech.csguide.springmongoshardedreplicateddemo.repositories.blogwrite.WUserRepository;

@Service
public class UserService {

    @Autowired
    private WUserRepository wUserRepository;

    @Autowired
    private RUserRepository rUserRepository;

    public ResponsePayload<?> createUser(CreateUserRequestPayload createUserRequestPayload) {

        User user = new User();
        user.setId(ObjectId.get().toString());
        user.setName(createUserRequestPayload.getName());
        user.setCountry(createUserRequestPayload.getCountry());

        User save = wUserRepository.save(user);

        return new ResponsePayload<>(save, "User created successfully!", HttpStatus.CREATED);
    }

    public User findUser(String id) {
        return rUserRepository.findById(id).get();
    }
}
