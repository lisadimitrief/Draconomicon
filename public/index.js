let header = document.getElementById("head");
let activePage = document.getElementsByTagName("h1");
const token = window.localStorage.getItem("token");

if(token===null){
    header.innerHTML= 
        `
            <div id="titre">
                <a href="/home" id="lienAcceuil">
                    <img src="images/draconomicon.png" id="draconomicon">
                </a>
            </div>
            <nav>
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
                <a href="/home" id="lienAcceuil">
                    <img src="images/draconomicon.png" id="draconomicon">
                </a>
            </div>
            <nav>
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
    let deconnexion = document.getElementById("deconnexion");
    deconnexion.addEventListener("click",()=>{
        window.localStorage.removeItem("token");
        window.localStorage.removeItem("pseudo");
        window.localStorage.removeItem("userId");
        window.location.pathname = "/index"
    })
}

//////FOOTER/////////////////////////////////////////////////////////////////////////////

let footer = document.getElementById("foot");
footer.innerHTML = 
    `
        <h3>Crée par Lisa Dimitrief-Dontcheff</h3>
    `


///////BURGER///////////////////////////////////////////////////////////////

const btnBurger = document.getElementById("burger");
// const boutonD = document.getElementById("burger");

// let container = document.createElement("div");
// let modal = document.createElement("div");

// document.body.append(container);
// container.append(modal);
// container.setAttribute("id","container");
// modal.setAttribute("id","modal");


// modal.innerHTML=
//                 `
//                     <ul>
//                         <a href="index.html"><li>Acceuil</li></a>
//                         <a href="inscription.html"><li>Inscription</li></a>
//                         <a href="connexion.html"><li>Connection</li></a>
//                         <a href="encyclopdie.html"><li>Encylopédie</li></a>
//                         <a href="blog.html"><li>Blog</li></a>
//                     </ul>
//                 `

                
                
boutonD.onclick = ()=>boutonD.classList.toggle("active");
boutonD.onclick = ()=>container.classList.toggle("menuBurger");



