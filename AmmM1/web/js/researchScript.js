/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function ()
{
   $("#Filtra").keyup(function()
    {  
        // Preleva il valore
        var text = $("#Filtra").val();
       
        $.ajax(
        {
            url: "ClienteAjax",
            data:{
              cmd: "search",
              text: text
            },
            dataType: 'json',
            success : function(data, state){
                //Posso controllare il valore della barra di ricerca
                //in modo che quando non ho digitato nulla la funzione non venga eseguita????
                aggiornaListaOggetti(data);
            },
            error : function(data, state){
            }
        });
        
       // Funzione che viene richiamata in caso di successo
        function aggiornaListaOggetti(listaOggetti)
        {
            // Cancella la lista
            $("tr[class!='intestazione']").empty();
            
            // Per ogni oggetto trovato dal database
            for(var oggetto in listaOggetti)
            {
               $("#tabOggetti").append($("<tr>").append(
                       
                    "<td>" + listaOggetti[oggetto].nome + "</td>"
                  + "<td>" + "<img src='" + listaOggetti[oggetto].urlImmagine + "' " + ">" + "</td>"
                  + "<td>" + listaOggetti[oggetto].quantita + "</td>"
                  + "<td>" + listaOggetti[oggetto].prezzo + "</td>"
                  + "<td class='carrello'><a href='cliente.html?idObj="+ listaOggetti[oggetto].idObj + "'></a></td>"));
            }    
        }
    }); 
});