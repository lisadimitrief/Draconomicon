let header = document.getElementById("head");
let activePage = document.getElementsByTagName("h1");

if(header == null){}else {
header.innerHTML= 
    `
        <div id="titre">
            <a href="index.html" id="lienAcceuil">
                <img src="images/draconomicon.png" id="draconomicon">
            </a>
        </div>
        <nav>
            <a href="inscription.html">
                <img src="images/onglet.png" alt="parchemin déchiré" class="longP">
                <img src="images/ongletFocus.svg" alt="rectangle rouge" class="ongletFocus" ${activePage[0].outerText=='Inscription' ? 'id="focus"' : ''}>
                <p>Inscription</p>
            </a>
            <a href="connexion.html">
                <img src="images/onglet.png" alt="parchemin déchiré" class="longP">
                <img src="images/ongletFocus.svg" alt="rectangle rouge" class="ongletFocus" ${activePage[0].outerText=='Connexion' ? 'id="focus"' : ''}>
                <p>Connexion</p>
            </a>
            <a href="enyclopedie.html">
                <img src="images/onglet.png" alt="parchemin déchiré" class="longP">
                <img src="images/ongletFocus.svg" alt="rectangle rouge" class="ongletFocus" ${activePage[0].outerText=='Encyclopédie' ? 'id="focus"' : ''}>
                <p>Encyclopédie</p>
            </a>
            
            <a href="blog.html">
                <img src="images/onglet.png" alt="parchemin déchiré">
                <img src="images/ongletFocus.svg" alt="rectangle rouge" class="ongletFocus" ${activePage[0].outerText=='Blog' ? 'id="focus"' : ''}>
                <p>Blog</p>
            </a>
            <a id="burger"><img src="images/icone.png"></a>
        </nav>        
    `;
}
////////CONNECTER///////////////////////////////////////////////////////////////

let headerProfil = document.getElementById("headP");
if(headerProfil == null){}else {
headerProfil.innerHTML =
    `
        <div id="titre">
        <a href="index.html" id="lienAcceuil">
            <img src="images/draconomicon.png" id="draconomicon">
        </a>
        </div>
        <nav>
            <a href="profil.html">
                <img src="images/onglet.png" alt="parchemin déchiré" class="longP">
                <img src="images/ongletFocus.svg" alt="rectangle rouge" class="ongletFocus" ${activePage[0].outerText=='Profil' ? 'id="focus"' : ''}>
                <p>Profil</p>
            </a>
            <a href="index.html" id="deconnexion">
                <img src="images/onglet.png" alt="parchemin déchiré" class="longP">
                <p>Déconnexion</p>
            </a>
            <a href="enyclopedie.html">
                <img src="images/onglet.png" alt="parchemin déchiré" class="longP">
                <img src="images/ongletFocus.svg" alt="rectangle rouge" class="ongletFocus" ${activePage[0].outerText=='Encyclopédie' ? 'id="focus"' : ''}>
                <p>Encyclopédie</p>
            </a>
            <a href="blog.html">
                <img src="images/onglet.png" alt="parchemin déchiré">
                <img src="images/ongletFocus.svg" alt="rectangle rouge" class="ongletFocus" ${activePage[0].outerText=='Blog' ? 'id="focus"' : ''}>
                <p>Blog</p>
            </a>
            <a id="burger"><img src="images/icone.png"></a>
        </nav>
    `;
}

let deconnexion = document.getElementById("deconnexion");
deconnexion.addEventListener("click",()=>{
  window.localStorage.removeItem("token");
  window.location.pathname = "/index.html"
})

///////BURGER///////////////////////////////////////////////////////////////

const boutonD = document.getElementById("burger");

let container = document.createElement("div");
let modal = document.createElement("div");

document.body.append(container);
container.append(modal);
container.setAttribute("id","container");
modal.setAttribute("id","modal");


modal.innerHTML=
                `
                    <ul>
                        <a href="index.html"><li>Acceuil</li></a>
                        <a href="inscription.html"><li>Inscription</li></a>
                        <a href="connexion.html"><li>Connection</li></a>
                        <a href="encyclopdie.html"><li>Encylopédie</li></a>
                        <a href="blog.html"><li>Blog</li></a>
                    </ul>
                `

                
                
boutonD.onclick = ()=>boutonD.classList.toggle("active");
boutonD.onclick = ()=>container.classList.toggle("menuBurger");

//////FOOTER/////////////////////////////////////////////////////////////////////////////

let footer = document.getElementById("foot");
footer.innerHTML = 
    `
        <h3>Crée par Lisa Dimitrief-Dontcheff</h3>
    `
