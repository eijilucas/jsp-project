<%-- 
    Document   : resultado
    Created on : 30/05/2023, 15:58:44
    Author     : lucas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styleresultado.css">
        <title>Erro</title>
    </head>

    <body>
        <form action="Controle_Cliente" method="post">
            <div class="container">
                <h2>Resultado da operação</h2>
                <% String msg = (String) request.getAttribute("msg");%>
                <p>Erro! <%out.print(msg);%> não foi realizado!</p>
                <button name="op" value="REDIRECIONAR">Voltar ao início</button>
            </div>
        </form>
    </body>
</html>