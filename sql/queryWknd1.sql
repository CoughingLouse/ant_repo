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

01  OK
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

02  KO
select
    concat(p.name,' ',p.surname) as Persona,
    avg(ps.value) as patrimonioMedio
from person as p, possession as ps
where
    gender='F' and
    residence='Milano' and
    p.id=ps.idp
group by Persona;

02  OK
select
		(sum(possession.value)/count(distinct person.id)) as patrimonioMedio
from
		person
    inner join
    possession
    on
    person.id=possession.idp
where
		gender='F' and
    residence='Rezzano';

03  OK
select
    p.residence as Citta,
    (sum(ps.value)/count(distinct p.id)) as patrimonioMedio
from person as p, possession as ps
where
    gender='M' and
    p.id=ps.idp
group by Citta;

04
select
		concat(sposo1.name,' ',sposo1.surname) as Sposo1,
    concat(sposo2.name,' ',sposo2.surname) as Sposo2,
    sum(sommabeni1.value) as Totale
from
		person as sposo1
    inner join
    person as sposo2 on sposo1.mateid=sposo2.id
    inner join
    possession as sommabeni1 on
  		sposo1.id=sommabeni1.idp
      or
      sposo2.id=sommabeni1.idp
group by sposo1.id;

05
select
		concat(p.name,' ',p.surname) as Persona
from person as p, person as father
where p.fatherid=father.id and father.residence='Milano'

06
select
		concat(son.name,' ',son.surname) as Persona
from
		person as son
        left join
        person as father
			on
			son.fatherid=father.id
		left join
        person as mother
			on
            son.motherid=mother.id
		inner join
        occupation
			on
            occupation.idperson=father.id
            or
            occupation.idperson=mother.id
where
		occupation.wage>3000

07  (distinct oppure group by father.id)
select
    concat(father.name,' ',father.surname) as Padre
from
    person as son
    inner join
    person as father
    on
    son.fatherid=father.id
group by
    father.id

08
select
    concat(mother.name,' ',mother.surname) as Madre,
    count(*) as numeroFigli
from
	person as children
    inner join
    person as mother
    on
    children.motherid=mother.id
group by
	mother.id
having
	numeroFigli>3

09
select residence, count(*)
from person p
where mateid is null
group by residence;

10
select
	concat(name,' ',surname) as Persona
from
	person
where mateid is null
	and
    (
		id in
		(select id from patrimoni where patrimonio > 100000)
        or fatherid in
        (select id from patrimoni where patrimonio > 100000)
        or motherid in
        (select id from patrimoni where patrimonio > 100000)
	)
  
