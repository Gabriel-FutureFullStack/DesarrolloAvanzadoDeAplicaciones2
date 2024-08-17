package com.pe.idat.dsi.dsaa2.demoproyectobackend.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.detallepedidos.DetallePageable;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.detallepedidos.DetalleSorting;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.DetallePedidos;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Pedidos;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Productos;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.repositories.DetallePedidosRepository;

@Service
public class DetallePedidosService {
    //REPOSITORIO DETALLE-P[E]DIDOS
    private DetallePedidosRepository dPedidosRepository;
    //SERVICIOS
    private PedidosService pedidosService;
    private ProductosService productosService;
    //Me sugiere usar Autowired XD
    @Autowired
    public DetallePedidosService( PedidosService pedidosService, ProductosService productosService){
        this.pedidosService = pedidosService;
        this.productosService = productosService;     
    }

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
    public Page<DetallePedidos> getAllPageable(DetallePageable pageable){
        Sort detalleSorting = Sort.by(pageable.getDirection().equals("asc")? Direction.ASC:Direction.DESC, pageable.getColumnOrder());
        Pageable detallePageable = PageRequest.of(pageable.getPageNumber(),pageable.getPageSize(), detalleSorting);
        return dPedidosRepository.findAllPageableActiveDetalles(detallePageable, pageable.getFilter());
    }
    public DetallePedidos getById(Long id){
        Optional<DetallePedidos> response = dPedidosRepository.findById(id);
        if(!response.isPresent()){
            return null;
        }
        return response.get();
    }
    public DetallePedidos insertDetalle(DetallePedidos detalle){
        Pedidos pedido = pedidosService.getById(detalle.getPedido().getPedidoId());
        Productos producto = productosService.getById(detalle.getProducto().getProductoId());
        if (pedido == null || producto == null) {
            return null; 
        }
        detalle.setPedido(pedido);
        detalle.setProducto(producto);
        DetallePedidos response = dPedidosRepository.saveAndFlush(detalle);
        if(response.getDetalleId() == null || response.getDetalleId() == 0){
            return null;
        }
        return response;
    }
}
