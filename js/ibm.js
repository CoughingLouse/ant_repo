let peso = document.getElementById('peso');
let alt = document.getElementById('alt');
let ris = document.getElementById('ris');
//
let c1 = document.getElementById('c1');
let c2 = document.getElementById('c2');
let c3 = document.getElementById('c3');
//
let p = {};

function calc(){
  let rtn;
  let alt_ = parseInt(alt.value) / 100;
  rtn = Math.round(parseInt(peso.value) / Math.pow(alt_,2),2);
  
  p.peso = peso.value;
  p.altezza = alt.value;
  p.ibm = rtn;
  show(p);  
}

function show(){
  c1.innerHTML = p.peso;
  c2.innerHTML = p.altezza;
  c3.innerHTML = p.ibm;
}