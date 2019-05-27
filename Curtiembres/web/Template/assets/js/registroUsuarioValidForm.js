function validarFormulario() {

    var name = $("#inputName").val();
    var apellido = $("#inputApellido").val();
    var email = $("#inputEmail").val();
    var password = $("#inputPassword").val();
    var password4 = $("#inputPassword4").val();
    var city = $("#inputCity").val();
    
    if (name === ""){
        $("#nameError").html("Ingresa tus nombres" + " " + '<i class="fas fa-times"></i>');
    } else {
        $("#nameError").html("");
    }
    
    if (apellido === ""){
       $("#apellidoError").html("Ingresa tus apellidos" + " " + '<i class="fas fa-times"></i>');
    } else {
        $("#apellidoError").html("");
    }
    
    if (email === ""){
       $("#emailError").html("Ingresa tu correo electrónico" + " " + '<i class="fas fa-times"></i>');
    } else {
        $("#emailError").html("");
    }
    
    if (password === ""){
       $("#passError").html("Ingresa una contraseña" + " " + '<i class="fas fa-times"></i>');
    } else {
        $("#passError").html("");
    }
    
    if (password4 === ""){
       $("#pass2Error").html("Ingresa una contraseña" + " " + '<i class="fas fa-times"></i>');
    } else {
        $("#pass2Error").html("");
    }
    
    if (city === ""){
       $("#cityError").html("Ingresa tu ciudad donde vives" + " " + '<i class="fas fa-times"></i>');
    } else {
        $("#cityError").html("");
    }
}
