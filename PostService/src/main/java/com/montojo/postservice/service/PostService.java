package com.montojo.postservice.service;


import com.montojo.postservice.dto.PostDTO;
import com.montojo.postservice.mapper.Mapper;
import com.montojo.postservice.model.PostEnt;
import com.montojo.postservice.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.http.HttpRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class PostService {

    private static final Logger log = LoggerFactory.getLogger(PostService.class);
    @Autowired
    PostRepository postRepository;

    public PostDTO savePost(PostDTO postDTO) {
        PostEnt postEnt = Mapper.mapToEnt(postDTO);
        postEnt.setPostedAt(LocalDate.now());
        postEnt = postRepository.save(postEnt);
        log.info("Post saved: " + postEnt + " \n");

        try {
            String urlString = "http://localhost:8082/api/v1/users/user/" + postDTO.getAuthorId();
            log.info("Using url: {}", urlString);
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.getResponseCode();
            con.disconnect();
        } catch (IOException e) {
          log.warn("PostsAmount not increased for User with id: {}", postDTO.getAuthorId());
        }

        return Mapper.mapToDto(postEnt);
    }

    public PostDTO getPost(Long id) {
        PostEnt postEnt = postRepository.getReferenceById(id);
        log.info("Post found: " + postEnt + " \n");
        return Mapper.mapToDto(postEnt);
    }

    public PostDTO updatePost(Long id, PostDTO postDTO) {
        PostEnt retrievedPost = postRepository.getReferenceById(id);
        retrievedPost.setText(postDTO.getText());
        retrievedPost = postRepository.save(retrievedPost);
        log.info("Post with id {} updated: {}\n", id, retrievedPost);
        return Mapper.mapToDto(retrievedPost);
    }

    public void deletePost(Long id) {
        PostEnt postEnt = postRepository.getReferenceById(id);
        postRepository.deleteById(id);
        log.info("Post with id {} deleted.\n", id);
        try {
            String urlString = "http://users:8082/api/v1/users/user/" + postEnt.getAuthorId();
            log.info("Using url: {}", urlString);
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("DELETE");
            con.getResponseCode();
            con.disconnect();
        } catch (IOException e) {
            log.warn("PostsAmount not increased for User with id: {}", postEnt.getAuthorId());
        }
    }
}
