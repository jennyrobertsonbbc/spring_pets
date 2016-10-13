console.log("test");

$(document).ready(function(){
    $("p").click(function(){
        $(this).hide();
    });


    $('#form').on('submit', function(e){

        e.preventDefault();
        var values = {};
        $.each($('#form').serializeArray(), function(i, field) {
            values[field.name] = field.value;
        });
        console.log(values);


        $.get("http://localhost:8080/pets/new/" +
            + values.petOwnerId + "/"
            + values.petName + "/"
            + values.petAge + "/"
            + values.petHunger + "/"
            + values.petTypeId
            ,function(data) {

                addNewPet(data);
            });
    });

    $.get("http://localhost:8080/pets", function(data) {
      $.each(data, function(i, pet) {
        addNewPet(pet);
    });


  });
});

function addNewPet(pet){

    switch (pet.petTypeId){
        case 1:
        imageSrc = "images/guineapig.png";
        break;
        case 2:
        imageSrc = "images/cat.png";
        break;
        case 3:
        imageSrc = "images/pig.png";
        break;
        case 4:
        imageSrc = "images/dog.png";
        break;
    }

    $("#contents").prepend(
        '<div class="showPet">'+

        '<div class="petColumnLeft">'+
        '<img class="petImage" src="'+ imageSrc +'"/>'+
        '</div>'+

        '<div class="petColumnMiddle">'+
        '<h2 class="petName">' + pet.name + '</h2>'+
        '<span class="petAge">' + pet.age + ' years old</span>'+
        '</div>'+

        '<div class="petColumnRight">'+
        '<span class="petOwner">Owned by ' + pet.ownerId + '</span><br>'+
                // '<span class="petHunger">Hunger: ' + pet.hunger + '</span><br>'+
                '<span class="petId">Id: ' + pet.petId +'</span>'+

                '</div>'+

                '<div class="petRowBottom">'+
                '<button>Feed</button>'+

                '<div class="petHungerSlider">'+
                '<div class="petHungerSliderHearts"></div>'+

                '<div class="petHungerSliderInner" style="width:'+ pet.hunger + '%"></div>'+

                '</div>'+

                ' </div>'+

                '</div><!-- show pet -->');
}


