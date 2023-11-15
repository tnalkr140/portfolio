package com.kh.com.kh.domain.svc.s_HamaFindSVC;

import com.kh.com.kh.domain.dao.entity.Community;
import com.kh.com.kh.domain.dao.entity.Portfolio;
import com.kh.com.kh.web.form.hamafindForm.HamaFindForm;

import java.util.List;

public interface HamaFindSVC {
  List<Portfolio> portfolioAll();

}
