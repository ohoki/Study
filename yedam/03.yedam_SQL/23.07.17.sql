SELECT NVL(MAX(bno), 100) +1
FROM board;

SELECT 'BD' || TO_CHAR(SYSDATE, 'YYmmDD') || TO_CHAR(NVL(MAX(bno),0)+1, 'FM000') AS bno FROM board; 

-- ���� (��¥���� �ڿ� �ٴ� ���ڰ��� �ʱ�ȭ �ǵ���)
SELECT 'BD' || TO_CHAR(SYSDATE, 'RRmmDD') || LPAD(NVL(MAX(SUBSTR(bno, -3)),0)+1, 3, '0')
FROM board
WHERE SUBSTR(bno, 3, 6) = TO_CHAR(sysdate, 'rrMMdd');

INSERT INTO board (bno, title, writer) VALUES (100, 'ù����', '�͸�');

COMMIT;