package com.montojo.postservice.mapper;

import com.montojo.postservice.dto.PostDTO;
import com.montojo.postservice.model.PostEnt;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Mapper {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY");
    public static PostDTO mapToDto(PostEnt postEnt){

        PostDTO postDTO = new PostDTO();
        postDTO.setPostId(postEnt.getPostId());
        postDTO.setText(postEnt.getText());
        postDTO.setAuthorId(postEnt.getAuthorId());
        postDTO.setPostedAt(postEnt.getPostedAt().format(formatter));

        postDTO.setTopic(postEnt.getTopic());
        return postDTO;
    }

    public static PostEnt mapToEnt(PostDTO postDTO){

        PostEnt postEnt = new PostEnt();
        postEnt.setPostId(postDTO.getPostId());
        postEnt.setAuthorId(postDTO.getAuthorId());
        postEnt.setText(postDTO.getText());
        postEnt.setPostedAt(postDTO.getPostedAt() ==null? null : LocalDate.parse(postDTO.getPostedAt()));

        postEnt.setTopic(postDTO.getTopic());

        return postEnt;
    }
}
