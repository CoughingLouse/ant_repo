
01	stampare tutti uomini fra 35 e 45
select
	concat(p.name,' ',p.surname) as Persona,
    (year(now())-year(p.birth)) as age
from
	person as p
where
	year(now())-year(p.birth) between 35 and 45

-- FUNCTION 1
delimiter //
create function calcolaprezzo(cc int, seats int, doors int) returns int
begin
	declare ris int;
	set ris = cc * seats * doors;
  return ris;
end
//

-- query esempio 1
select
	*, calcolaprezzo(cc, seats, doors) as prezzo
from
	cars

-- FUNCTION 2
delimiter //
create function reddito(idp int) returns int
begin
	declare ris int;
    set ris = (select sum(wage) from occupation where idperson=idp);
    return ris*12;
end
//
-- query esempio 2
select
	concat(p.name,' ',p.surname) as Lavoratore,
    reddito(p.id) as Reddito
from
	person as p

-- FUNCTION 3
delimiter //
create function nmarriage(idp int) returns int
begin
	declare ris int;
  set ris = (select count(*) from relation where type='marriage' and (idp=idp1 or idp=idp2));
  return ris;
end
//
-- query esempio 3
select
	concat(name,' ',surname) as Persona,
  nmarriage(id) as nMatrimoni
from
	person

-- FUNCTION 4
delimiter //
create function nauto(idp int) returns int
begin
	declare ris int;
  set ris = (select count(*) from ride where idp=personid);
  return ris;
end
//
-- query esempio 4
select
	concat(name,' ',surname) as Pilota,
  nauto(id) as nAuto
from
	person

-- FUNCTION 5
-- stampare media stipendio di una persona tenendo conto anche della durata di ogni impiego
-- utilizzare la formula k1 * d1 / d + k2 * d2 / d
-- k1=stipendio, d1=durata in gg di un lavoro, d=durata giorni tutti i lavori
-- d1 e d espressi in mesi (media mensile)
delimiter //
create function avgwage(idp int) returns double
begin
	declare ris double;
    set ris = (
						select
							sum(wage * (datediff(ending,beginning))) /
							sum(datediff(ending,beginning))
            from occupation
            where idp=idperson
					);
    return round(ris,2);
end
//
-- query esempio 5
select
	concat(name,' ',surname) as Stipendiato,
  avgwage(id) as medioMensile
from
	person

-- PROCEDURE 5
delimiter //
create procedure avgwage(idp int)
begin
	select
		round(
			sum(wage * datediff(ending,beginning)) /
			sum(datediff(ending,beginning))
      ,2) as mediaStipendi
	from occupation
	where idp=idperson;
end
//
-- query esempio 5 (con procedure)
call avgwage(1)

-- SECONDA META
01	-- function che restituisce quante cars possiede ognuno
delimiter //
create function owners(idc int) returns int
begin
	declare ris int;
  set ris = (select count(*) from ride where  idc=carid);
  return ris;
end
//
--
select distinct
	carid,
  owners(carid) as nPossessori
from
	ride

02	KO -- dato l'id di una persona dire quanti giorni è stato sposato in totale
delimiter //
create function daysmarried(idp int) returns int
begin
	declare ris int;
    set ris = (select sum(
										datediff(
										if(ending is null, now(), ending), beginning)
									)
					from relation
                    where type='married' and (idp=idp1 or idp=idp2));
    return ris;
end
//
--
select
	concat(name,' ',surname) as Persona,
	daysmarried(id) as giorniSposati
from person

03 KO
-- fare una procedure che dato un id di persona stampi una tabella che ha due colonne:
-- una avrà il nome e l'altra il periodo in giorni del lavoro più longevo di quella persona
delimiter //
create procedure longerjob(idp int)
begin
	select
		occupation.name as job,
        datediff(ending,beginning) as days
	from occupation
    where
		occupation.idperson=idp and
        datediff(ending,beginning) = (select max(datediff(ending,beginning)) where idp=idperson);
end
//
--
select
	concat(name,' ',surname) as Persona,
	daysmarried(id) as giorniSposati
from person

-- query per fiki
-- overlappingmarriage
delimiter //
create procedure poligamy(idpersona int)
begin
	select
		*
	from
		relation as rel, relation as old
	where
		rel.type='marriage' and old.type='marriage'
		and
		(rel.idp1=id or rel.idp2=idpersona)
		and
		(old.idp1=idpersona or old.idp2=idpersona)
		and
		rel.id <> old.id
		and
		(
		(
		rel.beginning between old.beginning and
		if(old.ending is null, now(), old.ending)
		or
		if(rel.ending is null, now(), rel.ending)
		between old.beginning and
		if(old.ending is null, now(), old.ending)
		)
		or
		(
		old.beginning between rel.beginning and
		if(rel.ending is null, now(), rel.ending)
		or
		if(old.ending is null, now(), old.ending)
		between rel.beginning and
		if(rel.ending is null, now(), rel.ending)
		)
		);
end
//
--
