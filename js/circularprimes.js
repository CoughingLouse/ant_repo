const MAX = 1000;

function isPrime(n){
  let primo = true;
  for(let k=3; k<(n/2); k+=2)
  {
    if(n%k === 0)
    {
      primo = false;
      break;
    }
  }
  return primo;
}

function inverter(n){
  let s = n.toString();
  let rtn;
  for(let i=s.length; i>=0; i--){
    rtn += s[i];
  }
  return rtn.replace('NaN','');
}

// var ultima = n.pop();
// n.unshift(ultima);

function cicle(){
  for(let i=3; i<MAX; i+=2)
  {
    if(isPrime(i) && isPrime(inverter(i))){
      console.log(i + " - " + inverter(i));
    }
  }
}

console.log(":: PRIMI CIRCOLARI ENTRO " + MAX + " ::");
cicle();

