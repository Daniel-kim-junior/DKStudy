SELECT BOARD_ID, WRITER_ID, TITLE, PRICE, 
case 
    when status = 'DONE' then '거래완료'
    when status = 'SALE' then '판매중'
    ELSE '예약중'
END AS VIEWS
FROM USED_GOODS_BOARD
WHERE CREATED_DATE = '2022-10-05'
ORDER by BOARD_ID desc;