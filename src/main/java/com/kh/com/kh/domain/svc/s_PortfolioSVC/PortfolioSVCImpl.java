package com.kh.com.kh.domain.svc.s_PortfolioSVC;

import com.kh.com.kh.domain.dao.entity.Portfolio;
import com.kh.com.kh.domain.dao.s_PortfolioDAO.PortfolioDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PortfolioSVCImpl implements PortfolioSVC{

  private final PortfolioDAO portfolioDAO;

  @Override
  public Long save(Portfolio portfolio) {

    return portfolioDAO.save(portfolio);
  }

  @Override
  public Optional<Portfolio> findByMemberId(long pf_member_id) {
    return portfolioDAO.findByMemberId(pf_member_id);
  }

  @Override
  public int update(Portfolio portfolio, long pf_member_id) {

    return portfolioDAO.update(portfolio, pf_member_id);
  }

  @Override
  public int delete(long pf_member_id){

    return portfolioDAO.delete(pf_member_id);
  }
}