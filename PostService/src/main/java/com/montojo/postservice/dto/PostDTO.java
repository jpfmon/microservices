package com.montojo.postservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDTO {

    private Long postId;

    @NotNull
    private Long authorId;
    @NotNull
    private String text;

    private String postedAt;

   private String topic;

}
