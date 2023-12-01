package tech.csguide.springmongoshardedreplicateddemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tech.csguide.springmongoshardedreplicateddemo.payloads.CreateUserRequestPayload;
import tech.csguide.springmongoshardedreplicateddemo.payloads.ResponsePayload;
import tech.csguide.springmongoshardedreplicateddemo.services.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequestPayload createUserRequestPayload) {
        ResponsePayload<?> responsePayload = userService.createUser(createUserRequestPayload);
        return ResponseEntity.status(responsePayload.getStatus()).body(responsePayload);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") String id) {
        return ResponseEntity.ok(new ResponsePayload<>(userService.findUser(id), "success", HttpStatus.OK));
    }

}
