<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>CS 355 Home Page</title>
  <link rel="stylesheet" type="text/css" href="css/style.css">
  <style>
    body{
      color:white;
    }
  </style>
</head>
<?php
    require_once("db.php");
    session_start();
    if(isset($_POST['register_url']))
    {
        $insert = "INSERT INTO url(user_id , original_url , shortened_url) VALUES({$_SESSION['user_id']} , '{$_POST['original_url']}' , '{$_POST['shortened_url']}')";
        if($db->query($insert) == false)
        {
            echo "<span>Some Problem Occurred while inserting URL data - ".mysqli_error($db)."</span>";
        }
    }
?>
<body>
   <!-- NAVBAR BEGINS HERE-->
   <body>
   <!-- NAVBAR BEGINS HERE-->
   <nav id="navbar">
     <ul>
       <li class="dropdown">
         <a href="index.html" class="dropbtn">Home</a>
         <div class ="dropdown-content">
         </div>
       </li>
       <li class="dropdown">
         <a href="#" class="dropbtn">Course</a>
         <div class="dropdown-content">
           <a href="https://docs.google.com/document/d/1iM_6SF4n3CSMTUTa10aupA06g1acdElOKerVbbhiCX0/edit" target="_blank">Lecture Schedule</a>
             <a href="https://drive.google.com/drive/folders/1I65l5JZaIWbdnAGbTc7acYyWwj_hNXJM" target="_blank">Lecture Notes</a>
             <a href="https://drive.google.com/drive/folders/1FFU7i1DVSR-3eMhgPdS5zlPUR3tJhGpa" target="_blank">Lecture Recordings</a>
             <a href="https://drive.google.com/drive/folders/16R8lxyl9rrc_h8yAzJ80wizomarbH_pF" target="_blank">Lecture Slides</a>
           <a href="https://tophat.com/" target="_blank">TopHat</a>
           <a href="https://drive.google.com/open?id=1AsHhIFfQ3yNE_m2z4wswRfKh77K0UH9w" target="_blank">Course Google Drive</a>
           <a href="https://www.w3schools.com/" target="_blank">W3Schools</a>
         </div>
       </li>
       <li class="dropdown">
         <a href="#" class="dropbtn">About</a>
         <div class="dropdown-content">

           <a href="https://docs.google.com/document/d/1ArpycWbzgmi6EF9fqiCbz5afROnU1ZZDA6X2Vo3Zm6g/edit">About The Developer</a>
           <a href="https://www.linkedin.com/in/yousra-hanif-5427ba1ab/">Contact</a>
         </div>
       </li>
        <li class="dropdown">
           <a href="#" class="dropbtn">Search</a>
           <div class="dropdown-content">
              <a href="fromFile.html">From File</a>
              <a href="googleAPI.html">Google API</a>
           </div>
        </li>
      </ul>
   </nav>
   </nav>
   <!--NAVBAR ENDS HERE-->
<form method="POST">
	<input type="text" id="myURL" placeholder="Original URL" name="original_url"><br />
    <span>Place Url=</span>
	<input type="text" id="result" placeholder="Shortened URL" name="shortened_url"><br />
	<button type="button" id="shortenURL">Shorten</button>
    <button id="registerURL" name="register_url" type="submit">Register URL</button>
</form>
<?php
  $select = "SELECT * FROM url WHERE user_id = {$_SESSION['user_id']}";
  $result = $db->query($select);
  if(mysqli_num_rows($result) == 0)
  {
    goto end;
  }
?>
<h4>Report</h4>
<table cellspacing="15px">
  <thead>
    <th>Registered Timestamp</th>
    <th>Orginal URL</th>
    <th>Shortened URL</th>
    <th>Hits</th>
  </thead>
  <tbody>
    <?php
      while($row = $result->fetch_assoc())
      {
        echo "<tr>";
          echo "<td>{$row['date_registered']}</td>";
          echo "<td>{$row['original_url']}</td>";
          echo "<td>{$row['shortened_url']}</td>";
          echo "<td>{$row['hits']}</td>";
        echo "</tr>";
      }
    ?>
  </tbody>
</table>
<?php
  end:
?>
<script>
	function randomNumber(n) {
		var result = '';
		var charAllow = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
		for (var ind = 0; ind < n; ind++){
			result += charAllow.charAt(
			Math.floor(Math.random() * charAllow.length)
			);
		}
		return result;
	}

  document.getElementById('shortenURL').addEventListener("click" , function(e)
  {
    if(document.getElementById("myURL").value == '')
        {
            alert("Please enter a url");
            e.preventDefault();
        }
		var value=randomNumber(8);
		document.getElementById("result").value=value;
  } , false);

  document.getElementById('registerURL').addEventListener("click" , function(e)
  {
    if(document.getElementById('myURL').value == '')
        {
            alert("Please enter a url");
            e.preventDefault();
        }
        if(document.getElementById('result').value == '')
        {
            alert("Shortened URL is empty");
            e.preventDefault();
        }
  } , false);
</script>
</body>
</html>