package com.pe.idat.dsi.dsaa2.demoproyectobackend.services;

import org.springframework.stereotype.Service;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.repositories.PedidosRepository;

@Service
public class PedidosService {

    private PedidosRepository pRepository;
    
    public PedidosService(PedidosRepository pRepository){
        this.pRepository = pRepository;
    }

}
