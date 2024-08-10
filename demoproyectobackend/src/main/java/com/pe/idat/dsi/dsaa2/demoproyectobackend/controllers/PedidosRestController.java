package com.pe.idat.dsi.dsaa2.demoproyectobackend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.services.PedidosService;

@Controller
@RequestMapping("/api/v1/pedidos")
public class PedidosRestController {

    private PedidosService pService;

    public PedidosRestController(PedidosService pService){
        this.pService = pService;
    }
}
