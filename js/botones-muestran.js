// JavaScript Document
function ocultarCrearEmpresa(){	var a = document.getElementById("seccion-crear-empresa").style.display="none";	
}
function mostrarCrearEmpresa(){
	ocultarSecciones();
	var a = document.getElementById("seccion-crear-empresa").style.display="block";	
}
function ocultarEmpresas(){
	var a = document.getElementById("seccion-empresas").style.display="none";	
}
function mostrarEmpresas(){
	ocultarSecciones();
	var a = document.getElementById("seccion-empresas").style.display="block";	
}
function mostrarInicio(){
	ocultarSecciones();
	var a = document.getElementById("seccion-inicio").style.display="block";	
}
function ocultarInicio(){
	var a = document.getElementById("seccion-inicio").style.display="none";	
}
function mostrarHistorial(){
	ocultarSecciones();
	var a = document.getElementById("seccion-historial").style.display="block";	
}
function ocultarHistorial(){
	var a = document.getElementById("seccion-historial").style.display="none";	
}
function mostrarContacto(){
	ocultarSecciones();
	var a = document.getElementById("seccion-contacto").style.display="block";	
}
function ocultarContacto(){
	var a = document.getElementById("seccion-contacto").style.display="none";	
}

function ocultarSeminarios(){
	var a = document.getElementById("seccion-seminarios").style.display="none";	
}
function mostrarSeminarios(){
	ocultarSecciones();
	var a = document.getElementById("seccion-seminarios").style.display="block";	
}
function main(){
	var b = document.getElementById("empresas").addEventListener("click",mostrarEmpresas,false);
	var b = document.getElementById("crear-empresa").addEventListener("click",mostrarCrearEmpresa,false);	
	var b = document.getElementById("seminarios").addEventListener("click",mostrarSeminarios,false);
	var b = document.getElementById("historial").addEventListener("click",mostrarHistorial,false);
	var b = document.getElementById("inicio").addEventListener("click",mostrarInicio,false);
	var b = document.getElementById("contacto").addEventListener("click",mostrarContacto,false);		
	ocultarSecciones();	
	mostrarInicio();
}
function ocultarSecciones(){
	ocultarCrearEmpresa();	
	ocultarEmpresas();
	ocultarSeminarios();
	ocultarInicio();
	ocultarHistorial();
	ocultarContacto();
}
window.addEventListener("load",main,false);