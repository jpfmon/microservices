package com.montojo.postservice.api;

import com.montojo.postservice.dto.PostDTO;
import com.montojo.postservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/posts")
public class PostsController {

    @Autowired
    PostService postService;

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public PostDTO SavePost(@Valid @RequestBody PostDTO postDTO) {
        PostDTO postDTOSaved = postService.savePost(postDTO);
        return postDTOSaved;
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public PostDTO UpdatePost(@PathVariable Long id, @Valid @RequestBody PostDTO postDTO) {
        PostDTO updatedPostDTO = postService.updatePost(id, postDTO);
        return updatedPostDTO;
    }


    @GetMapping("/{id}")
    public PostDTO GetPost(@PathVariable Long id) {
        PostDTO retrievedPostDTO = postService.getPost(id);
        return retrievedPostDTO;
    }

    @DeleteMapping("/{id}")
    public void DeletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
