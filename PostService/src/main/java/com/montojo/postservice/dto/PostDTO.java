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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostDTO postDTO = (PostDTO) o;

        if (!getPostId().equals(postDTO.getPostId())) return false;
        if (!getAuthorId().equals(postDTO.getAuthorId())) return false;
        if (!getText().equals(postDTO.getText())) return false;
        return getPostedAt().equals(postDTO.getPostedAt());
    }

    @Override
    public int hashCode() {
        int result = getPostId().hashCode();
        result = 31 * result + getAuthorId().hashCode();
        result = 31 * result + getText().hashCode();
        result = 31 * result + getPostedAt().hashCode();
        return result;
    }
}
