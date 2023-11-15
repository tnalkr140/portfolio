package com.kh.com.kh.web.Controller;


import com.kh.com.kh.domain.dao.entity.Community;
import com.kh.com.kh.domain.dao.entity.Portfolio;
import com.kh.com.kh.domain.svc.AedSVC.ApiResponse;
import com.kh.com.kh.domain.svc.s_HamaFindSVC.HamaFindSVC;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequestMapping
@RequiredArgsConstructor
public class HamaFindController {

  private final HamaFindSVC hamaFindSVC;

  @GetMapping("/hamafind")
  public ModelAndView hamafind() {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("webPage/hamafind/hamafind");
    return mv;
  }

  @GetMapping("/hamafind/all")
  @ResponseBody
  public ApiResponse<List<Portfolio>> hamafindAll() {
    List<Portfolio> portfolios = hamaFindSVC.portfolioAll();
    ApiResponse<List<Portfolio>> result = null;
    if(portfolios.isEmpty()) {
      result = ApiResponse.createApiResponse("01", "실패", null);
    } else {
      result = ApiResponse.createApiResponse("00", "성공", portfolios);
    }
    return result;
  }

}
