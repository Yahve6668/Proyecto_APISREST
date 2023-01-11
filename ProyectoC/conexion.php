<?php
  $server = "localhost";
  $user= "root";
  $password= "1234";
  $db= "proyecto";
  $conn= new mysqli($server,$user,$password,$db);
  if($conn->connect_error){
      die("Conexion Fallida".$conn->connect_error);
  }
?>