var peri = document.getElementById("peri");
var area = document.getElementById("area");

function Triangolo(b,a){
  // equilatero
  this.base = b;
  this.altezza = a;
  this.perimetro = function(){return this.base*3;}
  this.area = function(){return this.base*this.altezza/2;}
}

function calcola(b,a){
  var tri = new Triangolo(b,a);
  peri.innerHTML = tri.perimetro();
  area.innerHTML = tri.area();
}