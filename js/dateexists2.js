var sAnno = document.getElementById("selectAnno");
var sMese = document.getElementById("selectMese");
var sGiorno = document.getElementById("selectGiorno");
var res = document.getElementById("res");
var anni = [];
var mesi = [];
var giorni = [];
const MIN = 1;
const minANNI = 1960;
const maxANNI = 2017;
const maxMESI = 12;
const maxGIORNI = 31;
const mesiDa30 = [4,6,9,11];
const gds = ['Domenica','Lunedì','Martedì','Mercoledì','Giovedì','Venerdì','Sabato'];
//
function setup(){
  for(var i=minANNI; i<=maxANNI; i++)
    anni.push(i);
  for(var i=MIN; i<=maxMESI; i++)
    mesi.push(i);
  for(var i=MIN; i<=maxGIORNI; i++)
    giorni.push(i);
  
  populate();
}

function populate(){
  
  for(var i = 0; i < anni.length; i++) {
    var opt = anni[i];
    var el = document.createElement("option");
    el.textContent = opt;
    el.value = opt;
    sAnno.appendChild(el);
  }
  
  for(var i = 0; i < mesi.length; i++) {
    var opt = mesi[i];
    var el = document.createElement("option");
    el.textContent = opt;
    el.value = opt;
    sMese.appendChild(el);
  }
  
  for(var i = 0; i < giorni.length; i++) {
    var opt = giorni[i];
    var el = document.createElement("option");
    el.textContent = opt;
    el.value = opt;
    sGiorno.appendChild(el);
  }
}

function isBisestile(a){
  return (a%100 === 0 && a/400 === 0);
}

function check0(a,m,g){
  var ris = true;
  
  if((m==4 || m==6 || m==9 || m==11) && g==31)
    ris = false;
  
  if(m==2)
    if(g>=30 || (g==29 && a%4!=0))
      ris = false;
  
  var d = new Date(a, (m-1), g);
  var dd = d.getDay();
  res.innerHTML = ris ? "Data OK ed era un" + (dd === 0 ? "a "+gds[dd] : " "+gds[dd]) : "Data KO";
}

function check(a,m,g){
  
  var ris = true;
    
  if(mesiDa30.indexOf(m)>=0 && g === maxGIORNI) ris = false;
  if(m === 2)
    if(g>28 && !isBisestile(a)) ris = false;
  
    
  
  
  var d = new Date(a, (m-1), g);
  var dd = d.getDay();
  res.innerHTML = ris ? "Data OK ed era un" + (dd === 0 ? "a "+gds[dd] : " "+gds[dd]) : "Data KO";
}


setup();