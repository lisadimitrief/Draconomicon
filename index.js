let header = document.getElementById("head");
let activePage = document.getElementsByTagName("h1");
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
    `

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






// boutonD.addEventListener("click", popup());
// boutonD.addEventListener("dblclick", poplus());
// container.style.display="none";
// function popup(){
//     console.log(container);
//         container.style.display="block";
//         boutonD.style.position= "fixed";
//         boutonD.style.bottom= 5+"em";
//         boutonD.style.top= none;
//     };
//     function poplus(){
//         console.log(container);
//         container.style.display="none";
//         boutonD.style.bottom= none;
//         boutonD.style.top= 0;
//     };
//     // function test() {
//     // if (container.style.display="block"?) {
//     //     // container.style.display="none";
//     //     // boutonD.style.bottom= none;
//     //     // boutonD.style.top= 0;
//     // } else {
//     //     container.style.display="block";
//     //     boutonD.style.position= "fixed";
//     //     boutonD.style.bottom= 5+"em";
//     // }
//     // } 
