function inscription(formulaire){
  // axios : envoi une requête http
  // on donne la méthode, l'url de connexion (ici localhost:8080/login) et les informations nécessaires avec le "data{}"
  axios({
    method: 'post', // get, post, put, delete...
    url: 'http://localhost:8080/register', // l'URL que tu vises ; pour ton api ça serait qqchose du genre http://localhost:8080/api/user/register ?
    data: {
      username: formulaire.elements["username"].value,
      mail: formulaire.elements["mail"].value,
      password: formulaire.elements["password"].value,
      age: formulaire.elements["age"].value,
      genreProfil: 1
    },
}).then((res) => {
    // ici tu récupères le retour de l'api, et tu l'exploites comme tu veux ; ça peut être du texte ou un json
    // tes données que te renvoie l'api sont dans res.data
    // window.localStorage.setItem("token", res.data.token);
    // window.location.pathname = "/profil.html"
  console.log(res);
  }).catch((error) => {
    console.log(error)
    alert("Tu t'es trompé dans ta saisie");
  });
}
