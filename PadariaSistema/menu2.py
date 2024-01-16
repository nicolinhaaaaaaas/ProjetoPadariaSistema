import mysql.connector

from classes import Cliente
# Conectar ao banco de dados MySQL
conexao = mysql.connector.connect(
    host='localhost',
    user='root',
    password='55879276',
    database='projetoteste'
)
if conexao.is_connected:  
    # Criar um cursor
    cursor = conexao.cursor()

def cadastroCliente(cpf, nome, email, senha, telefone, endereco):
    try:
        cursor.execute(f'SELECT * FROM cliente WHERE cpf = {cpf}')
        if cursor.rowcount > 0:
            print('Cliente já cadastrado!')
        else:
            cursor.execute(f'INSERT INTO cliente (nome_cliente, cpf, email_cliente, senha_cliente, endereco, contato) VALUES({nome},{cpf},  {email}, {senha}, {endereco}, {telefone})')
            conexao.commit()
            print('Cliente cadastrado com sucesso!')
    except mysql.connector.Error as erro:
        print(f'Falha ao inserir cliente: {erro}')



def loginCliente(email, senha):
    try:
        emailCliente = email.get()
        senhaCliente = senha.get()
        cursor.execute(f'SELECT * FROM cliente WHERE email_cliente = {emailCliente} AND senha_cliente = {senhaCliente}')
        resultado = cursor.fetchone()
        if resultado != None:
            print('Login realizado com sucesso!')
            cliente = Cliente(resultado[0], resultado[1], resultado[2], resultado[3], resultado[4], resultado[5])
            return cliente
        else:
            print('Login ou senha incorretos!')
            return None
    except mysql.connector.Error as erro:
        print(f'Falha ao realizar login: {erro}')

def cadastroGerente():
    pass

def loginGerente():
    pass
