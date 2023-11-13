import mysql.connector

con=mysql.connector.connect(host='localhost',database='loja',user='root',password='')
if con.is_connected():
    print('Versão do servidor Mysql: ', con.get_server_info())

cursor=con.cursor()
cursor.execute('select database();')
print ('Conectado ao banco de dados ', cursor.fetchone())
cursor.execute('create table if not exists produto (codigo int primary key, '
                                    'descricao varchar(30), '
                                    'preco float, '
                                    'qtde int)')


#cursor.execute("insert into produto values (101, 'Pendrive 64GB', 30,10)")
insert='insert into produto values (%s,%s,%s,%s)'
#dados=(102,'notebook i5 16GB 15pol. SSD 254GB', 4000,2)
dados=[(103,'Pendrive 254GB', 150,5),
       (104,'Impressora laser', 1000,2),
       (105,'Monitor LCD 19pol.', 700,5)]
#cursor.execute(insert,dados)
cursor.executemany(insert,dados)
print ('Registros inseridos: ',str(cursor.rowcount))
con.commit()

select='select * from produto'
cursor.execute(select)
for (codigo, descricao, preco, qtde) in cursor:
    print('\nCodigo: ',codigo,'\nDescricao: ', descricao,
          '\nPreço: ', preco, '\nQtde: ',qtde)

codigo=input('Código do produto para consulta: ')
select='select * from produto where codigo='+codigo
cursor.execute(select)
'''
resultado=cursor.fetchall()
for linha in resultado:
    print('\nCodigo: ',linha[0],'\nDescricao: ', linha[1],
          '\nPreço: ', linha[2], '\nQtde: ',linha[3])
'''
'''
linha=cursor.fetchone()
print('\nCodigo: ', linha[0], '\nDescricao: ', linha[1],
      '\nPreço: ', linha[2], '\nQtde: ', linha[3])
'''


codigo=input('Código do produto para excluir: ')
select='delete from produto where codigo='+codigo
cursor.execute(select)
if cursor.rowcount>0:
    print('Registro excluído com sucesso!')
    con.commit()
else:
    print('Falha na exclusão do registro!')