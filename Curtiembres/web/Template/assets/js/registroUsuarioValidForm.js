function validarFormulario() {
    debugger;
    var name = $("#form1\\:inputName").val();
    var apellido = $("#form1\\:inputApellido").val();
    var email = $("#form1\\:inputEmail").val();
    var password = $("#form1\\:inputPassword").val();
    var password4 = $("#form1\\:inputPassword4").val();
    var city = $("#form1\\:inputCity").val();

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
