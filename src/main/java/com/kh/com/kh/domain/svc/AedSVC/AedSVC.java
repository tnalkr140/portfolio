package com.kh.com.kh.domain.svc.AedSVC;

public interface AedSVC {

  // row데이터
  String requestAed(String lat, String lng);

  String requestAed(String lat, String lng, String pageNo, String numOfRows);

  //가공데이터
  Object requestAedFilter(String lat, String lng);

  Object requestAedFilter(String lat, String lng, String pageNo, String numOfRows);

  }
