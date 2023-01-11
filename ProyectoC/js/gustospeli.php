<?php
 include "../conexion.php";
 session_start();
        
    $id=$_SESSION['usern'];
    $js="[";
    $slq="SELECT peliculas_idPeliculas FROM proyecto.gustospeliculas where Usuario_idUsuario='$id';";
    $consul=$conn->query($slq);
    while($row= $consul->fetch_assoc()){
      $url="http://www.omdbapi.com/?i=".$row['peliculas_idPeliculas']."&apikey=208a05f2";
      $json=file_get_contents($url);
      $datos=json_decode($json,true);
      $gene=explode(",", $datos['Genre']);
      for($i=0;$i<count($gene);++$i){
        $js.='"';
        $js.=$gene[$i];
        $js.='"';
        $js.=","; 
      }
    }
   $js=substr($js,0,-1);
   $js.="]";
   echo $js;

?>