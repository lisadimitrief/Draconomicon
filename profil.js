document.addEventListener("DOMContentLoaded", getCurrentUserInfo());

function getCurrentUserInfo() {

    const token = window.localStorage.getItem("token");
    const headers = { 'Authorization' : `Bearer ${token}` };
    const url = "http://localhost:8080/usercurrent";

    axios({url, headers}).then((res) => {
    
    let user = res.data;
    let boiteProfil = document.getElementById("boiteProfil");

    window.localStorage.setItem("userId", res.data.idUser);

    const avatars = ["amphitere.jpg", "kirin.jpg", "dragon.jfif", "amphitere2.jpg", "dragon2.jpg", "dragonAsiatique.jfif", "dragonAsiatique2.jpg", "dragonMagique.jpg", "dragonSteampunk.jfif", "dragonSteampunkMagique.jfif"];
    const images = avatars.map(avatar => {
        if (user.avatar !== avatar) {
            return `<div class="hexagone"><div class="hexagonemain"><div class="hexagonemainbefore"><img src="images/avatar/${avatar}" onclick="modifAvatar('${avatar}')"/></div></div></div>`;
        } else {
            return "";
        }
    });

    boiteProfil.innerHTML = 
        `
            <div id="imagesProfil">
                <div id="headProfil">
                    <div class="hexagone">
                        <div class="hexagonemain">
                            <div class="hexagonemainbefore">
                                <img src="images/avatar/${user.avatar}" alt="">
                            </div>
                        </div>
                    </div>
                    <h3>${user.username}</h3>
                </div>
                <div id="choixAvatar">
                `
                +
                images.join("")
                +
                    `
                </div>
            </div>
            <form onsubmit="modif(this)">
                <label>Mes Informations</label>
                <div>
                    <label>Pseudo</label>
                    <input type="texte" name="username" maxlength="20" value="${user.username}">
                </div>
                <div>
                    <label>E-mail</label>
                    <input type="texte" name="mail" maxlength="30" value="${user.mail}">
                </div>
                <div>
                    <label>Age</label>
                    <input type="number" name="age" value="${user.age}">
                </div>
                <div>
                    <label for="genre-selection">Genre :</label>
                    <select name="idGenre" id="genre-selection">
                        <option class="optionCible" value="1" ${user.idGenre === 1 ? "selected":""}>Femme</option>
                        <option class="optionCible" value="2" ${user.idGenre === 2 ? "selected":""}>Homme</option>
                        <option class="optionCible" value="3" ${user.idGenre === 3 ? "selected":""}>Autre</option>
                    </select>
                </div>
                <input type="submit" value="Valider">
            </form>
        `;

    }).catch((error) => {
        console.log(error);
    });
} 
function modif(form){
    const token = window.localStorage.getItem("token");
    const userId = window.localStorage.getItem("userId");
    console.log(userId);
    const headers = { 'Authorization' : `Bearer ${token}` };
    const url = `http://localhost:8080/user/${userId}`;
    axios({
        headers,
        url,
        method: 'patch',
        data: {
            username: form.elements["username"].value,
            mail: form.elements["mail"].value,
            age: form.elements["age"].value,
            idGenre: form.elements["idGenre"].value
        }
        }
    ).then((res) => {
        console.log(res.data);
    }).catch((error) => {
        console.log(error);
    });
}

function modifAvatar(avatar){
    const token = window.localStorage.getItem("token");
    const userId = window.localStorage.getItem("userId");
    const headers = { 'Authorization' : `Bearer ${token}` };
    const url = `http://localhost:8080/user/${userId}`;
    axios({
        headers,
        url,
        method: 'patch',
        data: {
            avatar: avatar
        }
        }
    ).then((res) => {
        window.location.reload();
    }).catch((error) => {
        console.log(error);
    });
}
