CREATE DATABASE IF NOT EXISTS proyectodsa2;
Use proyectodsa2;
-- Insertar datos de ejemplo en clientes
INSERT INTO clientes (nombre_cliente, direccion, telefono, email) VALUES
('Juan Perez', 'Calle Falsa 123', '1234567890', 'juan.perez@example.com'),
('Maria Lopez', 'Avenida Siempre Viva 456', '0987654321', 'maria.lopez@example.com');

-- Insertar datos de ejemplo en productos
INSERT INTO productos (nombre_producto, descripcion, precio, stock) VALUES
('Producto 1', 'Descripción del Producto 1', 10.00, 100),
('Producto 2', 'Descripción del Producto 2', 20.00, 50);

-- Insertar datos de ejemplo en pedidos
INSERT INTO pedidos (cliente_id, fecha, total) VALUES
(1, '2024-08-04', 30.00),
(2, '2024-08-05', 20.00);

-- Insertar datos de ejemplo en detalle_pedidos
INSERT INTO detalle_pedidos (pedido_id, producto_id, cantidad, precio_unitario) VALUES
(1, 1, 2, 10.00),
(1, 2, 1, 10.00),
(2, 2, 1, 20.00);