package com.pe.idat.dsi.dsaa2.demoproyectobackend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.services.ProductoService;

@Controller
@RequestMapping("/api/v1/productos")
public class ProductosRestController {
    private ProductoService productoService;

    public ProductosRestController(ProductoService productoService){
        this.productoService = productoService;
    }
}
