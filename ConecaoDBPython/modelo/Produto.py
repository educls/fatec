class Produto:
    def __init__(self, codigo, descricao, preco, qtde):
        self.codigo=codigo
        self.descricao=descricao
        self.preco=preco
        self.qtde=qtde


    def getCodigo(self):
        return self.codigo

    def getDescricao(self):
        return self.descricao

    def getPreco(self):
        return  self.preco

    def getQtde(self):
        return  self.qtde

    def setPreco(self, preco):
        self.preco=preco

    def repor(self, qtde):
        self.qtde+=qtde

    def vender(self, qtde):
        if qtde>self.qtde:
            return False
        self.qtde-=qtde
        return  True


p=Produto(101, 'Pendrive 128GB', 60.0, 10)
print('Qtde=', p.getQtde())
p.repor(5)
print('Qtde=', p.getQtde())
p.vender(2)
print('Qtde=', p.getQtde())
print('Cdigo:', p.getCodigo(), '\nDescrição:', p.getDescricao(), '\nPreco:', p.getPreco(), '\nQtde:', p.getQtde())


