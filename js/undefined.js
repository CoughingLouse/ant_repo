var persone = [];
var ris = document.getElementById("ris");

function Persona(n)
{
  this.name = n;
  this.scheda = function(){
    var rtn = "Nome: " + this.name + "<br/>";
  }
}

function aggiungi(){
  var p = new Persona();
  persone.push(p);
  console.log(p);
  stampali();
}

function stampali(){
  var rtn = "";
  for(var i=0; i<persone.length; i++){
    rtn += persone[i].scheda();
  }
  ris.innerHTML = rtn;
}