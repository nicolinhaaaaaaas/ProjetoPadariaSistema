import mysql.connector
from classes import Cliente, Compra, ForneceIngrediente, Funcionario, Ingrediente, Produto, Fornecedor, Pedido, Gerente, ProdutoIngrediente

# Funções do Cliente ###########################################################
def cadastroCliente(cursor, conexao):
    try:
        nome = input('Digite seu nome: ')
        cpf = input('Digite seu CPF: ')
        email = input('Digite seu Email: ')
        senha = input('Digite sua Senha: ')
        endereco = input('Digite seu Endereço: ')
        contato = input('Digite seu telefone de Contato: ')

        cursor.execute(f'SELECT * FROM cliente WHERE cpf = "{cpf}"')
        if cursor.fetchone() is not None:
            print('CPF já cadastrado!')
            return
        else:
            cursor.execute(f'SELECT * FROM cliente WHERE email_cliente = "{email}"')
            if cursor.fetchone() is not None:
                print('Email já cadastrado!')
                return
            else:   
                cliente = Cliente(nome, cpf, email, senha, endereco, contato)
                cursor.execute(f'INSERT INTO cliente (nome_cliente, cpf, email_cliente, senha_cliente, endereco, contato) VALUES ("{cliente.nome}", "{cliente.cpf}", "{cliente.email}", "{cliente.senha}", "{cliente.endereco}", "{cliente.contato}")')
                conexao.commit()
                print('Cliente cadastrado com sucesso!')
    
    except mysql.connector.Error as err:
        print(err)
        return None


def loginCliente(cursor):
    try:
        #parte que importa
        email = input('Digite seu Email: ')
        senha = input('Digite sua Senha: ')
        cursor.execute(f'SELECT * FROM cliente WHERE email_cliente = "{email}" AND senha_cliente = "{senha}"')
        
        resultado = cursor.fetchone()

        if resultado is None:
            print('Email ou senha incorretos!')
            return None
        else:
            cliente = Cliente(resultado[0], resultado[1], resultado[2], resultado[3], resultado[4], resultado[5])
            return cliente
        #
    except mysql.connector.Error as erro:
        print(f"Erro ao buscar cliente: {erro}")
        return None


def atualizarContaCliente(objeto_cliente, cursor, conexao):
    try:
        print('Deseja atualizar seus dados? (1)-Sim (0)-Não')
        if (input() == '1'):
            objeto_cliente.nome = input('Digite seu novo nome:')
            objeto_cliente.email = input('Digite seu novo email:')
            objeto_cliente.senha = input('Digite sua nova senha:')
            objeto_cliente.endereco = input('Digite seu novo endereço:')
            objeto_cliente.contato = input('Digite seu novo contato:')

            cursor.execute(f'UPDATE cliente SET nome_cliente = "{objeto_cliente.nome}", email_cliente = "{objeto_cliente.email}", senha_cliente = "{objeto_cliente.senha}", endereco = "{objeto_cliente.endereco}", contato = "{objeto_cliente.contato}" WHERE cpf = "{objeto_cliente.cpf}"')
            conexao.commit()
            print('Dados atualizados com sucesso!')

        else:
            print('Operação cancelada')
            return None

    except mysql.connector.Error as err:
        print(err)
        return None


def removerContaCliente(objeto_cliente, cursor, conexao):
    try:
        print('Deseja remover sua conta? (1)-Sim (0)-Não')
        if (input() == '1'):
            cursor.execute(f'DELETE FROM cliente WHERE cpf = "{objeto_cliente.cpf}"')
            conexao.commit()
            print('Conta removida com sucesso!')
        else:
            print('Operação cancelada')
            return None
    except mysql.connector.Error as err:
        print(err)
        return None

def listarClientes(cursor):
    try:
        cursor.execute('SELECT * FROM cliente')
        resultado = cursor.fetchall()
        for cliente in resultado:
            print(f'Nome: {cliente[0]}\tCPF: {cliente[1]}\tEmail: {cliente[2]}\tSenha: {cliente[3]}\tEndereço: {cliente[4]}\tContato: {cliente[5]}\n')
    except mysql.connector.Error as err:
        print(err)
        return None
    
def buscarCliente(cursor, conexao):
    try:
        cpf = input('Digite o CPF do cliente: ')
        cursor.execute(f'SELECT * FROM cliente WHERE cpf = "{cpf}"')
        resultado = cursor.fetchone()
        if resultado is None:
            print('Cliente não encontrado!')
            return None
        else:
            cliente = Cliente(resultado[0], resultado[1], resultado[2], resultado[3], resultado[4], resultado[5])
            return cliente
    except mysql.connector.Error as err:
        print(err)
        return None

def removerCliente(cursor, conexao):
    try:
        print('Clientes cadastrados no sistema:')
        listarClientes(cursor)
        cpf = input('Digite o CPF do cliente que deseja remover: (0)-Cancelar')
        if cpf == '0':
            print('Operação cancelada')
            return None
        else:
            cursor.execute(f'SELECT * FROM cliente WHERE cpf = "{cpf}"')
            resultado = cursor.fetchone()
            if resultado is None:
                print('Cliente não encontrado!')
                return None
            else:
                cursor.execute(f'DELETE FROM cliente WHERE cpf = "{cpf}"')
                conexao.commit()
                print('Cliente removido com sucesso!')
    except mysql.connector.Error as err:
        print(err)
        return None

# Funções do Gerente ###########################################################
def cadastroGerente(cursor, conexao):
    try:
        nome = input('Digite seu nome: ')
        email = input('Digite seu email: ')
        senha = input('Digite sua senha: ')

        cursor.execute(f'SELECT * FROM gerente WHERE email_gerente = "{email}"')
        if cursor.fetchone() is not None:
            print('Email já cadastrado!')
            return
        else:
            cursor.execute(f'INSERT INTO gerente (nome_gerente, email_gerente, senha_gerente) VALUES ("{nome}", "{email}", "{senha}")')
            conexao.commit()
            print('Gerente cadastrado com sucesso!')

    except mysql.connector.Error as err:
        print(err)
        return None


def loginGerente(cursor):
    try:
        email = input('Digite seu Email: ')
        senha = input('Digite sua Senha: ')
        cursor.execute(f'SELECT * FROM gerente WHERE email_gerente = "{email}" AND senha_gerente = "{senha}"')
        
        resultado = cursor.fetchone()

        if resultado is None:
            print('Email ou senha incorretos!')
            return None
        else:
            gerente = Gerente(resultado[0], resultado[1], resultado[2], resultado[3])
            return gerente

    except mysql.connector.Error as erro:
        print(f"Erro ao buscar gerente: {erro}")
        return None

def atualizarContaGerente(objeto_gerente, cursor, conexao):
    try:
        print('Deseja atualizar seus dados? (1)-Sim (0)-Não')
        if (input() == '1'):
            objeto_gerente.nome = input('Digite seu novo nome:')
            objeto_gerente.email = input('Digite seu novo email:')
            objeto_gerente.senha = input('Digite sua nova senha:')

            cursor.execute(f'UPDATE gerente SET nome_gerente = "{objeto_gerente.nome}", email_gerente = "{objeto_gerente.email}", senha_gerente = "{objeto_gerente.senha}" WHERE email_gerente = "{objeto_gerente.email}"')
            conexao.commit()
            print('Dados atualizados com sucesso!')

        else:
            print('Operação cancelada')
            return None

    except mysql.connector.Error as err:
        print(err)
        return None

def removerContaGerente(objeto_gerente, cursor, conexao):
    try:
        print('Deseja remover sua conta? (1)-Sim (0)-Não')
        if (input() == '1'):
            cursor.execute(f'DELETE FROM gerente WHERE email_gerente = "{objeto_gerente.email}"')
            conexao.commit()
            print('Conta removida com sucesso!')
        else:
            print('Operação cancelada')
            return None
        
    except mysql.connector.Error as err:
        print(err)
        return None

def listarGerentes(cursor):
    try:
        cursor.execute('SELECT * FROM gerente')
        resultado = cursor.fetchall()
        for gerente in resultado:
            print(f'ID: {gerente[0]}\tNome: {gerente[1]}\tEmail: {gerente[2]}\tSenha: {gerente[3]}\n')
    except mysql.connector.Error as err:
        print(err)
        return None

# Funções do Funcionário ###########################################################
def cadastroFuncionario(cursor, conexao):
    try:
        nome = input('Digite o nome do novo funcioário: ')
        email = input('Digite o email do novo funcioário: ')
        contato = input('Digite o contato do novo funcioário: ')
        cargo = input('Digite o cargo do novo funcioário: ')
        salario = input('Digite o salário do novo funcioário: ')

        cursor.execute(f'SELECT * FROM funcionario WHERE email_funcionario = "{email}"')
        if cursor.fetchone() is not None:
            print('Email já cadastrado!')
            return
        else:
            cursor.execute(f'INSERT INTO funcionario (nome_funcionario, email_funcionario, contato_funcionario, cargo, salario) VALUES ("{nome}", "{email}", "{contato}", "{cargo}", "{salario}")')
            conexao.commit()
            print('Funcionário cadastrado com sucesso!')
    except mysql.connector.Error as err:
        print(err)
        return None


def atualizarFuncionario(cursor, conexao):
    try:
        print('Funcionários cadastrados no sistema:')
        listarFuncionarios(cursor, conexao)
        id = input('Digite o ID do funcionário que deseja atualizar: (0)-Cancelar')
        if id == '0':
            print('Operação cancelada')
            return None
        else:
            cursor.execute(f'SELECT * FROM funcionario WHERE id_funcionario = "{id}"')
            resultado = cursor.fetchone()
            if resultado is None:
                print('Funcionário não encontrado!')
                return None
            else:
                print('Deseja atualizar os dados do funcionário? (1)-Sim (0)-Não')
                if (input() == '1'):
                    cargo = input('Digite o novo cargo do funcionário: ')
                    salario = input('Digite o novo salário do funcionário: ')

                    cursor.execute(f'UPDATE funcionario SET cargo = "{cargo}", salario = "{salario}" WHERE id_funcionario = "{id}"')
                    conexao.commit()
                    print('Dados atualizados com sucesso!')
                else:
                    print('Operação cancelada')
                    return None
    except mysql.connector.Error as err:
        print(err)
        return None

def removerFuncionario(cursor, conexao):
    try:
        print('Funcionários cadastrados no sistema:')
        listarFuncionarios(cursor, conexao)
        id = input('Digite o ID do funcionário que deseja remover: (0)-Cancelar')
        if id == '0':
            print('Operação cancelada')
            return None
        else:
            cursor.execute(f'SELECT * FROM funcionario WHERE id_funcionario = "{id}"')
            resultado = cursor.fetchone()
            if resultado is None:
                print('Funcionário não encontrado!')
                return None
            else:
                print('Deseja remover o funcionário? (1)-Sim (0)-Não')
                if (input() == '1'):
                    cursor.execute(f'DELETE FROM funcionario WHERE id_funcionario = "{id}"')
                    conexao.commit()
                    print('Funcionário removido com sucesso!')
                else:
                    print('Operação cancelada')
                    return None
    except mysql.connector.Error as err:
        print(err)
        return None

def listarFuncionarios(cursor):
    try:
        cursor.execute('SELECT * FROM funcionario')
        resultado = cursor.fetchall()
        for funcionario in resultado:
            print(f'ID: {funcionario[0]}\tNome: {funcionario[1]}\tEmail: {funcionario[2]}\tContato: {funcionario[3]}\tCargo: {funcionario[4]}\tSalário: {funcionario[5]}\n')
    except mysql.connector.Error as err:
        print(err)
        return None

# Funções do Produto ###########################################################
def cadastroProduto(cursor, conexao):
    try:
        nome = input('Nome do produto: ')
        descricao = input('Descrição do produto: ')
        preco = input('Preço do produto: ')
        cursor.execute(f'INSERT INTO produto (nome_produto, descricao, preco) VALUES ("{nome}", "{descricao}", "{preco}");')
        conexao.commit()
        cursor.execute(f'SELECT LAST_INSERT_ID();')
        id_produto = cursor.fetchone()

        quantidade = input('Quantos ingredientes esse produto leva? ')
        if quantidade.isdigit():
            quantidade = int(quantidade)
            for i in range(0, quantidade):
                ingrediente = input('Digite o nome do ingrediente: ')
                quantidadeUtilizada = input('Digite a quantidade do ingrediente: ')
                cursor.execute(f'SELECT * FROM ingrediente WHERE nome_ingrediente = "{ingrediente}"')
                resultado = cursor.fetchone()
                if resultado is None:
                    unidadeMedida = input('Digite a unidade de medida do ingrediente: ')
                    cursor.execute(f'INSERT INTO ingrediente (nome_ingrediente, estoque, unidade_medida) VALUES ("{ingrediente}", "0", "{unidadeMedida}")')
                    conexao.commit()
                    cursor.execute(f'SELECT LAST_INSERT_ID()')
                    id_ingrediente = cursor.fetchone()
                    produtoIngrediente1 = ProdutoIngrediente(id_produto, id_ingrediente, quantidadeUtilizada)
                    cursor.execute(f'INSERT INTO produto_ingrediente (id_produto, id_ingrediente, quantidade_usada) VALUES ("{produtoIngrediente1.produto_id}", "{produtoIngrediente1.ingrediente_id}", "{produtoIngrediente1.quantidade_usada}");')
                    conexao.commit()
                    i += 1
                else:
                    ingrediente = Ingrediente(resultado[0], resultado[1], resultado[2], resultado[3])
                    produtoIngrediente2 = ProdutoIngrediente(id_produto, id_ingrediente, quantidadeUtilizada)
                    cursor.execute(f'INSERT INTO produto_ingrediente (id_produto, id_ingrediente, quantidade_usada) VALUES ("{produtoIngrediente2.produto_id}", "{produtoIngrediente2.ingrediente_id}", "{produtoIngrediente2.quantidade_usada}");')
                    conexao.commit()
                    i += 1
        else:
            print('Valor inválido!')
            return None
    except mysql.connector.Error as err:
        print(err)
        return None

def atualizarProduto(cursor, conexao):
    try:
        print('Produtos cadastrados no sistema: ')
        listarProdutos(cursor)
        id = input('Digite o ID do produto que deseja atualizar: (0)-Cancelar')
        if id == '0':
            print('Operação cancelada')
            return None
        else:
            cursor.execute(f'SELECT * FROM produto WHERE id_produto = "{id}"')
            resultado = cursor.fetchone()
            if resultado is None:
                print('Produto não encontrado!')
                return None
            else:
                print('Deseja atualizar os dados do produto? (1)-Sim (0)-Não')
                if (input() == '1'):
                    nome = input('Digite o novo nome do produto: ')
                    descricao = input('Digite a nova descrição do produto: ')
                    preco = input('Digite o novo preço do produto: ')
                    cursor.execute(f'UPDATE produto SET nome_produto = "{nome}", descricao = "{descricao}", preco = "{preco}" WHERE id_produto = "{id}"')
                    conexao.commit()
                    print('Dados atualizados com sucesso!')
                else:
                    print('Operação cancelada')
                    return None
    except mysql.connector.Error as err:
        print(err)
        return None

def removerProduto(cursor, conexao):
    try:
        print('Produtos cadastrados no sistema:')
        listarProdutos(cursor, conexao)
        id = input('Digite o ID do produto que deseja remover: (0)-Cancelar')
        if id == '0':
            print('Operação cancelada')
            return None
        else:
            cursor.execute(f'SELECT * FROM produto WHERE id_produto = "{id}"')
            resultado = cursor.fetchone()
            if resultado is None:
                print('Produto não encontrado!')
                return None
            else:
                print('Deseja remover o produto? (1)-Sim (0)-Não')
                if (input() == '1'):
                    cursor.execute(f'DELETE FROM compra WHERE id_produto = "{id}"')
                    cursor.execute(f'DELETE FROM produto_ingrediente WHERE id_produto = "{id}"')
                    cursor.execute(f'DELETE FROM produto WHERE id_produto = "{id}"')
                    conexao.commit()
                    print('Produto removido com sucesso!')
                else:
                    print('Operação cancelada')
                    return None
    except mysql.connector.Error as err:
        print(err)
        return None

def listarProdutos(cursor):
    try:
        cursor.execute('SELECT * FROM produto')
        resultado = cursor.fetchall()
        for produto in resultado:
            print(f'ID: {produto[0]}\tNome: {produto[1]}\tDescrição: {produto[2]}\tPreço: {produto[3]}\n')
    except mysql.connector.Error as err:
        print(err)
        return None

def buscarProduto(cursor):
    try:
        id = input('Digite o ID do produto: ')
        cursor.execute(f'SELECT * FROM produto WHERE id_produto = "{id}"')
        resultado = cursor.fetchone()
        if resultado is None:
            print('Produto não encontrado!')
            return None
        else:
            produto = Produto(resultado[0], resultado[1], resultado[2], resultado[3])
            print(f'ID: {produto.produto_id}\tNome: {produto.nome}\tDescrição: {produto.descricao}\tPreço: {produto.preco}\n')
            return produto
    except mysql.connector.Error as err:
        print(err)
        return None

# Funções do Fornecedor ###########################################################
def cadastroFornecedor(cursor, conexao):
    try:
        nome = input('Digite o nome do fornecedor: ')
        cnpj = input('Digite o CNPJ do fornecedor: ')
        email = input('Digite o E-Mail do fornecedor: ')
        contato = input('Digite o contato do fornecedor: ')
        local = input('Digite o local de origem do fornecedor: ')

        cursor.execute(f'SELECT * FROM fornecedor WHERE cnpj = "{cnpj}"')
        if cursor.fetchone() is not None:
            print('CNPJ já cadastrado!')
            return
        else:
            fornecedor = Fornecedor(cnpj, nome, contato, email, local)
            cursor.execute(f'INSER INTO fornecedor (cnpj, nome_fornecedor, email_fornecedor, contato_fornecedor, local_fornecedor) VALUES ("{fornecedor.cnpj}", "{fornecedor.nome_fornecedor}", "{fornecedor.email_fornecedor}", "{fornecedor.contato_fornecedor}", "{fornecedor.local}")')
            conexao.commit()
            print('Fornecedor cadastrado com sucesso!')
    except mysql.connector.Error as err:
        print(err)
        return None

def listarFornecedores(cursor):
    try:
        cursor.execute('SELECT * FROM fornecedor')
        resultado = cursor.fetchall()
        for fornecedor in resultado:
            print(f'CNPJ: {fornecedor[0]}\tNome: {fornecedor[1]}\tE-Mail: {fornecedor[2]}\tContato: {fornecedor[3]}\tLocal: {fornecedor[4]}\n')
    except mysql.connector.Error as err:
        print(err)
        return None

def compraIngrediente(cursor, conexao):
    try:
        print('Fornecedores cadastrados no sistema: ')
        listarFornecedores()
        nomeFornecedor = input('Digite o nome do fornecedor que deseja fazer uma compra: ')
        cursor.execute(f'SELECT * FROM fornecedor WHERE nome_fornecedor = "{nomeFornecedor}"')
        resultadoFornecedor = cursor.fetchone()
        if resultadoFornecedor is not None:
            fornecedor = Fornecedor(resultadoFornecedor[0], resultadoFornecedor[1], resultadoFornecedor[2], resultadoFornecedor[3], resultadoFornecedor[4])
            dataCompra = input('Digite a data da compra: ')
            quantidadeIngrediente = input('Digite a quantidade de ingredientes que deseja comprar: ')
            for i in range(0, int(quantidadeIngrediente())):
                nomeIngrediente = input('Digite o nome do ingrediente: ')
                cursor.execute(f'SELECT * FROM ingrediente WHERE nome_ingrediente = "{nomeIngrediente}"')
                resultadoIngrediente = cursor.fetchone()
                if resultadoIngrediente is None: 
                    unidadeMedida = input('Digite a Unidade de medida desse ingrediente: ')
                    quantidadeComprada = input("Digite a quantidade que deseja comprar desse ingrediente: ")
                    preco = input('Digite o preço pago por essa compra: ')
                    cursor.execute(f'INSERT INTO ingrediente (nome_ingrediente, estoque, unidade_medida) VALUES ("{nomeIngrediente}", "{quantidadeComprada}", "{unidadeMedida}")')
                    conexao.commit()
                    cursor.execute("SELECT LAST_INSERT_ID()")
                    id_inserido = cursor.fetchone()
                    forneceIngrediente = ForneceIngrediente(fornecedor.cnpj, id_inserido, preco, dataCompra, quantidadeComprada)
                    cursor.execute(f'INSERT INTO fornece_ingrediente (id_fornecedor, id_ingrediente, preco_compra, data_compra, quantidade_fornecida) VALUES ("{forneceIngrediente.fornecedor_id}", "{forneceIngrediente.ingrediente_id}")')
                    conexao.commit()
                    i += 1
                else:
                    ingrediente = Ingrediente(resultadoIngrediente[0], resultadoIngrediente[1], resultadoIngrediente[2], resultadoIngrediente[3])
                    quantidadeComprada = input("Digite a quantidade que deseja comprar desse ingrediente: ")
                    preco = input('Digite o preço pago por essa compra: ')
                    forneceIngrediente = ForneceIngrediente(fornecedor.cnpj, ingrediente.ingrediente_id , preco, dataCompra, quantidadeComprada)
                    cursor.execute(f'UPDATE ingrediente SET estoque = "{ingrediente.estoque + forneceIngrediente.quantidade_fornecida}" WHERE id_ingrediente = "{ingrediente.ingrediente_id}";')
                    cursor.execute(f'INSERT INTO fornece_ingrediente (id_fornecedor, id_ingrediente, preco_compra, data_compra, quantidade_fornecida) VALUES ("{forneceIngrediente.fornecedor_id}", "{forneceIngrediente.ingrediente_id}");')
                    conexao.commit()
                    i += 1
        else:
            print('Fornecedor não encontrado.')
            return    
    except mysql.connector.Error as err:
        print(err)
        return None

def listarEstoque(cursor, conexao):
    try:
        cursor.execute('SELECT * FROM ingrediente')
        resultado = cursor.fetchall()
        for ingrediente in resultado:
            print(f'ID: {ingrediente[0]}\tNome: {ingrediente[1]}\tUnidade de medida: {ingrediente[3]}\tEstoque: {ingrediente[2]}\n')
    except mysql.connector.Error as err:
        print(err)
        return None

# Funções do Pedido ###########################################################
def fazerPedido(objeto_cliente, cursor, conexao):
    try:
        input('Deseja fazer um pedido? (1)-Sim (0)-Não')
        if input() == '0':
            print('Operação cancelada')
            return None
        else:
            valor_total = 0
            cursor.execute(f'INSERT INTO pedido (cliente_cpf, status, valor_total) VALUES ("{objeto_cliente.cpf}", "Em Andamento", "{valor_total}")')
            conexao.commit()
            cursor.execute(f'SELECT LAST_INSERT_ID()')
            id_pedido = cursor.fetchone()
            pedido = Pedido(id_pedido, objeto_cliente.cpf, 'Em Andamento', valor_total)
            print('Produtos disponíveis no sistema: ')
            listarProdutos(cursor)
            while True:
                id_produto = input('Digite o ID do produto que deseja comprar: ')
                cursor.execute(f'SELECT * FROM produto WHERE id_produto = "{id_produto}"')
                resultado = cursor.fetchone()
                if resultado is None:
                    print('Produto não encontrado!')
                    return None
                else:
                    produto = Produto(resultado[0], resultado[1], resultado[2], resultado[3])
                    quantidade_comprada = input('Digite a quantidade que deseja comprar: ')
                    valor_compra = produto.preco * quantidade_comprada   
                    compra = Compra(id_pedido, id_produto, quantidade_comprada)
                    cursor.execute(f'INSERT INTO compra (id_pedido, id_produto, quantidade_comprada) VALUES ("{compra.pedido_id}", "{compra.produto_id}", "{compra.quantidade_comprada}")')
                    conexao.commit()
                    input('Deseja continuar comprando? (1)-Sim (0)-Não')
                    if input() == '0':
                        pedido.status = 'Finalizado'
                        cursor.execute(f'UPDATE pedido SET status ="{pedido.status}" , "valor_total = "{valor_total + valor_compra}" WHERE id_pedido = "{id_pedido}"')
                        conexao.commit()
                        print('Pedido realizado com sucesso!')
                        break
                    else:
                        cursor.execute(f'UPDATE pedido SET valor_total = "{valor_total + valor_compra}" WHERE id_pedido = "{id_pedido}"')
                        conexao.commit()
                        print('Produto adicionado ao pedido com sucesso!')
    except mysql.connector.Error as err:
        print(err)
        return None

def atualizarPedido(cursor, conexao):
    try:
        print('Lista de pedidos: ')
        listarPedidos(cursor, conexao)
        id_pedido = input('Digite o ID do pedido que deseja atualizar: (0)-Cancelar Operação')
        if id_pedido == '0':
            print('Operação cancelada')
            return None
        else:
            cursor.execute(f'SELECT * FROM pedido WHERE id_pedido = "{id_pedido}"')
            resultado = cursor.fetchone()
            if resultado is None:
                print('Pedido não encontrado!')
                return None
            else:
                print('Deseja atualizar o status do pedido? (1)-Sim (0)-Não')
                if input() == '1':
                    status = input('Digite o novo status do pedido: ')
                    cursor.execute(f'UPDATE pedido SET status_pedido = "{status}" WHERE id_pedido = "{id_pedido}"')
                    conexao.commit()
                    print('Status do pedido atualizado com sucesso!')
                else:
                    print('Operação cancelada')
                    return None
    except mysql.connector.Error as err:
        print(err)
        return None

def cancelarPedido(objeto_cliente, cursor, conexao):
    try:
        print('Lista de pedidos feita por você: ')
        listarPedidosPorCliente(objeto_cliente, cursor, conexao)
        id_pedido = input('Digite o ID do pedido que deseja cancelar: (0)-Cancelar Operação')
        if id_pedido == '0':
            print('Operação cancelada')
            return None
        else:
            cursor.execute(f'SELECT * FROM pedido WHERE id_pedido = "{id_pedido}"')
            resultado = cursor.fetchone()
            if resultado is None:
                print('Pedido não encontrado!')
                return None
            else:
                print('Deseja cancelar o pedido? (1)-Sim (0)-Não')
                if input() == '1':
                    cursor.execute(f'UPDATE pedido SET status_pedido = "Cancelado" WHERE id_pedido = "{id_pedido}"')
                    conexao.commit()
                    print('Pedido cancelado com sucesso!')
                else:
                    print('Operação cancelada')
                    return None
    except mysql.connector.Error as err:
        print(err)
        return None

def listarPedidos(cursor):
    try:
        cursor.execute('SELECT * FROM pedido')
        resultado = cursor.fetchall()
        for pedido in resultado:
            print(f'ID: {pedido[0]}\tCPF do cliente: {pedido[1]}\tStatus: {pedido[2]}\tValor total: {pedido[3]}\n')
    except mysql.connector.Error as err:
        print(err)
        return None

def listarPedidosPorCliente(objeto_cliente, cursor):
    try:
        cursor.execute(f'SELECT * FROM pedido WHERE cliente_cpf = "{objeto_cliente.cpf}"')
        resultado = cursor.fetchall()
        for pedido in resultado:
            print(f'ID: {pedido[0]}\tCPF do cliente: {pedido[1]}\tStatus: {pedido[2]}\tValor total: {pedido[3]}\n')
    except mysql.connector.Error as err:
        print(err)
        return None

def buscarPedido(cursor):
    try:
        id_pedido = input('Digite o ID do pedido: ')
        cursor.execute(f'SELECT * FROM pedido WHERE id_pedido = "{id_pedido}"')
        resultado = cursor.fetchone()
        if resultado is None:
            print('Pedido não encontrado!')
            return None
        else:
            pedido = Pedido(resultado[0], resultado[1], resultado[2], resultado[3])
            print(f'ID: {pedido.pedido_id}\tCPF do cliente: {pedido.cliente_cpf}\tStatus: {pedido.status}\tValor total: {pedido.valor_total}\n')
            return pedido
    except mysql.connector.Error as err:
        print(err)
        return None