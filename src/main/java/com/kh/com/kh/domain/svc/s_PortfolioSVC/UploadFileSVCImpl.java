package com.kh.com.kh.domain.svc.s_PortfolioSVC;//package com.kh.com.kh.domain.svc.s_PortfolioSVC;
//
//import com.kh.com.kh.domain.dao.entity.AttachFileType;
//import com.kh.com.kh.domain.dao.entity.UploadFile;
//import com.kh.com.kh.domain.dao.s_PortfolioDAO.UploadFileDAO;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//
//@Slf4j
//@Service
//@Transactional
//@RequiredArgsConstructor
//public class UploadFileSVCImpl implements UploadFileSVC{
//
//  @Value("${attach.root_dir}") // d:/attach/
//  private String ROOT_DIR;
//
//  private final UploadFileDAO uploadFileDAO;
//
//  @Override
//  public Long addFile(UploadFile uploadFile) {
//    return uploadFileDAO.addFile(uploadFile);
//  }
//
//  @Override
//  public Optional<List<UploadFile>> findFilesByCodeWithRid(AttachFileType attachFileType, Long rid) {
//    return uploadFileDAO.findFilesByCodeWithRid(attachFileType, rid);
//  }
//}
