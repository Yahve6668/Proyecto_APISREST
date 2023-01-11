<?php
  include "../conexion.php";
     session_start();
     $id=$_POST['userc'];
     $password=$_POST['password2']; 
     $sql="SELECT * FROM proyecto.usuario where userp='$id';";

     $consul=$conn->query($sql);
     $idd="";
     $con=""; 
    while($row= $consul->fetch_assoc()){
      echo "entre"; 
      $idd=$row['idUsuario'];
      $con=$row['contra'];
   }
   if($con==$password){
     $_SESSION['usern']=$idd;  
     echo $_SESSION['usern'];
     header("Location:http://localhost:8080/ProyectoC/principal.html");
    }else{
     echo'<script type="text/javascript">
    alert("password incorrecto");
    window.location.href="http://localhost:8081/Proyecto/";
    </script>';
    }
?>