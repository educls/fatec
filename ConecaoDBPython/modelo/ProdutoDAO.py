import mysql.connector

from modelo.Produto import Produto


class ProdutoDAO:
    def conectaDB(self):
        self.con=mysql.connector.connect(host='localhost',
                                         database='loja',
                                         user='root',
                                         password='')
        if self.con.is_connected():
            self.cursor=self.con.cursor()
            return  True
        return False
    def desconectaDB(self):
        self.con.close()

    def insert(self, p):
        sql='insert into produto values (%s, %s, %s, %s)'
        values=(p.getCodigo(), p.getDescricao(), p.getPreco(), p.getQtde())

        if self.conectaDB():
            self.cursor.execute(sql, values)

            if self.cursor.rowcount>0:
                self.con.commit()
                self.desconectaDB()
                return  True
            self.desconectaDB()
        return False

    def updateDB(self, p):
        sql = 'update produto set preco=%s, qtde=%s where codigo=%s'
        values = p.getPreco(), p.getQtde(), (p.getCodigo())

        if self.conectaDB():
            self.cursor.execute(sql, values)
            if self.cursor.rowcount > 0:
                self.con.commit()
                self.desconectaDB()
                return True
            self.desconectaDB()
        return False

    def deleteDB(self, codigo):
        sql = 'delete from produto where codigo=%s'+ str(codigo)

        if self.conectaDB():
            self.cursor.execute(sql)
            if self.cursor.rowcount > 0:
                self.con.commit()
                self.desconectaDB()
                return True
            self.desconectaDB()
        return False

    def selectDB(self, codigo):
        sql = 'select * from produto where codigo=%s' + str(codigo)

        if self.conectaDB():
            self.cursor.execute(sql)
            dados=self.cursor.fetchone()
            if dados!=None:
                p=Produto(dados[0], dados[1], dados[2], dados[3])
                self.desconectaDB()
                return p
            self.desconectaDB()
        return None

pd=ProdutoDAO()
prod=Produto(101, 'Pendrive 128GB', 60.0, 10)
# pd.insert(prod)
prod=pd.selectDB(101)

print('Qtde=', prod.getQtde())
print('Cdigo:', prod.getCodigo(), '\nDescrição:', prod.getDescricao(), '\nPreco:', prod.getPreco(), '\nQtde:', prod.getQtde())

prod.vender(2)
pd.updateDB(prod)