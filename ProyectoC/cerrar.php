<?php
  session_start();

  session_destroy();
  echo'<script type="text/javascript">
    alert("ADIOS");
    window.location.href="http://localhost:8081/Proyecto/";
    </script>';
?>