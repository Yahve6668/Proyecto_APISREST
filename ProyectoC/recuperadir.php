<?php
   include "conexion.php";

    $t=$conn->query("SELECT * FROM proyecto.director");
    $ar="[";
    $a;
    while($a=mysqli_fetch_array($t)){
      
       $ar .='"';
       $ar .= $a['nombre'];
       $ar .='"';
       $ar .=',';
    } 
    $ar=substr($ar,0,-1);
    $ar.= "]";
    echo $ar;
    $conn->close();
    
?>