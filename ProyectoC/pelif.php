<?php
   include "conexion.php";
   session_start();   
   $id=$_SESSION['usern'];
   $sql="SELECT * FROM proyecto.gustospeliculas where Usuario_idUsuario='$id';";
   $consul=$conn->query($sql);
   $res="[";
   while($row= $consul->fetch_assoc()){
     $res.='"';
     $res.=$row['peliculas_idPeliculas'];
     $res.='"';
     $res.=","; 
   }
   $res=substr($res,0,-1);
   $res.="]";
   echo $res;
?>