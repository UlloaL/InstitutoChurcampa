$(document).ready(function(){
    $('.tooltips-general').tooltip('hide');
    $('.mobile-menu-button').on('click', function(){
        var mobileMenu=$('.navbar-lateral');	
        if(mobileMenu.css('display')=='none'){
            mobileMenu.fadeIn(300);
        }else{
            mobileMenu.fadeOut(300);
        }
    });
    $('.dropdown-menu-button').on('click', function(){
        var dropMenu=$(this).next('ul');
        dropMenu.slideToggle('slow');
    });
    $('.exit-system-button').on('click', function(e){
        e.preventDefault();
        var LinkExitSystem=$(this).attr("data-href");
        swal({
            title: "¿Estás seguro?",
            text: "Quieres salir del sistema y cerrar la sesión actual",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#5cb85c",
            confirmButtonText: "Si, salir",
            cancelButtonText: "No, cancelar",
            animation: "slide-from-top",
            closeOnConfirm: false 
        },function(){
            window.location=LinkExitSystem; 
        });  
    });
    $('.search-book-button').click(function(e){
        e.preventDefault();
        var LinkSearchBook=$(this).attr("data-href");
        swal({
           title: "¿Qué estás buscando?",
           text: "Por favor escribe el nombre",
           type: "input",   
           showCancelButton: true,
           closeOnConfirm: false,
           animation: "slide-from-top",
           cancelButtonText: "Cancelar",
           confirmButtonText: "Buscar",
           confirmButtonColor: "#3598D9",
           inputPlaceholder: "Escribe aquí el nombre de lo que buscas" }, 
      function(inputValue){
           if (inputValue === false) return false;  

           if (inputValue === "") {
               swal.showInputError("Debes escribir el nombre de lo que buscas");     
               return false;   
           } 
            window.location=LinkSearchBook+"?bookName="+inputValue;
       });
    });
    $('.btn-help').on('click', function(){
        $('#ModalHelp').modal({
            show: true,
            backdrop: "static"
        });
    });      
    
    
    //solo se ejecuta cuando hay  un elemento de 'id=listarCarreras'
    if($('#listarCarreras').length){
    	ajaxGet();
    }
    if($('#listarModulos').length){
    	moduloAjaxGet();
    }
        
    
});
(function($){
    $(window).load(function(){
        $(".custom-scroll-containers").mCustomScrollbar({
            theme:"dark-thin",
            scrollbarPosition: "inside",
            autoHideScrollbar: true,
            scrollButtons:{ enable: true }
        });
    });
})(jQuery);


//Function ajax conecta con controlador ajax
function ajaxGet(){
	$.ajax({
		type : "GET",
		url : "/api/carreras/all",
		success: function(result){
			result.forEach(function(e){
				$('#listarCarreras').append("<option value='"+e.nombre+"'>"+e.nombre+"</option>");
			});
			
			console.log("success", result);
		},
		error : function(error) {
			console.log("success", error);
		}
	});	
}
function moduloAjaxGet(){
	$.ajax({
		type : "GET",
		url : "/modulos/all",
		success: function(result1){
			result1.forEach(function(ev){				
				$('#listarModulos').append("<option value='"+ev.nombre+"'>"+ev.nombre+"</option>");
			});
			
			console.log("success", result1);
		},
		error : function(error) {
			console.log("success", error);
		}
	});	
}


