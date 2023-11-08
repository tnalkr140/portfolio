//package com.kh.com.kh.domain.svc.AedSVC;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Service;
//import org.springframework.web.util.DefaultUriBuilderFactory;
//
//@Slf4j
//@Service
//public class AedSVCImpl implements AedSVC {
//
//  private final WebClient webClient;
//  private final String baseUrl = "http://apis.data.go.kr";
//
//  private final String serviceKey = "Yq1cr3HrGMdIkRYbRgVuSE69blNqgpz8b2APN3p4mvhpS3KLAgodOrPWSQN3SrHgT6uoT%2F2JrS6xC9o3p2y2%2BQ%3D%3D";
//
//  @Autowired
//  public AedSVCImpl(WebClient.Builder webClientBilder ){
//
//    DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(baseUrl);
//    factory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.NONE);
//
//    this.webClient = webClientBilder
//        .uriBuilderFactory(factory)
//        .baseUrl(baseUrl)
//        .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)  //json포맷으로 요청
//        .build();
//  }
//  @Override
//  public String requestAed(String lat, String lng) {
//    final String pageNo = "1";
//    final String numOfRows = "10";
//
//    Mono<String> response = webClient.get()
//        .uri(uriBuilder -> uriBuilder
//            .path("/B552657/AEDInfoInqireService/getAedLcinfoInqire")
//            .queryParam("serviceKey", serviceKey)
//            .queryParam("WGS84_LON", lng)    //경도   129.3076
//            .queryParam("WGS84_LAT", lat)    //위도    35.53235
//            .queryParam("pageNo", pageNo)
//            .queryParam("numOfRows", numOfRows)
//            .build())
//        .retrieve()
//        .bodyToMono(String.class);
//    String data = response.block();
//    return data;
//  }
//
//  @Override
//  public String requestAed(String lat, String lng, String pageNo, String numOfRows) {
//
//    Mono<String> response = webClient.get()
//        .uri(uriBuilder -> uriBuilder
//            .path("/B552657/AEDInfoInqireService/getAedLcinfoInqire")
//            .queryParam("serviceKey", serviceKey)
//            .queryParam("WGS84_LON", lng)    //경도
//            .queryParam("WGS84_LAT", lat)    //위도
//            .queryParam("pageNo", pageNo)
//            .queryParam("numOfRows", numOfRows)
//            .build())
//        .retrieve()
//        .bodyToMono(String.class);
//    String data = response.block();
//    return data;
//  }
//  @Override
//  public Object requestAedFilter(String lat, String lng) {
//    final String pageNo = "1";
//    final String numOfRows = "10";
//
//    Mono<ApiResult> response = webClient.get()
//        .uri(uriBuilder -> uriBuilder
//            .path("/B552657/AEDInfoInqireService/getAedLcinfoInqire")
//            .queryParam("serviceKey", serviceKey)
//            .queryParam("WGS84_LON", lng)    //경도   129.3076
//            .queryParam("WGS84_LAT", lat)    //위도    35.53235
//            .queryParam("pageNo", pageNo)
//            .queryParam("numOfRows", numOfRows)
//            .build())
//        .retrieve()
//        .bodyToMono(ApiResult.class);
//    ApiResult data = response.block();
//    Object items = data.getResponse().getBody().getItems();
//    return items;
//  }
//
//  @Override
//  public Object requestAedFilter(String lat, String lng, String pageNo, String numOfRows) {
//    Mono<ApiResult> response = webClient.get()
//        .uri(uriBuilder -> uriBuilder
//            .path("/B552657/AEDInfoInqireService/getAedLcinfoInqire")
//            .queryParam("serviceKey", serviceKey)
//            .queryParam("WGS84_LON", lng)    //경도   129.3076
//            .queryParam("WGS84_LAT", lat)    //위도    35.53235
//            .queryParam("pageNo", pageNo)
//            .queryParam("numOfRows", numOfRows)
//            .build())
//        .retrieve()
//        .bodyToMono(ApiResult.class);
//    ApiResult data = response.block();
//    Object items = data.getResponse().getBody().getItems();
//    return items;
//  }
//}
