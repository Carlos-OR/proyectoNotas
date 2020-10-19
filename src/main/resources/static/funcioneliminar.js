function eliminar (id){
    swal({
      title: "Estas seguro?",
      text: "No se podrá recuperar esta nota!",
      icon: "warning",
      buttons: true,
      dangerMode: true,
    })
    .then((OK) => {
      if (OK) {
        $.ajax({
            url:"/notas/eliminar/"+id,
            success: function(res){
                console.log(res);
            }
        });

        swal("Se ha eliminado la nota!", {
          icon: "success",
        }).then((ok) =>{
            if(ok){
                location.href="/notas";
            }
        });
      } else {
        swal("Your imaginary file is safe!");
      }
    });

}