package com.koreait.spring_boot_study.Controller;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
class UserDto {
    private int userId;
    private String username;
    private int age;
}

//controller => SSR
//즉 서버쪽에서 웹페이지를 랜더링해서 반환하는 SSR
@Controller
public class MainController {
    private List<UserDto> users = new ArrayList<>();

    //이러한 방식은 정적 웹페이지를 보여주는 것
    //데이터 즉 동적인 요소가 없는 정적 웹페이지
    @GetMapping("/main")
    public String getMain() {
        return "main.html";
    }

    //SSR에 동적을 추가하면 Thymeleaf를 적용하면 된다.
    //HTML 파일은 템플릿 패키지 폴더에 있어야힌다
    //Thymeleaf?
    //서버에서 HTML을 랜더링할 때, 자바 데이터를 끼워 넣을 수 있게 해주는 템플릿 엔진

    @GetMapping("/profile")
    public String getProfile(Model model) {
        model.addAttribute("username", "<b>최호진</b>");
        model.addAttribute("isAdult", false);
        model.addAttribute("age", 18);

        Map<String, String> userList = new HashMap<>();
        userList.put("최호진", "17");
        userList.put("ㅇㅇㅇ", "17");
        userList.put("이재준", "45");
        userList.put("나이제", "47");
        model.addAttribute("userList", userList);

        return "proflie.html";
    }

    @GetMapping("/search")
    public String getSearch(@RequestParam String keyword, Model model) {
        model.addAttribute("keyword", keyword);
        return "search.html";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup.html";
    }

    @PostMapping("/signup")
    public String signupSubmit(@RequestParam String name, @RequestParam int age, Model model) {
        UserDto userDto = new UserDto(users.size() + 1, name, age);
        users.add(userDto);
        model.addAttribute("message", name + "님, 가입 환영");
        return "signup-result";
    }
}
