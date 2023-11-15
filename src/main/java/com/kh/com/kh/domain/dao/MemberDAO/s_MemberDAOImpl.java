package com.kh.com.kh.domain.dao.MemberDAO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Slf4j
@Repository
@RequiredArgsConstructor
public class s_MemberDAOImpl implements s_MemberDAO {

  private final NamedParameterJdbcTemplate  template;

  //이메일 중복 확인
  @Override
  public Boolean emailExist(String email) {
    String sql = new String();
    sql = "select count(*) from member where email = :email ";

    Map<String, String> param = Map.of("email", email);

    Integer cnt = template.queryForObject(sql, param, Integer.class);

    return cnt ==1 ? true : false;
  }
}
