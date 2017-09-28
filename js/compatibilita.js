var pers = [];

function Persona2(n,c,d){
  this.nome = n;
  this.car = c.split(',').sort();
  this.div = d.split(',').sort();
  this.compatibilita = function(p){
    // return numero caratteristiche comuni, 0 se c'è un divieto
    var carcom = 0;
    // scorro i divieti di this e verifico se corrispondono a una caratteristica in p
    for(var i=0; i<this.div.length; i++){
      for(var k=0; k<p.car.length; k++){
        if(this.div.indexOf(p.car[k])>=0){
          //console.log(this.nome+" odia la caratteristica "+this.div[i]+" di "+p.nome);
          return 0;
        }
      }
    }
    
    // scorro le caratteristiche per calcolare il numero di comuni
    for(var i=0; i<this.car.length; i++){
      for(var k=0; k<p.car.length; k++){
        if(this.car.indexOf(p.car[k])>=0){
          //console.log(this.nome+" e "+p.nome+" hanno in comune la caratteristica "+p.car[k]);
          carcom++;
        }
      }
    }
    
    //console.log(this.nome+" ha "+carcom+" caratteristiche in comune con "+p.nome);
    return carcom;    
  }
}

function Persona(n,c,d){
  this.nome = n;
  this.car = c.split(',').sort();
  this.div = d.split(',').sort();
  this.compatibilita = function(p){

    var count = 0;
    
    for(var i=0; i<this.car.length; i++)
    {
      for(var k=0; k<p.car.length; k++)
      {
        if(this.div.indexOf(p.car[k])>=0)
        {
          //console.log(this.div.indexOf(p.car[k])>=0);
          return 0;
        }
        if(this.car.indexOf(p.car[k])>=0)
        {
          //console.log(this.car.indexOf(p.car[k])>=0);
          count++;
          break;
        }
      }
    }
    return count;
  }
}

function init(){
  //var p1 = new Persona('Alberto', 'A,B,C,F,H', 'Z,X');
  var p1 = new Persona('Alberto', 'C,F', 'Z,X');
  var p2 = new Persona('Bertoldo', 'C,F,H', 'B');
  var p3 = new Persona('Caio', 'B,C,F,L', 'A,X');
  var p4 = new Persona('Damiano', 'A,B,C,X', 'H');
  var p5 = new Persona('Ettore', 'F,Z', 'X');
  pers.push(p1);
  pers.push(p2);
  pers.push(p3);
  pers.push(p4);
  pers.push(p5);

  console.log(":: CONFRONTO CARATTERISTICHE COMUNI RECIPROCHE ::\n");
  confronta();
}

function confronta(){
  for(var i=0; i<pers.length-1; i++){
    for(var k=i+1; k<pers.length; k++){
      var carcom = pers[i].compatibilita(pers[k]);
      console.log(pers[i].nome+" ha "+carcom+" caratteristiche in comune con "+pers[k].nome);
    }
    
  }
}

init();