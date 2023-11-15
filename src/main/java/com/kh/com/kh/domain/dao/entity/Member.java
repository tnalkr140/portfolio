package com.kh.com.kh.domain.dao.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Member {
  private Long member_id;
  private String email;
  private String passwd;
  private String nickname;
  private String hobby;
  private Long gubun;
  private byte[] pic;
  private LocalDateTime cdate;
  private LocalDateTime udate;

  //수미가 gubun Long타입으로 변경
}
