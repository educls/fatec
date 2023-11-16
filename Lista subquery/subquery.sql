1. Lista de imóveis do mesmo bairro do imóvel 2, excluindo o imóvel 2:

SELECT *
FROM imovel
WHERE id_bairro = (SELECT id_bairro FROM imovel WHERE id_imovel = 2)
  AND id_imovel != 2;

2. Lista de imóveis com preço superior à média de preço dos imóveis:

SELECT *
FROM imovel
WHERE valor > (SELECT AVG(valor) FROM imovel);


3. Lista de compradores com ofertas superiores a 70 mil:

SELECT *
FROM comprador_has_imovel
WHERE valor_oferta > 70000;


4. Lista de imóveis com oferta superior à média do valor das ofertas:

SELECT *
FROM imovel
WHERE id_imovel IN (
    SELECT id_imovel
    FROM comprador_has_imovel
    GROUP BY id_imovel
    HAVING AVG(valor_oferta) < valor
);


5. Lista de imóveis com preço superior à média de preço dos 
imóveis do mesmo bairro:

SELECT i.*
FROM imovel i
INNER JOIN bairro b ON i.id_bairro = b.id_bairro
WHERE i.valor > (SELECT AVG(valor) FROM imovel WHERE id_bairro = b.id_bairro);


6. Lista dos imóveis com maior preço agrupado por bairro, cujo maior preço 
seja superior à média de preços dos imóveis:

SELECT i.*
FROM (
    SELECT MAX(valor) AS max_valor, id_bairro
    FROM imovel
    GROUP BY id_bairro
    HAVING MAX(valor) > (SELECT AVG(valor) FROM imovel)
) AS max_values
INNER JOIN imovel i ON i.valor = max_values.max_valor AND i.id_bairro = max_values.id_bairro;


7. Lista com os imóveis que têm preço igual ao menor preço de cada vendedor:

SELECT i.*
FROM imovel i
INNER JOIN (
    SELECT MIN(valor) AS min_valor, id_vendedor
    FROM imovel
    GROUP BY id_vendedor
) AS min_values ON i.valor = min_values.min_valor AND i.id_vendedor = min_values.id_vendedor;


8. Lista com as ofertas dos imóveis com data de lançamento inferior a 30 dias e superior a 
180 dias, a partir de hoje, cujo código vendedor seja 2:

SELECT chi.*
FROM comprador_has_imovel chi
INNER JOIN imovel i ON chi.id_imovel = i.id_imovel
WHERE i.data_lancamento BETWEEN CURRENT_DATE - INTERVAL '30 days' AND CURRENT_DATE - INTERVAL '180 days'
  AND i.id_vendedor = 2;


9. Lista com os imóveis que têm o preço igual ao menor preço de todos os vendedores, 
exceto os imóveis do próprio vendedor:

SELECT i.*
FROM imovel i
INNER JOIN (
    SELECT MIN(valor) AS min_valor
    FROM imovel
    GROUP BY id_vendedor
) AS min_values ON i.valor = min_values.min_valor AND i.id_vendedor != min_values.id_vendedor;


10. Lista com as ofertas menores que todas as ofertas do comprador 2, exceto ofertas do próprio comprador:

SELECT chi.*
FROM comprador_has_imovel chi
WHERE chi.valor_oferta < ALL (
    SELECT valor_oferta
    FROM comprador_has_imovel
    WHERE id_comprador = 2 AND chi.id_imovel != id_imovel
);


11. Lista de todos os imóveis cujo Estado e Cidade sejam os mesmos do vendedor 3, 
exceto os imóveis do vendedor 3:

SELECT *
FROM imovel
WHERE id_estado = (SELECT id_estado FROM vendedor WHERE id_vendedor = 3)
  AND id_cidade = (SELECT id_cidade FROM vendedor WHERE id_vendedor = 3)
  AND id_vendedor != 3;


12. Lista com todos os nomes de bairro cujos imóveis sejam do mesmo Estado, 
cidade e bairro do imóvel código 5:

SELECT nome_bairro
FROM bairro
WHERE id_estado = (SELECT id_estado FROM imovel WHERE id_imovel = 5)
  AND id_cidade = (SELECT id_cidade FROM imovel WHERE id_imovel = 5)
  AND id_bairro = (SELECT id_bairro FROM imovel WHERE id_imovel = 5);
