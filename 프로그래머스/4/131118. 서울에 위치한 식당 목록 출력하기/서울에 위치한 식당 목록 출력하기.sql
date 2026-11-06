SELECT b.REST_ID, a.REST_NAME, a.FOOD_TYPE, a.FAVORITES, a.ADDRESS, 
    round(avg(b.review_score),2)as SCORE
from rest_info a
join rest_review b on a.rest_id = b.rest_id
group by b.rest_id
having a.address like '서울%'
order by score desc, favorites desc;