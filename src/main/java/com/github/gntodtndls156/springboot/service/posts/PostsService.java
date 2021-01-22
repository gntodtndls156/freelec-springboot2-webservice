package com.github.gntodtndls156.springboot.service.posts;

import com.github.gntodtndls156.springboot.domain.posts.Posts;
import com.github.gntodtndls156.springboot.domain.posts.PostsRepository;
import com.github.gntodtndls156.springboot.web.dto.PostsResponseDto;
import com.github.gntodtndls156.springboot.web.dto.PostsSaveRequiestDto;
import com.github.gntodtndls156.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service

public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequiestDto requiestDto) {
        return postsRepository.save(requiestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() ->
            new IllegalArgumentException("해당 게시글이 없습니다. id=" + id)
        );

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }
}