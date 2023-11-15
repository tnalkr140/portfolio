function convertToLink() {
  const urlInput = document.getElementById("urlInput");
  const resultElement = document.getElementById("result");

  // 입력된 URL을 <a> 태그로 변환
  const inputValue = urlInput.value;
  const textWithLink = `<a href="${inputValue}" target="_blank">${inputValue}</a>`;

  // 결과를 화면에 표시
  resultElement.innerHTML = textWithLink;
}
