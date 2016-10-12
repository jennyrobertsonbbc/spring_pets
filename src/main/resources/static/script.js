console.log("test");

$(document).ready(function(){
    $("p").click(function(){
        $(this).hide();
    });


     $.get("http://localhost:8080/pets", function(data) {
          $.each(data, function(i, pet) {

                        $("#container").append(
            '<div class="showPet">'+

           '<div class="petColumnLeft">'+
                '<img class="petImage" src=""/>'+
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
                    });

                });
});


