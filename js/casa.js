function Casa(salotto,bagno,camere,balcone){
  //console.log(salotto, bagno, camere, balcone);
  this.salotto = parseInt(salotto);
  this.altezza = parseInt(bagno);
  this.camere = parseInt(camere);
  this.balcone = (balcone === 'si');
  this.prezzo = function(){
    console.log(this.salotto + this.bagno);
    var rtn = (this.salotto + this.bagno) * 300 * this.camere;
    // rtn=NaN ???
    console.log("rtn="+rtn);
    var ris = this.balcone ? rtn + 10000 : rtn;
    return ris;
  }
}

function calcola(a,b,c,d){
  var casa = new Casa(a,b,c,d);
  console.log(casa);
  document.getElementById("prezzo").innerHTML = casa.prezzo();
  
}