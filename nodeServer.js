const http = require("http");
const fs = require("fs");

const server = http.createServer(
    (Requeste, Response)=>{
        let fichier = "";
        console.log("Server created successfully.");
        Response.setHeader('Content-Type', 'text/html;charset=utf8');
        if ((Requeste.url=== "/" || Requeste.url === "/home") && Requeste.method === "GET") {
            // Response.write("<p>Vous êtes sur la home page.</p>")
            fichier = "index.html"
        } else if (Requeste.url === "/connexion" && Requeste.method === "GET") {
            // Response.write("<p>Vous êtes sur la page contact.</p>")
            fichier = "connexion.html"
        } else if (Requeste.url === "/profil"  && Requeste.method === "GET") {
            // Response.write("<p>Vous êtes sur la page profil.</p>")
            fichier = "profil.html"
        } else if (Requeste.url === "/blog"  && Requeste.method === "GET") {
            // Response.write("<p>Vous êtes sur la page produit.</p>")
            fichier = "blog.html"
        } else if (Requeste.url === "/CGU"  && Requeste.method === "GET") {
            // Response.write("<p>Vous êtes sur la page produit.</p>")
            fichier = "cgu.html"
        } else if (Requeste.url === "/encyclopedie"  && Requeste.method === "GET") {
            // Response.write("<p>Vous êtes sur la page produit.</p>")
            fichier = "encyclopedie.html"
        } else if (Requeste.url === "/inscription"  && Requeste.method === "GET") {
            // Response.write("<p>Vous êtes sur la page produit.</p>")
            fichier = "inscription.html"
        } else {
            // Response.write("<p>Error 404, page not found.</p>")
            fichier = "404.html"
        }
        fs.readFile(fichier, (Error, Data)=>{
            if (Error){
                console.error(Error);
                Response.end();
            } else {
                // console.log(Data.toString());
                Response.write(Data);
                Response.end();
            }
        })
    }
)
server.listen(5500, "localhost", ()=>{
    console.log("server listening on port 5500");
})