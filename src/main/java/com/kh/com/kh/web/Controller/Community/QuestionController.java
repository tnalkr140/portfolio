//package com.kh.com.kh.web.Controller.Community;
//
//import com.kh.com.kh.domain.dao.entity.Community;
//import com.kh.com.kh.domain.svc.AedSVC.ApiResponse;
//import com.kh.com.kh.domain.svc.CommunitySVC.CommunitySVC;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.List;
//
//@Slf4j
//@Controller
//@RequestMapping("/community/question")
//@RequiredArgsConstructor
//public class QuestionController {
//
//  private final CommunitySVC communitySVC;
//
//  //궁금해요의 초기화면 : 궁금해요의 모든 게시글이 보임
//  @GetMapping
//  @ResponseBody
//  public ApiResponse<List<Community>> questionAll(){
//    List<Community> communities = communitySVC.questionAll();
//    ApiResponse<List<Community>> result = null;
//    if(communities.isEmpty()){
//      result = ApiResponse.createApiResponse("01","실패",null);
//    }else{
//      result = ApiResponse.createApiResponse("00", "성공", communities);
//    }
//    return result;
//  }
//}
