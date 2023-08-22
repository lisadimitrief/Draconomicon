function inscription(formulaire) {
  const premierMDP = document.getElementById("premierMDP").value;
  const deuxiemeMDP = document.getElementById("deuxiemeMDP").value;
  if (premierMDP !== deuxiemeMDP) {
    alert("Tes saisies de mot de passe ne sont pas identique");
  } else {
    axios({
      method: "post",
      url: "http://localhost:8080/register",
      data: {
        username: formulaire.elements["username"].value,
        mail: formulaire.elements["mail"].value,
        password: formulaire.elements["password"].value,
        age: formulaire.elements["age"].value,
        idGenre: formulaire.elements["genre"].value,
      },
    })
      .then((res) => {
        window.location.pathname = "/connexion.html";
        console.log(res);
      })
      .catch((error) => {
        console.log(error);
        alert("Tu t'es trompé dans ta saisie");
      });
  }
}
