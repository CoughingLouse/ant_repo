let in_ = document.getElementById("in");
let p1 = document.getElementById("p1");
let p2 = document.getElementById("p2");

function somma(n){
  let rtn;
  for(rtn=0;n>0;n--){
    rtn += n;
  }
  return rtn;
}

function fatt(n){
  if(n === 0 || n === 1)
    return 1;
  else
    return n*fatt(n-1);
}

function calc(){
  let n = parseInt(in_.value);
  p1.innerHTML = somma(n);
  p2.innerHTML = fatt(n);
}

function calcola(){
  let s = 0;
  let f = 1;
  for(let i=1; i<=n; i++){
    s += i;
    f *= i;
  }
  p1.innerHTML = s;
  p2.innerHTML = f;
}