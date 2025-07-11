-- Insertar datos de ejemplo para Grupos
INSERT INTO grupo (codigo, nombre) VALUES ('ELEC', 'Electrónicos');
INSERT INTO grupo (codigo, nombre) VALUES ('HOGAR', 'Hogar y Cocina');
INSERT INTO grupo (codigo, nombre) VALUES ('ROPA', 'Ropa y Accesorios');

-- Insertar datos de ejemplo para Fabricantes
INSERT INTO fabricante (nombre) VALUES ('Samsung');
INSERT INTO fabricante (nombre) VALUES ('Apple');
INSERT INTO fabricante (nombre) VALUES ('Sony');

-- Insertar datos de ejemplo para Proveedores
INSERT INTO proveedor (nombre) VALUES ('Distribuidora Tech SA');
INSERT INTO proveedor (nombre) VALUES ('Importadora Global');
INSERT INTO proveedor (nombre) VALUES ('Comercial Bolivia');

-- Insertar datos de ejemplo para Productos
INSERT INTO producto (nombre, nombre_extranjero, cod_barra, cod_alternativo, peso, unidad_medida, precio, grupo_id, fabricante_id, proveedor_id)
VALUES ('Galaxy S24', 'Galaxy S24', '8801643740825', 'SAM-S24-001', 0.168, 'kg', 1200.00, 1, 1, 1);

INSERT INTO producto (nombre, nombre_extranjero, cod_barra, cod_alternativo, peso, unidad_medida, precio, grupo_id, fabricante_id, proveedor_id)
VALUES ('iPhone 15', 'iPhone 15', '194253106647', 'APL-IP15-001', 0.171, 'kg', 1500.00, 1, 2, 2);

INSERT INTO producto (nombre, nombre_extranjero, cod_barra, cod_alternativo, peso, unidad_medida, precio, grupo_id, fabricante_id, proveedor_id)
VALUES ('PlayStation 5', 'PlayStation 5', '711719541592', 'SNY-PS5-001', 4.5, 'kg', 800.00, 1, 3, 3);