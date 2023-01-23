package com.montojo.postservice.config;

import com.montojo.postservice.dto.PostDTO;
import com.montojo.postservice.model.PostEnt;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {


//    @Bean
//    public ModelMapper modelMapper() {
//
//        ModelMapper modelMapper = new ModelMapper();
//
////        TypeMap<PostEnt, PostDTO> typeMap = modelMapper.createTypeMap(PostEnt.class, PostDTO.class);
////
////        typeMap.addMappings(
////                mapper -> mapper.map(src ->src.getPostId(), PostDTO::setId)
////        );
////
//
//        return modelMapper;
//    }
}
