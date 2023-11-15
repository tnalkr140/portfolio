package com.kh.com.kh.web.Controller;


import com.kh.com.kh.domain.dao.entity.Member;
import com.kh.com.kh.domain.svc.MemberSVC.MemberSVC;
import com.kh.com.kh.domain.svc.MemberSVC.s_MemberSVC;
import com.kh.com.kh.web.form.memberForm.SignupForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class SignupController {

  private final MemberSVC memberSVC;
  //수미 추가
  private final s_MemberSVC s_memberSVC;

  @GetMapping("/signup")
  public ModelAndView signUp(SignupForm signupForm){
    ModelAndView mv = new ModelAndView();
    mv.addObject("SignupForm",signupForm);
    mv.setViewName("webPage/Login/signup");
    return mv;
  }
  @PostMapping("/signup")
  public ModelAndView signUpForm(
      @Valid
      @ModelAttribute
      SignupForm signupForm,
      BindingResult bindingResult
  ){
    ModelAndView mv = new ModelAndView();

    if(bindingResult.hasErrors()){
      mv.setViewName("webPage/Login/signup");
      return mv;
    }

    Optional<Member> byMember = memberSVC.findByInfo(signupForm.getEmail());
    Boolean nicknameCNT = memberSVC.nickExist(signupForm.getNickname());
    Boolean emailCNT = s_memberSVC.emailExist(signupForm.getEmail());

//    if(!byMember.isEmpty()){
//      bindingResult.rejectValue("email","equal",null);
//      mv.setViewName("webPage/Login/signup");
//      return mv;
//    }
//    //수미 추가 이메일 중복 확인
//    if(emailCNT) {
//      bindingResult.rejectValue("email", "equal", null);
//      mv.setViewName("webPage/Login/signup");
//      return mv;
//    }
//    //nicknameCNT가 1일시 참이다 1이면 존재함으로 오류 발생
//    if(nicknameCNT){
//      bindingResult.rejectValue("nickname","equal",null);
//      mv.setViewName("webPage/Login/signup");
//      return mv;
//    }
//    //수미 추가 비밀번호 확인
//    if(!signupForm.getPasswd().equals(signupForm.getPasswdck())){
//      bindingResult.rejectValue("passwdck", "member");
//      mv.setViewName("webPage/Login/signup");
//      return mv;
//    }
//    //수미 추가 약관 동의
//    if(!signupForm.isTerms() || !signupForm.isPrivacy() || !signupForm.isAge()) {
//      bindingResult.rejectValue("check", "manual");
//      mv.setViewName("webPage/Login/signup");
//      return mv;
//    }

    //이메일이 중복될 때
    if (emailCNT) {
      bindingResult.rejectValue("email", "equal", null);
      mv.setViewName("webPage/Login/signup");
      return mv;
    } //닉네임이 중복될 때
    else if (nicknameCNT) {
      bindingResult.rejectValue("nickname", "equal", null);
      mv.setViewName("webPage/Login/signup");
      return mv;
    } //비밀번호와 비밀번호 확인 불일치
    else if (!signupForm.getPasswd().equals(signupForm.getPasswdck())) {
      bindingResult.rejectValue("passwdck", "member");
      mv.setViewName("webPage/Login/signup");
      return mv;
    } //약관 체크 미동의
    else if (!signupForm.isTerms() || !signupForm.isPrivacy() || !signupForm.isAge()) {
      bindingResult.rejectValue("check", "manual");
      mv.setViewName("webPage/Login/signup");
      return mv;
    } //모든 유효성 검사 패스

    Member member = new Member();
    member.setEmail(signupForm.getEmail());
    member.setPasswd(signupForm.getPasswd());
    member.setNickname(signupForm.getNickname());
    Member insert = memberSVC.insert(member);

    mv.setViewName("webPage/Login/success");
    return mv;
  }

  @GetMapping("/success")
  public ModelAndView success(){
    ModelAndView mv = new ModelAndView();
    mv.setViewName("webPage/Login/success");
    return mv;
  }
}
