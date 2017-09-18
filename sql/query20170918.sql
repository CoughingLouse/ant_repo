1- Numero dei maschi divisi per citta
2- Numero dei single divisi per sesso
3- Il numero totale del patrimonio diviso per sesso
4- Stampare età media delle donne
5- Stampare le tasse che ognuno deve pagare sul proprio patrimonio
	calcolata sul 22% di esso, stampare soltanto chi paga più di 1000 euro
6- La media delle tasse pagate di tutti i cittadini
7- Quante relazioni amorose ci sono SENZA CONTARE 2 VOLTE LA STESSA RELAZIONE
8- Stampare il nome di tutte le persone che possiedono dei lego, per trovarla
   guardare se nella description compare la parola lego

01
select residence as citta, count(*) as num
from person
where gender='M'
group by residence;

02
select gender as sesso, count(*) as num
from person
where mateid is null
group by gender

03
select
	gender as Sesso,
	sum(patrimonio) as totalePatrimoni
from
	person as p
    inner join
    patrimoni as pa
    on
    pa.id=p.id
group by
	gender

04
select
	avg(age)/365 as etaMediaDonne
from
	(select datediff(now(), person.birth) as age from person where gender='F') as agess

05
select
	concat(pa.name,' ',pa.surname),
  round((pa.patrimonio*0.22),2) as tasse
from
	person as p
    inner join
    patrimoni2 as pa
    on
    p.id=pa.id
group by pa.id
having tasse>1000

06
select round(avg(iva),2) as mediaTasse
from
	(select id, patrimonio*0.22 as iva
	from patrimoni2) as tasse

07
select
	concat(c1.name,' ',c1.surname) as Amante1,
  concat(c2.name,' ',c2.surname) as Amante2
from
	person as c1,
  person as c2
where
	c1.mateid=c2.id and
  c2.mateid=c1.id and
  c1.id > c2.id

08
select
	concat(p.name,' ',p.surname) as possessoriLego
from
	person as p,
    possession as ps
where
	p.id=ps.idp and
  description like '%lego%'

--------------------------------------------------------
09  numero persone in ant questo anno
select
	count(*) as numeroPersone
from
	presence
where
	year(now()) between
	year(beginning) and
    year(ending) and
    description='ant';

10  nome e cognome tutte persone che 2017-02-15 erano da qualche parte
select
	concat(p.name,' ',p.surname) as Persona,
    ending
from
	person as p
    inner join
    presence as pre
    on
    p.id=pre.idp
where
	'2017-02-15' between
  beginning and ending;

11  lista tutte destinazioni raggiunte con somma totale giorni in cui persone ci sono state
select
	description as Meta,
    sum(datediff(ending,beginning)) as giorniTotali
from presence
group by description;

12  come prima ma solo se >1000 giorni
select
	description as meta,
    sum(datediff(ending,beginning)) as giorni
from presence
group by description
having giorni>1000;

13
select
	p2.name, p2.surname,
	min(sqrt(
				((p1.x-46.77894)*(p1.x-46.77894))
				+
				((p1.y-8.10012)*(p1.y-8.10012))
			)) as distance
from
	presence as p1
    inner join
    person as p2
    on
    p1.idp=p2.id
group by p1.id
order by distance;

14
select
	cars.model,
    case when ride.personid is null then 0
    else count(*) end
from
		person
    right join
		ride on person.id = ride.personid
	right join
		cars on ride.carid = cars.id
group by
	cars.model;
  
