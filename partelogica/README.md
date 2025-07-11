# Sistema de Gestión de Productos - Aplicando Principios SOLID

## Grupo C
- Ing. Joaquin Gonzales Mosquera
- Ing. Edson Mancilla Rodriguez  
- Ing. Juan Jose Miranda Mendoza
- Ing. Milena Mollinedo Franco
- Ing. César Nilton Vincenty Funes

## Descripción del Proyecto

API REST desarrollada en **Spring Boot** para la gestión de productos, aplicando los principios SOLID y arquitectura por capas. El sistema permite registrar y administrar productos con sus respectivos fabricantes, proveedores y grupos.

## Tecnologías Utilizadas

- **Backend**: Spring Boot 3.5.3, Java 17
- **Base de Datos**: MySQL 8.0
- **Documentación**: OpenAPI/Swagger
- **Infraestructura**: AWS (EC2, RDS) con Terraform
- **Build Tool**: Maven

## Arquitectura por Capas

```
├── Controller Layer    (Controladores REST)
├── Service Layer      (Lógica de negocio)
├── Repository Layer   (Acceso a datos)
└── Domain Layer       (Entidades y DTOs)
```

## Aplicación de Principios SOLID

### **S - Single Responsibility Principle (SRP)**
- **Entidades separadas**: `Producto`, `Fabricante`, `Proveedor`, `Grupo`
- **Servicios específicos**: Cada servicio maneja una sola entidad
- **Controladores dedicados**: Un controlador por recurso

### **O - Open/Closed Principle (OCP)**
- **Interfaces de servicio**: Extensibles sin modificar código existente
- **Spring Data JPA**: Repositorios extensibles automáticamente

### **L - Liskov Substitution Principle (LSP)**
- **Implementaciones intercambiables**: Las implementaciones de servicio pueden sustituirse
- **Polimorfismo**: Uso de interfaces en lugar de clases concretas

### **I - Interface Segregation Principle (ISP)**
- **Interfaces específicas**: Cada servicio tiene su propia interfaz
- **DTOs especializados**: Objetos de transferencia específicos por entidad

### **D - Dependency Inversion Principle (DIP)**
- **Inyección de dependencias**: Spring maneja todas las dependencias
- **Abstracciones**: Dependencia de interfaces, no implementaciones

## Mapeo de Campos (Consigna Original → Implementación)

| Campo Original | Implementación |
|---|---|
| `cSku` | `id` (Long, auto-generado) |
| `cNombre` | `nombre` |
| `cNombreExtranjero` | `nombreExtranjero` |
| `cCodGrupoProducto` + `cNombreGrupoProducto` | `Grupo` (entidad separada) |
| `cSkuFabricante` + `cNmbFabricante` | `Fabricante` (entidad separada) |
| `cNmbProveedor` | `Proveedor` (entidad separada) |
| `nPeso` | `peso` |
| `cUM` | `unidadMedida` |
| `nPrecioLista` | `precio` (BigDecimal) |
| `cCodBarra` | `codBarra` |
| `cSkuAlternante` | `codAlternativo` |

## Endpoints API

### Productos
- `GET /api/productos` - Listar productos
- `POST /api/productos` - Crear producto
- `GET /api/productos/{id}` - Obtener producto
- `PUT /api/productos/{id}` - Actualizar producto
- `DELETE /api/productos/{id}` - Eliminar producto

### Fabricantes, Proveedores, Grupos
- Misma estructura CRUD para cada entidad
- Endpoints: `/api/fabricantes`, `/api/proveedores`, `/api/grupos`

## Ejecución Local

```bash
# Clonar repositorio
git clone <repo-url>
cd partelogica

# Configurar MySQL
# Editar src/main/resources/application.properties

# Ejecutar aplicación
mvn spring-boot:run
```

**URLs disponibles:**
- API: http://localhost:8080
- Swagger UI: http://localhost:8080/swagger-ui.html
- API Docs: http://localhost:8080/api-docs

## Despliegue en AWS

Infraestructura automatizada con **Terraform**:

```bash
cd terraform
cp terraform.tfvars.example terraform.tfvars
# Editar terraform.tfvars
terraform init
terraform apply
```

**Recursos creados:**
- EC2 t2.micro (aplicación)
- RDS MySQL t3.micro (base de datos)
- VPC con subnets públicas/privadas
- Security Groups configurados

## Estructura del Proyecto

```
src/main/java/bo/edu/uagrm/soe/prac01solid/
├── aplicacion/
│   ├── dto/           # Data Transfer Objects
│   ├── mappers/       # Conversores DTO ↔ Entity
│   └── service/       # Interfaces y servicios
├── controller/        # Controladores REST
├── domain/
│   ├── entity/        # Entidades JPA
│   └── repository/    # Repositorios Spring Data
├── config/           # Configuraciones
└── exception/        # Manejo de excepciones
```

## Beneficios de la Implementación

✅ **Mantenibilidad**: Código organizado y fácil de modificar
✅ **Escalabilidad**: Arquitectura preparada para crecimiento
✅ **Testabilidad**: Dependencias inyectadas facilitan testing
✅ **Documentación**: API autodocumentada con Swagger
✅ **Despliegue**: Infraestructura como código con Terraform