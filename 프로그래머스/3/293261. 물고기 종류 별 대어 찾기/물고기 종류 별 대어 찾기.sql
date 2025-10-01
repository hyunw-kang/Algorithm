select i.ID, n.FISH_NAME, i.LENGTH
FROM FISH_INFO i
join FISH_NAME_INFO n
on i.FISH_TYPE = n.FISH_TYPE
WHERE i.LENGTH = (select max(fi.LENGTH)
                        from FISH_INFO fi
                        WHERE fi.FISH_TYPE = n.FISH_TYPE)
ORDER BY i.ID ASC;