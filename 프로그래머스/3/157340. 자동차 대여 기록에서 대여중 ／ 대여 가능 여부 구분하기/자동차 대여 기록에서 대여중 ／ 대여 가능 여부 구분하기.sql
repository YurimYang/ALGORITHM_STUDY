-- 코드를 입력하세요
SELECT CAR_ID, 
CASE
    WHEN COUNT(CASE 
               WHEN START_DATE <= '2022-10-16' AND END_DATE >= '2022-10-16' 
               THEN 1 ELSE NULL
                END) = 0 
    THEN '대여 가능' ELSE '대여중' 
    END AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
ORDER BY CAR_ID DESC