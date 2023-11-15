package com.kh.com.kh.domain.dao.s_PortfolioDAO;

import com.kh.com.kh.domain.dao.entity.Portfolio;

import javax.sound.sampled.Port;
import java.util.Optional;

public interface PortfolioDAO {
  //등록
  Long save(Portfolio portfolio);

  //조회
  Optional<Portfolio> findByMemberId(long pf_member_id);

  //수정
  int update(Portfolio portfolio, long pf_member_id);

  //삭제
  int delete(long pf_member_id);
}
