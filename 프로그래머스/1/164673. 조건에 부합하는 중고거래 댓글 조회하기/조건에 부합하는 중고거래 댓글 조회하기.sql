-- 코드를 입력하세요
SELECT TITLE,USED_GOODS_BOARD.BOARD_ID,REPLY_ID,USED_GOODS_REPLY.WRITER_ID,USED_GOODS_REPLY.CONTENTS,DATE_FORMAT(USED_GOODS_REPLY.CREATED_DATE,'%Y-%m-%d')
FROM USED_GOODS_BOARD,USED_GOODS_REPLY
WHERE USED_GOODS_BOARD.BOARD_ID=USED_GOODS_REPLY.BOARD_ID
AND USED_GOODS_BOARD.CREATED_DATE LIKE '2022-10%'
ORDER BY USED_GOODS_REPLY.CREATED_DATE ASC,TITLE ASC
