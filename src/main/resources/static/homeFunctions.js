/**
 * Created by marco on 12/06/2017.
 */


function getDataFromApi() {
    jQuery.ajax({
        url: "/rest/abc",
        type: "GET",

        contentType: 'application/json; charset=utf-8',
        success: function(resultData) {
            var listaQuadri = document.getElementById('lQ');
            $each(resultData.data, function (k, v) {
                var entry = document.createElement('li');
                entry.appendChild(document.createTextNode(v.titolo));
                listaQuadri.appendChild(entry);
            })


        },
        error : function(jqXHR, textStatus, errorThrown) {
        },

        timeout: 120000,
    });
}