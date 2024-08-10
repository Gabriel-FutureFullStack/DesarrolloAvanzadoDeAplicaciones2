package com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.clientes;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ClientesPageableResponse {
    private int totalItems;
    private int pageNumber;
    private int totalPages;
    private int pageSize;
    private List<ClientesPageableItemResponse> items;

    public static ClientesPageableResponse toClientesPageableResponse(ClientesPageDto clientesPDto){
        return new ClientesPageableResponse(clientesPDto.getTotalItems(), 
                                            clientesPDto.getPageNumber(), 
                                            clientesPDto.getTotalPages(), 
                                            clientesPDto.getPageSize(), 
                                        clientesPDto.getItems().stream().map(ClientesPageableItemResponse::toClientesPageableItemResponse).toList());
                                        }
}
