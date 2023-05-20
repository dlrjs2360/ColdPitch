package com.ColdPitch.domain.apicontroller;

import com.ColdPitch.domain.entity.dto.post.PostRequestDto;
import com.ColdPitch.domain.entity.dto.post.PostResponseDto;
import com.ColdPitch.domain.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/post")
public class PostApiController {

    private final PostService postService;

    @PostMapping()
    @Operation(summary = "게시글 등록")
    public ResponseEntity<PostResponseDto> createPost(Authentication authentication, PostRequestDto postRequestDto) {
        return ResponseEntity.status(200).body(postService.createPost(authentication.getName(), postRequestDto));
    }

    @PatchMapping()
    @Operation(summary = "게시글 수정")
    public ResponseEntity<PostResponseDto> updatePost(Authentication authentication, PostRequestDto postRequestDto) {
        return ResponseEntity.status(200).body(postService.updatePost(authentication.getName(), postRequestDto));
    }

    @DeleteMapping()
    @Operation(summary = "게시글 삭제")
    public ResponseEntity<String> deletePost(Authentication authentication, PostRequestDto postRequestDto) {
        return ResponseEntity.status(200).body(postService.deletePost(authentication.getName(), postRequestDto));
    }
}
