package com.kh.com.kh.web.form.memberForm;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SessionForm {
  private Long member_id;
  private String email;
  private String nickname;
  private Long gubun;
}