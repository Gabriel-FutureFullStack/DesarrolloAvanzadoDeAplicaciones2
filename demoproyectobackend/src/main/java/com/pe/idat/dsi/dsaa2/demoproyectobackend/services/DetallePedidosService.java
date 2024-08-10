package com.pe.idat.dsi.dsaa2.demoproyectobackend.services;


import com.pe.idat.dsi.dsaa2.demoproyectobackend.repositories.DetallePedidosRepository;

public class DetallePedidosService {

    private DetallePedidosRepository dPedidosRepository;

    public DetallePedidosService(DetallePedidosRepository dPedidosRepository){
        this.dPedidosRepository = dPedidosRepository;
    }
}
