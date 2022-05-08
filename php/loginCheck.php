<?php
    include("./Connections/connect.php");		//使用資料庫的呼叫程式
    $link=Connection();		//產生mySQL連線物件

    $userIDInput = $_GET["userID"];
    $userPWDInput = $_GET["userPWD"];

    $q =  "SELECT * FROM `account` WHERE `account` = '%s'";
    //SELECT * FROM `account` WHERE `account` = '281477'

    $query = sprintf($q,$userIDInput);
    $result = mysqli_query($link, $query);      //搜尋帳號
    mysqli_close($link);		//關閉Query

    if(!$result){       //帳號不存在
        echo "FALSE";
    }else{
        if(mysqli_num_rows($result)>0){
            $check[] = mysqli_fetch_assoc($result);
            mysqli_free_result($result);
            if($check[0]["password"] == $userPWDInput)        
                echo "TRUE";
            else        //密碼錯誤
                echo "FALSE";
        }
        else{
            echo "Failed";
        }
    }
?>