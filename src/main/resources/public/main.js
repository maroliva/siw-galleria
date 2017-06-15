/**
 * Created by marco on 12/06/2017.
 */


function updateList() {

    var $quadri = $('#quadri');

    jQuery.ajax({
        url: "/api/quadri",
        type: "GET",
        success: function(resultData) {
            $.each(resultData, function (k,v) {
                console.log("quadro:" + v.nome);
                $quadri.append('<li> Titolo: ' + v.nome + '</li>');
            })
        },
        error: function(jqXHR, textStatus, errorThrown) {
            console.log("ERRORE:" + textStatus);
        },
        timeout: 120000
    });
}


function loadImages() {

}

function onImageClicked(imageId) {

}

function onSearch() {
    console.log("Searched:" + document.getElementById('searchField_id').value);
}

function main() {
    document.getElementById("test").innerHTML = "My First JavaScript";
}