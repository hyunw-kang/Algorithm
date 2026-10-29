SELECT a.CATEGORY, sum(b.sales) as TOTAL_SALES
from book a
join book_sales b on a.book_id = b.book_id
where YEAR(b.SALES_DATE) = 2022 and MONTH(b.SALES_DATE) = 01
group by a.CATEGORY
order by a.CATEGORY