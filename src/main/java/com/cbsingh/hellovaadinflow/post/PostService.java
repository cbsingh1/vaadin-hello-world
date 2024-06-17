package com.cbsingh.hellovaadinflow.post;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private static final Logger log = LoggerFactory.getLogger(PostService.class);
    private final List<Post> posts = new ArrayList<>();

    public PostService(final ObjectMapper objectMapper){
        try(InputStream inputStream = TypeReference.class.getResourceAsStream("/data/posts.json")){
            Posts allPosts = objectMapper.readValue(inputStream, Posts.class);
            log.info("Reading {} posts from JSON data", allPosts.posts().size());
            posts.addAll(allPosts.posts());
        }catch (IOException e){
            throw new RuntimeException("Failed to read JSON data", e);
        }
    }

    List<Post> findAll() {
        return posts;
    }
}
