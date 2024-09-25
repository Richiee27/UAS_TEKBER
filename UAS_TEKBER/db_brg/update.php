<?php 
	include "koneksi.php";
	$response=array();
	if($_SERVER['REQUEST_METHOD']=='POST'){
		$kd_brg = $_POST["kd_brg"];
		$nama_brg = $_POST["nama_brg"];
		$jumlah = $_POST["jumlah"];
		$harga = $_POST["harga"];
		
		$perintah = "UPDATE tbl_brg SET nama_brg='$nama_brg',jumlah='$jumlah',harga='$harga' WHERE kd_brg='$kd_brg'";
		$eksekusi = mysqli_query($koneksi,$perintah);
		$cek = mysqli_affected_rows($koneksi);
		if($cek>0){
			$response["kode"] = 1;
			$response["pesan"] = "Data berhasil di update";
		}else{
			$response["kode"] = 0;
			$response["pesan"] = "Data gagal di update";
		}
	}else{
		$response["kode"] = 0;
		$response["pesan"] = "Tidak ada yang di-save";
	}
	echo json_encode($response);
	mysqli_close();

?>