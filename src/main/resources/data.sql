
INSERT INTO empleado (id,documento, tipo_documento, nombres, apellidos, telefono, cargo, direccion, fecha_ingreso, tipo_contrato, estado, supervisor)
VALUES ('1','109875487', 'cedula', 'Juan Miguel', 'cervantes', '+573189657715', 'QA', 'calle recocha 5', '2023-05-05', 'indefinido', 'Activo', 'azucena');

INSERT INTO empleado (id,documento, tipo_documento, nombres, apellidos, telefono, cargo, direccion, fecha_ingreso, tipo_contrato, estado, supervisor)
VALUES ('2','1005648795', 'pasaporte', 'Jacinta', 'Ruiz', '+573152487715', 'lider', 'calle lima 135', '2023-05-05', 'indefinido', 'Activo', 'azucena');

INSERT INTO empleado (id,documento, tipo_documento, nombres, apellidos, telefono, cargo, direccion, fecha_ingreso, tipo_contrato, estado, supervisor)
VALUES ('3','37648957', 'cedula', 'Lucas', 'Tolima', '+573176437715', 'desarrollador', 'calle susan 185', '2020-05-05', 'indefinido', 'Activo', 'azucena');

INSERT INTO empleado (id,documento, tipo_documento, nombres, apellidos, telefono, cargo, direccion, fecha_ingreso, tipo_contrato, estado, supervisor)
 VALUES ('4','1005268784', 'cedula','Alejandra','Dominguez','+573175847715','desarrollador','calle peres 15','2021-06-25','indefinido','Activo','juan');


INSERT INTO solicitud_vacaciones (tipo_solicitud, fecha_inicio, fecha_fin, dias, comentario, estado,empleado_id, fecha,fecha_contratacion)
VALUES ('vacaciones', '2023-07-25', '2023-07-30', '5', 'vacaciones familiares','pendiente','4', '2023-06-25','2021-06-25');

INSERT INTO solicitud_vacaciones (tipo_solicitud, fecha_inicio, fecha_fin, dias, comentario, estado,empleado_id, fecha,fecha_contratacion)
VALUES ('vacaciones', '2021-05-05', '2021-05-30', '25', 'vacaciones familiares','aprovada','4', '2023-06-25','2021-06-25');

INSERT INTO solicitud_vacaciones (tipo_solicitud, fecha_inicio, fecha_fin, dias, comentario, estado,empleado_id, fecha,fecha_contratacion)
VALUES ('vacaciones', '2021-08-25', '2021-08-30', '5', 'vacaciones familiares','rechazada','3', '2023-06-25','2020-05-05');


