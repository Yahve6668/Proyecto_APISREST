<?php
 include "conexion.php";
 session_start();
  
 //$User=$_SESSION['usern'];
 
 
    $nom=$_POST['generos'];
    $pel=@json_decode($_POST['peliculas'], true);
    $titulos=@json_decode($_POST['titulos'], true);
    $genros=@json_decode($_POST['generos'], true);
    $act=$_POST['actores'];
    $direc=$_POST['directores'];
    $user=$_POST['User'];
    //Usuario
    $slq="SELECT * from proyecto.usuario where userp='$user';";
    $consul=$conn->query($slq);
    $row= $consul->fetch_assoc();
    $id=$row['idUsuario'];
    $_SESSION['usern']=$id;
    //actores y directores
    for($i=$act;$i<$act+3;++$i){
     $slq="SELECT * from proyecto.actores where idActores='$i';";
     $consul=$conn->query($slq);
     $row= $consul->fetch_assoc();
     $ida=$row['idActores'];
     $stm=$conn->prepare("insert into actores_has_usuario(usuario_idUsuario,Actores_idActores) values (?,?)");
     $stm->bind_param("ii",$id,$ida);
     $stm->execute();
     $stm->close();
   }
  
   for($i=$direc;$i<$direc+3;++$i){
     $slq="SELECT * from proyecto.director where iddirector='$i';";
     $consul=$conn->query($slq);
     $row= $consul->fetch_assoc();
     $ida=$row['iddirector'];
     $stm=$conn->prepare("insert into directorgustos(director_iddirector,Usuario_idUsuario) values (?,?)");
     $stm->bind_param("ii",$ida,$id);
     $stm->execute();
     $stm->close();
    }
   
    //generos
   for($i=0;$i< count($genros);++$i){
     $stm=$conn->prepare("insert into generogusto(genero_idgenero,Usuario_idUsuario) values (?,?)");
     $stm->bind_param("ii",$genros[$i],$id);
     $stm->execute();
     $stm->close(); 
   }
   
   //peliculas
   for($i=0;$i< count($pel);++$i){
    $slq="SELECT * from proyecto.peliculas where idPeliculas='$pel[$i]';";
    $consul=$conn->query($slq);
    $row= $consul->fetch_assoc();
    if($row==false){
      $stm=$conn->prepare("insert into peliculas(idPeliculas,nombre) values (?,?)");
      $stm->bind_param("ss",$pel[$i],$titulos[$i]);
      $stm->execute();
    }
    $stm=$conn->prepare("insert into gustospeliculas(Usuario_idUsuario,peliculas_idPeliculas) values (?,?)");
      $stm->bind_param("is",$id,$pel[$i]);
      $stm->execute();
  }
  $stm->close(); 
     
  
   echo "exito";
   $conn->close();
?>