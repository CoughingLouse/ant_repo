let in_ = document.getElementById("in");
let res = document.getElementById("res");
let btn = document.getElementById("btn");
let v = [];

function check(){
  let s = in_.value.trim(); 
  v = s.split(" ");
  console.log(v);
  if(v.length !== 5){
    alert(v.length + " numeri non sono 5. Riprova.");
  }
  else{
    media(v);
  }
}

function media(v){
  let rtn = 0;
  for(let i=0; i<v.length; i++){
    rtn += parseInt(v[i]);
  }
  res.innerHTML = rtn / 5;
}

function check2(){
  let s = in_.value.trim(); 
  v = s.split(" ");
  //console.log(v);
  if(v.length !== 5){
    btn.disabled = true;
  }
  else{
    btn.disabled = false;
    media(v);
  }
}
  if(v.length !== 5){
    alert(v.length + " numeri non sono 5. Riprova.");
  }
  else{
    media(v);
  }
}