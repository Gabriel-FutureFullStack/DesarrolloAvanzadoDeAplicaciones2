package com.pe.idat.dsi.dsaa2.demoproyectobackend.dto.clientes;

import java.util.List;

import com.pe.idat.dsi.dsaa2.demoproyectobackend.models.Clientes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class ClientesPageDto {
    private int totalItems;
    private int pageNumber;
    private int totalPages;
    private int pageSize;
    private List<Clientes> items;
}
