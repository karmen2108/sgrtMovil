<?php

	$usu = $_REQUEST['usu'];
	$pas = $_REQUEST['pas'];
	
	$cnx=new PDO("mysql:host=localhost;dbname=prueba","root","");
	$res=$cnx->query("select * from usuarios where usuario='$usu' and contrasenia='$pas'");
	
	$datos = array();
	foreach ($res as $row){
		$datos[]=$row;
		
	}
	
	echo json_encode($datos);
	


?>