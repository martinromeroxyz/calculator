
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

### TracerAPI

He implementado la funcionalidad de hacer trace de la respuesta utilizando la funcionalidad proporcionada 
en la clase TracerResponseBodyAdvice que implementa ResponseBodyAdvice<Object>. De esta forma esta funcionalidad 
es independiente del endpoint que invoquemos en la petición (en caso de ser necesario en el futuro).

He creado un @Component utilizando la interfaz y la implementación proporcionadas para aprovechar las ventajas 
de la inyección de dependencias.

### Operaciones

Para implementar las operaciones he utilizado la interfaz funcional BinaryOperator<T>. Las operaciones se definen en un 
HashMap donde la clave es el nombre de la operación y el valor es la lambda correspondiente. Este planteamiento permite que 
un funcionamiento genérico y escalable. Para añadir una nueva operación solo hay que agregar una nueva entrada en el HashMap 
correspondiente, incluyendo tanto operaciones binarias como unarias. 

Por ejemplo, el producto de dos números:

	operations.put("product", (a, b) -> a * b);
	
o el cuadrado del primer operando:

	operations.put("substract", (a, b) -> a * a);
	
He formateado la respuesta para que los enteros aparezcan como enteros y los decimales se muestren con dos dígitos 
después de la coma. 

### Otras consideraciones

He añadido un control de excepciones básico a nivel global (implementado también como un @ControllerAdvice) y test unitarios 
para las operaciones de suma y resta sobre la capa de servicio. 
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
