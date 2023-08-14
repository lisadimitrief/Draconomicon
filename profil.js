document.addEventListener("DOMContentLoaded", getCurrentUserInfo());

function getCurrentUserInfo() {
  const token = window.localStorage.getItem("token");
  const headers = { 'Authorization' : `Bearer ${token}` };
  const url = "http://localhost:8080/usercurrent";
  axios({url, headers}).then((res) => {
    // axios({
    //   url: 'http://localhost:8080/usercurrent', // l'URL que tu vises ; pour ton api ça serait qqchose du genre http://localhost:8080/api/user/register ?
    //   withCredentials: false, 
    //   headers: { 
    //       "Authorization" : `Bearer ${token}`,
    //      "Access-Control-Allow-Origin":"*"
    //     }
    // }).then((res) => {
    console.log(res.data);

    let nom = document.getElementById("nom");
    // nom.innerHTML = res.data.username
    nom.innerHTML = `Mon pseudo c'est ${res.data.username}`

    }).catch((error) => {
      console.log(error);
    });
} 


// Faire un axios basique :
// axios({
    //   url: 'http://localhost:8080/usercurrent', // l'URL que tu vises ; pour ton api ça serait qqchose du genre http://localhost:8080/api/user/register ?
    //   withCredentials: false, 
    //   headers: { 
    //       "Authorization" : `Bearer ${token}`,
    //      "Access-Control-Allow-Origin":"*"
    //     }
    // }).then((res) => {
      // console.log(res.data);

      // let nom = document.getElementById("nom");
      // // nom.innerHTML = res.data.username
      // nom.innerHTML = `Mon pseudo c'est ${res.data.username}`
  
      // }).catch((error) => {
      //   console.log(error);
      // });