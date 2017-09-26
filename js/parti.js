// stampa schermo numeri primi fino a 100
function parti(a)
{
  for(let i=3; i<a; i+=2)
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
}