// Ceci sert a la connexion

function connexion(formulaire){
  // axios : envoi une requête http
  // on donne la méthode, l'url de connexion (ici localhost:8080/login) et les informations nécessaires avec le "data{}"
  axios({
    method: 'post', // get, post, put, delete...
    url: 'http://localhost:8080/login',
    // withCredentials: false,
    headers: {"Access-Control-Allow-Origin": "*"},
    data: {
      username: formulaire.elements["username"].value,
      password: formulaire.elements["password"].value
    },
}).then((res) => {
    // ici on récupères le retour de l'api, et tu l'exploites comme tu veux ; ça peut être du texte ou un json
    // tes données que te renvoie l'api sont dans res.data
    window.localStorage.setItem("token", res.data.token);
    window.location.pathname = "/profil.html"
  }).catch((error) => {
    console.log(error)
    alert("Tu t'es trompé dans ta saisie");
  });
}

// fetch(`https://api.themoviedb.org/3/search/movie?api_key=${ApiKey}&query=Eragon`).then(response=>console.log(response.json().results[0]))
// let myHeaders = new Headers();

// let myInit = {
//   method: "post",
//   headers: myHeaders,
//   mode: "cors",
//   cache: "default",
// };

// fetch("flowers.jpg", myInit)
//   .then(function (response) {
//     return response.blob();
//   })
//   .then(function (myBlob) {
//     var objectURL = URL.createObjectURL(myBlob);
//     myImage.src = objectURL;
//   });
