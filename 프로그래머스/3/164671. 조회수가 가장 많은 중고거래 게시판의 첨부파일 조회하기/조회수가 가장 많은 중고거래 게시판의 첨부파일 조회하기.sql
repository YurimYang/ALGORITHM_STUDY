-- 코드를 입력하세요
# SELECT CONCAT('/home/grep/src/', G.BOARD_ID, '/',G.FILE_ID, G.FILE_NAME, G.FILE_EXT) AS FILE_PATH
# FROM USED_GOODS_BOARD B, USED_GOODS_FILE G
# WHERE G.BOARD_ID = (
#                     SELECT B.BOARD_ID
#                     FROM USED_GOODS_BOARD B
#                     GROUP BY BOARD_ID
#                     ORDER BY B.VIEWS DESC
#                     LIMIT 1
#                     )
# ORDER BY G.FILE_ID DESC

SELECT CONCAT('/home/grep/src/', G.BOARD_ID, '/',G.FILE_ID, G.FILE_NAME, G.FILE_EXT) AS FILE_PATH
FROM USED_GOODS_BOARD B JOIN USED_GOODS_FILE G ON B.BOARD_ID = G.BOARD_ID
WHERE B.VIEWS = (SELECT MAX(VIEWS)
                FROM USED_GOODS_BOARD)
# WHERE G.BOARD_ID = (
#                     SELECT B.BOARD_ID
#                     FROM USED_GOODS_BOARD B
#                     GROUP BY BOARD_ID
#                     ORDER BY B.VIEWS DESC
#                     LIMIT 1
#                     )
ORDER BY G.FILE_ID DESC