DROP DATABASE IF EXISTS Lista1;

CREATE DATABASE Lista1;

use Lista1;


create table PAIS (
	PAIS_ID char(6) not null primary key,
	SIGLA varchar(3) not null,
	NOME varchar(15) not null
);

create table ITENS(
	ITEM_ID char(6) not null primary key,
	PRODUTO char(6) not null,
	PRECO decimal(9,2) not null,
	QTD char(5) not null,
	DESCONTO decimal(9,2) not null
);

create table CIDADE (
	CIDADE_ID char(6) not null primary key,
	NOME varchar(20) not null,
	UF varchar(2) not null,
	PAIS char(6) not null
);

create table CLIENTE (
	CLIENTE_ID char(6) not null primary key,
	NOME varchar(20) not null,
	TIPO varchar(15) not null,
	CONTATO varchar(15) not null,
	CARGO varchar(15) not null,
	ENDERECO varchar(20) not null,
	CIDADE char(6) not null,
	CEP varchar(10) not null,
	FONE varchar(15) not null,
	FAX varchar(15),
	OBS varchar(30)
);


	
create table PRODUTO (
	PRODUTO_ID char(6) not null primary key,
	NOME varchar(20) not null,
	TIPO varchar(6) not null,
	DESCRICAO varchar(30) not null,
	APRESENT varchar(50) not null,
	VENDA varchar(10) not null,
	CUSTO char(10) not null,
	QTD_ESTOQUE varchar(10) not null,
	MIN_ESTOQUE varchar(10) not null,
	SITUACAO varchar(15) not null
);	

create table TIPO (
	TIPO_ID char(6) not null primary key,
	NOME varchar(15) not null,
	DESCRICAO char(30) not null
);

create table FUNCAO(
	FUNCAO_ID char(6) not null primary key,
	NOME varchar(20) not null,
	GRATIFIC varchar(10) not null
);	

create table SETOR(
	SETOR_ID char(6) not null primary key,
	SIGLA char(6),
	NOME varchar(20) not null,
	RAMAL varchar(6) not null,
	CHEFE char(6) 
);

create table FUNCIONARIO(
	FUNCIONARIO_ID char(6) not null primary key,
	NOME varchar(20) not null,
	SEXO varchar(1) not null,
	EST_CIVIL varchar(30) not null,
	RG varchar(50) not null,
	CPF varchar(11) not null,
	DATA_NASC char(10) not null,
	NATURALIDADE char(6) not null,
	DATA_ADM varchar(10) not null,
	ENDERECO varchar(20) not null,
	COMPLEMENTO varchar(20),
	BAIRRO varchar(20),
	CIDADE char(6) not null,
	CEP varchar(10) not null,
	FONE varchar(15),
	CELULAR varchar(15) not null,
	FUNCAO char(6),
	SETOR char(6),
	SALARIO decimal(9,2),
	EMAIL varchar(50),
	OBS varchar(30)
);
	
create table PEDIDO(
	PEDIDO_ID char(6) not null primary key,
	TIPO char(6) not null,
	CLIENTE char(6) not null,
	VENDEDOR char(6) not null,
	DATA_PEDIDO date,
	DATA_FATURA date,
	VIA varchar(15) not null,
	FRETE char(15) not null
);


INSERT INTO PAIS (PAIS_ID, SIGLA, NOME) 
VALUES 
(1,"BRA", "Brasil"),
(2,"USA", "Estados Unidos"),
(3,"PER", "Peru"),
(4,"JAP", "Japao"),
(5,"POR", "Portugal"),
(6,"RUS", "Russia");

INSERT INTO CIDADE (CIDADE_ID, NOME, UF, PAIS) 
VALUES 
(1,"Marilia", "SP", 1),
(2,"Michigan", "IL", 2),
(3,"Sydney", "SG", 6),
(4,"Nagoia", "AI", 5),
(5,"Berlin", "BR", 4),
(6,"Cordoba", "Co", 3);

INSERT INTO CLIENTE (CLIENTE_ID, NOME, TIPO, CONTATO, CARGO, ENDERECO, CIDADE, CEP, FONE, FAX, OBS) 
VALUES 
(1,"Luiz Jose", "", "", "vendedor", "Av Faria lima 23", 1, "15214500", "551133012598", null, null),
(2,"Rosemary", "", "", "marketing", "20 Saint James Av", 2, "20058", "16233022015", null, null),
(3,"Janet", "", "", "teacher", "550 Ocean Av", 3, "20058", "16233022015", "16256985632", "blablabla"),
(4,"Cristian pela", "", "", "estudante", "Rua de la plata 68", 6, "6686464", "54153265546", null, null),
(5,"Cristina Rode", "", "", "programadora", "Freder Stras 125", 5, "526548", "3546544", null, null),
(6,"Liu xiang", "", "", "professora", "feng xang da lu 12", 4, "35465465", "84213546546", null, "peng you");

INSERT INTO TIPO (TIPO_ID, NOME, DESCRICAO) 
VALUES 
(1,"TIPO 1", "DESCRICAO TIPO 1"),
(2,"TIPO 2", "DESCRICAO TIPO 2"),
(3,"TIPO 3", "DESCRICAO TIPO 3"),
(4,"TIPO 4", "DESCRICAO TIPO 4");

INSERT INTO PRODUTO (PRODUTO_ID, NOME, TIPO, DESCRICAO, APRESENT, VENDA, CUSTO, QTD_ESTOQUE, MIN_ESTOQUE, SITUACAO) 
VALUES 
(1,"PRODUTO 1", 1, "DESCRICAO PRODUTO 1", "APRESENT PRODUTO 1", 125.25, 78.90, 150, 20, "situacao 1" ),
(2,"PRODUTO 2", 2, "DESCRICAO PRODUTO 2", "APRESENT PRODUTO 1", 125.25, 78.90, 110, 20, "situacao 2" ),
(3,"PRODUTO 3", 3, "DESCRICAO PRODUTO 3", "APRESENT PRODUTO 1", 125.25, 78.90, 85, 20, "situacao 3" ),
(4,"PRODUTO 4", 4, "DESCRICAO PRODUTO 4", "APRESENT PRODUTO 1", 125.25, 78.90, 78, 30, "situacao 4" ),
(5,"PRODUTO 5", 1, "DESCRICAO PRODUTO 5", "APRESENT PRODUTO 1", 125.25, 78.90, 98, 20, "situacao 5" ),
(6,"PRODUTO 6", 2, "DESCRICAO PRODUTO 6", "APRESENT PRODUTO 1", 125.25, 78.90, 101, 50, "situacao 6" ),
(7,"PRODUTO 7", 4, "DESCRICAO PRODUTO 7", "APRESENT PRODUTO 1", 125.25, 78.90, 58, 50, "situacao 7" ),
(8,"PRODUTO 8", 1, "DESCRICAO PRODUTO 8", "APRESENT PRODUTO 1", 125.25, 78.90, 145, 10, "situacao 8" ),
(9,"PRODUTO 9", 2, "DESCRICAO PRODUTO 9", "APRESENT PRODUTO 1", 125.25, 78.90, 189, 80, "situacao 9" ),
(10,"PRODUTO 10", 3, "DESCRICAO PRODUTO 10", "APRESENT PRODUTO 1", 125.25, 78.90, 112, 30, "situacao 10" );

INSERT INTO FUNCAO(FUNCAO_ID, NOME, GRATIFIC) 
VALUES 
(1,"FUNCAO 1", "DES_FUNC_1"),
(2,"FUNCAO 2", "DES_FUNC_2"),
(3,"FUNCAO 3", "DES_FUNC_3"),
(4,"FUNCAO 4", "DES_FUNC_4");

INSERT INTO SETOR(SETOR_ID, SIGLA, NOME, RAMAL, CHEFE) 
VALUES 
(1,"S1","SETOR 1", "1221", 4),
(2,"S2","SETOR 2", "1224", 2),
(3,"S2","SETOR 3", "1223", 3),
(4,"S3","SETOR 4", "1222", 4);	

INSERT INTO FUNCIONARIO (FUNCIONARIO_ID, NOME, SEXO, EST_CIVIL, RG, CPF, DATA_NASC, NATURALIDADE, DATA_ADM, ENDERECO, 
COMPLEMENTO, BAIRRO, CIDADE, CEP, FONE, CELULAR, FUNCAO, SETOR, SALARIO, EMAIL, OBS) 
VALUES 
(1,"Josefina Almeida", "F", "Solteira", "485221145", "11155588874", "1992-05-20", 1, "2015-05-21", "Rua jose bras 21",
 null, "Parque das Orquideas", 1, "215452", "112246654654", "5464654654", 2, 3, 1.200, "nome@email.com.br", null ),
(2,"Mauro benedito", "M", "Casado", "485465145", "11454548748", "1980-09-10", 1, "2014-01-21", "Rua jose bras 22",
 null, "Parque das Orquideas", 1, "215452", "11226587465", "546545654654", 1, 4, 1.500, "nome2@email.com.br", null ),
(3,"Mauro benedito", "M", "Casado", "485465145", "11454548704", "1980-09-10", 1, "2014-01-21", "Rua jose bras 22",
 null, "Parque das Orquideas", 1, "215452", "112265874654", "54654565464", 1, 4, 1.500, "nome2@email.com.br", null ),
(4,"Camila Silva", "F", "Solteira", "485221145", "11155588487", "1986-02-12", 3, "2013-02-21", "Rua jose bras 23",
 null, "Palmital", 6, "215452", "112246654654", "54646546504", 4, 1, 3.200, "nome3@email.com.br", null ),
(5,"John Feer", "M", "Solteira", "485221145", "11155588874", "1990-10-04", 2, "2012-03-21", "Rua jose bras 24",
 null, "Cezar Almeida", 2, "215452", "112246654654", "54646546540", 4, 2, 5.200, "nome4@email.com.br", null ),
(6,"Michael Flanagam", "M", "Solteira", "485221145", "11155588874", "1978-08-29", 4, "2011-04-21", "Rua jose bras 25",
 null, "Parque das Nações", 5, "215452", "112246654654", "54646546540", 1, 3, 2.200, "nome5@email.com.br", null ),
(7,"Kena Fany", "F", "Solteira", "485221145", "11155588874", "1995-03-21", 5, "2010-09-21", "Rua jose bras 26",
 null, "Parque das Nações", 4, "215452", "112246654654", "54646546540", 3, 3, 4.100, "nome6@email.com.br", null );

 INSERT INTO PEDIDO(PEDIDO_ID, TIPO, CLIENTE, VENDEDOR, DATA_PEDIDO, DATA_FATURA, VIA, FRETE) 
VALUES 
(1, 4,2,1,"2017-01-20", "2017-01-22", "VIA 1", "FRETE1"),
(2, 2,1,2,"2017-01-25", "2017-01-28", "VIA 1", "FRETE1"),
(3, 1,3,3,"2017-02-10", "2017-02-15", "VIA 1", "FRETE1"),
(4, 3,4,1,"2017-02-18", "2017-02-22", "VIA 1", "FRETE1");

INSERT INTO ITENS(ITEM_ID, PRODUTO, PRECO, QTD, DESCONTO) 
VALUES 
(1,2,152.20,2,20.0),
(2,1,112.20,1,12.0),
(3,3,152.20,3,7.0),
(4,4,182.20,1,5.0),
(5,1,102.20,3,10.0),
(6,2,125.20,5,50.0);

alter table SETOR 
	add foreign key (CHEFE) references FUNCIONARIO(FUNCIONARIO_ID) ON UPDATE CASCADE;
alter table FUNCIONARIO
	add foreign key (FUNCAO) references FUNCAO(FUNCAO_ID) ON UPDATE CASCADE,
	add foreign key (SETOR) references SETOR(SETOR_ID) ON UPDATE CASCADE,
	add foreign key (NATURALIDADE) references PAIS(PAIS_ID) ON UPDATE CASCADE,
	add foreign key (CIDADE) references CIDADE(CIDADE_ID) ON UPDATE CASCADE;
alter table PEDIDO
	add foreign key (CLIENTE) references CLIENTE(CLIENTE_ID) ON UPDATE CASCADE,
	add foreign key (VENDEDOR) references FUNCIONARIO(FUNCIONARIO_ID) ON UPDATE CASCADE,
	add foreign key (TIPO) references TIPO(TIPO_ID) ON UPDATE CASCADE;
alter table ITENS
	add foreign key (PRODUTO) references PRODUTO(PRODUTO_ID) ON UPDATE CASCADE;
alter table CIDADE
	add foreign key (PAIS) references PAIS(PAIS_ID) ON UPDATE CASCADE;
alter table CLIENTE
	add foreign key (CIDADE) references CIDADE(CIDADE_ID) ON UPDATE CASCADE;
