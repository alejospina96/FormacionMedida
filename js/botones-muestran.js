// JavaScript Document
function ocultarCrearEmpresa(){	var a = document.getElementById("seccionCrearEmpresa").style.display="none";	
}
function mostrarCrearEmpresa(){
	ocultarSecciones();
	var a = document.getElementById("seccionCrearEmpresa").style.display="block";	
}
function ocultarEmpresas(){
	var a = document.getElementById("seccion-empresas").style.display="none";	
}
function mostrarEmpresas(){
	ocultarSecciones();
	var a = document.getElementById("seccion-empresas").style.display="block";	
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
	ocultarSecciones();	
}
function ocultarSecciones(){
	ocultarCrearEmpresa();	
	ocultarEmpresas();
	ocultarSeminarios();
}
window.addEventListener("load",main,false);