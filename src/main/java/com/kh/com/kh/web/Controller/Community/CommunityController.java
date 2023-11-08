package com.kh.com.kh.web.Controller.Community;

import com.kh.com.kh.domain.dao.entity.Community;
import com.kh.com.kh.domain.svc.AedSVC.ApiResponse;
import com.kh.com.kh.domain.svc.CommunitySVC.CommunitySVC;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/community")
@RequiredArgsConstructor
public class CommunityController {

  private final CommunitySVC communitySVC;

  //초기화면 전체
//  @GetMapping
//  public ModelAndView community() {
//    ModelAndView mv = new ModelAndView();
//    mv.setViewName("webPage/community/community");
//    return mv;
//  }

  //궁금해요 초기화면
  @GetMapping("/question")
  public ModelAndView question(){
      ModelAndView mv = new ModelAndView();
      mv.setViewName("webPage/community/community_question");
      return mv;
  }

  //모든 게시글 조회
  @GetMapping("/question/all")
  @ResponseBody
  public ApiResponse<List<Community>> questionAll(){
    List<Community> communities = communitySVC.questionAll();
    ApiResponse<List<Community>> result = null;
    if(communities.isEmpty()){
      result = ApiResponse.createApiResponse("01","실패",null);
    }else{
      result = ApiResponse.createApiResponse("00", "성공", communities);
    }
    return result;
  }


  //얼마예요 초기화면
  @GetMapping("/howmuch")
  public ModelAndView howMuch(){
    ModelAndView mv = new ModelAndView();
    mv.setViewName("webPage/community/community_howMuch");
    return mv;
  }
  @GetMapping("/howmuch/all")
  @ResponseBody
  public ApiResponse<List<Community>> howMuchAll(){
    List<Community> communities = communitySVC.howMuchAll();
    ApiResponse<List<Community>> result = null;
    if(communities.isEmpty()){
      result = ApiResponse.createApiResponse("01","실패",null);
    }else{
      result = ApiResponse.createApiResponse("00", "성공", communities);
    }
    return result;
  }


  //모여봐요 초기화면
  @GetMapping("/gethering")
  public ModelAndView gethering(){
    ModelAndView mv = new ModelAndView();
    mv.setViewName("webPage/community/community_gethering");
    return mv;
  }
  @GetMapping("/gethering/all")
  @ResponseBody
  public ApiResponse<List<Community>> getheringAll(){
    List<Community> communities = communitySVC.getheringAll();
    ApiResponse<List<Community>> result = null;
    if(communities.isEmpty()){
      result = ApiResponse.createApiResponse("01","실패",null);
    }else{
      result = ApiResponse.createApiResponse("00", "성공", communities);
    }
    return result;
  }

  //글 삭제
  @ResponseBody
  @DeleteMapping("/{comu_post_id}")
  public ApiResponse<String> delete(@PathVariable("comu_post_id") Long comu_post_id){
    ApiResponse<String> result = null;

    int row = communitySVC.deleteById(comu_post_id);
    if(row == 1){
      result = ApiResponse.createApiResponse("00", "성공", null);
    }else {
      result = ApiResponse.createApiResponse("01","실패", null);
    }
    return result;
  }
}
