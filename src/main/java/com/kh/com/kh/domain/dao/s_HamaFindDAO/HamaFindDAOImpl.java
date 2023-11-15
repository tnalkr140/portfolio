package com.kh.com.kh.domain.dao.s_HamaFindDAO;

import com.kh.com.kh.domain.dao.entity.Portfolio;
import com.kh.com.kh.web.form.hamafindForm.HamaFindForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Slf4j
@Repository
@RequiredArgsConstructor
public class HamaFindDAOImpl implements HamaFindDAO{

  private final NamedParameterJdbcTemplate template;

  @Override
  public List<Portfolio> portfolioAll() {

    StringBuffer sql = new StringBuffer();
    sql.append("select member.nickname, portfolio.pf_member_id, portfolio.pf_title, portfolio.pf_content" );
    sql.append(" from portfolio, member ");
    sql.append(" where member.member_id = portfolio.pf_member_id ");

    List<Portfolio> list = template.query(sql.toString(), BeanPropertyRowMapper.newInstance(Portfolio.class));

    return list;
  }

}
