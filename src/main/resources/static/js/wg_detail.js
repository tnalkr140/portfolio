const category = localStorage.getItem('category');
const $textarea = document.querySelector('.chat-text-box');
const $btn = document.querySelector('.button');
const $area_sub = document.getElementById('area_subcat');
const $url = 'http://localhost:9080/give/detail'

        document.querySelector('.select_category').textContent =  '★ '+category+' ☆';
        let localflag = false;
        let dateflag = false;
        $area_sub.addEventListener('click', e=>{
            $btn.disabled = false;
            })
        $btn.addEventListener('click',e =>{
            const text_value = $textarea.value;
            localStorage.setItem('text',text_value);
            const dataToPost = JSON.stringify({
                location : localStorage.getItem('location'),
                category : localStorage.getItem('category'),
                date : localStorage.getItem('date'),
                text : localStorage.getItem('text')
            });
            console.log(dataToPost);
            fetch($url, {
                method: 'POST',
                headers: {
                    'Content-Type' : 'application/json'
                },
                body: dataToPost,
            })
                .then(response=> response.json())
                .then(dataToPost => {
                    console.log('서버응답:', dataToPost);
                    location.href = "http://localhost:9080/give/detail/result";
                })
                .catch(

                );
            })
