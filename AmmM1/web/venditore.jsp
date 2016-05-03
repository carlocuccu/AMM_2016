<%-- 
    Document   : Venditore
    Created on : 26-apr-2016, 11.38.45
    Author     : carlo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <!--
    To change this license header, choose License Headers in Project Properties.
    To change this template file, choose Tools | Templates
    and open the template in the editor.
    -->
    <html>
            <head>
                    <title>Vendi - La bottega del suono</title>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <meta name="author" content="Carlo Cuccu" >
                    <meta name="description" content="Vendita strumenti nuovi e usati - seller page" >
                    <meta name="keywords" content="chitarre elettriche, chitarra acustica, bassi elettrici, bassi acustici, batterie acustiche,
                          trombe, sax, custodia, jack">
                    <link rel="stylesheet" type="text/css" href="style.css" media="screen">
            </head>
            
            <body>
                <div id="page">
                    
                    <div id="header">           
                        <!-- Form per l'accesso al sito -->
                        
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
                                <li><a href="venditore.html?logout=true">Logout</a></li>
                            </c:if>
                        </ul>
                    </nav>

                    <!-- Form per l'inserimento di nuovi annunci -->
                    <div id="content">
                        <div class="formPosition">
                            
                            <c:if test="${loggedId == true}">
                                <h2>Benvenuto ${venditore.username}</h2>
                            </c:if>
                                                       
                            <h2>Inserisci l'oggetto da mettere in vendita</h2>
                            
                            <c:if test="${inputError != null}">
                                <p>${inputError}</p>
                            </c:if>
                            
                            <form action="venditore.html" method="get">
                                <label for="nomeOggetto">Nome oggetto</label>
                                <input type="text" name="nomeOggetto" id="nomeOggetto">

                                <label for="immagineOggetto">Inserisci URL dell'immagine</label>
                                <input type="text" name="immagineOggetto" id="immagineOggetto">

                                <label for="descrizioneOggetto">Descrizione</label>
                                <textarea rows="10" cols="20" name="descrizioneOggetto" id="descrizioneOggetto"></textarea>

                                <label for="prezzo">Prezzo</label>
                                <input type="number" step="0.1" name="prezzo" id="prezzo" min="0">

                                <label for="numeroOggetti">Quantità disponibile</label>
                                <input type="number" name="numeroOggetti" id="numeroOggetti" min="0">

                                <button type="submit" name="Submit">Invia</button>

                                <button type="reset">Azzera campi</button>
                            </form>
        
                        </div>
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

