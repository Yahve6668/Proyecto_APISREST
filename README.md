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
Gracias por proporcionar más detalles sobre la estructura de tus carpetas y archivos. Parece que estás describiendo un proyecto web que implica múltiples componentes, incluidos archivos HTML, CSS, PHP y JavaScript, así como una base de datos para el almacenamiento de películas y preferencias de usuario. Aquí hay una breve descripción de lo que parece estar en cada carpeta:

**Carpeta "java"**:
- Contiene código Java relacionado con la inserción de datos en la base de datos.
- Incluye las interfaces web para el inicio de sesión, registro y búsqueda de películas.

**Carpeta "Proyecto"**:
- Contiene el código relacionado con la funcionalidad de inicio de sesión y registro de usuarios.
- También puede incluir la lógica para mostrar recomendaciones de películas a usuarios registrados.
- Puede haber archivos HTML, CSS, PHP y JavaScript relacionados con estas funciones.

**Carpeta "ProyectoC"**:
- Contiene las interfaces gráficas para el llenado de campos de registro relacionados con las preferencias del usuario.
- También alberga la página principal que se muestra a los usuarios registrados y no registrados, con recomendaciones de películas y opciones para acceder a películas favoritas y búsquedas.
- Puede incluir archivos HTML y CSS para la interfaz de usuario, así como archivos PHP y JavaScript para la funcionalidad de la aplicación.

**Archivos HTML y CSS**:
- Utilizados para la estructura y el estilo de las páginas web.
- Pueden incluir formularios de registro, páginas de inicio de sesión, páginas de búsqueda de películas y páginas de perfil de usuario.

**Archivos PHP**:
- Se utilizan para crear secciones y recursos de API, como filtrado de sugerencias y formularios de registro de gustos.
- Pueden manejar la interacción entre la interfaz de usuario y la base de datos.

**Archivos JavaScript (JS)**:
- Utilizados para la lógica de la aplicación, incluida la generación de recomendaciones de películas basadas en géneros y la animación de elementos en la interfaz de usuario.
- También se utilizan para realizar solicitudes a APIs externas.

En resumen, parece que estás desarrollando una aplicación web que implica la gestión de usuarios, la búsqueda y recomendación de películas, y la personalización de la experiencia del usuario. A medida que trabajes en este proyecto, asegúrate de que todos estos componentes estén interconectados y funcionen juntos para lograr el objetivo deseado. También es importante tener en cuenta la seguridad y la eficiencia en el manejo de la base de datos y las solicitudes de API.
```

# Ventajas del empleo de APIs basados en REST.

Las APIs basadas en REST simplifican significativamente la tarea de consultar y recopilar datos. Esto facilita el proceso de desarrollo de aplicaciones web, ya que reduce la complejidad asociada con la obtención y depuración de información. Además, las APIs REST son altamente escalables, lo que permite una interacción eficiente entre los usuarios y los servidores en los que residen. También son independientes del lenguaje de programación utilizado, lo que las hace versátiles y fáciles de integrar en una variedad de entornos de desarrollo web, adaptándose a las preferencias de los programadores
