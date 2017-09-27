const peso = document.getElementById('peso');
const alt = document.getElementById('alt');
const lista = document.getElementById('lista');
//
var v = [];
var count = 0;

function calc(){
  let alt_ = parseInt(alt.value) / 100;
  let rtn = Math.round(parseInt(peso.value) / Math.pow(alt_,2),2);
  
  let p = {};
  p.peso = parseInt(peso.value);
  p.altezza = parseInt(alt.value);
  p.ibm = rtn;
  
  v.push(p);
  show();
  //clear();
}

function show(){
  
  let template =
      "PESO: [peso] ALTEZZA: [alt] IBM: [ibm]";
  
  for(let k=0; k<v.length; k++){
    
    var scheda = template
                .replace("[peso]",v[k].peso)
                .replace("[alt]",v[k].altezza)
                .replace("[ibm]",v[k].ibm);
    
    //console.log(v[k]);
    if(lista.hasChildNodes())
    {
      var li = document.createElement("li");
      li.innerHTML = scheda;
      console.log(scheda + " c=" + (++count));
      lista.appendChild(li);
    }
  }
}

function clear(){
  peso.value = "";
  alt.value = "";
}