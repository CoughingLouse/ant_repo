01  numero totale patrimonio diviso per sesso
select
  p.gender as Sesso,
  sum(ps.value) as patrimonioTotale
from person as p, possession as ps
where p.id=ps.idp
group by p.gender;

02  generalità e numero dei figli di ogni genitore
select
	concat(father.name,' ',father.surname) as Padre,
    count(*) as Figli
from
	person as son
    inner join
    person as father
    on
    son.fatherid=father.id
group by father.id;

03  stampare nome tutti i padri che hanno avuto un figlio dopo i 35 anni
select
	father.name, father.surname
from
	person as child
    inner join
	person as father
	on
	child.fatherid=father.id
where
	year(child.birth)-year(father.birth) >= 35;

04  numero di figli di ogni persona
select
	parent.name,
	(
		select count(*)
        from person
        where motherid=parent.id or fatherid=parent.id
    ) as nfigli
from person as parent;

05  numero di figli di ogni persona e somma età figli
select
	concat(parent.name,' ',parent.surname) as Genitore,
	(
		select count(*)
        from person
        where motherid=parent.id or fatherid=parent.id
    ) as nfigli,
    (
		select sum(year(now())-year(birth))
        from person
        where motherid=parent.id or fatherid=parent.id
    ) as sommaEta
from person as parent;

06  nome cognome quante persone può portare in giro -> totale posti sue auto
select
	concat(person.name,' ',person.surname) Proprietario,
    sum(cars.seats) as totPosti
from
	person inner join ride
    on
    person.id=ride.personid
    inner join cars
    on
    ride.carid=cars.id
group by person.id;

07
select
	person.name, person.surname
from
	partecipate inner join person
    on partecipate.personid = person.id
    inner join course
    on partecipate.courseid = course.id
where
	course.name like '%java%';

08 TRIGGER
-- drop trigger investigation.course_after_delete;
create definer = current_user
trigger investigation.course_after_delete after delete
on course for each row
-- begin | begin/end servono solo in caso di istruzioni multiple!
	insert into log (event, date)
    values
    (
		concat('è stato cancellato il corso di ', old.name, ' con id ', old.id),
        now()
	)
-- end

09
-- drop trigger investigation.cars_after_delete;
create definer = current_user
trigger investigation.cars_after_delete after delete
on cars for each row
update cars set cars.price = cars.price + 1000
where id > 0;

10  stampare età media ogni corso
select
	course.name,
	avg(year(now())-year(person.birth))
from
	course inner join partecipate
    on course.id = partecipate.courseid
    inner join person
    on person.id = partecipate.personid
group by courseid;

11  stampare corso e numero di persone sopra i 30
select
	course.name,
  count(*) as sopra30
from
	course inner join partecipate
  on course.id = partecipate.courseid
  inner join person
  on person.id = partecipate.personid
where
	(year(now())-year(person.birth)) > 30
group by courseid;

12  stampare SOLO nome dei corsi che hanno almeno 4 corsisti
select
	course.name
from
	course inner join partecipate
  on course.id = partecipate.courseid
  inner join person
  on person.id = partecipate.personid
group by courseid
having count(*) > 4;
