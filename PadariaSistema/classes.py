class Cliente:
    def __init__(self, cpf, nome_cliente, email_cliente, senha_cliente, endereco, contato):
        self.cpf = cpf
        self.nome_cliente = nome_cliente
        self.email_cliente = email_cliente
        self.senha_cliente = senha_cliente
        self.endereco = endereco
        self.contato = contato

    def info(self):
        return f'Nome: {self.nome_cliente}\tCPF: {self.cpf}\tEmail: {self.email_cliente}\tSenha: {self.senha_cliente}\tEndereço: {self.endereco}\tContato: {self.contato}'


class Gerente:
    def __init__(self, gerente_id, nome_gerente, email_gerente, senha_gerente):
        self.gerente_id = gerente_id
        self.nome_gerente = nome_gerente
        self.email_gerente = email_gerente
        self.senha_gerente = senha_gerente

    def info(self):
        return f'Nome: {self.nome_gerente}\tID: {self.gerente_id}\tEmail: {self.email_gerente}\tSenha: {self.senha_gerente}'
    

class Funcionario:
    def __init__(self, funcionario_id, nome_funcionario, email_funcionario, contato_funcionario, cargo, salario):
        self.funcionario_id = funcionario_id
        self.nome = nome_funcionario
        self.email = email_funcionario
        self.contato = contato_funcionario
        self.cargo = cargo
        self.salario = salario

    def info(self):
        return f'Nome: {self.nome}\tID: {self.funcionario_id}\tEmail: {self.email}\tContato: {self.contato}\tCargo: {self.cargo}\tSalário: {self.salario}'


class Produto:
    def __init__(self, produto_id, nome, descricao, preco, estoque):
        self.produto_id = produto_id
        self.nome = nome
        self.descricao = descricao
        self.preco = preco

    def info(self):
        return f'Nome: {self.nome}\tID: {self.produto_id}\tDescrição: {self.descricao}\tPreço: {self.preco}'


class Fornecedor:
    def __init__(self, cnpj, nome_fornecedor, contato_fornecedor, email_fornecedor, local):
        self.cnpj = cnpj
        self.nome_fornecedor = nome_fornecedor
        self.contato_fornecedor = contato_fornecedor
        self.email_fornecedor = email_fornecedor
        self.local = local

    def info(self):
        return f'Nome: {self.nome_fornecedor}\tCNPJ: {self.cnpj}\tContato: {self.contato_fornecedor}\tEmail: {self.email_fornecedor}\tLocal: {self.local}'


class Ingrediente:
    def __init__(self, ingrediente_id, nome, estoque, unidade_medida):
        self.ingrediente_id = ingrediente_id
        self.nome = nome
        self.estoque = estoque
        self.unidade_medida = unidade_medida

    def info(self):
        return f'Nome: {self.nome}\tID: {self.ingrediente_id}\tEstoque: {self.estoque}\tUnidade de medida: {self.unidade_medida}'


class Pedido:
    def __init__(self, pedido_id, cliente_cpf, status, valor_total):
        self.pedido_id = pedido_id
        self.cliente_cpf = cliente_cpf
        self.status = status
        self.valor_total = valor_total

    def info(self):
        return f'ID: {self.pedido_id}\tCPF do cliente: {self.cliente_cpf}\tStatus: {self.status}\tValor total: {self.valor_total}'


class Compra:
    def __init__(self, pedido_id, produto_id, quantidade_comprada):
        self.pedido_id = pedido_id
        self.produto_id = produto_id
        self.quantidade_comprada = quantidade_comprada


class ForneceIngrediente:
    def __init__(self, fornecedor_id, ingrediente_id, preco_compra, data_compra, quantidade_fornecida):
        self.fornecedor_id = fornecedor_id
        self.ingrediente_id = ingrediente_id
        self.preco_compra = preco_compra
        self.data_compra = data_compra
        self.quantidade_fornecida = quantidade_fornecida


class ProdutoIngrediente:
    def __init__(self, produto_id, ingrediente_id, quantidade_usada):
        self.produto_id = produto_id
        self.ingrediente_id = ingrediente_id
        self.quantidade_usada = quantidade_usada