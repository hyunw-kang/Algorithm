select DISTINCT a.id, a.email, a.first_name, a.last_name
from DEVELOPERS a
join SKILLCODES b on (a.SKILL_CODE & b.CODE) > 0
WHERE b.CATEGORY = 'Front End'
ORDER BY a.ID ASC;