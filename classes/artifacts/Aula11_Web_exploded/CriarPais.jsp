<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Criar Pais</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<c:import url="Menu.jsp" />
	
	<div id="main" class="container">
        <h3 class="page-header">Incluir Pais</h3>
        <form action="controller.do" method="post">
            <!-- area de campos do form -->
            <div id="fundo">
            <div class="container">
            <div class="row">
                <div class="form-group col-md-12">
                    <label for="nome" style=color:black>Pais</label>
                    <input type="text" class="form-control" name="nome" id="nome" required maxlength="100" placeholder="Brasil">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="populacao"style=color:black>populacao</label>
                    <input type="text" class="form-control" name="populacao" id="populacao" required maxlength="60" placeholder="166665">
                
                    </div>

                <div class="form-group col-md-6">
                 <label for="area"style=color:black;>area</label>
                    <input type="text" class="form-control" name="area" id="area" maxlength="15"  placeholder="1554.6555">
                </div>
            </div>
            </div>
            </div>
            <hr/>
            <div id="actions" class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary" name="command" value="CriarPais">Salvar</button>
                    <a href="index.jsp" class="btn btn-default">Cancelar</a>
                </div>
            </div>
            
        </form>
        
    </div>
</body>
</html>