
# Calculator POC

Implementación de un microservicio "calculadora" usando maven + spring-boot (prueba de concepto).

### Punto de partida

Para empezar he creado un nuevo proyecto Spring-Boot utilizando [spring-initilizr](https://start.spring.io/) 
con las dependencias Spring Web, Spring Boot DevTools y Lombok.

### Arranque del proyecto
Una vez clonado ejecutar en el directorio raíz:

	./mvnw spring-boot:run

### Formato de la petición

El microservicio responde a la siguiente petición GET para realizar los cálculos: 

	http://localhost:8080/calc/add?op1=1&op2=1
	
La operación a realizar se define como un PathParam y los operandos como QueryParams. Se han 
implementado inicialmente las operaciones *add* y *substract*. 

He marcado como obligatorio solo el primer operando. De esta forma la aplicación es más escalable 
porque se podrán implementar operaciones unarias en el futuro.
