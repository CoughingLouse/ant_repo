let in_ = document.getElementById("in");
let res = document.getElementById("res");
let btn = document.getElementById("btn");
let avg = document.getElementById("avg");
let v = [];

avg.disabled = true;

function insert(){
  
  if(v.length <= 5){
    let n = parseInt(in_.value);
    v.push(n);
    res.innerHTML = "";
  }
  else {
    avg.disabled = false;
  }
}

function avg(){
  let rtn = 0;
  for(let i=0; i<v.length; i++){
    rtn += v[i];
  }
  res.innerHTML = rtn / v.length;
}