package com.chap2.book.springboot.service.posts;

import com.chap2.book.springboot.domain.posts.Posts;
import com.chap2.book.springboot.domain.posts.PostsRepository;
import com.chap2.book.springboot.web.dto.PostsListResponseDto;
import com.chap2.book.springboot.web.dto.PostsResponseDto;
import com.chap2.book.springboot.web.dto.PostsSaveRequestDto;
import com.chap2.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor // 생성자를 통한 DI
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id)
                                     .orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        // 더티체킹
        // : 값변경의 쿼리를 실행하는 문을 안쓰고 Entity의 메소드를 사용했음에도 값변경 쿼리가 자동으로 실행되어
        //   테이블의 값을 변경 시켜준다.
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        postsRepository.delete(posts);
    }

    @Transactional
    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id)
                                      .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true) // 조회 속도 개선
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                                            .map(PostsListResponseDto::new)//.map(posts -> new PostListResponseDto(posts))
                                            .collect(Collectors.toList());
    }

}
