<?php 
	$host = "localhost";
	$user = "root";
	$pass = "testing-db";
	$db = "CRUD_Brg";
	$port = 3307;
	
	$koneksi = mysqli_connect($host,$user,$pass,$db,$port) or die ("Database MySQL tidak terkoneksi");
?>