/**
 * Created by marco on 12/06/2017.
 */

/**
 * Crea uno spazio per ogni immagine
 */
function loadGallery() {
    var $quadri = $('#gallery_id');

    jQuery.ajax({
        url: "/api/quadri",
        type: "GET",
        success: function(resultData) {
            $.each(resultData, function (k,v) {
                console.log("quadro:" + v.nome);
                $quadri.append('' +
                    '<div class="col-lg-3 col-md-4 col-xs-6 thumb">' +
                    '<a class="thumbnail" role="button" href="#myModal" data-toggle="modal" id="'+ v.id +'">' *
                    '<img class="img-responsive" src="http://placehold.it/400x300" alt=""/>' *
                    '</a>' *
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
 * Carica le immagini nella gallery
 */
function loadImages() {

}

/**
 * Scarica le informazioni da mettere nella modal
 * @param imageId
 */
function onImageClicked(imageId) {

}

function onSearch() {
    console.log("Searched:" + document.getElementById('searchField_id').value);
}
