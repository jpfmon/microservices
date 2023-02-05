package com.montojo.postservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostEnt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postId;
    private Long authorId;
    private String text;
    private LocalDate postedAt;

    private String topic;
}
