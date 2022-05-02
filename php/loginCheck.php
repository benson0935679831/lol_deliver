<?php
    include("./Connections/connect.php");		//使用資料庫的呼叫程式
    $link=Connection();		//產生mySQL連線物件

    $userIDInput = $_GET["userID"];
    $userPWDInput = $_GET["userPWD"];

    $q =  "SELECT * FROM `account` WHERE `account` = '%s'";

    $query = sprintf($q,$userIDInput);
    $result = mysqli_query($link, $query);      //搜尋帳號
    mysqli_close($link);		//關閉Query
    if(!$result){       //帳號不存在
        return FALSE;
    }else{      
        if($result["password"] == $userPWDInput)        
            return TRUE;
        else        //密碼錯誤
            return FALSE;
    }
?>
