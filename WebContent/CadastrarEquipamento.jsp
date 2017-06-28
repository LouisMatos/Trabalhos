<%-- 
    Document   : CadastrarEquipamento
    Created on : 22/06/2017, 08:57:40
    Author     : Trabalho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Programa daora de POO</title>
        <link href="css/bootstrap.min.css" rel="stylesheet"></link>
        <link href="css/style.css" rel="stylesheet"></link>
    </head>
    <body>
        <form class="form-horizontal" action="FrontController?action=CadEquip" method="POST">
            <input type="hidden" name="HDNCAD" id="HDNCAD" value="1">
            <div class="container-fluid">
                <fieldset>

                    <!-- Form Name -->
                    <legend><a href="index.html">HOME</a></legend>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="NomeEquip">Nome do Equipamento:</label>  
                        <div class="col-md-4">
                            <input name="NomeEquip" class="form-control input-md" id="NomeEquip" type="text" placeholder="">

                        </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="TipoEquip">Tipo do Equipamento:</label>  
                        <div class="col-md-4">
                            <input name="TipoEquip" class="form-control input-md" id="TipoEquip" type="text" placeholder="">

                        </div>
                    </div>

                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="PesoEquip">Peso do Equipamento:</label>  
                        <div class="col-md-4">
                            <input name="PesoEquip" class="form-control input-md" id="PesoEquip" type="text" placeholder="">

                        </div>
                    </div>

                    <!-- Button -->
                    <div class="form-group">
                        <label class="col-md-4 control-label" for="Cadastrar"></label>
                        <div class="col-md-4" align="right">
                            <input name="Cadastrar" class="btn btn-success" id="Cadastrar" type="submit" value="Cadastrar">
                        </div>
                    </div>

                </fieldset>
            </div>
        </form>

    </body>
</html>
