var result;
document.addEventListener("DOMContentLoaded", ()=>{
    // 게시글 내용을 담은 배열 생성
    const question = [];
    let contentContainer = document.querySelector('.commu_content');

    // '모여봐요' 게시글 조회 함수
    async function getgethering(){
        const option = {
        method : 'GET',
        headers : {Accept : 'application/json'},
        };
        try {
            const url = '/community/gethering/all';  //commu_gubun : '모여봐요'
            const response = await fetch(url,option);
            const data = await response.json();
            console.log(data);
            post(data.body);
        } catch(err){
            console.error(err.message);
        }
    };


//            //삭제버튼을 누르면 게시글ID를 콘솔에 출력하게
//            const $delBtn = postInfo.querySelector('.delBtn');
//            $delBtn.addEventListener('click', e=>{
//                console.log('삭제버튼클릭!')
//                console.log(data);
//                });

        // 게시글을 화면에 추가
    function post(data){
        // data.body.length : 배열이 가지고 있는 요소의 개수, 즉 db에 있는 게시글 수
        data.forEach(data => {
        let postInfo= document.createElement('div');
        postInfo.innerHTML =`
                        <a href="#">
                            <div class="content_commu">
                                <div class="content_title">${data.title}</div>
                                <div class="content_left">
                                    <div class="content_text">${data.content}</div>
                                    <div class="content_cnt">
                                        <button class="delBtn">삭제</button>
                                    </div>
                                </div>
                            </div>
                        </a>
                    `;
            contentContainer.append(postInfo);
        })
    }
getgethering();
});





        //삭제
//        async function delgethering(){
//            const option = {
//            method : 'DELETE',
//            headers : {Accept : 'application/json'},
//            };
//            try {
//                const url = '/community/gethering/{comu_post_id}';  //commu_gubun : '모여봐요'
//                const response = await fetch(url,option);
//                const data = await response.json();
//                return data;
//            } catch(err){
//                console.error(err.message);
//            }
//        };
//