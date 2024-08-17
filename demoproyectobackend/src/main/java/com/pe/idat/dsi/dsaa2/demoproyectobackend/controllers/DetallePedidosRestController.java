package com.pe.idat.dsi.dsaa2.demoproyectobackend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.detallepedidos.DetalleGetByIDResponse;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.detallepedidos.DetalleInsertRequest;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.detallepedidos.DetalleInsertResponse;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.detallepedidos.DetallePageable;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.detallepedidos.DetallePageableResponse;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.detallepedidos.DetalleSorting;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.DetallePedidos;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Pedidos;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Productos;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.services.DetallePedidosService;
import com.pe.idat.dsi.dsaa2.demoproyectobackend.services.PedidosService;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.services.ProductosService;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("api/v1/detalle-pedidos")
public class DetallePedidosRestController {
    private DetallePedidosService detallePedidosService;
    private PedidosService pedidosService;
    private ProductosService productosService;

    public DetallePedidosRestController(DetallePedidosService detallePedidosService, PedidosService pedidosService, ProductosService productosService){
        this.detallePedidosService = detallePedidosService;
        this.pedidosService = pedidosService;
        this.productosService = productosService;
    }

    @GetMapping()
    public List<DetallePedidos> getAll(@RequestParam(defaultValue = "id", required = false) String columnOrder, @RequestParam(defaultValue = "asc", required = false) String direction) {
        DetalleSorting sorting = new DetalleSorting(columnOrder, direction);
        return detallePedidosService.getAll(sorting);
    }
    @GetMapping("/page")
    public ResponseEntity<DetallePageableResponse> getAllPageable(@RequestParam( required = false, defaultValue = "0") int pageNumber, 
                                                                @RequestParam(required = false, defaultValue = "10") int pageSize,
                                                                @RequestParam( required = false, defaultValue = "asc") String direction, 
                                                                @RequestParam(required = false, defaultValue = "id") String columnOrder,
                                                                @RequestParam(required = false, defaultValue = "") String filter)  
    {
        DetallePageable pageable = new DetallePageable(pageNumber, pageSize, columnOrder, direction,filter);
        Page<DetallePedidos> response = detallePedidosService.getAllPageable(pageable);

        if(response == null){
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(DetallePageableResponse.toDetallePageableResponse(response));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<DetalleGetByIDResponse> getById(@PathVariable Long id) {
        DetallePedidos detalle = detallePedidosService.getById(id);
        if (detalle == null || detalle.getDetalleId() == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(DetalleGetByIDResponse.toDetalleGetByIDResponse(detalle));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DetalleInsertResponse> insertDetalle(@RequestBody DetalleInsertRequest entity) {
        
        try{
            Pedidos pedido = pedidosService.getById(entity.getPedidoId());
            Productos producto = productosService.getById(entity.getProductoId());
            entity.setEstado("1");
            entity.setPrecioUnitario(productosService.getById(entity.getProductoId()).getPrecio());
            //Convertir DTO a entidad relacional 
            DetallePedidos detalle = entity.toDetallePedidos(pedido,producto);
            DetallePedidos saveDetalle = detallePedidosService.insertDetalle(detalle);
            
            if(saveDetalle == null || saveDetalle.getDetalleId() == 0){
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(DetalleInsertResponse.toDetalleInsertResponse(saveDetalle));
        }
        catch(Exception ex)
        {        
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new DetalleInsertResponse(null, null, null, 0, 0, "Ocurrió un error: " + ex.getMessage()));
        }
    }
    
}
