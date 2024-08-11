package com.pe.idat.dsi.dsaa2.demoproyectobackend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.detallepedidos.DetalleSorting;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.DetallePedidos;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.services.DetallePedidosService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/v1/detalle-pedidos")
public class DetallePedidosRestController {
    private DetallePedidosService detallePedidosService;

    public DetallePedidosRestController(DetallePedidosService detallePedidosService){
        this.detallePedidosService = detallePedidosService;
    }

    @GetMapping()
    public List<DetallePedidos> getAll(@RequestParam(defaultValue = "id", required = false) String columnOrder, @RequestParam(defaultValue = "asc", required = false) String direction) {
        DetalleSorting sorting = new DetalleSorting(columnOrder, direction);
        return detallePedidosService.getAll(sorting);
    }
    
}
