# Introducción
> Gestión de tareas y los usuarios que forman parte de esta tarea.
>
> Esta aplicación permitirá realizar operaciones relacionadas con tareas, estados de las mismas y usuarios pertenecientes a tareas.

## Entities
A continuación presentamos el diagrama de clases del paquete de entidades:  
![Entidades](https://github.com/zuldare/APAW-ECP2-JaimeHernandez/blob/develop/docs/wiki/ECP-task-user.png)

# API Rest
## Leer una tarea concreta `GET /tasks/{id}` 
> Devuelve la información de una tarea concreta que corresponde con la tarea con el mismo identificador indicado en la URI.

Ejemplo: `GET /tasks/5`

Parámetros | Respuesta | Respuesta si _id_ no entero
--|--|--
-- | `OK (200) {"id":5,"state":"CREATED"}` | `BAD_REQUEST(400)`<br>`{"error":"RequestInvalidException"}`

## Crear una nueva tarea `POST /tasks` 
> Crea una nueva tarea, devolviendo el id de la tarea creada.

Ejemplo: `POST /tasks`

Parámetros | Respuesta | Respuesta errónea
--|--|--
--| `CREATED (201) {"id":5}` |`BAD_REQUEST(400)`

## Borrar una tarea `DELETE /tasks/{id}`
> Borra una tarea concreta, no devolviendo nada en el cuerpo

Ejemplo: `DELETE /tasks/1`

Parámetros | Respuesta
--|--
--| `NO CONTENT (204)`

## Devolver la lista de usuarios que realizan una tarea `GET /tasks/{id}/users`
> Devuelve el listado de usuarios que realizan una tarea concreta.

Ejemplo: `GET /tasks/{id}/1`

Parámetros | Respuesta | Respuesta si <br/>id no existe <br/>id no entero
--|--|--
--|`OK (200) {{"id":1,"state":"IN_PROGRESS"},[{"name":"Robert Martin"},{"name":"Kent Beck"}]}`|`BAD_REQUEST(400)` <br>`{"error":"TaskIdNotFoundException"}`<br> `{"error":"RequestInvalidException"}`