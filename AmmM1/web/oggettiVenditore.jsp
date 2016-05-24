<%-- 
    Document   : oggettiVenditore
    Created on : 25-apr-2016, 14.44.13
    Author     : carlo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>      
    <head>
        <title>I tuoi oggetti - La bottega del suono</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Carlo Cuccu" >
        <meta name="description" content="Vendita strumenti nuovi e usati - customer page" >
        <meta name="keywords" content="chitarre elettriche, chitarra acustica, bassi elettrici, bassi acustici, batterie acustiche,
              trombe, sax, custodia, jack">
        
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    
    <body>
        <div id="page">
            <div id="header">
                <div id="logo">
                    <h1>La bottega del suono</h1>
                </div>
            </div>
            
            <!-- Sezione di navigazione del sito -->
            <nav id="leftSidebar" class="normalLink">
                <h3>Sezioni</h3>
                <ul>
                    <li><a href="descrizione.html">Descrizione</a></li>
                    <li><a href="login.html">Login</a></li>
                    <c:if test="${loggedId == true}">
                        <li><a href="oggettiVenditore.html?logout=true">Logout</a></li>
                    </c:if>
                </ul>
            </nav>
            
            <!-- Esposizione annunci -->
            <div id="content" class="normalLink">
                
                <h2>I tuoi oggetti in vendita</h2>            
                
                <table>
                    
                    <tr class="intestazione">
                        <th>Oggetto</th>
                        <th>Foto</th>
                        <th>Quantità disponibile</th>
                        <th>Prezzo</th>
                        <th>ID</th>
                        <th>Gestisci</th>
                    </tr>
                  
                    <c:forEach var="oggetto" items="${listaOggetti}">
                                  
                        <tr>
                            <td>${oggetto.nome}</td>
                            <td> <img title="${oggetto.nome}"
                                      alt="${oggetto.nome}" src="${oggetto.urlImmagine}"
                                      width="150" height="150">
                            </td>
                            <td>${oggetto.quantita}</td>
                            <td>${oggetto.prezzo}</td>
                            <td>${oggetto.id}</td>
                            <td class="gestisciOggetto">
                                <a href="oggettiVenditore.html?act=m&idObj=${oggetto.id}">Modifica</a>
                                <a href="oggettiVenditore.html?act=r&idObj=${oggetto.id}">Rimuovi</a>
                            </td>
                        </tr>
                        
                    </c:forEach>
                                       
                   
                </table>
            </div>
            
            <div id="clear"></div>

           <div id="footer">
                    <ul>
                        <li id="fb"><a href="http://www.facebook.com"></a></li>
                        <li id="twitter"><a href="http://twitter.com/"></a></li>
                        <li id="youtube"><a href="http://www.youtube.com/"></a></li>
                    </ul>
            </div>
        </div>
    </body>
</html>
