<?php
    require_once("db.php");
    if(isset($_GET['url']))
    {
        $select = "SELECT original_url FROM url WHERE shortened_url = '{$_GET['url']}'";
        $result = $db->query($select);
        $row = $result->fetch_assoc();

        $update = "UPDATE url SET hits = hits + 1 WHERE shortened_url = '{$_GET['url']}'";
        if($db->query($update) == false)
        {
            echo "Some error occurred while redirecting";
            die();
        }

        header("Location: https://".$row['original_url']);
    }
?>