SELECT p.id, p.name, count(p.id) as 임대가능일
from places p
         inner join schedules s on (p.id = s.place_id)
group by p.id
order by p.id
