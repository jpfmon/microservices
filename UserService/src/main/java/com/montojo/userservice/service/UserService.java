package com.montojo.userservice.service;


import com.montojo.userservice.dto.UserDTO;
import com.montojo.userservice.model.UserEnt;
import com.montojo.userservice.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    public UserDTO saveUser(UserDTO userDTO) {
        UserEnt userEnt = modelMapper.map(userDTO, UserEnt.class);
        userEnt.setAmount("0");
        userEnt = userRepository.save(userEnt);
        log.info("UserService saved: " + userEnt + " \n");
        return modelMapper.map(userEnt, UserDTO.class);
    }

    public UserDTO getUser(Long id) {
        UserEnt userEnt = userRepository.getReferenceById(id);
        log.info("User found: " + userEnt + " \n");
        return modelMapper.map(userEnt, UserDTO.class);
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {
        UserEnt retrievedUser = userRepository.getReferenceById(id);
        retrievedUser.setUserName(userDTO.getUsername());
        retrievedUser = userRepository.save(retrievedUser);
        log.info("User with id {} updated: {}\n", id, retrievedUser);
        return modelMapper.map(retrievedUser, UserDTO.class);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
        log.info("User with id {} deleted.\n", id);


    }

    public void addOnePost(Long id) {
        UserEnt userEnt = userRepository.getReferenceById(id);
        log.info("User retrieved: {}" , userEnt);
        String newAmount = (Long.parseLong(userEnt.getAmount()) + 1L)+"";
        userEnt.setAmount(newAmount);
        userRepository.save(userEnt);
        log.info("User with id {} has been added 1 Post; total posts: {}", id, newAmount);
    }

    public void removeOnePost(Long id) {
        UserEnt userEnt = userRepository.getReferenceById(id);
        log.info("User retrieved: {}" , userEnt);
        String newAmount = (Long.parseLong(userEnt.getAmount()) - 1L)+"";
        userEnt.setAmount(newAmount);
        userRepository.save(userEnt);
        log.info("User with id {} has been deleted 1 Post; total posts: {}", id, newAmount);
    }
}
