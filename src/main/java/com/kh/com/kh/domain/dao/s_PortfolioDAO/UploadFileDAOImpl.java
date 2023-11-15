package com.kh.com.kh.domain.dao.s_PortfolioDAO;//package com.kh.com.kh.domain.dao.s_PortfolioDAO;
//
//import com.kh.com.kh.domain.dao.entity.AttachFileType;
//import com.kh.com.kh.domain.dao.entity.UploadFile;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.jdbc.core.namedparam.SqlParameterSource;
//import org.springframework.jdbc.support.GeneratedKeyHolder;
//import org.springframework.jdbc.support.KeyHolder;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//@Slf4j
//@Repository
//@RequiredArgsConstructor
//public class UploadFileDAOImpl implements UploadFileDAO {
//
//  private final NamedParameterJdbcTemplate template;
//
//  @Override
//  public Long addFile(UploadFile uploadFile) {
//
//    StringBuffer sql = makeAddFileSql();
//    SqlParameterSource param = new BeanPropertySqlParameterSource(uploadFile);
//    KeyHolder keyHolder = new GeneratedKeyHolder();
//    template.update(sql.toString(),param,keyHolder,new String[]{"uploadfile_id"});
//
//    return keyHolder.getKey().longValue();
//  }
//
//  private StringBuffer makeAddFileSql() {
//    StringBuffer sql = new StringBuffer();
//    sql.append("INSERT INTO uploadfile ( ");
//    sql.append("  uploadfile_id, ");
//    sql.append("  code, ");
//    sql.append("  rid, ");
//    sql.append("  store_filename, ");
//    sql.append("  upload_filename, ");
//    sql.append("  fsize, ");
//    sql.append("  ftype ");
//    sql.append(") VALUES ( ");
//    sql.append("  uploadfile_uploadfile_id_seq.nextval, ");
//    sql.append("  :code, ");
//    sql.append("  :rid, ");
//    sql.append("  :store_filename, ");
//    sql.append("  :upload_filename, ");
//    sql.append("  :fsize, ");
//    sql.append("  :ftype ");
//    sql.append(") ");
//    return sql;
//  }
//
//  //조회
//  @Override
//  public Optional<List<UploadFile>> findFilesByCodeWithRid(AttachFileType attachFileType, Long rid) {
//    StringBuffer sql = new StringBuffer();
//
//    sql.append("SELECT  ");
//    sql.append("   uploadfile_id, ");
//    sql.append("   code, ");
//    sql.append("   rid,  ");
//    sql.append("   store_filename, ");
//    sql.append("   upload_filename,  ");
//    sql.append("   fsize,  ");
//    sql.append("   ftype,  ");
//    sql.append("   cdate,  ");
//    sql.append("   udate ");
//    sql.append("  FROM  uploadfile  ");
//    sql.append(" WHERE CODE = :code  ");
//    sql.append("   AND RID = :rid  ");
//
//    List<UploadFile> result = template.query(
//        sql.toString(),
//        Map.of("code", attachFileType.name(), "rid", rid),
//        BeanPropertyRowMapper.newInstance(UploadFile.class));
//
//    return result.size() > 0 ? Optional.of(result) : Optional.empty();
//
//  }
//}
