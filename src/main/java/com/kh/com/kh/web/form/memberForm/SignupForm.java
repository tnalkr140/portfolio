package com.kh.com.kh.web.form.memberForm;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.DialectOverride;

@Data
@Valid
public class SignupForm {
  @NotEmpty(message = "이메일을 입력해주세요")
  private String email;
  @NotEmpty(message = "별명을 입력해주세요")
  private String nickname;
  @Size(min = 6, max = 20, message = "비밀번호를 6~20자의 형태로 입력해주세요")
  private String passwd;
  private String passwdck;
  
  private String check; // 추가

  private boolean terms;
  private boolean privacy;
  private boolean age;
}
