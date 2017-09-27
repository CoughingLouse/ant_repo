var persone = [];

function Persona(n,l,v,c,s)
{
  this.nome = n;
  this.lettura = l;
  this.vg = v;
  this.cinema = c;
  this.sport = s;
}

function scheda(p)
{
  var s = "_nome: " + p.name + " _interessi: ";
  if(p.lettura) s += "lettura ";
  if(p.vg) s += "videogames ";
  if(p.cinema) s += "cinema ";
  if(p.sport) s += "sport ";
  return s + "<br/>";
}

function aggiungi(n,l,v,c,s)
{
  var p = new Persona(n,l,v,c,s);
  console.log("p.nome="+p.nome);
  console.log("n="+n);
  persone.push(p);
  //console.log("persone.length="+persone.length);
  stampali();
  //document.getElementById("name").value = "";
}

function stampali()
{
  var rtn = "";
  for(var i=0; i<persone.length; i++){
    rtn += scheda(persone[i]);
  }
  document.getElementById("lista").innerHTML = rtn;
  
}