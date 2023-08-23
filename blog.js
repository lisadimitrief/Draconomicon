document.addEventListener("DOMContentLoaded", publications());
const username = window.localStorage.getItem("pseudo");
console.log(username);

let formPost = document.getElementById("formPost");
if (!(token===null || token===undefined)) {
    formPost.innerHTML =  
    `
        <form onsubmit="postBlog(this);">
            <input type="text" name="titre" id="titrePost" placeholder="Titre Accrocheur"></br>
            <input type="text" name="contenu" id="contenuPost" placeholder="Quoi de neuf ?"></br>
            <!-- <input type="file" name="image" id="imagePost"></br> -->
            <input type="submit" value="Publier" id="publier">
        </form>
    `
}

function postBlog(formulaire){
  const token = window.localStorage.getItem("token");
  axios({
    method: 'post',
    url: 'http://localhost:8080/blog',
    headers: {"Authorization" : `Bearer ${token}`},
    data: {
      titre: formulaire.elements["titre"].value,
      contenu: formulaire.elements["contenu"].value
    }
  }).then((res) => {
    titre===null?error:titre
    console.log(res);
  }).catch((error) => {
    console.log(error)
    alert("Il y a eu un problème, essaie plus tard petit dragon");
  });
}

function publications() {
    axios({
        method: "get",
        url: 'http://localhost:8080/blog/viewall',  
    }).then((res)=>{
        let article = document.getElementById("articles");
        article.innerHTML = res.data.map(fil=> 
            afficheBlog(fil)
        ).join("")}
)}

function publicationsDe(formulaire) {
    let blogCible = formulaire.elements["blogCible"].value;
    axios({
        method: "get",
        url: `http://localhost:8080/blog/search/${blogCible}`,
    }).then((res)=>{
        let article = document.getElementById("articles");
        article.innerHTML = res.data.map(fil=> 
            afficheBlog(fil)
        ).join("")})
}

function afficheBlog(fil) {
    return  `
                <div id="post">
                        <div id="${fil.idBlog}">
                            <div id="entetePost">
                                <div class="hexagoneB">
                                    <div class="hexagoneBmain">
                                        <div class="hexagoneBmainbefore">
                                            <img src="images/avatar/${fil.avatar}">
                                        </div>
                                    </div>
                                </div>
                                <h3 id="userPost">${fil.username}</h3>
                                <h3>${new Date(Date.parse(fil.dateBlog)).toLocaleString()}</h3>
                    `
                    +
                    (username===fil.username?`<button id="X" onclick="deletePost(this)">X</button>`:``)
                    +
                    `
                            </div>
                            <hr />
                            <div id="contenuPost">
                                <h3>${fil.titre}</h3>
                                <p>${fil.contenu}</p>
                            </div>
                        </div>
                </div>
            `;
}

function deletePost(post) {
    let postId = post.parentElement.parentElement.id;
    const token = window.localStorage.getItem("token");

    axios({
        method: "delete",
        url: `http://localhost:8080/blog/${postId}`,
        headers: {"Authorization" : `Bearer ${token}`},
    }).then((res)=>{
        window.location.reload();
    });
}