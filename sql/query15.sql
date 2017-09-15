01
select *
from persona;

02
select nome, cognome
from persona;

03
select nome, cognome, genere
from persona
where citta='Milano';

04
select nome, cognome, citta
from persona
where citta in (capoluoghiDiProvinciaLombardi);

05
select nome, cognome, statura
from persona
where genere='M' and
      redditoAnnuo>30000;

06
select nome, cognome, genere
from persona
where (genere='M' and statura>180) or
      (genere='F' and statura<170);

07
select nome, cognome
from persona
where genere='F' and
      citta in ('Milano','Monza') and
      (statura between 155 and 170) and
      redditoAnnuo between 20000 and 30000
order by nome;

08
select nome, cognome
from persona
where titoloStudio in ('laurea') and
      redditoAnnuo>30000;

09
select citta, count(*) as laureati
from persona
where titoloStudio='laurea'
group by citta;

10
select citta, count(*) as laureati
from persona
where titoloStudio='laurea'
group by citta
having count(*)>2;

11
select citta, count(*) as laureati
from persona
where titoloStudio='laurea' and
      genere='F'
group by citta
having count(*)>2;

12
select citta, max(statura), min(statura), avg(statura)
from persona
group by citta;

13
select citta, avg(peso/statura), genere
from persona
group by citta, genere

14
select citta, avg(peso/statura)
from persona
group by citta
having avg(peso/statura)>0.7

15
select avg(redditoAnnuo) as media, max(redditoAnnuo) as max,
        min(redditoAnnuo) as min, count(*) as num
from persona
where redditoAnnuo between 10000 and 100000 and
      titoloStudio <> 'nessuno'
group by titoloStudio
order by avg(redditoAnnuo)
