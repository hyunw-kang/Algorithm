SELECT datetime as '시간'
FROM ANIMAL_INS
WHERE datetime = (select min(datetime) from animal_ins);