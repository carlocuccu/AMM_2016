<%-- 
    Document   : listaOggettiJason  
    Created on : 1-giu-2016, 11.45.48
    Author     : Carlo
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<json:array>
    <c:forEach var="oggetto" items="${listaOggetti}">
        <json:object>
            <json:property name="nome" value="${oggetto.nome}"/>
            <json:property name="urlImmagine" value="${oggetto.urlImmagine}"/>
            <json:property name="quantita" value="${oggetto.quantita}"/>
            <json:property name="prezzo" value="${oggetto.prezzo}"/>
            <json:property name="idObj" value="${oggetto.id}"/>
        </json:object>
    </c:forEach>
</json:array>