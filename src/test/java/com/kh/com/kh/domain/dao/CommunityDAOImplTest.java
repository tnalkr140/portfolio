package com.kh.com.kh.domain.dao;


import com.kh.com.kh.domain.dao.CommunityDAO.CommunityDAO;
import com.kh.com.kh.domain.dao.entity.Community;
import groovy.util.logging.Slf4j;
import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Data
@Slf4j
@SpringBootTest
public class CommunityDAOImplTest {

  @Autowired
  CommunityDAO communityDAO;

  @Test
  @DisplayName("글등록")
  void save(){
    Community community = new Community();
    community.setComu_post_id(5L);
    community.setComu_gubun("얼마예요");
    community.setTitle("울산에서 제일 싼 연어");
    community.setContent("아는 업체 있으신 분?");
    community.setMember_id(5L);
    community.setArea("울산");

    Long save = communityDAO.save(community);
  }

}
