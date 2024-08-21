import { Component, ElementRef, ViewChild } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatSort, MatSortModule } from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table';
import { RouterModule } from '@angular/router';
import { DetalleService } from '../../Services/detalle.service';
import { Item } from '../../Models/detalle-page';
import { DetalleSearchFilter } from '../../Models/detalle-search-filter';
import { Router } from 'express';

@Component({
  selector: 'app-detalle-pedidos-cliente',
  standalone: true,
  imports: [RouterModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    MatTableModule,
    MatSortModule,
    MatButtonModule,
    MatPaginatorModule],
  templateUrl: './detalle-pedidos-cliente.component.html',
  styleUrl: './detalle-pedidos-cliente.component.scss'
})
export class DetallePedidosClienteComponent {
  title = "Detalles de:" + "${usuario}"
  detalles: Item[] = [];
  clienteId: number = 1
  displayedColumns = ['detalleId','pedidoId', 'producto','cantidad','precioUnitario'];
  filter:DetalleSearchFilter;
  isLoadingResults= false;
  totalItems;

  @ViewChild(MatPaginator) paginator: MatPaginator | undefined;
  @ViewChild(MatSort) sort: MatSort | undefined;
  @ViewChild('input', {static: true}) filterInput:ElementRef | undefined;
  
  constructor(private detalleService: DetalleService, private router: Router) { 
    this.filter =new DetalleSearchFilter(0, 5, "id", "asc", "");
    this.totalItems = 0;
    this.detalles = [] as Item[];
  }

  ngOnInit(): void {
    this.detalleService.getDetallesByCliente(this.clienteId, this.filter).subscribe(
      response => {
        console.log(response);
        this.totalItems = response.totalItems;
        this.detalles = response.items
        
        this.isLoadingResults = false;
      },
      error => {
        this.isLoadingResults = false;
        console.log("Ocurrio un error al recuperar los detalles del pedido =>", error);
      }
    );
  }
  applyFilter() {
    if (this.filterInput && this.filterInput.nativeElement) {
      this.filter.filter = this.filterInput.nativeElement.value.trim();
      this.ngOnInit();
    }
  }
}
