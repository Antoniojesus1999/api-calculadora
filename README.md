# Calculadora
Microservicio de una calculadora realizado con Spring Boot y Swagger 2.

La calculadora traza todos los resultados usando la librería tracer-1.0.0.jar.
### Tecnologías

Apache Maven 3.9.2

Java JDK 17

#### Librerías necesarias
<!-- librería de tracer -->
		<dependency>
			<groupId>io.corp.calculator</groupId>
			<artifactId>tracer</artifactId>
			<version>1.0</version>
			<scope>system</scope>
			<systemPath>${basedir}/lib/tracer-1.0.0.jar</systemPath>
		</dependency>
---
## Estructura del Proyecto

El proyecto sigue una estructura típica de una aplicación Spring Boot:

- `src/main/java`: Contiene el código fuente de la aplicación.
    - `com.iteriam.sanitas.calculadora`: Paquete raíz del proyecto.
        - `config`: Contiene clases de configuración (configuración Bean Log).
        - `controller`: Contiene el controlador rest de la calculadora.
          - `constants`: Contiene las constantes que usamos en el controller.
          - `exception`: Contiene el modelo y metodos de las excepciones.
            - `model`: Contiene los modelos de las excepciones.
          - `impl`: Implementación del controller.
          - `responses`: Modelo de respuesta.
        - `log`: Interfaz del log.
          - `impl`: Implementación del log.
        - `model`: Model que utilizamos en el service para hacer las operaciones.
        - `service`: Contiene la lógica de negocio de la aplicación en este caso las operaciones de la calculadora.
          - `impl`: Implementación de la logica.
- `src/main/resources`: Contiene archivos de recursos.
    - `application.properties`: Archivo de configuración de la aplicación.
- `src/test`: Contiene las pruebas unitarias y de integración.
- `pom.xml`: Archivo de configuración de Maven que define las dependencias del proyecto.

#### Cómo compilar el microservicio en local

Para construir el proyecto se utilizarán los siguientes comandos:

> mvn clean install

Este comando ejecuta (en la carpeta del proyecto): 
1. Limpiar el target del proyecto.
2. Recogerá las librerías necesarias para el microservicio.
3. Compilará el proyecto con las propiedades de la carpeta `src/main/resources/application.properties`

---

#### Cómo ejecutar el microservicio en local
Siguiendo los pasos anteriores, bastaría con ejecutar el comando en la carpeta raíz del proyecto:

> mvn spring-boot:run

---

#### Servicios disponibles
Una vez lanzado el microservicio se podrá acceder al API accediendo a la siguiente URL:
> **local**: http://localhost:8080/swagger-ui.html

#### Ejemplos de llamadas al API

A continuación, se presentan ejemplos de las llamadas al API disponibles:
Todas las peticiones son de tipo GET sin cabeceras
    
    Parametros
        >> operand1
        >> operator
        >> operand2

**Suma satisfactoria:**
> **URL**: http://localhost:8080/operations?operand1=1.1&operator=ADD&operand2=1.1

Resultado esperado:
```json
{
  "data": {
    "result": 2.2
  }
}
```

**Resta satisfactoria:**
> **URL**: http://localhost:8080/operations?operand1=1.1&operator=SUB&operand2=0.9

Resultado esperado:
```json
{
    "data": {
        "result": 0.2
    }
}
```

**Petición con excepción por operador invalido:**
> **URL**: http://localhost:8080/operations?operand1=1.1&operator=LOQUESEA&operand2=0.9

Resultado esperado:
```json
{
  "errorCode": 500,
  "errorMessage": "Operación no soportada para el valor: LOQUESEA"
}

```
**Petición con excepción por falta de uno o dos operadores:**
> **URL**: http://localhost:8080/operations?operand1=&operator=ADD&operand2=

Resultado esperado:
```json
{
  "errorCode": 400,
  "errorMessage": "Falta operadores, Porfavor introduzca operador 1 y operador 2 para hacer el cálculo."
}
```