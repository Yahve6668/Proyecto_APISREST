<?php
  include "../conexion.php";
    session_start();
    $id=$_SESSION['usern'];
   
    $json="[";
    $slq="SELECT genero_idgenero FROM proyecto.generogusto where Usuario_idUsuario='$id';";
    $consul=$conn->query($slq);
    while($row= $consul->fetch_assoc()){
           $sql2="SELECT nombre FROM proyecto.genero where idgenero=".$row['genero_idgenero'].";";
           $gen=$conn->query($sql2);
           $nombre=$gen->fetch_assoc();   
           $json.= ('"'.$nombre['nombre'].'"'."," );    
    }
    $json=substr($json,0,-1);
    $json.="]";
    echo $json;
?>