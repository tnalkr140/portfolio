package com.kh.com.kh.domain.svc.MemberSVC;

import com.kh.com.kh.domain.dao.MemberDAO.s_MemberDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class s_MemberSVCImpl implements s_MemberSVC{
  private final s_MemberDAO s_memberDAO;

  public Boolean emailExist(String email) {
    return s_memberDAO.emailExist(email);
  }
}
