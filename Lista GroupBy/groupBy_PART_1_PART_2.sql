1 Itens vendidos sem desconto:
SELECT ID_NF, ID_ITEM, COD_PROD, VALOR_UNIT
FROM venda
WHERE DESCONTO = 0 OR DESCONTO IS NULL;


2 Itens vendidos com desconto:
SELECT ID_NF, ID_ITEM, COD_PROD, VALOR_UNIT, (VALOR_UNIT - (VALOR_UNIT * (DESCONTO / 100))) AS VALOR_VENDIDO
FROM venda
WHERE DESCONTO > 0;


3 Alterar desconto nulo para zero:
UPDATE venda
SET DESCONTO = 0
WHERE DESCONTO IS NULL;


4 Itens vendidos com detalhes (VALOR_TOTAL e VALOR_VENDIDO):
SELECT ID_NF, ID_ITEM, COD_PROD, VALOR_UNIT, (QUANTIDADE * VALOR_UNIT) AS VALOR_TOTAL, DESCONTO, (VALOR_UNIT - (VALOR_UNIT * (DESCONTO / 100))) AS VALOR_VENDIDO
FROM venda;


5 Valor total das NF ordenado do maior para o menor:
SELECT ID_NF, SUM(QUANTIDADE * VALOR_UNIT) AS VALOR_TOTAL
FROM venda
GROUP BY ID_NF
ORDER BY VALOR_TOTAL DESC;


6 Valor vendido das NF ordenado do maior para o menor:
SELECT ID_NF, SUM(VALOR_UNIT - (VALOR_UNIT * (DESCONTO / 100))) AS VALOR_VENDIDO
FROM venda
GROUP BY ID_NF
ORDER BY VALOR_VENDIDO DESC;


7 Produto que mais vendeu no geral:
SELECT COD_PROD AS ID_PROD, SUM(QUANTIDADE) AS QUANTIDADE
FROM venda
GROUP BY COD_PROD
ORDER BY QUANTIDADE DESC
LIMIT 1;


8 NF que venderam mais de 10 unidades de pelo menos um produto:
SELECT ID_NF, COD_PROD, SUM(QUANTIDADE) AS QUANTIDADE
FROM venda
GROUP BY ID_NF, COD_PROD
HAVING SUM(QUANTIDADE) > 10;


9 Valor total das NF onde o valor seja maior que 500:
SELECT ID_NF, SUM(QUANTIDADE * VALOR_UNIT) AS VALOR_TOT
FROM venda
GROUP BY ID_NF
HAVING VALOR_TOT > 500
ORDER BY VALOR_TOT DESC;


10 Valor médio dos descontos por produto:
SELECT COD_PROD AS ID_PROD, AVG(DESCONTO) AS MEDIA
FROM venda
GROUP BY COD_PROD;


11 Menor, maior e média dos descontos por produto:
SELECT COD_PROD AS ID_PROD, MIN(DESCONTO) AS MENOR, MAX(DESCONTO) AS MAIOR, AVG(DESCONTO) AS MEDIA
FROM venda
GROUP BY COD_PROD;


12 NF com mais de 3 itens vendidos:
SELECT ID_NF, COUNT(ID_ITEM) AS QTD_ITENS
FROM venda
GROUP BY ID_NF
HAVING COUNT(ID_ITEM) > 3;


PARTE 2


a Encontre a MAT dos alunos com nota em BD em 2015 menor que 5:
SELECT codigo_aluno AS MAT
FROM historico
WHERE sigla_disciplina = 'BD' AND n1 < 5 AND n2 < 5 AND codigo_aluno IN (
    SELECT codigo
    FROM aluno
    WHERE cidade != 'NATAL'
);

b Encontre a MAT e calcule a média das notas dos alunos na disciplina de POO em 2015:
SELECT h.codigo_aluno AS MAT, AVG((h.n1 + h.n2) / 2) AS MEDIA_POO
FROM historico h
WHERE h.sigla_disciplina = 'POO' AND h.codigo_aluno IN (
    SELECT codigo
    FROM aluno
    WHERE cidade != 'NATAL'
) AND h.codigo_aluno IN (
    SELECT codigo
    FROM aluno
    WHERE cidade != 'NATAL'
);

c Encontre a MAT e calcule a média das notas dos alunos na disciplina de POO em 2015 e que esta média seja superior a 6:
SELECT h.codigo_aluno AS MAT, AVG((h.n1 + h.n2) / 2) AS MEDIA_POO
FROM historico h
WHERE h.sigla_disciplina = 'POO' AND h.codigo_aluno IN (
    SELECT codigo
    FROM aluno
    WHERE cidade != 'NATAL'
) GROUP BY h.codigo_aluno HAVING AVG((h.n1 + h.n2) / 2) > 6;


d Encontre quantos alunos não são de Natal:
SELECT COUNT(*) AS Quantidade_Alunos_Nao_Natal
FROM aluno
WHERE cidade != 'NATAL';

