let v=[];
let lista = document.getElementById("lista");
let text = document.getElementById("text");

text.addEventListener("keydown", function(e) {
    if(e.keyCode === 13)
      inserisci();
});

function stampa(){
  lista.innerHTML = v;
}

function ordina(){
  v.sort(function(a,b){return a>b;});
  stampa();
}

function poppa(){
  v.pop();
  stampa();
}

// non serve se si setta l'input type a number
function inserisci(){
  let el = parseInt(text.value);
  console.log(typeof el);
  if(typeof el === "number" && !isNaN(el)){
    v.push(el);
    stampa();
  }
  else
    alert("Voglio solo numeri!");
}

stampa();