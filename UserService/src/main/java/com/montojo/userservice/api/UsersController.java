package com.montojo.userservice.api;

import com.montojo.userservice.dto.UserDTO;
import com.montojo.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
public class UsersController {

    @Autowired
    UserService userService;

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO NewUser(@Valid @RequestBody UserDTO userDTO) {
        UserDTO userDTOSaved = userService.saveUser(userDTO);
        return userDTOSaved;
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO UpdateUser(@PathVariable Long id, @Valid @RequestBody UserDTO userDTO) {
        UserDTO updatedUserDTO = userService.updateUser(id, userDTO);
        return updatedUserDTO;
    }


    @GetMapping("/{id}")
    public UserDTO GetUser(@PathVariable Long id) {
        UserDTO retrievedUserDTO = userService.getUser(id);
        return retrievedUserDTO;
    }

    @DeleteMapping("/{id}")
    public void DeleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @PostMapping("/user/{id}")
    public void AddOnePost(@PathVariable Long id){
        System.out.println("I heared something, I am AddOnePOst");
        userService.addOnePost(id);
    }

    @DeleteMapping("/user/{id}")
    public void RemoveOnePost(@PathVariable Long id){
        System.out.println("I heared something, I am RemoveOnePOst");
        userService.removeOnePost(id);
    }
}
