(select *
 from(
         select '01' as MONTH, p.name as NAME, count(p.id) as COUNT
         from place_reviews r join places p on (r.place_id = p.id)
         where year(r.created_at) = 2018
           and month(r.created_at) = 1
         group by p.id
         order by p.name
     ) sub
 where count = (select count(r.id) as count
 from place_reviews r
 where year(r.created_at) = 2018 and month(r.created_at) = 1
 group by r.place_id
 order by count desc
     limit 1)
)
union
(select *
from(
    select '02' as MONTH, p.name as NAME, count(p.id) as COUNT
    from place_reviews r join places p on (r.place_id = p.id)
    where year(r.created_at) = 2018
        and month(r.created_at) = 2
    group by p.id
    order by p.name
    ) sub
where count = (select count(r.id) as count
                from place_reviews r
                where year(r.created_at) = 2018 and month(r.created_at) = 2
                group by r.place_id
                order by count desc
                limit 1)
)
union
(select *
from(
    select '03' as MONTH, p.name as NAME, count(p.id) as COUNT
    from place_reviews r join places p on (r.place_id = p.id)
    where year(r.created_at) = 2018
        and month(r.created_at) = 3
    group by p.id
    order by p.name
    ) sub
where count = (select count(r.id) as count
                from place_reviews r
                where year(r.created_at) = 2018 and month(r.created_at) = 3
                group by r.place_id
                order by count desc
                limit 1)
)
union
(select *
from(
    select '04' as MONTH, p.name as NAME, count(p.id) as COUNT
    from place_reviews r join places p on (r.place_id = p.id)
    where year(r.created_at) = 2018
        and month(r.created_at) = 4
    group by p.id
    order by p.name
    ) sub
where count = (select count(r.id) as count
                from place_reviews r
                where year(r.created_at) = 2018 and month(r.created_at) = 4
                group by r.place_id
                order by count desc
                limit 1)
)
union
(select *
from(
    select '05' as MONTH, p.name as NAME, count(p.id) as COUNT
    from place_reviews r join places p on (r.place_id = p.id)
    where year(r.created_at) = 2018
        and month(r.created_at) = 5
    group by p.id
    order by p.name
    ) sub
where count = (select count(r.id) as count
                from place_reviews r
                where year(r.created_at) = 2018 and month(r.created_at) = 5
                group by r.place_id
                order by count desc
                limit 1)
)
union
(select *
from(
    select '06' as MONTH, p.name as NAME, count(p.id) as COUNT
    from place_reviews r join places p on (r.place_id = p.id)
    where year(r.created_at) = 2018
        and month(r.created_at) = 6
    group by p.id
    order by p.name
    ) sub
where count = (select count(r.id) as count
                from place_reviews r
                where year(r.created_at) = 2018 and month(r.created_at) = 6
                group by r.place_id
                order by count desc
                limit 1)
)
union
(select *
from(
    select '07' as MONTH, p.name as NAME, count(p.id) as COUNT
    from place_reviews r join places p on (r.place_id = p.id)
    where year(r.created_at) = 2018
        and month(r.created_at) = 7
    group by p.id
    order by p.name
    ) sub
where count = (select count(r.id) as count
                from place_reviews r
                where year(r.created_at) = 2018 and month(r.created_at) = 7
                group by r.place_id
                order by count desc
                limit 1)
)
union
(select *
from(
    select '08' as MONTH, p.name as NAME, count(p.id) as COUNT
    from place_reviews r join places p on (r.place_id = p.id)
    where year(r.created_at) = 2018
        and month(r.created_at) = 8
    group by p.id
    order by p.name
    ) sub
where count = (select count(r.id) as count
                from place_reviews r
                where year(r.created_at) = 2018 and month(r.created_at) = 8
                group by r.place_id
                order by count desc
                limit 1)
)
union
(select *
from(
    select '09' as MONTH, p.name as NAME, count(p.id) as COUNT
    from place_reviews r join places p on (r.place_id = p.id)
    where year(r.created_at) = 2018
        and month(r.created_at) = 9
    group by p.id
    order by p.name
    ) sub
where count = (select count(r.id) as count
                from place_reviews r
                where year(r.created_at) = 2018 and month(r.created_at) = 9
                group by r.place_id
                order by count desc
                limit 1)
)
union
(select *
from(
    select '10' as MONTH, p.name as NAME, count(p.id) as COUNT
    from place_reviews r join places p on (r.place_id = p.id)
    where year(r.created_at) = 2018
        and month(r.created_at) = 10
    group by p.id
    order by p.name
    ) sub
where count = (select count(r.id) as count
                from place_reviews r
                where year(r.created_at) = 2018 and month(r.created_at) = 10
                group by r.place_id
                order by count desc
                limit 1)
)
union
(select *
from(
    select '11' as MONTH, p.name as NAME, count(p.id) as COUNT
    from place_reviews r join places p on (r.place_id = p.id)
    where year(r.created_at) = 2018
        and month(r.created_at) = 11
    group by p.id
    order by p.name
    ) sub
where count = (select count(r.id) as count
                from place_reviews r
                where year(r.created_at) = 2018 and month(r.created_at) = 11
                group by r.place_id
                order by count desc
                limit 1)
)
union
(select *
from(
    select '12' as MONTH, p.name as NAME, count(p.id) as COUNT
    from place_reviews r join places p on (r.place_id = p.id)
    where year(r.created_at) = 2018
        and month(r.created_at) = 12
    group by p.id
    order by p.name
    ) sub
where count = (select count(r.id) as count
                from place_reviews r
                where year(r.created_at) = 2018 and month(r.created_at) = 12
                group by r.place_id
                order by count desc
                limit 1)
)
