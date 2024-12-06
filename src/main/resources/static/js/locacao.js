function buscarQuartosDisponiveis(){
    let checkin = $("#checkin").val();
    let checkout = $("#checkout").val();

    $.ajax({
        url: "/getQuartosDisponiveis",
        method: "POST",
        data: {
            checkin: checkin,
            checkout: checkout
        },
        success: function(response){
            $("#area_quartos").html(response);
        },
        error: function(){
            alert("Deu Ruim!");
        }
    });
}
$("#btnBuscarQuarto").click(buscarQuartosDisponiveis);

function atualizaValores(element){
    let option = $(element).find("option:selected");

    let preco = option.data('preco');
    let quantidadeCama = option.data('capacidadehospedes');

    $("#info_quarto").removeClass('d-none');
    $("#reservarQuarto").removeClass('d-none');
    $("#valor_quarto").text(preco);
    $("#capacidade_quarto").text(quantidadeCama);
}

function reservar(){
    let checkin = $("#checkin").val();
    let checkout = $("#checkout").val();
    let quarto = $("#quarto").find("option:selected").val();
    $.ajax({
        url: "/reservar",
        method: "post",
        data: {
            checkin: checkin,
            checkout: checkout,
            quarto: quarto
        },
        success: function(response){
            alert("Deu Bom!");
        },
        error: function(){
            alert("Deu Ruim!");
        }
    });
}

$("#reservarQuarto").click(reservar);