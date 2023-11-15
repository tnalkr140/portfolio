package com.kh.com.kh.domain.dao.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class Portfolio {
  private long pf_id;
  private long pf_member_id;
  private String nickname;
//  private blob pf_pic;
  private String pf_title;
  private String pf_content;
}
