select p.driver, p.number
from people as pp
join license as p on pp.license_id = p.id;

select pp.name, pp.age, p.driver, p.number
from people as pp
left join license as p on pp.license_id = p.id;

select pp.name, p.driver, p.number
from people as pp
join license as p on pp.license_id = p.id
where pp.age > 20;