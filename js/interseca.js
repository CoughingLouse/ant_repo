var rettangoli = [];

function Rettangolo(x1,y1,x2,y2,n){
  this.x1 = x1;
  this.y1 = y1;
  this.x2 = x2;
  this.y2 = y2;
  this.nome = n
}

function interseca(r1,r2){
  var ris = false;
  
  if( ((r1.x1<=r2.x1 && r1.y1>=r2.y2) && (r1.x2>=r2.x2 && r1.y2<=r2.y2)) // r1 contiene r2
      ||
      ((r2.x1<=r1.x1 && r2.y1>=r1.y2) && (r2.x2>=r1.x2 && r2.y2<=r1.y2)) // r2 contiene r1
      ||
      ((r1.x1<=r2.x1 && r1.y1>=r2.y2) && (r1.x2<=r2.x2 && r1.y2>=r2.y2)) // r1 sovrapposto a r2
      ||
      ((r2.x1<=r1.x1 && r2.y1>=r1.y2) && (r2.x2>=r1.x2 && r2.y2>=r1.y2)) // r2 sovrapposto a r1
    )
    ris = true;
  
  say(r1,r2,ris);
}

function interseca_bis(r1,r2){ // 
  var ris = true;
  
  if(r1.xy > r2.x1 || r2.x1 > r1.xy) ris = false;
  
  if(r1.y1 < r2.y2 || r2.y1 < r1.y2) ris = false;
  
  say(r1,r2,ris);
}

function interseca_tris(a,b){
  // ragionare in termini di segmenti
  var ris = true;
  if( (b.x1 > a.x1 && b.x1 < a.x2) && (b.y1 < a.y1 && b.y1 > b.y2) 
      ||
      (a.x2 > b.x2 && a.x2 < b.x1) && (a.y2 > b.y2 && a.y2 < b.y1)
      // manca la continenza
    )
    return false
  say(a,b,ris);
}

function interseca2(r1,r2){  // non funzia
  var ris = !(r2.x1 > r1.x2 ||
              r2.x2 < r1.x1 ||
              r2.y1 > r1.y2 ||
              r2.y2 < r1.y1);
  
  say(r1,r2,ris);
}

// ((X,Y),(A,B)) and ((X1,Y1),(A1,B1))
function interseca3(r1,r2){
  /*
  if(A<X1 or A1<X or B<Y1 or B1<Y):
    Intersection = Empty
  else:
    Intersection = Not Empty
  */
  var ris;
  if(r1.x2 < r2.x2 || r2.x2 < r1.x1 || r1.y2 < r2.y1 || r2.y2 < r1.x2)
    ris = false;
  else
    ris = true;
  
  say(r1,r2,ris);
}

function say(r1,r2,ris){
  var msg = "I rettangoli " + r1.nome + " e " + r2.nome;
  msg += ris ? " si intersecano" : " non si intersecano";
  console.log(msg);
}

function setup(){
  var r1 = new Rettangolo(0,6,4,3,'r1');
  var r2 = new Rettangolo(2,4,6,1,'r2');
  var r3 = new Rettangolo(5,3,10,2,'r3');
  var r4 = new Rettangolo(9,5,11,0,'r4');
  rettangoli.push(r1);
  rettangoli.push(r2);
  rettangoli.push(r3);
  rettangoli.push(r4);
}

function go(){
  setup();
  
  for(var i=0; i<rettangoli.length-1; i++){
    for(var k=i+1; k<rettangoli.length; k++){
      interseca_tris(rettangoli[i],rettangoli[k]);
    }
  }
}
///////////////
go();
//////////////