let header = document.getElementById("head");
let activePage = document.getElementsByTagName("h1");
const token = window.localStorage.getItem("token");

if(token===null){
    header.innerHTML= 
        `
            <div id="titre">
                <a href="/home" id="lienAccueil">
                    <img src="images/draconomicon.png" id="draconomicon">
                </a>
            </div>
            <nav >
                <a href="/inscription">
                    <img src="images/onglet.png" alt="parchemin déchiré" class="longP">
                    <img src="images/ongletFocus.svg" alt="rectangle rouge" class="ongletFocus" ${activePage[0].outerText=='Inscription' ? 'id="focus"' : ''}>
                    <p>Inscription</p>
                </a>
                <a href="/connexion">
                    <img src="images/onglet.png" alt="parchemin déchiré" class="longP">
                    <img src="images/ongletFocus.svg" alt="rectangle rouge" class="ongletFocus" ${activePage[0].outerText=='Connexion' ? 'id="focus"' : ''}>
                    <p>Connexion</p>
                </a>
                <a href="/encyclopedie">
                    <img src="images/onglet.png" alt="parchemin déchiré" class="longP">
                    <img src="images/ongletFocus.svg" alt="rectangle rouge" class="ongletFocus" ${activePage[0].outerText=='Encyclopédie' ? 'id="focus"' : ''}>
                    <p>Encyclopédie</p>
                </a>
                
                <a href="/blog">
                    <img src="images/onglet.png" alt="parchemin déchiré">
                    <img src="images/ongletFocus.svg" alt="rectangle rouge" class="ongletFocus" ${activePage[0].outerText=='Blog' ? 'id="focus"' : ''}>
                    <p>Blog</p>
                </a>
            </nav>
        `;
}else{
    header.innerHTML=
        `
            <div id="titre">
                <a href="/home" id="lienAccueil">
                    <img src="images/draconomicon.png" id="draconomicon">
                </a>
            </div>
            <nav >
                <a href="/profil">
                    <img src="images/onglet.png" alt="parchemin déchiré" class="longP">
                    <img src="images/ongletFocus.svg" alt="rectangle rouge" class="ongletFocus" ${activePage[0].outerText=='Profil' ? 'id="focus"' : ''}>
                    <p>Profil</p>
                </a>
                <a href="/home" id="deconnexion">
                    <img src="images/onglet.png" alt="parchemin déchiré" class="longP">
                    <p>Déconnexion</p>
                </a>
                <a href="/encyclopedie">
                    <img src="images/onglet.png" alt="parchemin déchiré" class="longP">
                    <img src="images/ongletFocus.svg" alt="rectangle rouge" class="ongletFocus" ${activePage[0].outerText=='Encyclopédie' ? 'id="focus"' : ''}>
                    <p>Encyclopédie</p>
                </a>
                <a href="/blog">
                    <img src="images/onglet.png" alt="parchemin déchiré">
                    <img src="images/ongletFocus.svg" alt="rectangle rouge" class="ongletFocus" ${activePage[0].outerText=='Blog' ? 'id="focus"' : ''}>
                    <p>Blog</p>
                </a>
            </nav>
        `;
}

//////FOOTER/////////////////////////////////////////////////////////////////////////////

let footer = document.getElementById("foot");
footer.innerHTML = 
    `
        <h3>Créé par Lisa Dimitrief-Dontcheff</h3>
    `
    
    
///////BURGER///////////////////////////////////////////////////////////////
let navBurger = document.getElementById("navBurger");
if(token===null){
    navBurger.innerHTML= 
        `
            <a href="/home" id="lienAccueil">
                <p>Accueil</p>
            </a>
            <a href="/inscription">
                <p>Inscription</p>
            </a>
            <a href="/connexion">
                <p>Connexion</p>
            </a>
            <a href="/encyclopedie">
                <p>Encyclopédie</p>
            </a>
            
            <a href="/blog">
                <p>Blog</p>
            </a>
            <a disable>
                <p class="invisible">Blog</p>
            </a>
            <a disable>
                <p class="invisible">Blog</p>
            </a>
        `;
}else{
    navBurger.innerHTML=
        `
            <a href="/home" id="lienAccueil">
                <p>Accueil</p>
            </a>
            <a href="/profil">
                <p>Profil</p>
            </a>
            <a href="/home" id="deconnexion">
                <p>Déconnexion</p>
            </a>
            <a href="/encyclopedie">
                <p>Encyclopédie</p>
            </a>
            <a href="/blog">
                <p>Blog</p>
            </a>
            <a disable>
                <p class="invisible">Blog</p>
            </a>
            <a disable>
                <p class="invisible">Blog</p>
            </a>
        `;
}


const btnBurger = document.getElementById("burger");
let styleNavBurger = document.getElementById("navBurger");
let styleBurger = document.getElementById("burger");
btnBurger.addEventListener("click", ()=>{
    if (styleNavBurger.style.display=== "block") {
        styleNavBurger.style.display= "none";
        styleBurger.style.top= -5+"em";
    } else {
        styleNavBurger.style.display= "block";
        styleBurger.style.top= 25+"em";
    }
});

let deconnexion = document.getElementById("deconnexion");
    deconnexion.addEventListener("click",()=>{
        window.localStorage.removeItem("token");
        window.localStorage.removeItem("pseudo");
        window.localStorage.removeItem("userId");
        window.location.pathname = "/home"
    })


