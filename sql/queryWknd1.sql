-- query a casuccia; l'unica suocera è Jessica Henger
-- Aggiungere nel db qualche bene costoso e stipendio mensile
01  elenco delle persone con relativo patrimonio (somma di quello che hanno)
02  patrimonio medio di una donna di Milano
03  patrimonio medio per un uomo diviso per città
04  nome del marito, nome della moglie, somma dei loro patrimoni
05  nome e cognome di tutte le persone il cui padre sia di Milano (solo il padre!)
06  nome e cognome di tutte le persone il cui padre o la cui madre guadagnano più di 3.000 euro al mese
07  nome e cognome di tutti gli uomini che sono padri, senza ripetizioni
08  nome e cognome di tutte le donne con almeno 3 figli (having)
09  numero dei single divisi per città
10  (lunedì mattina) stampare nomi donne single la cui madre, il cui padre o loro stesse (or)
    abbiano un patrimonio immobiliare di almeno 100.000

01
select
    concat(p.name,' ',p.surname) as Persona,
    sum(ps.value) as Averi
from person as p, possession as ps
where p.id = ps.idp
group by Persona;

select
    concat(p.name,' ',p.surname) as Persona,
    sum(ps.value) as Averi
from person as p left join possession as ps on p.id=ps.idp
group by Persona
order by Averi desc, Persona asc;

02  patrimonio medio di una donna di Milano
select
    concat(p.name,' ',p.surname) as Persona,
    avg(ps.value) as patrimonioMedio
from person as p, possession as ps
where
    gender='F' and
    residence='Milano' and
    p.id=ps.idp
group by Persona;

03
select
    p.residence as Citta,
    avg(ps.value) as patrimonioMedio
from person as p, possession as ps
where
    gender='M' and
    residence='Milano' and
    p.id=ps.idp
group by Citta;

04
select
    concat(p.name,' ',p.surname) as Persona,
    concat(c.name,' ',c.surname) as Coniuge,
    sum(ps.value) as patrimonioCongiunto
from person as p, person as c, possession as ps
where p.mateid=c.mateid and p.id=ps.idp
group by Persona;

05
select
		concat(p.name,' ',p.surname) as Persona
from person as p, person as father
where p.fatherid=father.id and father.residence='Milano'

06
select
		concat(p.name,' ',p.surname) as Persona,
from person as p, person as father, person as mother, occupation as o
where
		p.fatherid=father.id and
    p.motherid=mother.id and
    (o.idperson=father.id or o.idperson=mother.id)>3000;

07
select distinct
    concat(father.name,' ',father.surname) as Padre
from person as p, person as father
where p.fatherid=father.id

08
select
    concat(mother.name,' ',mother.surname) as Madre
from person as p, person as mother
where
    p.motherid=mother.id
group by Madre
having count(*)>3

09
select residence, count(*)
from person p
where mateid is null
group by residence;

10
