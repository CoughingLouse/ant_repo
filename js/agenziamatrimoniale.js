var persone = [];

function Persona(n,i){
  this.nome = n;
  this.interessi = i.split(",");
}

function insert(n,i){
  var p = new Persona(n,i);
  persone.push(p);
}

////////////////////
var p1 = new Persona('Alberto','A,B,C');
var p2 = new Persona('Bertoldo','A,B');
var p3 = new Persona('Caio','D,B');
var p4 = new Persona('Domyos','B,E,A');

persone.push(p1);
persone.push(p2);
persone.push(p3);
persone.push(p4);

function match(){
  
  var count = 0;

  for(var i=0; i<persone.length-1; i++)
  {
    for(var k=i+1; k<persone.length; k++)
    {
      for(var m=0; m<persone[i].interessi.length; m++)
      {
        for(var n=0; n<persone[k].interessi.length; n++)
        {
          if(persone[i].interessi[m] === persone[k].interessi[n])
            count++;
        }
      }
    
    }
  }
  
  console.log(count);
}