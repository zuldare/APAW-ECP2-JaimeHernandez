# APAW. Práctica ECP2: Desarrollo de un mini API-Rest simulado a partir de un modelo de entidades
> Este proyecto pretende ser un ejemplo de arquitectura de un API-Rest simulado para comprender las capas que intervienen y la organización de los diferentes tipos de tests, con integración continua y control de la calidad del código.
>
> El modelo de entidades ha sido indicado en la retroalimentación de la práctica ECP1. También puede observarse en la siguiente figura

   [[https://github.com/zuldare/APAW-ECP2-JaimeHernandez/blob/develop/docs/wiki/ECP-task-user.png]]

> #### [Máster en Ingeniería Web por la Universidad Politécnica de Madrid (miw-upm)](http://miw.etsisi.upm.es)
> #### Asignatura: *Arquitectura y Patrones para Aplicaciones Web*

#### Para organizar el desarrollo de la práctica se crearán **6 issues** con su descripción concisa en la wiki. Cada issue corresponde a la creación de una operación en el API-Rest y el proceso de trabajo para cada uno de esos issues será el siguiente:

##### Fase 1: Definición del API Rest e implementación del dispatcher con los DTOs
1. Definición de la **petición** en la wiki. Se detallarán con los valores enviados y devueltos, los estados devueltos con sus códigos y las posibles excepciones provocadas. Si se prefiere, se pueden definir las seis a la vez, en este caso, se realizará un **issue** por fase.
1. Copia del **paquete http** para la simulación de http, se puede localizar en este mismo repositorio
1. Programación de los **Test de Funcionalidad**
1. Programación del **Dispatcher**. Dependiendo de los recursos, devolverá valores fijos para pasar los test

##### Fase 2: Desarrollo de los paquetes _resources_ & _resources.exception_
1. Implementación de los paquetes de los recursos y las excepciones. 
1. Se realizará el control de datos de las diferentes peticiones con las excepciones necesarias para aquellos casos de error
1. Se conectará el Dispatcher con los diferentes métodos de las clases de recursos. Los recursos devolverán valores fijos para superar los test

##### Fase 3: Desarrollo de los paquetes _controllers_, _entities_ & _daos_
1. Implementación de las entidades con algún test unitario
1. Implementación de los daos. Se podrán copiar de este mismo repositorio
1. Ampliación de los DTOs para que se construyan a partir de entidades con sus test unitarios
1. Programación de los controladores con sus test de integración
1. Conectar el paquete de recursos con el paquete de controladores y superar los test de funcionalidad
