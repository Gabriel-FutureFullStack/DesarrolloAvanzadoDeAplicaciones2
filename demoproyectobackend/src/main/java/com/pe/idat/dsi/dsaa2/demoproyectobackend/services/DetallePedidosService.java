package com.pe.idat.dsi.dsaa2.demoproyectobackend.services;


import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.detallepedidos.DetalleSorting;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.DetallePedidos;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.repositories.DetallePedidosRepository;

@Service
public class DetallePedidosService {

    private DetallePedidosRepository dPedidosRepository;

    public DetallePedidosService(DetallePedidosRepository dPedidosRepository){
        this.dPedidosRepository = dPedidosRepository;
    }
    public List<DetallePedidos> getAll() {
        return dPedidosRepository.findAll();
    }
    public List<DetallePedidos> getAll(DetalleSorting sorting){
        Sort detalleSorting = Sort.by(sorting.getDirecction().equals("asc")? Direction.ASC:Direction.DESC, sorting.getColumnOrder());
        return dPedidosRepository.findAllActiveDetalles(detalleSorting);
    
    }
}
