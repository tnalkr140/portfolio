
// 포트폴리오 조회
async function hamafind() {
    const option = {
        method : 'GET',
        headers : {Accept : 'application/json'},
    };
    try {
        const url = '/hamafind/all';
        const response = await fetch(url, option);
        const data = await response.json();
        console.log(data);
        console.log("포트폴리오 목록 호출");
        post(data.body);
    } catch(err) {
        console.log(err.message);
    }
};

hamafind();

//게시글을 화면에 추가
function post(data) {
//게시글 내용을 담은 배열 생성
    let contContainer = document.querySelector('.list_box');
    //data.body.length : 배열이 가지고 있는 요소의 개수
    data.forEach(data => {
        let postInfo = document.createElement('div');
        postInfo.innerHTML = `
            <a href='#'>
                <div class = "list__hf">
                    <div class = "profile_hf">
                        <div class = "pro_img"></div>
                        <div class = "pro_name">${data.nickname}</div>
                    </div>
                    <div class = "profile_chf">
                        <div class = "list_title">${data.pf_title}</div>
                        <div class = "list_content">${data.pf_content}</div>
                    </div>
                </div>
            </a>
        `;
        contContainer.append(postInfo);
    })
}