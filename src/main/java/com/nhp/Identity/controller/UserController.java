package com.nhp.Identity.controller;

import com.nhp.Identity.dto.request.UserCreationRequest;
import com.nhp.Identity.dto.request.UserUpdateRequest;
import com.nhp.Identity.dto.response.ApiResponse;
import com.nhp.Identity.entity.User;
import com.nhp.Identity.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    User createUser(@RequestBody @Valid UserCreationRequest request){

        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createUser(request));
        return apiResponse.getResult();
    }

    @GetMapping
    List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    User getUser(@PathVariable("userId") Long userId){
        return userService.getUser(userId);
    }

    @PutMapping("/{userId}")
    User updateUser(@PathVariable Long userId, @RequestBody @Valid UserUpdateRequest request){
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
        return "User has been deleted";
    }
}
