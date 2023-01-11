# Proyecto_APISREST
2192006529

# Requisitos
```
Tener la extension Moesif CORS  en su navergador
Tener instalado apahce en el puerto 8080
Terner instalado apachetomcat en el puerto 8081
Asosciar el server de apachetomcat como servidor en apacheNebtbens 
Crear la base de datos con el documento .sql desde mysqlworkbechse 
Descargar los 3 proyectos asi como los jar para el funcionamineto de los mismos y correr los mismos en apacheNetbens  
Colocar la carpeta de proyectoC en la htdocs del apache
Nota: para las conexxiones a la base de  datos en java asi como en la php es necesario cambiar los datos con los asociados a sus datos y password  de sus base de datos
```
# Lenguajes usados 
```
PHP (consumidor de API http://www.omdbapi.com/ ) asi como para la creaccion de algunas 
JavaScript (uso de metos basado en promesas con el metodo fetch para el consumo de apis)
Java (Servelts y Creacion de APIST)
```
# Descripccion 
```
En la carpeta java: se encontrara todo lo necesario para insercciones en la base de datos de datos necesarios para el llenado de formularios  asi mismo se encuntran las interfases web del login , registro y de busqueda peliculas
Buscador de peliculas (inserccion de datos como lo son generos ,direcotres y actores)
Tarea (buscador de peliculas)
Proyecto (login y registro)

En la carpeta ProyectoC se encuantra las interface graficas para el llenado de algunos campos de registro en cuanto a los gustos del usuario  asi mismo se encuntra la pagina principla que se le muetra tanto a los usuarios nuevos como a los ya registrados donde vera las recomendaciones de peliculas asi como pestallas donde podra acceder a sus peliculas favoristas asi como a busqueda de algunas

Los archivos html y css son  parte de la insterfas grafica 
Los php son creacciones de secciones asi como tambien de recursos API que se usan para el filtrado de  sugerencias asi como tabien para la creaccion del formulario del registro de gustos
Los js son la base de la logica del algoritmo de de recomendacion meante una tabla de frecuencia y busqueda lineal mediante busquedas aleatoria a la api para en base a la tabla de frecuencia basada en generos se genere el filtrado basado en generos  de las peliculas que se le recomendaran asi mismo tambien se usa para las animaciones del carusel y consumo de apis .

```

# Ventajas del empleo de APIs basados en REST.

Las apis basadas en rest nos facilitan  mucho el trabajo de  consulta  de datos   ,así como la recolección de los mismo lo que hace que la creación de aplicaciones web sean más fácil en cuanto a trabajo de recolección de datos y depuración de la misma así como también tienen la capacidad de escalar de forma eficientes perimiendo  que la interacción entre los usuarios y los servidores donde se alojan las mismas  así como también estas son independientes del consumo ya que ofrecen una gran variedad de formas de consumo de las misma en diferentes lenguajes de desarrollo web lo que lo hace muy versátil y fácil de trabajar con ellas en el lenguaje que más se acomode al programador.
