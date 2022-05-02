<?php
    include("./Connections/connect.php");		//使用資料庫的呼叫程式
    $link=Connection();		//產生mySQL連線物件

    $userIdentity = $_GET["userIdentity"];
    if($userIdentity == "customer"){
        $userName = $_GET["userName"];
        $userMail = $_GET["userMail"];
        $userPassword = $_GET["userPassword"];
        $userPhone = $_GET["userPhone"];
        $userAddr = $_GET["userAddr"];
        
        $qAccount = "INSERT INTO `account` (`account`, `password`, `identity`) VALUES ('%s', '%s', '%s')";
        $qCustomer = "INSERT INTO `customer` (`name`, `phone`, `mail`) VALUES ('%s', '%s', '%s')";
        $qAddr = ""
        $query = sprintf($qAccount,$userMail,$userPassword,$userIdentity);
        if(mysqli_query($query)){
            $query = sprintf($qCustomer,$userName,$userPhone,$userMail);
            mysqli_query($query);

        }
        else{
            return FALSE;
        }
    }

    