-- 코드를 입력하세요
# SELECT HISTORY_ID, 
#         ROUND(C.DAILY_FEE * (DATEDIFF(DAY, H.START_DATE, H.END_DATE) + 1) * (100 - IFNULL(DISCOUNT_RATE, 0) /100, 0) AS FEE
# FROM (SELECT *, (CASE 
#                 WHEN DATEDIFF(DAY, H.START_DATE, H.END_DATE) >= 7 THEN NULL
#                 WHEN DATEDIFF(DAY, H.START_DATE, H.END_DATE) >= 30 THEN '7일 이상'
#                 WHEN DATEDIFF(DAY, H.START_DATE, H.END_DATE) >= 90 THEN '30일 이상'
#                 ELSE '90일 이상'
#                 END) AS  DURATION_TYPE
#      FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY H)
#      JOIN CAR_RENTAL_COMPANY_CAR C ON H.CAR_ID = C.CAR_ID
#      LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN P ON P.CAR_TYPE = C.CAR_TYPE AND P.DURATION_TYPE = H.DURATION_TYPE
# WHERE C.CAR_TYPE = '트럭'
# ORDER BY 2 DESC,1 DESC;

SELECT history_id,
       round(daily_fee * (datediff(end_date, start_date) + 1) * (100 - ifnull(discount_rate, 0)) /
             100, 0) fee
FROM (SELECT *,
             CASE
                 WHEN datediff(end_date, start_date) + 1 < 7 THEN NULL
                 WHEN datediff(end_date, start_date) + 1 < 30 THEN '7일 이상'
                 WHEN datediff(end_date, start_date) + 1 < 90 THEN '30일 이상'
                 ELSE '90일 이상'
                 END duration_type
      FROM car_rental_company_rental_history) a
         JOIN car_rental_company_car b
              ON a.car_id = b.car_id
         LEFT JOIN car_rental_company_discount_plan c
                   ON c.car_type = b.car_type AND a.duration_type = c.duration_type
WHERE b.car_type = '트럭'
ORDER BY 2 DESC, 1 DESC
                