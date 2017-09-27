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
const gds = ['Domenica','Lunedì','Martedì','Mercoledì','Gioved+','Venerdì','Sabato'];
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
  
  if((m==4 || m==6 || m==9) && g==31)
    ris = false;
  
  if(m==2)
    if(g>=30 || (g==29 && a%4!=0))
      ris = false;
  
  var d = new Date(a, (m-1), g);
  
  // res.innerHTML = ris ? "Data OK. Era un " + d.getDay() : "Data KO";
  res.innerHTML = ris ? "Data OK ed era un" + (d.getDay() === 0 ? "a "+gds[d.getDay()] : " "+gds[d.getDay()]) : "Data KO";
  
}
/*
function check(a,m,g){
  
  var limMese = 0;
  var limGiorno = (isBisestile(sAnno)) ? 29 : 28;
    
  for(mese in mesiDa30){
    limMese = if(m === 2) ? 30 :
              if(m === 2) ? 29; 
}
*/
setup();