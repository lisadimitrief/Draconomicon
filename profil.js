document.addEventListener("DOMContentLoaded", getCurrentUserInfo());

function getCurrentUserInfo() {
  const token = window.localStorage.getItem("token");
  axios({
    method: 'get', // get, post, put, delete...
    url: 'http://localhost:8080/usercurrent', // l'URL que tu vises ; pour ton api ça serait qqchose du genre http://localhost:8080/api/user/register ?
    headers: { 'Authorization' : `Bearer ${token}` }
  }).then((res) => {
    console.log(res.data);

    let nom = document.getElementById("nom");
    // nom.innerHTML = res.data.username
    nom.innerHTML = `Mon pseudo c'est ${res.data.username}`

    }).catch((error) => {
      console.log(error);
    });
}
