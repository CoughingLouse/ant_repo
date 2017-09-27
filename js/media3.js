let in_ = document.getElementById("in");
let res = document.getElementById("res");
let btn = document.getElementById("btn");
let v = [];

function avg(){
  let s = in_.value.trim();
  v = s.split(" ");
  let sum = 0;

  for(let i=0; i<v.length; i++){
    sum += parseInt(v[i]);
  }
  console.log(v);
  console.log("sum="+sum);
  
  res.innerHTML = sum / v.length;
}

