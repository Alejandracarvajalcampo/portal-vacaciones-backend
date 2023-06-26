# Portal para la solicitud de vacaciones
Se realizo un sistema de vacaciones que permite los siguientes métodos
- Crear empleado
- Listar empleados
- Buscar empleado por documento
- Actualizar empleado
- Eliminar empleado
- Obtener las vacaciones del empleado por su número de documento
- Crear solicitud de vacaciones
- listar todas las solicitudes en todos sus estados
- Eliminar solicitud vacaciones

Se crea una data.sql donde se insertan 4 empleados y  3 solicitudes de vacaciones como carga inicial de datos, para que esto se ejecute se debe crear una base de datos en mysql con el nombre de vacation_request.

En el siguiente drive podrás encontrar la colección completa con las anteriores operaciones descritas

https://1drv.ms/u/s!ArQ4HoRgNuh9gXm3Yh-cG2i2jlbz?e=3YXyZT

Nota: se deja la propiedad spring.jpa.hibernate.ddl-auto=create-drop en ese estado para que cada vez que se corra la aplicación se borren y se vuelvan a crear los datos iniciales, para que el insert no se ejecute varias veces y se repitan los datos y genere algún tipo de error

