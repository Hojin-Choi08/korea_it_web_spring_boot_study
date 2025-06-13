package com.koreait.spring_boot_study.Repository;

import com.koreait.spring_boot_study.Dto.SignupReqDto;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AuthRepository {
    private final Map<String, String > userDb = new HashMap<>();

    public AuthRepository() {
        userDb.put("test@mail", "Kai");
    }

    public int findByemail(String email) {
        if(userDb.containsKey(email)) {
            return 0;
        } else {
            return 1;
        }
    }

    public int addUser(SignupReqDto signupReqDto) {
        userDb.put(signupReqDto.getEmail(), signupReqDto.getUsername());
        return 1;
    }

}
