package com.koreait.spring_boot_study.Controller;

import com.koreait.spring_boot_study.Service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/get")
    public String getPost() {
        System.out.println("get으로 들어온 요청입니다~");
        return postService.getPost();
    }

    @GetMapping("/user")
    public String getPostUser() {
        System.out.println("user로 들어온 요청입니다~");
        return "어떤 게시물의 유저 정보";
    }
}
