# Proyecto_APISREST
2192006529

# Requisitos
```
Instala la extensión Moesif CORS en tu navegador:

Esta extensión te ayudará a evitar problemas de políticas de mismo origen (Same Origin Policy) al realizar solicitudes desde tu navegador a servidores en diferentes dominios.
Instala Apache en el puerto 8080:

Asegúrate de tener Apache HTTP Server instalado en tu máquina y configurado para ejecutarse en el puerto 8080. Puedes modificar la configuración en el archivo de configuración httpd.conf.
Instala Apache Tomcat en el puerto 8081:

Instala y configura Apache Tomcat para que se ejecute en el puerto 8081. Asegúrate de que Tomcat esté funcionando correctamente.
Asocia el servidor Apache Tomcat en Apache NetBeans:

Abre Apache NetBeans y configura un nuevo servidor. En este caso, selecciona Apache Tomcat como el servidor que deseas usar. Debes proporcionar la ubicación de la instalación de Tomcat y configurar las opciones necesarias.
Crea la base de datos desde un documento .sql en MySQL Workbench:

Utiliza MySQL Workbench para conectarte a tu servidor MySQL local y ejecutar el script SQL que contiene las instrucciones para crear la base de datos y sus tablas.
Descarga los proyectos y los archivos JAR necesarios:

Descarga los proyectos web que deseas ejecutar en Apache NetBeans. Asegúrate de que todos los archivos JAR y dependencias necesarios estén disponibles y agregados al proyecto.
Ejecuta los proyectos en Apache NetBeans:

Importa los proyectos descargados en Apache NetBeans y configura las conexiones a la base de datos en el código, utilizando tus propias credenciales de acceso y configuración de base de datos.
Coloca la carpeta del proyectoC en la carpeta htdocs de Apache:

Si estás utilizando Apache HTTP Server, coloca la carpeta del proyectoC en la carpeta htdocs para que pueda ser accesible a través de http://localhost:8080/proyectoC.
Asegúrate de corregir errores ortográficos y configurar las conexiones a la base de datos:

Revise el código de los proyectos web y asegúrate de que las conexiones a la base de datos estén configuradas correctamente con los datos de tu servidor MySQL.
Ejecuta los proyectos en Apache NetBeans:

Inicia los proyectos en Apache NetBeans y accede a ellos desde tu navegador a través de la dirección correspondiente, según la configuración del servidor y el proyecto.
```
# Lenguajes usados 
```
PHP (consumidor de API http://www.omdbapi.com/ ) asi como para la creaccion de algunas 
JavaScript (uso de métodos basado en promesas con el método fetch para el consumo de apis)
Java (Servelts y Creacion de APIST)
```
# Descripción 
```
En la carpeta java: se encontrará todo lo necesario para inserciones en la base de datos de datos necesarios para el llenado de formularios  así mismo se encuentran las interfaces web del login , registro y de búsqueda películas
Buscador de peliculas (inserción de datos como lo son géneros ,directores y actores)
Tarea (buscador de peliculas)
Proyecto (login y registro)

En la carpeta ProyectoC se encuentran las interface gráficas para el llenado de algunos campos de registro en cuanto a los gustos del usuario  asi mismo se encuentra la pagina principal que se le muestra tanto a los usuarios nuevos como a los ya registrados donde verá las recomendaciones de peliculas asi como pestañas donde podrá acceder a sus películas favoritas así como a búsqueda de algunas

Los archivos html y css son  parte de la interfaz grafica 
Los php son creaciones de secciones así como tambien de recursos API que se usan para el filtrado de  sugerencias asi como también para la creación del formulario del registro de gustos
Los js son la base de la lógica del algoritmo de de recomendación mediante una tabla de frecuencia y búsqueda lineal mediante búsquedas aleatoria a la api para en base a la tabla de frecuencia basada en géneros se genere el filtrado basado en géneros  de las películas que se le recomendaran asimismo también se usa para las animaciones del carrusel y consumo de apis .

```

# Ventajas del empleo de APIs basados en REST.

Las apis basadas en rest nos facilitan  mucho el trabajo de  consulta  de datos   ,así como la recolección de los mismo lo que hace que la creación de aplicaciones web sean más fácil en cuanto a trabajo de recolección de datos y depuración de la misma así como también tienen la capacidad de escalar de forma eficientes permitiendo  que la interacción entre los usuarios y los servidores donde se alojan las mismas  así como también estas son independientes del consumo ya que ofrecen una gran variedad de formas de consumo de las misma en diferentes lenguajes de desarrollo web lo que lo hace muy versátil y fácil de trabajar con ellas en el lenguaje que más se acomode al programador.


