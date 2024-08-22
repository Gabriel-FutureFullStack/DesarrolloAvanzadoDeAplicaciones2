package com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.servicios;


import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Servicios;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ServiciosPageableItemResponse {
    private Long servicioId;
    private String nombreServicio;
    private String descripcion;
    private double precio;
    private String estado; 

    public static ServiciosPageableItemResponse toServiciosPageableItemResponse(Servicios servicios){
        return new ServiciosPageableItemResponse(
            servicios.getServicioId(), 
            servicios.getNombreServicio(), 
            servicios.getDescripcion(), 
            servicios.getPrecio(),
            servicios.getEstado());
    }
}
