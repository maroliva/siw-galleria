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
                    '<img class="img-responsive" src="/pictures/'+v.id+'" alt=""/>' +
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
}


/**
 * Listner per la modal
 */
$(document).ready(function() {
    $('#myModal').on('show.bs.modal', function(e) {

        var $modal = $(this),
            esseyId = e.relatedTarget.id;


        $modal.find('.modal-body').html("<h1>"+esseyId+"</h1>");


    })
});

