package com.koreait.spring_boot_study.Service;

import com.koreait.spring_boot_study.Dto.SignupReqDto;
import com.koreait.spring_boot_study.Dto.SignupRespDto;
import com.koreait.spring_boot_study.Repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    public SignupRespDto signup(SignupReqDto signupReqDto) {
        if(signupReqDto.getEmail() == null || signupReqDto.getEmail().trim().isEmpty()) {
            SignupRespDto signupRespDto = new SignupRespDto("failed", "이메일 입력 요망");
            return signupRespDto;
        } else if (signupReqDto.getPassword() == null || signupReqDto.getPassword().trim().isEmpty()) {
            SignupRespDto signupRespDto = new SignupRespDto("failed", "비밀번호 입력 요망");
            return signupRespDto;
        } else if (signupReqDto.getUsername() == null || signupReqDto.getUsername().trim().isEmpty()) {
            SignupRespDto signupRespDto = new SignupRespDto("failed", "사용자 이름 입력 요망");
            return signupRespDto;
        }

        int chkEmail = authRepository.findByemail(signupReqDto.getEmail());
        if (chkEmail == 1) {
            authRepository.addUser(signupReqDto);
            return new SignupRespDto("success", signupReqDto.getUsername() + "님 회원가입이 완료되었습니다.");
        } else if (chkEmail == 0) {
            return new SignupRespDto("failed", "이미 존재하는 이메일입니다.");
        }

        return new SignupRespDto("failed", "회원가입에 오류가 발생했습니다. 재시도 요망");
    }

}
