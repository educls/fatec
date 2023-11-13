import mysql.connector

def conexao(con, cursor):
    con=mysql.connector.connect(host='localhost',database='loja',
                                user='root', password='')
    if con.is_connected():
        cursor=con.cursor()
        return True
    return False

def menu():
    op=input('Cadastro de produtos\n\n1-Cadastrar\n2-Consultar\n3-Alterar preco'+
             '\n4-Excluir\n5-Listar todos os produtos\n6-Finalizar\nOpção: ')
    return op

def cadastrar():
    sql='insert into produto values (%s,%s,%s,%s)'
    codigo=int(input('Código: '))
    descricao=input('Descrição: ')
    preco=float(input('Preço: '))
    qtde=int(input('Qtde: '))
    values=(codigo, descricao, preco, qtde)
    cursor.execute(sql, values)
    if cursor.rowcount>0:
        con.commit()
        print('Produto cadastrado com sucesso!!')
    else:
        print('Falha no cadastro do produto!!')

def consultar():
    codigo=input('Código do produto para consulta: ')
    cursor.execute('select * from produto where codigo='+codigo)
    dados=cursor.fetchone()
    if dados!=None:
        print('Codigo: '+str(dados[0])+'\nDescrição: '+dados[1]+
             '\nPreço: '+str(dados[2])+'\nQtde: '+str(dados[3]))
    else:
        print('Produto não cadastrado!')

def alterar():
    codigo=int(input('Código do produto para alterar o preço: '))
    preco=float(input('Novo preço: '))
    sql='update produto set preco=%s where codigo=%s'
    cursor.execute(sql, (preco,codigo))
    if cursor.rowcount>0:
        con.commit()
        print('Preço atualizado com sucesso!')
    else:
        print('Falha na atualização do preço!')

def excluir():
    codigo=input('Código do produto para excluir: ')
    cursor.execute('delete from produto where codigo='+codigo)
    if cursor.rowcount>0:
        con.commit()
        print('Produto excluído com sucesso!')
    else:
        print('Falha na exclusão do produto!')

def listar():
    cursor.execute('select * from produto')
    for linha in cursor:
        print('Código: ',linha[0],'\nDescrição: ',linha[1],
              '\nPreço: ',linha[2],'\nQtde: ',linha[3])

#inicio do programa
con = mysql.connector.connect(host='localhost', database='loja',
                              user='root', password='')
if con.is_connected():
    cursor = con.cursor()
else:
    print('Falha na conexão com o banco de dados!!!')
    exit(0)
print('Conectado ao banco de dados!')

while True:
    op=menu()
    if op=='6':
        break;
    elif op=='1':
        cadastrar()
    elif op=='2':
        consultar()
    elif op=='3':
        alterar()
    elif op=='4':
        excluir()
    elif op=='5':
        listar()



