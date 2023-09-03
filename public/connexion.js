function connexion(formulaire){

  let username = formulaire.elements["username"].value;
  
  axios({

    method: 'post',
    url: 'http://localhost:8080/login',
    headers: {"Access-Control-Allow-Origin": "*"},
    data: {
      username: username,
      password: formulaire.elements["password"].value
    }

}).then((res) => {
    
    window.localStorage.setItem("token", res.data.token);
    window.localStorage.setItem("pseudo", username);
    window.location.pathname = "/profil"
    
    }).catch((error) => {
    console.log(error)
    alert("Tu t'es trompé dans ta saisie");
    });

}