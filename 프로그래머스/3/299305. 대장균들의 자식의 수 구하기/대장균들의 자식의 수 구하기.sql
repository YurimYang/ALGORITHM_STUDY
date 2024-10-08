-- 코드를 작성해주세요
SELECT parent.ID, COUNT(child.id) AS CHILD_COUNT
FROM ECOLI_DATA child 
    RIGHT JOIN ECOLI_DATA parent
    ON child.PARENT_ID = parent.ID
GROUP BY parent.ID