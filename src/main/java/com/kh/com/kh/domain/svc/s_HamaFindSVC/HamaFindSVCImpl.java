package com.kh.com.kh.domain.svc.s_HamaFindSVC;

import com.kh.com.kh.domain.dao.entity.Portfolio;
import com.kh.com.kh.domain.dao.s_HamaFindDAO.HamaFindDAO;
import com.kh.com.kh.web.form.hamafindForm.HamaFindForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class HamaFindSVCImpl implements HamaFindSVC{

  private final HamaFindDAO hamaFindDAO;
  @Override
  public List<Portfolio> portfolioAll() {

    return hamaFindDAO.portfolioAll();
  }
}
