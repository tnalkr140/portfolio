var result;
document.addEventListener("DOMContentLoaded", ()=>{
    // 게시글 내용을 담은 배열 생성
    const howmuch = [];
    let contentContainer = document.querySelector('.commu_content');

    async function gethowmuch(){
        const option = {
        method : 'GET',
        headers : {Accept : 'application/json'},
        };
        try {
            const url = '/community/howmuch/all';  //commu_gubun : '얼마예요'
            const response = await fetch(url,option);
            const data = await response.json();
            console.log(data+"응답");
            return data;
        } catch(err){
            console.error(err.message);
        }
    };

        // 게시글을 화면에 추가
    async function post(data){
    result= data;
    let post_title = result["body"][0]["title"];
    let post_titleContent = result["body"][0]["content"];
        // data.body.length : 배열이 가지고 있는 요소의 개수, 즉 db에 있는 게시글 수
        for (let i = 0; i < data.body.length; i++) {
        let postInfo= document.createElement('div');
        postInfo.innerHTML =`
                        <a href="#">
                            <div class="content_commu">
                                <div class="content_title">${post_title}</div>
                                <div class="content_left">
                                    <div class="content_text">${post_titleContent}</div>
                                    <div class="content_cnt">
                                        <div class="cnt_m"></div>
                                    </div>
                                </div>
                            </div>
                        </a>
                    `;
            contentContainer.append(postInfo);
        }
    }
//    let task1 = async()=>{await getgethowmuch()};
//    let task2 = async()=>{await post(task1())}
//    let task3 = async()=>{await task2()}

    gethowmuch().then(data=>post(data).then(res=>console.log(res)))
});