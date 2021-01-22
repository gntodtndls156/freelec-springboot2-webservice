package com.github.gntodtndls156.springboot.web;

import com.github.gntodtndls156.springboot.domain.posts.PostsRepository;
import com.github.gntodtndls156.springboot.service.posts.PostsService;
import com.github.gntodtndls156.springboot.web.dto.PostsResponseDto;
import com.github.gntodtndls156.springboot.web.dto.PostsSaveRequiestDto;
import com.github.gntodtndls156.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequiestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }
}
