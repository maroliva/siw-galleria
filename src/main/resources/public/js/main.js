/**
 * Created by marco on 12/06/2017.
 */

/**
 * Crea uno spazio per ogni immagine
 */
function loadGallery() {
    var $gallery = $('#gallery_id');

    jQuery.ajax({
        url: "/api/quadri",
        type: "GET",
        success: function(resultData) {
            $.each(resultData, function (k,v) {
                console.log("quadro:" + v.nome);
                $gallery.append('' +
                    '<div class="col-lg-3 col-md-4 col-xs-6 thumb">' +
                    '<a class="thumbnail" role="button" href="#myModal" data-toggle="modal" id="'+ v.id +'">' +
                    '<img class="img-responsive" src="'+v.pictureUrl+'" alt=""/>' +
                    '</a>' +
                    '</div>');
            })
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.log("ERRORE:" + textStatus);
        },
        timeout: 120000
    });
}

/**
 * Scarica le informazioni da mettere nella modal
 * @param imageId
 */
function onImageClicked(imageId) {

}

/**
 * Rimuove tutte le immagini dalla gallery
 */
function clearGallery() {
    document.getElementById("gallery_id").innerHTML = '<div class="col-lg-12">' +
        '<h1 class="page-header">Thumbnail Gallery</h1>' +
        '</div>';

}


function onSearch() {
    console.log("Searched:" + document.getElementById('searchField_id').value);
    clearGallery();
    var keys = document.getElementById('searchField_id').value;

    var $gallery = $('#gallery_id');

    jQuery.ajax({
        url: "/api/search?key="+ keys.replace(/ /g,"+"),
        type: "GET",
        success: function(resultData) {
            $.each(resultData, function (k,v) {
                console.log("quadro:" + v.nome);
                $gallery.append('' +
                    '<div class="col-lg-3 col-md-4 col-xs-6 thumb">' +
                    '<a class="thumbnail" role="button" href="#myModal" data-toggle="modal" id="'+ v.id +'">' +
                    '<img class="img-responsive" src="'+v.pictureUrl+'" alt=""/>' +
                    '</a>' +
                    '</div>');
            })
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.log("ERRORE:" + textStatus);
        },
        timeout: 120000
    });

}


/**
 * Listner per la modal
 */
$(document).ready(function() {
    $('#myModal').on('show.bs.modal', function(e) {

        var $modal = $(this),
            quadroId = e.relatedTarget.id;
        jQuery.ajax({
            url: "/api/quadri/" + quadroId,
            type: "GET",
            success: function(resultData) {

                var quadro = resultData;
                console.log(quadro);

                $modal.find('.immagine').html('<img class="img-responsive" src="'+ quadro.pictureUrl + '" alt=""/>');

                $modal.find('.modal-title').html(quadro.nome);
                $modal.find('.anno-realizzazione').html('Anno realizzazione: ' + quadro.anno);
                $modal.find('.tecnica').html('Tecnica: ' + quadro.tecnica.nome);
                $modal.find('.altezza').html('Altezza: ' + quadro.altezza);
                $modal.find('.larghezza').html('Larghezza: ' + quadro.larghezza);
                var autore = quadro.autore;
                $modal.find('.nome-autore').html('Nome: ' + autore.nome);
                $modal.find('.cognome-autore').html('Cognome: ' + autore.cognome);
                $modal.find('.data-nascita').html('Nascita: '+ autore.dataDiNascita);
                $modal.find('.data-morte').html('Morte: ' + autore.dataDiMorte);
                var nazionalita = autore.nazione;
                $modal.find('.nazionalita').html('Nazionalita: ' + nazionalita.nomeNazione);



            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.log("ERRORE:" + textStatus);
            },
            timeout: 120000
        });


    })
});

