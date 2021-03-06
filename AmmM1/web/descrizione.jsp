<%-- 
    Document   : descrizione
    Created on : 26-apr-2016, 11.31.26
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
        <title>La bottega del suono</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Carlo Cuccu" >
        <meta name="description" content="Vendita strumenti nuovi e usati - Description page" >
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
      
            
            <nav id="leftSidebar" class="normalLink">
                <h3>Sezioni</h3>

                <div id="sommario" class="normalLink">
                  <ul>
                        <!-- Link che rimanda alla pagina di login dove sarà possibile accedere alle varie sezioni del sito -->
                        <li><a href="login.html" id="login">Login</a></li>
                        <c:if test="${loggedId == true}">
                            <li><a href="descrizione.html?logout=true">Logout</a></li>
                        </c:if>
                        <!-- Collegamentii alle sezioni interne della pagina descrizione.html -->
                        <li><a href="#categorie">Categorie di strumenti</a></li>
                        <li><a href="#venditore">Istruzioni per i venditori</a></li>
                        <li><a href="#cliente">Instruzioni per i clienti</a></li>
                  </ul>
              </div>
                
            </nav>
        
            
            <!-- Sezione categorie e Sezione istruzioni per l'uso -->
            <div id="content"> 
                <h2 id="categorie">Categorie di strumenti</h2>
                <ol>
                    <li><h3>Strumenti a corde</h3>
                        <p>Chitarre, bassi, arpe, pianoforti...</p>
                    </li>

                    <li><h3>Strumenti a fiato</h3>
                        <p>Sax, trombe, clarinetti, flauti...</p>
                    </li>

                    <li><h3>Percussioni</h3>
                        <p>Batterie acustiche, batterie elettroniche, percussioni etniche, xilofoni...</p>
                    </li>

                    <li><h3>Strumenti entnici</h3>
                        <p>Cornamusa, didgeridoo, kazoo...</p>
                    </li>

                   <li><h3>Accessori</h3>
                        <p>Custodie, pletri, corde...</p>
                    </li>
                </ol>
           
                <h3 id="venditore">Sei un venditore?</h3>
                <p>Avrai la possibilità di controllare il saldo del tuo conto, inserire, modificare e rimuovere i tuoi oggetti in vendita.
                Ma la volpe col suo balzo ha raggiunto il quieto Fido. Quel vituperabile xenofobo zelante assaggia il whisky ed esclama: 
                alleluja! Aquel vituperable xenófobo apasionado prgüisqui y exclama: ¡Aleluya! Ma la volpe col suo balzo ha raggiunto il 
                Quel vituperabile xenofobo zelante assaggia il whisky ed esclama: alleluja!Aquel vituperable xenófobo apasionado prueba su 
                güisqui y exclama: ¡Aleluya! Ma la volpe 
                col suo balzo ha raggiunto il quieto Fido. Quel vituperabile xenofobo zelante assaggia il 
                whisky ed esclama: alleluja! Aquel vituperable xenófobo apasionado prueba su güisqui y 
                exclama: ¡Aleluya! Ma la volpe col suo balzo ha raggiunto il quieto Fido. Quel vituperabile 
                xenofobo zelante assaggia il whisky ed esclama: alleluja! Aquel vituperable xenófobo apasionado 
                prueba su güisqui y exclama: ¡Aleluya! Ma la volpe col suo balzo ha raggiunto il quieto Fido. 
                Quel vituperabile xenofobo zelante assaggia il whisky ed esclama: alleluja! Aquel vituperable 
                xenófobo apasionado prueba su güisqui y exclama: ¡Aleluya! Ma la volpe col suo balzo ha raggiunto 
                il quieto Fido. Quel vituperabile xenofobo zelante assaggia il whisky ed esclama: alleluja! 
                Aquel vituperable xenófobo apasionado prueba su güisqui y exclama: ¡Aleluya!Ma la volpe col suo 
                balzo ha raggiunto il quieto Fido. Quel vituperabile xenofobo </p>

                <h3 id="cliente">Sei un cliente?</h3>
                <p>Avrai la possibilità ricaricare il tuo saldo e procedere all’acquisto 
                   degli oggetti messi in vendita. Per poter acquistare è necessario essere registrati. 
                   Durante la consultazione del catalogo sarà possibile aggiungere al carrello
                   gli strumenti che si desidera acquistare tramite il tasto "Aggiungi al carrello"
                   riportato a destra di ogni annuncio.Li Europan lingues es membres del sam familie. 
                   Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa li 
                   sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu 
                   commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa 
                   continuar payar custosi traductores. At solmen va esser necessi far uniform grammatica, 
                   pronunciation e plu sommun paroles. Ma quande lingues coalesce, li grammatica del resultant 
                   lingue es plu simplic e regulari quam ti del coalescent lingues. Li nov lingua franca va esser 
                   plu simplic e regulari quam li existent Europan lingues. It va esser tam simplic quam 
                   Occidental in fact, it va esser Occidental. A un Angleso it va semblar un simplificat Angles, 
                   quam un skeptic Cambridge amico dit me que Occidental es.Li Europan lingues es membres del sam 
                   familie. Lor separat existentie es un myth. Por scientie, musica, sport etc, litot Europa usa 
                   li sam vocabular. Li lingues differe solmen in li grammatica, li pronunciation e li plu 
                   commun vocabules. Omnicos directe al desirabilite de un nov lingua franca: On refusa continuar 
                   payar custosi traductores. At solmen va esser necessi far uniform grammatica, pronunciation e 
                   plu sommun paroles. </p>
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

