console.log("test");

$(document).ready(function(){
    $("p").click(function(){
        $(this).hide();
    });


     $.get("http://localhost:8080/pets", function(data) {
          $.each(data, function(i, pet) {

                        $("body").append(
                            "<tr><td>" + pet.name + "</td>" +
                            "<td>" + pet.age + "</td>" +
                            "<td>" + pet.hunger + "</td></tr>");
                    });

                });
});