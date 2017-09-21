01  -- tutti i beni che costano più di 10000 euro
select description, value
from possession
where value>10000

02  -- contare i sopra 10000 (count(*) conta le righe; lavora sull'intero gruppo)
select count(*)
from possession
where value>10000

03  -- aggiungo la media del sottogruppo
select
	count(*) as beniDiLusso,
  round(avg(value),2) as prezzoMedio
from possession
where value>10000

04
select
	year(bought) as anno,  -- funzione di campo, lavora su un solo valore
  count(*) as nBeni,
  sum(value) as spesa,  --
  max(value) as piuCostoso
from possession
group by anno -- diviso in sottoinsiemi

05
select name, gender, description, value
from person as p, possession as ps
where p.id=ps.idp

06  -- nome e sesso della pesona, descrizione e valore del bene
select
	name, gender, description, value
from
	person as pe, possession as po
where
	pe.id=po.idp and -- condizione di join
  gender='F'; -- condizione di dominio

07  -- nome pesona, totale suoi averi
select
	name, sum(value) as totAveri
from
	person as pe, possession as po
where
	pe.id=po.idp
group by
	pe.id, name -- per evitare errori omonimie
having -- agisce sui gruppi
	totAveri > 50000

08  -- nome, cognome, job e durata
select
	concat(pe.name,' ',pe.surname) as person,
  oc.name as job,
  datediff(ending,beginning) as timespan
from
	occupation as oc
  inner join
  person as pe
  on pe.id=oc.idperson -- insieme risultato preso nella sua interezza

09
select
	concat(pe.name,' ',pe.surname) as person,
  oc.name as job,
  round(datediff(ending,beginning)/365) as timespanYears
from
	occupation as oc
  inner join
  person as pe
  on pe.id=oc.idperson
where
	round(datediff(ending,beginning)/365)>5
    -- altrim mySql si lamenta;
    -- con having avrebbe funzionato ma sarebbe stato sporco

10  -- stipendio medio persona
select
	name, avg(wage) as avgWage
from
	occupation
group by
	name
having
	avgWage > 3000

11
select
	name, avg(wage) as avgWage, round(avg(datediff(ending,beginning))) as timespan
from
	occupation
group by
	name
having
	avgWage > 3000 and
  timespan > (10*365)

12
select
	name, avg(wage) as avgWage,
  round(avg(datediff(ending,beginning))) as timespanDays,
  round(avg(datediff(ending,beginning))/365) as timespanYears
from
	occupation
group by
	name
having
	avgWage > 3000 and
  timespanDays > (10*365) and
  timespanYears > 10

13  -- stampare esperienze occupative che hanno reso più della media per quel lavoro
-- FUNCTION
delimiter //
create function mediaProfessione(professione varchar(100)) returns int
begin
	declare ris int;
    set ris = (select round(avg(wage)) from occupation where professione=name);
    return ris;
end
//
-- query
select *
from occupation
where wage > mediaProfessione(name);

14
-- FUNCTION
delimiter //
create function nFigli(idp int) returns int
begin
	declare ris int;
  set ris = (select count(*) from person where idp=fatherid or idp=motherid);
  return ris;
end
//
-- query
select person.name, person.surname, nFigli(person.id)
from person
-- versione JOIN IMPLICITO
select
	parent.name, parent.surname,
  count(*) as nFigli
from
	person as parent, person as child
where
  parent.id=child.fatherid or
  parent.id=child.motherid
group by
	parent.id;
-- versione INNER JOIN
select
	parent.name, parent.surname,
  count(*) as nFigli
from
	person as parent
  inner join
  person as child
  on
  parent.id=child.fatherid or
  parent.id=child.motherid
group by
	parent.id;

15
select
	p.name, p.surname,
  o.name as professione
from
	person as p, occupation as o
where
	p.id=o.idperson and
	nFigli(p.id) > 0 and
  o.name='Panettiere';
-- JOIN ESPLICITO
select
	p.name, p.surname,
  o.name as professione
from
	person as p
  inner join
  occupation as o
  on
  p.id=o.idperson
where
	nFigli(p.id) > 0 and
  o.name='Panettiere';

16
select
	id, name,
  surname,
  nFigli(person.id) as figli,
  possedimenti(person.id) as possedimenti,
  occupazione(person.id) as occupato
from
	person
where
	nFigli(person.id) > 0
  and
  possedimenti(person.id) < 30000
  and
  occupato(person.id) = 'NO';

17
delimiter //
create function ultimaDataLavoro(idp int) returns date
begin
	declare ris date;
    set ris = (select max(ending) from occupation where idp=idperson);
    return ris;
end
//

delimiter //
create function possedimenti(idpers int) returns int
begin
	declare ris int;
    set ris = (select sum(value) from possession where idpers=idp);
    return ris;
end
//

delimiter //
create function occupato(idp int) returns varchar(2)
begin
	declare ris varchar(2);
    declare d date;
    set d = ultimaDataLavoro(idp);
    set ris = if(d < now() or d is null, 'NO', 'SI');
    return ris;
end
//

-- query richiesta
select
	id, name,
  surname,
  nFigli(person.id) as figli,
  possedimenti(person.id) as possedimenti,
  occupazione(person.id) as occupato
from
	person
where
	nFigli(person.id) > 0
  and
  possedimenti(person.id) < 30000
  and
  occupazione(person.id) = 'NO';

-- query step-by-step KO
select
	gender,
  count(*) as occupati
from
	person
where
	occupato(id)='SI'
group by
	gender

----------------------------
-- 10 QUERY PER SBALLARSI --
----------------------------
01
select *
from occupation
where datediff(occupation.ending, occupation.beginning)
      > durataMediaOccupazione();

delimiter //
create function durataMediaOccupazione() returns int
begin
	declare ris int;
	set ris = (select avg(datediff(if(ending is null, now(), ending),beginning)) from occupation);
  return ris;
end
//



02
-- stampare la percentuale di matrimoni finiti (anche senza function)
select count(*) / nMatrimoniFiniti()
from relation;

delimiter //
create function nMatrimoniFiniti() returns int
begin
	declare ris int;
  set ris = (select count(*) from relation where ending is null);
	return ris;
end
//

03
-- inserire altre relazioni
-- raggruppando per relazioni, contare le relazioni in corso (sol=3)

select
	type, count(*) as relazioniInCorso
from
	relation
where
	ending is null
group by
	type

04
select * from person
where massimoReddito(person.id) > 1500
      and
      nFigli(person.id) > 2
      and
      occupato(person.id)='NO'
      and
      sposato(person.id)='SI'
-- PRO: aggiungere anche la moglie
-- query da borsa di studio
