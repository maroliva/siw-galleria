/**
 * Created by marco on 12/06/2017.
 */


function updateList() {

    var $quadri = $('#quadri');
    $quadri.append('<li> Titolo: </li>');

    $.ajax({
        url: "/api/quadri",
        type: "GET",
        success: function(resultData) {
            $.each(resultData.data, function (k, v) {
                $quadri.append('<li> Titolo: '+ v.nome +' </li>');
            })
        }
    });
}


function main() {
    document.getElementById("test").innerHTML = "My First JavaScript";
}