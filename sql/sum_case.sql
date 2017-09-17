-- magari mi darà un hint...
-- https://stackoverflow.com/questions/38483579/how-to-search-husband-and-wife-data-with-one-mysql-query

select ud.user_id
from UserDetails ud
group by ud.user_id
having sum(case when ud.gender = 'M' and ud.age between 50 and 60) = 1 and
       sum(case when ud.gender = 'F' and ud.age between 40 and 50 and
       ud.income between 30000 and 40000) = 1;
