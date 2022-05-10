<?php
    include("./Connections/connect.php");		//使用資料庫的呼叫程式
    $link=Connection();		//產生mySQL連線物件

    $userIdentity = $_GET["userIdentity"];
    if($userIdentity == "customer"){
        $userName = $_GET["userName"];
        $userMail = $_GET["userMail"];
        $userPassword = $_GET["userPassword"];
        
        $qAccount = "INSERT INTO `account` (`account`, `password`, `identity`) VALUES ('%s', '%s', '%s')";
        $qCustomer = "INSERT INTO `customer` (`name`, `mail`) VALUES ('%s', '%s')";
        $query = sprintf($qAccount,$userMail,$userPassword,$userIdentity);
        try{
            mysqli_query($link, $query)
        }catch(Exception e){
            echo "False";
            return;
        }
        $query = sprintf($qCustomer,$userName,$userMail);
        try{
            mysqli_query($link, $query)
        }catch(Exception e)
            echo "false";
            return;
        }
        echo "true";
        return;

    }
?> 