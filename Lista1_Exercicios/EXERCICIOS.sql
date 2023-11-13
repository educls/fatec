-- exercicio 1
--Exibir código, nome, salário e o salário com 30% de aumento para todos os funcionários

SELECT 
    f.FUNCIONARIO_ID AS CODIGO, 
    f.NOME AS NOME, 
    f.SALARIO AS SALARIO_SEM_AUMENTO,
ROUND(f.SALARIO * 1.3,2) AS "SALARIO_COM_AUMENTO"
FROM FUNCIONARIO f;

SELECT
    f.FUNCIONARIO_ID AS codigo,
    f.nome AS nome,
    f.SALARIO AS salario_sem_aumento,
    (f.SALARIO) + (f.SALARIO * 30 / 100) AS salario_com_aumento
FROM funcionario f;


-- exercicio 2
--Exibir os nomes das distintas cidades e bairros dos funcionários da empresa.

SELECT DISTINCT FUNCIONARIO.NOME, CIDADE.NOME, BAIRRO
FROM FUNCIONARIO, CIDADE;


-- exercicio 3
--Exibir código, nome, preço de custo, preço de venda e a diferença entre estes dois preços para todos os produtos.

SELECT PRODUTO_ID as CODIGO, PRODUTO.NOME, CUSTO, VENDA,
round(VENDA - CUSTO, 2) AS LUCRO
FROM PRODUTO;


-- exercicio 4
--Exibir os 3 primeiros clientes cadastrados.

SELECT CLIENTE_ID AS CODIGO, NOME
FROM CLIENTE
ORDER BY CLIENTE_ID
LIMIT 3;

SELECT *
FROM CLIENTE
LIMIT 3;


-- exercicio 5
--Exiba o nome do funcionário e o nome mês do seu aniversário.

SELECT NOME, MONTHNAME(DATA_NASC) AS MES_NIVER
FROM FUNCIONARIO;

SELECT NOME, MONTHNAME(STR_TO_DATE(DATA_NASC, '%Y-%m-%d')) AS "Nome do Mes de Aniversario"
FROM FUNCIONARIO;



-- exercicio 6   
--Mostre os 50% primeiros pedidos cadastrados.

SELECT COUNT(*) / 2 FROM PEDIDO;


SELECT *
FROM PEDIDO
WHERE PEDIDO_ID <= (SELECT MAX(PEDIDO_ID) * 0.5 FROM PEDIDO);


-- exercicio 7 
--Mostre a descrição, preço de custo e preço de venda arredondados para 1 casa decimal, de todos os produtos.

SELECT NOME, ROUND(CUSTO, 1) AS "Preco de Custo", ROUND(VENDA, 1) AS "Preco de Venda"
FROM PRODUTO;


-- exercicio 8 
--Mostre o primeiro caractere das siglas dos setores existentes na empresa, tudo em minúsculo.

SELECT LOWER(LEFT(SIGLA, 1)) AS "Primeiro Sigla"
FROM SETOR;


-- exercicio 9 
--Mostre o nome do dia de hoje.

SELECT DAYNAME(CURDATE()) AS "Nome do Dia de Hoje";


-- exercicio 10
--Mostre os pedidos realizados nos últimos 06 meses.

-- não possue registros dentro de 6 meses na base de dados
SELECT *
FROM PEDIDO
WHERE DATA_PEDIDO >= DATE_SUB(CURDATE(), INTERVAL 6 MONTH);


-- exercicio 11
--Exibir a data do pedido mais recente.

SELECT MAX(DATA_PEDIDO) AS "Data do Pedido Mais Recente"
FROM PEDIDO;


-- exercicio 12
--Mostre os nomes dos funcionários, e uma coluna adicional contendo ‘premiado’ com o cabeçalho ‘Bônus’ para todos os funcionários.

SELECT NOME, 'premiado' AS "Bonus"
FROM FUNCIONARIO;


-- exercicio 13
--Qual será o dia da semana, de hoje a 10 dias ??

SELECT DAYNAME(DATE_ADD(CURDATE(), INTERVAL 10 DAY)) AS "Dia da Semana daqui 10 Dias";


-- exercicio 14
--Mostre o preço de todos os itens elevados a 3.

SELECT preco * preco * preco AS "Preco Elevado ao Cubo"
FROM ITENS;

