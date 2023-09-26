document.addEventListener("DOMContentLoaded", getCurrentUserInfo());

function getCurrentUserInfo() {
    const token = window.localStorage.getItem("token");
    const headers = { Authorization: `Bearer ${token}` };
    const url = "http://localhost:8080/usercurrent";

    axios({ url, headers }).then((res) => {
        let user = res.data;
        let boiteProfil = document.getElementById("boiteProfil");

        window.localStorage.setItem("userId", res.data.idUser);

        const avatars = [
            "amphitere.jpg",
            "kirin.jpg",
            "dragon.jfif",
            "amphitere2.jpg",
            "dragon2.jpg",
            "dragonAsiatique.jfif",
            "dragonAsiatique2.jpg",
            "dragonMagique.jpg",
            "dragonSteampunk.jfif",
            "dragonSteampunkMagique.jfif",
        ];
        const images = avatars.map((avatar) => {
            if (user.avatar !== avatar) {
                return `
                    <div class="hexagone">
                        <div class="hexagonemain">
                            <div class="hexagonemainbefore">
                                <img src="images/avatar/${avatar}" onclick="modifAvatar('${avatar}')"/>
                            </div>
                        </div>
                    </div>`;
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
            ` +
            images.join("") +
            `
            </div>
            
        </div>
        <form onsubmit="modif(this); return false">
            <label>Mes informations</label>
            <div>
                <label>Pseudo</label>
                <input required type="texte" name="username" minlength="2" maxlength="20" value="${
                    user.username
                }">
            </div>
            <div>
                <label>E-mail</label>
                <input type="texte" name="mail" maxlength="30" value="${
                    user.mail
                }">
            </div>
            <div>
                <label>Age</label>
                <input required type="number" name="age" value="${user.age}" min="14" max="90">
            </div>
            <div>
                <label>Mot de Passe</label>
                <input type="password" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,16}$" name="password">
            </div>
            <div>
                <label for="genre-selection">Genre :</label>
                <select name="idGenre" id="genre-selection">
                    <option class="optionCible" value="1" ${
                        user.idGenre === 1 ? "selected" : ""
                    }>Femme</option>
                    <option class="optionCible" value="2" ${
                        user.idGenre === 2 ? "selected" : ""
                    }>Homme</option>
                    <option class="optionCible" value="3" ${
                        user.idGenre === 3 ? "selected" : ""
                    }>Autre</option>
                </select>
            </div>
            <div>
                <input type="submit" value="Valider">
            </div>
        </form>
        <svg xmlns="http://www.w3.org/2000/svg"><filter id="svgTint"><feColorMatrix type="matrix" values="1 1 1  0 0 0.0392156862745098 0.0392156862745098 0.0392156862745098  0 0 0.0392156862745098 0.0392156862745098 0.0392156862745098  0 0  0 0 0 1 0" /></filter></svg>
        <a id="btnSupprime"><img src="images/icone.png" alt="tête de dragon gris"/></a>
        `;
        let btnSupprime = document.getElementById("btnSupprime");

        btnSupprime.addEventListener("mouseout", finHoverBTNSupprime);
        btnSupprime.addEventListener("mouseover", hoverBTNSupprime);
        btnSupprime.addEventListener("click", popup);
    }).catch((error) => {
        console.log(error);
    });
}
function finHoverBTNSupprime(){
    document.getElementById("btnSupprime").style.filter= "none";
}
function hoverBTNSupprime(){
    document.getElementById("btnSupprime").style.filter= "brightness(68%) contrast(85%) hue-rotate(360deg) saturate(300%) url(#svgTint)";
}
function popup(){
    document.getElementById("supprimerTout").style.display= "block";
}
function modif(form) {
    const token = window.localStorage.getItem("token");
    const userId = window.localStorage.getItem("userId");
    const headers = { Authorization: `Bearer ${token}` };
    const url = `http://localhost:8080/user/${userId}`;
    if (window.confirm("es-tu sûr ?")) {
    
        axios({
            headers,
            url,
            method: "patch",
            data: {
                username: form.elements["username"].value,
                mail: form.elements["mail"].value,
                age: form.elements["age"].value,
                idGenre: form.elements["idGenre"].value,
                password: form.elements["password"].value,
            },
        })
        .then((res) => {
            window.localStorage.removeItem("token");
            window.localStorage.removeItem("pseudo");
            window.localStorage.removeItem("userId");
            window.localStorage.setItem("token", res.data.token);
            window.localStorage.setItem("pseudo", form.elements["username"].value);
            window.location.reload();
        }).catch((errorModif) => {console.log(errorModif);});
    }
}

function modifAvatar(avatar) {
    const token = window.localStorage.getItem("token");
    const userId = window.localStorage.getItem("userId");
    const headers = { Authorization: `Bearer ${token}` };
    const url = `http://localhost:8080/user/${userId}`;
    axios({
        headers,
        url,
        method: "patch",
        data: {
            avatar: avatar,
        }
    })
    .then((res) => {
        window.location.reload();
    })
    .catch((error) => {
        console.log(error);
    });
}

let supprimerTout = document.getElementById("supprimerTout");
supprimerTout.innerHTML = `
    <img src="images/onglet.png" alt="parchemin vertical" id="parcheminSupprime">
    <form id="formSupprimer" onsubmit="supprimeCompte(this); return false">
        <div><label id="titreSupprime">⚠️🔥 Supprimer mon compte et mes publications 🔥⚠️</label></div>
        <div>
            <label>Pseudo</label>
            <input type="texte" name="username" maxlength="20">
        </div>

        <div>
            <label>Mot de passe</label>
            <input type="password" name="password">
        </div>

        <div>
            <label class="invisible">invisible</label>
            <input type="submit" id="valideSupprime" value="Supprimer mon Compte">
        </div>

        <div>
            <label class="invisible">invisible</label>
            <input id="annuleSupprime" type="button" id="valideInsc" value="Annuler" >
        </div>
    </form>
`;

function supprimeCompte(formulaire) {
    if (window.confirm("Es-tu sûr ?")) {
        if (window.confirm("Veux-tu vraiment supprimer ton compte ?")) {
            if (window.confirm("Vraiment sûr ?")) {
                axios({
                    method: 'post',
                    url: 'http://localhost:8080/login',
                    headers: {"Access-Control-Allow-Origin": "*"},
                    data: {
                        username: formulaire.elements["username"].value,
                        password: formulaire.elements["password"].value
                    }
            
                }).then((response) => {
            
                    const token = window.localStorage.getItem("token");
                    const userId = window.localStorage.getItem("userId");
                    axios({ 
                        method: "delete",
                        url: `http://localhost:8080/user/${userId}`,
                        headers: {"Authorization" : `Bearer ${token}`}
                    })
                    .then((res) => {
                        window.localStorage.removeItem("token");
                        window.localStorage.removeItem("pseudo");
                        window.localStorage.removeItem("userId");
                        window.location.pathname = "/home"
                    })
                    .catch((error) => {
                        console.log(error);
                    });
            
                }).catch((error) => {
                    console.log(error)
                    alert("Ton pseudo et/ou ton mot de passe est incorrect.");
                });
            }    
        }
    }
}


let annuleSupprime = document.getElementById("annuleSupprime");
annuleSupprime.addEventListener("click", poplus);
function poplus(){
    document.getElementById("supprimerTout").style.display= "none";
};