document.addEventListener("DOMContentLoaded", publications());

function postBlog(formulaire){
  const token = window.localStorage.getItem("token");
  axios({
    method: 'post', // get, post, put, delete...
    url: 'http://localhost:8080/blog', // l'URL que tu vises ; pour ton api ça serait qqchose du genre http://localhost:8080/api/user/register ?
    headers: {"Authorization" : `Bearer ${token}`},
    data: {
      titre: formulaire.elements["titre"].value,
      contenu: formulaire.elements["contenu"].value
    }
  }).then((res) => {
    console.log(res);
  }).catch((error) => {
    console.log(error)
    alert("Il y a eu un problème, essaie plus tard petit dragon");
  });
}

function publications() {
  const token = window.localStorage.getItem("token");
    axios({
        method: "get",
        url: 'http://localhost:8080/blog',
        headers: {'Authorization' : `Bearer ${token}`}
    }).then((res)=>{
        console.log(res.data);

        let article = document.getElementById("articles");
        // for (let i = 0; i < res.data.length; i++) {
        article.innerHTML = res.data.map(fil=> 
          `
              <div>
                  <div>
                    <h3>${fil.username}</h3>
                    <h3>${new Date(Date.parse(fil.dateBlog)).toLocaleString()}</h3>
                  </div>
                  <h3>${fil.titre}</h3>
                  <p>${fil.contenu}</p>
              </div>
          `
        ).join("")}
)}

function publicationsDe(formulaire) {
  let blogCible = formulaire.elements["blogCible"].value;
  const token = window.localStorage.getItem("token");
    axios({
        method: "get",
        url: `http://localhost:8080/blog/${blogCible}`,
        headers: {'Authorization' : `Bearer ${token}`}
    }).then((res)=>{
        console.log(res.data);

        let article = document.getElementById("articles");
        article.innerHTML = res.data.map(fil=> 
          `
              <div>
                  <div>
                    <h3>${fil.username}</h3>
                    <h3>${new Date(Date.parse(fil.dateBlog)).toLocaleString()}</h3>
                  </div>
                  <h3>${fil.titre}</h3>
                  <p>${fil.contenu}</p>
              </div>
          `
        ).join("")}
)}