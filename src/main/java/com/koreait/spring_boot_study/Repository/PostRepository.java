package com.koreait.spring_boot_study.Repository;

import org.springframework.stereotype.Repository;

@Repository
public class PostRepository {
    public String getPost() {
        System.out.println("레포지토리 요청이 갔다감");
        return "레포지토리에서 보낸 어떠한 데이터";
    }
}
