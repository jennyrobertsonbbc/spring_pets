$(document).ready(function(){

    //load in all the pets from database and display
    $.get("http://localhost:8080/pets", function(data) {
        $.each(data, function(i, pet) {
            addNewPet(pet);
        });
    });

    //when form submitted
    $('#form').on('submit', function(e){
        e.preventDefault();

        //make an array
        var valuesFromForm = {};
        //Save the values from the form in a named array
        $.each($('#form').serializeArray(), function(i, field) {
            valuesFromForm[field.name] = field.value;
        });

        //get request of the url to make a new pet
        $.get("http://localhost:8080/pets/new/" +
            + valuesFromForm.petOwnerId + "/"
            + valuesFromForm.petName + "/"
            + valuesFromForm.petAge + "/"
            + valuesFromForm.petHealth + "/"
            + valuesFromForm.petTypeId
            ,function(data) {
                //with the json returned, add a new pet
                console.log(data);
                addNewPet(data);
        });
    });

        //when delete button clicked
        $("#contents").on("click", "button.delete_button", function(){
            var petName = $(this).parent().parent().find('.petName').html();
            console.log(petName);
            $(this).parent().parent().remove();

            $.get("http://localhost:8080/pets/"+ petName + "/delete/");

    });
//        //when feed button clicked
//        $("#contents").on("click", "button.feed_button", function(){
//            var petName = $(this).parent().parent().find('.petName').html();
//            console.log(petName);
//            $(this).parent().parent().remove();
//
//            $.get("http://localhost:8080/pets/" + petName + "/feed/1/beef");
//
//    });
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
                // '<span class="petHealth">health: ' + pet.health + '</span><br>'+
                '<span class="petId">Id: ' + pet.petId +'</span>'+

                '</div>'+

                '<div class="petRowBottom">'+
                '<button class="feed_button">Feed</button>'+
                '<button class="delete_button">X</button>'+

                '<div class="petHealthSlider">'+
                '<div class="petHealthSliderHearts"></div>'+

                '<div class="petHealthSliderInner" style="width:'+ pet.health + '%"></div>'+

                '</div>'+

                ' </div>'+

                '</div><!-- show pet -->');
}


