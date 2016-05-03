<%-- 
    Document   : login
    Created on : 25-apr-2016, 12.53.19
    Author     : carlo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserimento - La bottega del suono</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Carlo Cuccu" >
        <meta name="description" content="Vendita strumenti nuovi e usati - Login page" >
        <meta name="keywords" content="chitarre elettriche, chitarra acustica, bassi elettrici, bassi acustici, batterie acustiche,
              trombe, sax, custodia, jack">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    
    
    <body>
         <div id="page">
            <header>
                <div id="header">           
                    <!-- Form per l'accesso al sito -->
                    
                    <div id="logo">
                        <h1>La bottega del suono</h1>
                    </div>
                </div> 
            </header>
                
                      
                <!-- Sezione di navigazione del sito -->
                <nav id="leftSidebar" class="normalLink">
                    <h3>Sezioni</h3>
                    <ul>
                        <li><a href="login.html" id="login">Login</a></li>
                        <li><a href="descrizione.html">Descrizione</a></li>
                        <li><a href="venditore.html">Venditore</a></li>
                        <li><a href="cliente.html">Cliente</a></li>
                    </ul>
                </nav>

                <div id="content">
                    <h2 class="contentMessage">Riepilogo dati dell'oggetto inserito</h2>
                    
                    <table>                
                            <tr>
                                <td class="leftColTable">Nome</td>
                                <td>${nuovoOggetto.nome}</td>
                            </tr>
                            
                            <tr>
                                <td class="leftColTable">Immagine</td>
                                <td>${nuovoOggetto.urlImmagine}</td>
                            </tr>
                            
                            <tr>
                                <td class="leftColTable">Descrizione</td>
                                <td>${nuovoOggetto.descrizione}</td>
                            </tr>
                            
                             <tr>
                                <td class="leftColTable">Prezzo</td>
                                <td>${nuovoOggetto.prezzo}</td>
                            </tr>
                            
                             <tr>
                                <td class="leftColTable">Quantità</td>
                                <td>${nuovoOggetto.quantita}</td>
                            </tr>                                              
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
