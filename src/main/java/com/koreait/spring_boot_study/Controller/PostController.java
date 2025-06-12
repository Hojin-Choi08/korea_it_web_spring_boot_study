package com.koreait.spring_boot_study.Controller;

import com.koreait.spring_boot_study.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {

    //Autowired
    @Autowired //필요한 객체를 자동으로 주입해주는 어노테이션
    private PostService postService;
    //PostService가 주입되기전 시점에서 사용하게 되면 NPE(Null Point Exception)가 발생할 수도 있다.
    //예를 들어서, 생성자에서 바로 쓴다거나 아니면 서비스, 레포지토리 어노테이션을 안 붙였거나
//    private final PostService postService;

    //...

//    public PostController(PostService postService) {
//        postService.getPost();
//    }
    //생성자 방식이 더 권장된다 => 명시적이고 명확
    //final이 있기에 불변을 보장
    //생성자로 주입하면 객체가 생성될 때 필수로 의존성을 받아야 한다
    //그러면 이후에 그 의존성을 바꿀 수 없어서 안정적
    //애초에 객체 생성이 되기도 전에 생성자를 통해 주입이 완료됨, 생성 전부터 준비가 완료 됨

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
