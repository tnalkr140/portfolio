package com.kh.com.kh.domain.svc.MemberSVC;

import com.kh.com.kh.domain.dao.entity.Member;
public interface s_MemberSVC {

  //이메일 중복 확인
  Boolean emailExist (String email);
}
