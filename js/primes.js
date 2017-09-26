// stampa schermo numeri primi fino a 100
for(let i=3; i<100; i+=2)
{
  let primo = true;
  for(let k=3; k < (i/2); k+=2)
  {
    if(i%k==0)
    {
      primo = false;
      break;
    }
  }
  
  if(primo)
  document.writeln(i + '<br>');

}