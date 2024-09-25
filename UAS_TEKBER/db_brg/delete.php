<?php 
	include "koneksi.php";
	$response=array();
	if($_SERVER['REQUEST_METHOD']=='POST'){
		$kd_brg = $_POST["kd_brg"];
		
		$perintah = "DELETE FROM tbl_brg WHERE kd_brg='$kd_brg'";
		$eksekusi = mysqli_query($koneksi,$perintah);
		$cek = mysqli_affected_rows($koneksi);
		if($cek>0){
			$response["kode"] = 1;
			$response["pesan"] = "Data berhasil di hapus";
		}else{
			$response["kode"] = 0;
			$response["pesan"] = "Data gagal di hapus";
		}
	}else{
		$response["kode"] = 0;
		$response["pesan"] = "Tidak ada yang di-save";
	}
	echo json_encode($response);
	mysqli_close();

?>