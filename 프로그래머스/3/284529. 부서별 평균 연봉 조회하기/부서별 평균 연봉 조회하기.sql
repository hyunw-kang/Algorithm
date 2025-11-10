select r.DEPT_ID, h.DEPT_NAME_EN, Round(avg(r.sal)) as AVG_SAL
FROM HR_DEPARTMENT h
join HR_EMPLOYEES r
on h.dept_id = r.dept_id
group by r.dept_id
order by AVG_SAL desc;

