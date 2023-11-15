package com.kh.com.kh.domain.dao.s_PortfolioDAO;

import com.kh.com.kh.domain.dao.entity.Community;
import com.kh.com.kh.domain.dao.entity.Portfolio;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class PortfolioDAOImpl implements PortfolioDAO{

  private final NamedParameterJdbcTemplate template;

  @Override
  public Long save(Portfolio portfolio) {
    StringBuffer sql = new StringBuffer();
    sql.append("insert into portfolio(pf_id,pf_member_id,pf_title,pf_content) ");
    sql.append("values(portfolio_id_seq.nextval, :pf_member_id , :pf_title, :pf_content) ");

    Map<String,Object> param = new HashMap<>();
    param.put("pf_member_id", portfolio.getPf_member_id());
    param.put("pf_title", portfolio.getPf_title());
    param.put("pf_content", portfolio.getPf_content());

    template.update(sql.toString(),param);

    Long pf_id = template.queryForObject("SELECT portfolio_id_seq.currval FROM dual", param, Long.class);
    return pf_id;
  }

  // 조회
  @Override
  public Optional<Portfolio> findByMemberId(long pf_member_id) {
    String sql = "select * from portfolio where pf_member_id = :pf_member_id";

    try {
      Portfolio portfolio = template.queryForObject(sql, Map.of("pf_member_id", pf_member_id), BeanPropertyRowMapper.newInstance(Portfolio.class));
      return Optional.of(portfolio);
    } catch (EmptyResultDataAccessException e) {
      return Optional.empty();
    }
  }

  //수정
  @Override
  public int update(Portfolio portfolio, long pf_member_id) {
    StringBuffer sql = new StringBuffer();

    sql.append("update portfolio ");
    sql.append("set pf_title = :pf_title, pf_content = :pf_content ");
    sql.append("where pf_member_id = :pf_member_id ");

    SqlParameterSource param = new MapSqlParameterSource()
        .addValue("title", portfolio.getPf_title())
        .addValue("content", portfolio.getPf_content())
        .addValue("pf_member_id", pf_member_id);

    int rows = template.update(sql.toString(), param);

    return rows;
  }

  // 삭제
  @Override
  public int delete(long pf_member_id) {
    String sql = "DELETE FROM portfolio WHERE pf_member_id = :pf_member_id";

    int deletedRowCnt = template.update(sql, Map.of("pf_member_id", pf_member_id));

    return deletedRowCnt;
  }
}