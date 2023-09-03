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
  res.status(200).sendFile('blog.html', {root:__dirname})
})
app.get('/cgu', function (req, res) {
  res.status(200).sendFile('cgu.html', {root:__dirname})
})
app.get('/connexion', function (req, res) {
  res.status(200).sendFile('connexion.html', {root:__dirname})
})
app.get('/encyclopedie', function (req, res) {
  res.status(200).sendFile('encyclopedie.html', {root:__dirname})
})
app.get('/home', function (req, res) {
  res.status(200).sendFile('index.html', {root:__dirname})
})
app.get('/inscription', function (req, res) {
  res.status(200).sendFile('inscription.html', {root:__dirname})
})
app.get('/profil', function (req, res) {
  res.status(200).sendFile('profil.html', {root:__dirname})
})
app.get('/', function (req, res) {
    res.status(304).redirect('/home')
})


app.use((req, res)=>{
  res.status(404).sendFile('404.html', {root:__dirname})
})

app.listen(port, ()=>{
    console.log("server listening on port " + port);
})