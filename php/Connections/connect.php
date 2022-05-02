<?php
	function Connection() 
	{

		$server="localhost";		//mysql資料庫的ip or域名
		$user="delivery";			//連線mysql帳號
		$pass="lol";			//連線mysql帳號密碼
		$db="delivery";				//連線mysql主要運作的資料庫名稱 	
		$connection = mysqli_connect($server, $user, $pass);	//連線到資料庫  	

		if (!$connection) //不連線成功
		{
	    	die('MySQL ERROR: ' . mysql_error());		//連線失敗，idle(dead) here
		}
		
		mysqli_select_db($connection,$db); 	//切換目前資料庫
		mysqli_query($connection,"SET NAMES UTF8");	//切換目前語系 	
		session_start();	//啟動session  	
	
		return $connection  ;	//將連線回傳
	}
	
?>