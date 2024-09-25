<?php 
	include "koneksi.php";
	$sql = "select * from tbl_brg";
	$eks = mysqli_query($koneksi,$sql);
	$test = mysqli_affected_rows($koneksi);
	
	if($test>0){
		$response["kode"] = 1;
		$response["pesan"] = "Data tersedia";
		$response["data"] = array();
		while($dt=mysqli_fetch_array($eks)){
			$Ar["kd_brg"]=$dt[0];
			$Ar["nama_brg"]=$dt[1];
			$Ar["jumlah"]=$dt[2];
			$Ar["harga"]=$dt[3];
			
			array_push($response["data"],$Ar);
		}
		$sql2 = "SELECT (SUM(jumlah*harga)) AS total FROM tbl_brg";
		$teks = mysqli_query($koneksi,$sql2);
		$total = mysqli_fetch_array($teks);
		$response["total"] = $total[0];
		$sql3 = "SELECT SUM(jumlah) AS jml_data FROM tbl_brg";
		$teks2 = mysqli_query($koneksi,$sql3);
		$jml = mysqli_fetch_array($teks2);
		$response["jumlah_data"] = $jml[0];
	}else{
		$response["kode"] = 0;
		$response["pesan"] = "Data tidak tersedia";
	}
	echo json_encode($response);
	mysqli_close($koneksi);
?>