$(document).ready(function() {

    console.log("hello {0}".format("test"));

    populateAllPets();
    populateAllOwners();
    populateNewPetForm();


    //when form submitted
    $('#form').on('submit', function(e) {
        e.preventDefault();

        //make an array
        var valuesFromForm = {};
        //Save the values from the form in a named array
        $.each($('#form').serializeArray(), function(i, field) {
            valuesFromForm[field.name] = field.value;
        });

        //get request of the url to make a new pet
        $.get("http://localhost:8080/pets/new/" +
            +valuesFromForm.petOwnerId + "/" +
            valuesFromForm.petName + "/" +
            valuesFromForm.petAge + "/" +
            valuesFromForm.petHealth + "/" +
            valuesFromForm.petTypeId,
            function(data) {
                addNewPet(data);
            });
    });

    //when delete button clicked
    $("#contents").on("click", "button.delete_button", function() {
        var petId = $(this).parent().parent().find('.petId').html();
        console.log(petId);
        $(this).parent().parent().remove();

        $.get("http://localhost:8080/pets/" + petId + "/delete/");

    });
    //when feed button clicked
    $("#contents").on("click", "button#ham_button", function() {
        var buttonPressed = $(this);
        feedPet(buttonPressed, "ham");
    });
    $("#contents").on("click", "button#beef_button", function() {
        var buttonPressed = $(this);
        feedPet(buttonPressed, "beef");
    });
    $("#contents").on("click", "button#view_pets_button", function() {
        var buttonPressed = $(this);
        viewOwnersPets(buttonPressed);
    });



    $('#search').on('input', function(e) {
        var queryString = $(this).val();

        if (queryString.match(/[a-z]/i)) {
            $.get("http://localhost:8080/pets/search/" + $(this).val(),
                function(data) {
                    removeAllPets();
                    //with the json returned, add a new pet
                    $.each(data, function(i, pet) {
                        addNewPet(pet);
                    });

                });
        }
        else{
            removeAllPets();
            populateAllPets();
        }
    });



});

function feedPet(buttonPressed, food) {
    var newHealth;
    var petId = buttonPressed.parent().parent().find('.petId').html();
    var petHealthSlider = buttonPressed.parent().parent().find(".petHealthSliderInner");
    //do the thing
    $.get("http://localhost:8080/pets/" + petId + "/feed/1/" + food, function(data) {
        newHealth = data;
        console.log("newHealth: " + newHealth);
        petHealthSlider.css("width", newHealth + "%");
    });

}

function viewOwnersPets(buttonPressed) {
    var ownerId = buttonPressed.parent().parent().find('.ownerId').html();
    //do the thing
//    $.get("http://localhost:8080/pets/" + petId + "/feed/1/" + food, function(data) {
//        newHealth = data;
//        console.log("newHealth: " + newHealth);
//        petHealthSlider.css("width", newHealth + "%");
//    });

}

function addNewPet(pet) {

    imageSrc = pet.petType.name.toLowerCase();
    imageSrc = imageSrc.replace(/[^A-Z0-9]+/ig, '');
    imageSrc = "images/" + imageSrc + ".png"

    $("#petsDiv").prepend(
        '<div class="showPet">' +

        '<div class="petColumnLeft">' +
        '<img class="petImage" src="' + imageSrc + '"/>' +
        '</div>' +

        '<div class="petColumnMiddle">' +
        '<h2 class="petName">' + pet.name + '</h2>' +
        '<span class="petAge">' + pet.age + ' years old</span>' +
        '</div>' +

        '<div class="petColumnRight">' +
        '<span class="petOwner">Owned by ' + pet.owner.name + '</span><br>' +
        'Id: <span class="petId">' + pet.petId + '</span>' +

        '</div>' +

        '<div class="petRowBottom">' +
        '<button class="feed_button" id="ham_button">Ham</button>' +
        '<button class="feed_button" id="beef_button">Beef</button>' +
        '<button class="delete_button">X</button>' +

        '<div class="petHealthSlider">' +
        '<div class="petHealthSliderHearts"></div>' +

        '<div class="petHealthSliderInner" style="width:' + pet.health + '%"></div>' +

        '</div>' +

        ' </div>' +

        '</div><!-- show pet -->');
}

function addNewOwner(owner) {

//    imageSrc = pet.petType.name.toLowerCase();
//    imageSrc = imageSrc.replace(/[^A-Z0-9]+/ig, '');
//    imageSrc = "images/" + imageSrc + ".png"

    $("#ownersDiv").append(
            '<div class="showPet">'+

                '<div class="petColumnLeft">'+
                    '<img class="petImage" src="images/silhouette-female.jpg"/>'+
                '</div>'+

                '<div class="petColumnMiddle">'+
                    '<h2 class="petName">'+ owner.name  +'</h2>'+
                '</div>'+

               ' <div class="petColumnRight">'+
                   ' Id: <span class="ownerId">'+ owner.ownerId +' </span>'+
                '</div>'+

                '<div class="petRowBottom">'+
                  '  <button class="feed_button" id="view_pets_button">View Pets</button>'+
                 '   <button class="delete_button">x</button>'+
                '</div>'+
        '</div>'

        );
}

function populateAllPets(){
    //load in all the pets from database and display
    $.get("http://localhost:8080/pets", function(data) {
        $.each(data, function(i, pet) {
            addNewPet(pet);
        });
    });
}

function populateAllOwners(){
    //load in all the pets from database and display
    $.get("http://localhost:8080/owners", function(data) {
        $.each(data, function(i, owner) {
            addNewOwner(owner);
        });
    });
}


function populateNewPetForm(){
    //load in all the petTypes from database and display
    $.get("http://localhost:8080/pets/types", function(data) {
        $.each(data, function(i, petType) {

        //to camel case
        var petTypeString = petType.name;
        var re = /(\b[a-z](?!\s))/g;
        petTypeString = petTypeString.replace(re, function(x){return x.toUpperCase();});


            $("#petTypeId_container").append(
                "<option value='" + petType.id + "'>" + petTypeString + "</option>"

            );
        });
    });

    $.get("http://localhost:8080/owners", function(data) {
        $.each(data, function(i, owner) {
            $("#owner_option_container").append(
                "<option value='" + owner.ownerId + "'>" + owner.name + "</option>"

            );
        });
    });

}


function removeAllPets(){
$("#petsDiv").empty();

}


String.prototype.format = function() {
    var content = this;
    for (var i = 0; i < arguments.length; i++) {
        var replacement = '{' + i + '}';
        content = content.replace(replacement, arguments[i]);
    }
    return content;
};