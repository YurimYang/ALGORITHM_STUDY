-- 코드를 작성해주세요
SELECT FI.ID, FN.FISH_NAME, FI.LENGTH AS LENGTH
FROM FISH_INFO FI JOIN FISH_NAME_INFO FN ON FI.FISH_TYPE = FN.FISH_TYPE
WHERE FI.LENGTH = (SELECT MAX(LENGTH)
                   FROM FISH_INFO FI2
                   WHERE FI.FISH_TYPE = FI2.FISH_TYPE)
ORDER BY FI.ID