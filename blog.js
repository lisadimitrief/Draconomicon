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
    axios({
        method: "get",
        url: 'http://localhost:8080/blog/viewall',
    }).then((res)=>{
        console.log(res.data);

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
        console.log(res.data);
        let article = document.getElementById("articles");
        article.innerHTML = res.data.map(fil=> 
            afficheBlog(fil)
        ).join("")})
}

function afficheBlog(fil) {
    console.log(username, fil.username);
    return  `
                <div id="${fil.idBlog}">
                    <div>
                        <h3 id="userPost">${fil.username}</h3>
                        <h3>${new Date(Date.parse(fil.dateBlog)).toLocaleString()}</h3>
            `
            +
            (username===fil.username?`<button id="X" onclick="deletePost(this)">X</button>`:``)
            +
            `
                    </div>
                    <h3>${fil.titre}</h3>
                    <p>${fil.contenu}</p>
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