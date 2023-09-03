const browserEnv = require('browser-env');
const navigator = browserEnv(['navigator']);
const express = require('express');
const morgan = require('morgan');
const app = express();
const port = 5500;

if ("serviceWorker" in navigator) {
    navigator.serviceWorker.register("serviceWorker.js");
}

app.use(express.static('public'));
app.use(morgan("dev"));

app.get('/blog', function (req, res) {
  res.status(200).sendFile('HTML/blog.html', {root:__dirname})
})
app.get('/cgu', function (req, res) {
  res.status(200).sendFile('HTML/cgu.html', {root:__dirname})
})
app.get('/connexion', function (req, res) {
  res.status(200).sendFile('HTML/connexion.html', {root:__dirname})
})
app.get('/encyclopedie', function (req, res) {
  res.status(200).sendFile('HTML/encyclopedie.html', {root:__dirname})
})
app.get('/home', function (req, res) {
  res.status(200).sendFile('HTML/index.html', {root:__dirname})
})
app.get('/inscription', function (req, res) {
  res.status(200).sendFile('HTML/inscription.html', {root:__dirname})
})
app.get('/profil', function (req, res) {
  res.status(200).sendFile('HTML/profil.html', {root:__dirname})
})
app.get('/', function (req, res) {
    res.status(304).redirect('/home')
})


app.use((req, res)=>{
  res.status(404).sendFile('HTML/404.html', {root:__dirname})
})

app.listen(port, ()=>{
    console.log("server listening on port " + port);
})