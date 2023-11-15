    document.querySelector(".pf_btn_submit").addEventListener('click',()=>{
     let pf_form = new FormData();
     let title = document.querySelector('.title_input').value;
     let content = document.querySelector('.content_input').value;
     pf_form.append("pf_title",title);
     pf_form.append("pf_content",content);
     let url = "/submitportfolio";
     let options = {
          method : "post",
          body : pf_form,
     }
     fetch(url,options)
     .then(res => {
        if (res.ok) {
            return res.json();
        } else {
            throw new Error("서버 응답이 올바르지 않습니다.");
        }
     })
    .then(data => console.log(data))
    .catch(error => console.error(error));
    })

    document.querySelector(".pf_btn_update").addEventListener('click',()=>{
     let pf_form = new FormData();
     let title = document.querySelector('.title_input').value;
     let content = document.querySelector('.content_input').value;
     pf_form.append("pf_title",title);
     pf_form.append("pf_content",content);

     let url = "/updateportfolio";
     let options = {
          method : "patch",
          body : pf_form,
     }
     fetch(url,options)
     .then(res => {
        if (res.ok) {
            return res.json();
        } else {
            throw new Error("서버 응답이 올바르지 않습니다.");
        }
     })
    .then(data => console.log(data))
    .catch(error => console.error(error));
    })

    document.querySelector(".pf_btn_delete").addEventListener('click',()=>{
     let pf_form = new FormData();
     let title = document.querySelector('.title_input').value;
     let content = document.querySelector('.content_input').value;
     pf_form.append("pf_title",title);
     pf_form.append("pf_content",content);

     let url = "/deleteportfolio";
     let options = {
          method : "delete",
     }
     fetch(url,options)
     .then(res => {
        if (res.ok) {
            return res.json();
        } else {
            throw new Error("서버 응답이 올바르지 않습니다.");
        }
     })
    .then(data => console.log(data))
    .catch(error => console.error(error));
    })
