<%-- 
    Document   : resultadoBuscarId
    Created on : 30/05/2023, 16:01:35
    Author     : lucas
--%>

<%@page import="model.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="table.css">
        <title>Consultar por Id</title>
    </head>
    <body>

        <h1>Cliente</h1>
        <%
            Cliente cli = (Cliente) request.getAttribute("cli");
        %>
        <%if(cli.getNome() != null) {%>
        <form action="Controle_Cliente" method="post">
            <table border="1">
                <tr>
                    <th>Id</th>
                    <th>Idade</th>
                    <th>Nome</th>
                    <th>Cpf</th>
                    <th>Data de nascimento</th>
                    <th>Logradouro</th>
                    <th>Cidade</th>
                    <th>Estado</th>
                    <th>Email</th>
                    <th>Telefone</th>
                    <th>Lixeira</th>
                    <th>Editar</th>
                </tr>

                <tr>
                    <td><%out.print(cli.getId());%></td>
                    <td><%out.print(cli.getIdade());%></td>
                    <td><%out.print(cli.getNome());%></td>
                    <td><%out.print(cli.getCpf());%></td>
                    <td><%out.print(cli.getDataNascimento());%></td>
                    <td><%out.print(cli.getLogradouro());%></td>
                    <td><%out.print(cli.getCidade());%></td>
                    <td><%out.print(cli.getEstado());%></td>
                    <td><%out.print(cli.getEmail());%></td>
                    <td><%out.print(cli.getTelefone());%></td>
                    <td><a href="http://localhost:8084/ProjetoCliente/Controle_Cliente?txtId=<%out.print(cli.getId());%>&txtIdade=&txtNome=&txtLogradouro=&txtCidade=&txtEstado=&txtCpf=&txtTelefone=&txtEmail=&txtDataNascimento=&op=DELETAR"><img src="images/lixeira.png"></a></td>
                    <td><a href="http://localhost:8084/ProjetoCliente/Controle_Cliente?txtId=<%out.print(cli.getId());%>&txtIdade=&txtNome=&txtLogradouro=&txtCidade=&txtEstado=&txtCpf=&txtTelefone=&txtEmail=&txtDataNascimento=&op=ATUALIZAR"><img src="images/editar.png"></a></td>
                </tr>
            </table>
            <br>
            <button name="op" value="REDIRECIONAR">Voltar ao início</button>
        </form>
                <%}else {%>
                    <%String msg = "Buscar por id";%>
                    <%request.setAttribute("msg", msg);%>
                    <%request.getRequestDispatcher("erro.jsp").forward(request, response);%>
                <%}%>
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
        </style>
    </body>
</html>
