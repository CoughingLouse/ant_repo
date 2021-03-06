-- data persone2 stampare i nomi di tutte le persone con il nome del padre di fianco
select p1.nome as Figlio, p2.nome as Padre
from persone2 as p1, persone2 as p2
where p1.idpadre=p2.id;

-- rintracciare padre, madre e nonno paterno
select p1.nome as Persona, p2.nome as Padre, p3.nome as Madre, p4.nome as NonnoPaterno
from persone2 as p1, persone2 as p2, persone2 as p3, persone2 as p4
where p1.idpadre=p2.id and
			p1.idmadre=p3.id and
			p2.idpadre=p4.id;

-- dallo schermo
select person.name,
        person.surname,
        person.residence,
        possession.description,
        possession.value
from person, possession
where person.id = possession.idp and

-- dallo schermo 2
select person.id,
        person.name,
        person.surname,
        sum(possession.value) as valoreBeni
from person, possession
where person.id=possession.idp
group by person.id, person.name, person.surname

-- dallo schermo 3
select person.id,
        person.name,
        person.surname,
        sum(possession.value) as valoreBeni
from person, possession
where person.id=possession.idp
group by person.id, person.name, person.surname
having sum(possession.value)>100000

-- INNER JOIN vs LEFT JOIN
-- nb: l'inner join mostra solo entità collegate fra di loro
select
    concat(son.name,' ',son.surname) as Son,
    concat(father.name,' ',father.surname) as Father,
    concat(mother.name,' ',mother.surname) as Mother
from
    person as son
          left join -- anche i figli senza padre
    person as father
          on
    son.father.id=father.id
          left join -- anche i figli senza madre
    person as mother
          on
    son.motherid=mother.id

-- dopo aver aggiunto mateid, trovare la suocera (la madre della sposa)
select
    concat(sposo1.name,' ',sposo1.surname) as Sposo1,
    concat(sposo2.name,' ',sposo2.surname) as Sposo2,
    concat(suocera.name,' ',suocera.surname) as Suocera
from person as sposo1
    inner join person as sposo2 on -- avendo un botto di dati nulli
    sposo1.mateid=sposo2.id
    inner join person as suocera on
    sposo2.motherid=suocera.id
