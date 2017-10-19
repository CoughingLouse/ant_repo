<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    </head>
    <body>
        <h3>Benvenuto Specifica i dati del tuo videogioco</h3>
        <form:form method="POST" action="http://localhost:10001/addGame" modelAttribute="gioco">
             <table>
                <tr>
                    <td><form:label path="nome">Nome</form:label></td>
                    <td><form:input path="nome"/></td>
                </tr>
                <tr>
                    <td><form:label path="anno">Anno</form:label></td>
                    <td><form:input path="anno"/></td>
                </tr>
                <!--  <tr>
                    <td><form:label path="developer">Developer</form:label></td>
                    <td><form:input path="developer"/></td>
                </tr> -->
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>