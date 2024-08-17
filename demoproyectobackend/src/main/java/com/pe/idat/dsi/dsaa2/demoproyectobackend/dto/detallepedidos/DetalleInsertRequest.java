package com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.detallepedidos;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.DetallePedidos;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DetalleInsertRequest {
    private Long detalleId;
    private Long pedidoId;
    private Long productoId;
    private int cantidad;
    private double precioUnitario;
    private String estado;

    public DetallePedidos toDetallePedidos(){
        return new DetallePedidos(
        this.detalleId,
        null,
        null,
        this.cantidad,
        this.precioUnitario,
        this.estado);
    }

}
