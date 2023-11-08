package com.kh.com.kh.web.form.communityForm;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Valid
public class SaveForm {
  @NotBlank(message = "제목을 입력해주세요")
  private String title;

  @NotBlank(message = "본문을 입력해주세요")
  private String content;
}
