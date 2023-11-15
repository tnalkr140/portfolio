package com.kh.com.kh.web.Controller;

import com.kh.com.kh.domain.dao.MemberDAO.MemberDAO;
import com.kh.com.kh.domain.dao.MemberDAO.MemberDAOImpl;
import com.kh.com.kh.domain.dao.entity.Community;
import com.kh.com.kh.domain.dao.entity.Member;
import com.kh.com.kh.domain.dao.entity.Portfolio;
import com.kh.com.kh.domain.svc.MemberSVC.MemberSVC;
import com.kh.com.kh.domain.svc.s_PortfolioSVC.PortfolioSVC;
import com.kh.com.kh.web.form.memberForm.SessionForm;
import com.kh.com.kh.web.form.s_portfolio.PortFolioForm;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Slf4j
@Controller
@RequestMapping
@RequiredArgsConstructor
public class PortfolioController {

  private final PortfolioSVC portfolioSVC;
  private final MemberSVC memberSVC;

  @GetMapping("/portfolio")
  public String portfolioForm(Model model, HttpSession session) {
    log.info("portfolioForm 호출");
    PortFolioForm portFolioForm = new PortFolioForm();
    SessionForm sessionForm = (SessionForm)session.getAttribute("sessionForm");
    Optional<Portfolio> portfolio = portfolioSVC.findByMemberId(sessionForm.getMember_id());
    if (portfolio.isPresent()) {
      BeanUtils.copyProperties((Portfolio)portfolio.get(),portFolioForm);
    }

    model.addAttribute("portfolioForm", portFolioForm);
    return "webPage/portfolio/portfolio";

  }

  //등록
  @PostMapping("/portfolio")
  public ModelAndView portfolioSubmit(
      PortFolioForm portFolioForm,
      HttpSession session
  ){
    ModelAndView mv = new ModelAndView();

    log.info("portfolio 호출={}", portFolioForm);

    SessionForm sessionForm = (SessionForm) session.getAttribute("sessionForm");

    Portfolio portfolio = new Portfolio();

    sessionForm.setGubun(1L);
    memberSVC.updateGubun(sessionForm.getMember_id(), 1L);
      log.info("smember_id={}",sessionForm.getMember_id());
      portfolio.setPf_title(portFolioForm.getPf_title());
      portfolio.setPf_content(portFolioForm.getPf_content());
      portfolio.setPf_member_id(sessionForm.getMember_id());

    Long pf_member_id = portfolioSVC.save(portfolio);
    session.setAttribute("sessionForm", sessionForm);

    if (sessionForm.getGubun() == 1) {
      // gubun이 1이 아닐 때의 화면으로 이동
      mv.setViewName("redirect:/portfolio");
      return mv;
    } else {
        log.info("id={}", portfolio.getPf_member_id());
        log.info("gubun={}", sessionForm.getGubun());
        mv.setViewName("webPage/portfolio/portfolio");
      return mv;
    }
  }

  //수정
//  @GetMapping("/portfolioModify/{pf_member_id}")
//  public String portfolioModify(@PathVariable("pf_member_id") Long pf_member_id, Model model) {
//    model.addAttribute("portfolio", portfolioSVC.)
//  }
  @PostMapping("/updateportfolio/{pf_member_id}")
  public String portfolioupdate(
      @PathVariable("pf_member_id") Long pf_member_id,
      @Valid @ModelAttribute PortFolioForm portFolioForm,
      RedirectAttributes redirectAttributes) {
    log.info("포폴 update() 호출");
    log.info("portfolioForm={}", portFolioForm);

    Portfolio portfolio = new Portfolio();
    portfolio.setPf_title(portFolioForm.getPf_title());
    portfolio.setPf_content(portFolioForm.getPf_content());

    redirectAttributes.addAttribute("pf_member_id", pf_member_id);
    return "redirect:/portfolioupdate{pf_member_id}";
  }

  //삭제
  @PostMapping("/pf_del/{pf_id}")
  public ModelAndView delete(@PathVariable Long pf_id){
    ModelAndView mv = new ModelAndView();
    int portfolio = portfolioSVC.delete(pf_id);

    return mv;
  }
}