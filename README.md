# Backend Challenge myHotel

## Spring Boot App: Vehicle API

La aplicación se encuentra dentro de la carpeta *vehicle-api*. Para poder ejecutar la app, por favor leer todos los literales.

### Descripción del proyecto (estructura)
- **src/main/java:** En esta carpeta se encuentran los archivos Java del proyecto.
  - **com.example.vehicleapi:** Este es el paquete principal del proyecto, que contiene todas las clases de Java que son entidades que representan las tablas de la base de datos. Acá se encuentran las clases de Java como *Vehicle*, *Automobile* y *Truck* que heredan de *Vehicle*, *Maintenance* y la clase principal *VehicleApiApplication*.
  - **com.example.vehicleapi.repository:** Este paquete contiene las interfaces de repositorio que extienden JpaRepository para manejar las operaciones de base de datos para cada entidad (*Vehicle* y *Maintenance*).
  - **com.example.vehicleapi.service:** Este paquete contiene las clases de servicio que encapsulan la lógica de negocio del proyecto y utilizan los repositorios correspondientes para acceder a la base de datos.
  - **com.example.vehicleapi.controller:** Este paquete contiene los controladores de Spring MVC que manejan las solicitudes HTTP entrantes y las envían a los servicios correspondientes.
  
### Descripción de endpoints
Estos se pueden probar con una herramienta como *Postman*. Si se corre en el ambiente local, se debe colocar al inicio `http://localhost:8081`.
#### Vehicles:
- **GET /vehicles:** Este endpoint permite obtener la lista de todos los vehículos almacenados en la base de datos.
- **GET /vehicles/{id}:** Este endpoint permite obtener los detalles de un vehículo en particular, especificando su identificador en la URL.
- **POST /vehicles:** Este endpoint permite crear un nuevo vehículo en la base de datos, proporcionando los detalles del vehículo en el cuerpo de la solicitud.
- **PUT /vehicles/{id}:** Este endpoint permite actualizar los detalles de un vehículo existente, especificando su identificador en la URL.
- **DELETE /vehicles/{id}:** Este endpoint permite eliminar un vehículo existente de la base de datos, especificando su identificador en la URL.

#### Maintenance:
- **GET /maintenance/vehicle/{vehicleId}:** Este endpoint permite obtener la lista de todos los registros de mantenimiento asociados a un vehículo específico, especificando el identificador del vehículo en la URL.
- **POST /maintenance/vehicle/{vehicleId}:** Este endpoint permite crear un nuevo registro de mantenimiento para un vehículo específico, especificando el identificador del vehículo en la URL y proporcionando los detalles del registro en el cuerpo de la solicitud.
- **PUT /maintenance/{maintenanceId}:** Este endpoint permite actualizar los detalles de un registro de mantenimiento existente, especificando su identificador en la URL y proporcionando los nuevos detalles en el cuerpo de la solicitud.
- **DELETE /maintenance/{maintenanceId}:** Este endpoint permite eliminar un registro de mantenimiento existente de la base de datos, especificando su identificador en la URL.

### Configuración del ambiente
- **src/main/resources:** Acá en el archivo *application.properties* se definen algunas propiedades para la aplicación:
```
server.port=8081
spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=myuser
spring.datasource.password=mypassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL57Dialect
spring.jpa.hibernate.ddl-auto=update
```
Cabe mencionar que la propiedad *spring.jpa.hibernate.ddl-auto* está definida como *update* por si la base de datos o las tablas ya existen o no se han creado. Se debe actualizar las credenciales (username, password) a un usuario que tenga permisos en la base de datos.

- Dentro del *pom.xml*, se debe agregar una dependencia en *dependencies* para la base de datos de MySQL:
```
<dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>8.0.26</version>
  </dependency>
```

### Recursos necesarios
En este caso no hay que realizar ningún dump de base de datos, ya que la base de datos y las tablas se crean automáticamente y después se puede ir agregando o modificando información con los endpoints.

### ¿Cómo ejecutar la aplicación?
- Se puede emplear Spring Tool Suite (IDE) para ejecutarla.
- Clonar el repositorio e importar la carpeta *vehicle-api* en tu IDE. Para Spring Tool Suite se puede seguir los pasos: File -> Import... -> Maven -> Existing Maven Projects. Seleccionas la carpeta y das clic en Finish.
- Dar clic en la carpeta *src/main/java*, *Run As* -> *Spring Boot App*
![image](https://user-images.githubusercontent.com/51431125/222257892-fa681e36-0ea5-4c96-a2cd-3568b9cd0fbd.png)
![image](https://user-images.githubusercontent.com/51431125/222258005-190d2e2d-8376-40c3-b637-f0714c00fe36.png)

## Base de datos Employees (MySQL)

### Dump de base de datos
- Crear una base de datos en una herramienta como MySQLWorkbench.
- Para realizar el dump de la base de datos puedes emplear una herramienta como MySQLWorkbench e importar el archivo que estaba adjunto en el PDF y dejar las tablas e información en la base de datos creada previamente.
![image](https://user-images.githubusercontent.com/51431125/222260721-a36f38e2-a2fc-40fe-96a4-124e09d958c6.png)

### Queries
Los queries se encuentran adjuntos en el archivo *queries.sql* y se encuentran separados por su nombre. Estos pueden ser ejecutados y ver su resultado desde una herramienta como MySQLWorkbench.

## Spring Boot App: Employees API 

La aplicación se encuentra dentro de la carpeta *employees-api*. Para poder ejecutar la app, por favor leer todos los literales.

### Descripción del proyecto (estructura)
- **src/main/java:** En esta carpeta se encuentran los archivos Java del proyecto.
  - **com.example.employeesapi:** Este es el paquete principal del proyecto, que contiene todas las clases de Java que son entidades que representan las tablas de la base de datos. Acá se encuentran las clases de Java como *Employee*, *Department*, *Country*, *Job*, *Location* y la clase principal *EmployeesApiApplication*.
  - **com.example.employeesapi.repository:** Este paquete contiene las interfaces de repositorio que extienden JpaRepository para manejar las operaciones de base de datos. En este caso se tienen las queries.
  - **com.example.employeesapi.service:** Este paquete contiene las clases de servicio que encapsulan la lógica de negocio del proyecto y utilizan los repositorios correspondientes para acceder a la base de datos. En este caso se llama a las queries definidas en el repository.
  - **com.example.employeesapi.controller:** Este paquete contiene los controladores de Spring MVC que manejan las solicitudes HTTP entrantes y las envían a los servicios correspondientes. Acá se retornan las respuestas y se observan en formato JSON cuando se consultan los endpoints.

### Descripción de endpoints
Estos se pueden probar con una herramienta como *Postman*. Si se corre en el ambiente local, se debe colocar al inicio `http://localhost:8081`.

- **GET /employees/salary-segments-quantity:** Este endpoint devuelve la cantidad de empleados agrupados por segmento salarial (A, B o C), donde el límite superior de cada segmento se puede ajustar mediante los parámetros de consulta *minSalary* y *maxSalary*.
- **GET /employees/salary-segments-quantity-by-department:** Este endpoint devuelve la cantidad de empleados agrupados por segmento salarial (A, B o C) y departamento, donde el límite superior de cada segmento se puede ajustar mediante los parámetros de consulta *minSalary* y *maxSalary*.
- **GET /employees/highest-salary-by-department:** Este endpoint devuelve la información completa del empleado con el salario más alto en cada departamento.
- **GET /employees/managers-older-than:** Este endpoint devuelve la información de todos los gerentes (employees) cuya fecha de contratación es mayor a un número de años dado. El número de años se especifica en el parámetro de consulta *years*.
- **GET /employees/departments-salary-avg-having-more-than:** Este endpoint devuelve el salario promedio por departamento solo para aquellos departamentos que tienen más de un número de empleados. El número de empleados se especifica en el parámetro de consulta *count*.
- **GET /employees/stats-by-country:** Este endpoint devuelve estadísticas de empleados agrupados por país. Para cada país, se incluye el nombre del país, la cantidad de empleados, el salario promedio, el salario más alto, el salario más bajo y la antigüedad promedio de los empleados en años.

### Configuración del ambiente
- **src/main/resources:** Acá en el archivo *application.properties* se definen algunas propiedades para la aplicación:
```
server.port=8081
spring.datasource.url=jdbc:mysql://localhost:3306/myhotel_test
spring.datasource.username=myuser
spring.datasource.password=mypassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL57Dialect
spring.jpa.hibernate.ddl-auto=none
```
Cabe mencionar que la propiedad *spring.jpa.hibernate.ddl-auto* está definida como *none* ya que la base de datos, tablas y datos ya deben haber sido cargados con el dump. Se debe actualizar las credenciales (username, password) a un usuario que tenga permisos en la base de datos.

- Dentro del *pom.xml*, se debe agregar una dependencia en *dependencies* para la base de datos de MySQL:
```
<dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>8.0.26</version>
  </dependency>
```

### Recursos necesarios
Realizar el dump de la base de datos que se realizó previamente para el punto de las queries.

### ¿Cómo ejecutar la aplicación?
- Se puede emplear Spring Tool Suite (IDE) para ejecutarla.
- Clonar el repositorio e importar la carpeta *vehicle-api* en tu IDE. Para Spring Tool Suite se puede seguir los pasos: File -> Import... -> Maven -> Existing Maven Projects. Seleccionas la carpeta y das clic en Finish.
- Dar clic en la carpeta *src/main/java*, *Run As* -> *Spring Boot App*
![image](https://user-images.githubusercontent.com/51431125/222267926-4a0960bb-8a49-4c23-909e-b89fdacd09ef.png)
![image](https://user-images.githubusercontent.com/51431125/222267802-93e2f85d-5cbd-4680-8760-19b795ec7759.png)
