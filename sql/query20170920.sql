
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

-- 
