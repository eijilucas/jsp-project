<%-- 
    Document   : resultadoAtualizar
    Created on : 30/05/2023, 16:01:01
    Author     : lucas
--%>

<%@page import="model.Cliente"%>
<%@page contentType="text/html"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
        <script src="script.js"></script>
        <title>Atualizar</title>
    </head>
    <body>

        <div class="form-container">

            <form action="Controle_Cliente" method="POST">

                <h1 align="center">Atualizar</h1>
                <% Cliente cli = (Cliente) request.getAttribute("cli"); %>
                    
                <div class="form-group">
                    <label for="id" class="form-label">Id:</label>
                    <input type="hidden" id="id" name="txtId" class="form-input" value="<%out.print(cli.getId());%>">
                </div>

                <div class="form-group">
                    <label for="idade" class="form-label">Idade:</label>
                    <input type="text" id="idade" name="txtIdade" class="form-input" value="<%out.print(cli.getIdade());%>">
                </div>

                <div class="form-group">
                    <label for="nome" class="form-label">Nome:</label>
                    <input type="text" id="nome" name="txtNome" class="form-input" value="<%out.print(cli.getNome());%>">
                </div>

                <div class="form-group">
                    <label for="cpf" class="form-label">Cpf:</label>
                    <input type="text" id="cpf" name="txtCpf" class="form-input" value="<%out.print(cli.getCpf());%>">
                </div>

                <div class="form-group">
                    <label for="dataNascimento" class="form-label">Data de nascimento:</label>
                    <input type="text" id="dataNascimento" name="txtDataNascimento" class="form-input" value="<%out.print(cli.getDataNascimento());%>">
                </div>

                <div class="form-group">
                    <label for="telefone" class="form-label">Telefone:</label>
                    <input type="text" id="telefone" name="txtTelefone" class="form-input" value="<%out.print(cli.getTelefone());%>">
                </div>

                <div class="form-group">
                    <label for="email" class="form-label">Email:</label>
                    <input type="text" id="email" name="txtEmail" class="form-input" value="<%out.print(cli.getEmail());%>">
                </div>

                <div class="form-group">
                    <label for="logradouro" class="form-label">Logradouro:</label>
                    <input type="text" id="logradouro" name="txtLogradouro" class="form-input" value="<%out.print(cli.getLogradouro());%>">
                </div>

                <div class="form-group">
                    <label for="cidade" class="form-label">Cidade:</label>
                    <input type="text" id="cidade" name="txtCidade" class="form-input" value="<%out.print(cli.getCidade());%>">
                </div>

                <div class="form-group">
                    <label for="estado" class="form-label">Estado:</label>
                    <input type="text" id="estado" name="txtEstado" class="form-input" value="<%out.print(cli.getEstado());%>">
                </div>

                <div class="form-button">
                    <button type="submit" value="EFETIVAR" name="op">EFETIVAR</button>
                </div>
                
            </form>

        </div>

        <style>
            button {
                margin-top: 1em;
                padding: 10px 20px;
                background-color: #4caf50;
                color: #fff;
                border: none;
                border-radius: 5px;
                font-size: 16px;
                cursor: pointer;
            }
            
            .container {
                margin: 100px auto;
                width: 400px;
                padding: 20px;
                border: 1px solid #ccc;
                border-radius: 5px;
                background-color: #f9f9f9;
                font-family: Arial, sans-serif;
                text-align: center;
            }

        </style>
    </body>
</html>
