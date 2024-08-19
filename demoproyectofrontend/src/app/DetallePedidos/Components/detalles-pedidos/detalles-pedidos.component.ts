import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatSort, MatSortModule } from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table';
import { Router, RouterModule } from '@angular/router';
import { Item } from '../../Models/detalle-page';
import { DetalleSearchFilter } from '../../Models/detalle-search-filter';
import { MatDialog } from '@angular/material/dialog';
import { DetalleService } from '../../Services/detalle.service';
import { DetalleData } from '../../Models/detalle-data';
import { ItemDialogComponent } from '../../../CommonComponents/item-dialog/item-dialog.component';

@Component({
  selector: 'app-detalles-pedidos',
  standalone: true,
  imports: [RouterModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule,
    MatTableModule,
    MatSortModule,
    MatButtonModule,
    MatPaginatorModule],
  templateUrl: './detalles-pedidos.component.html',
  styleUrl: './detalles-pedidos.component.scss'
})
export class DetallesPedidosComponent implements OnInit{
  title = 'Detalle pedidos de Usuario'
  displayedColumns = ['pedido','cliente', 'producto','cantidad','precioUnitario', 'actions']
  dataSource: Item[] = [];
  filter:DetalleSearchFilter;
  isLoadingResults= false;
  totalItems;

  @ViewChild(MatPaginator) paginator: MatPaginator | undefined;
  @ViewChild(MatSort) sort: MatSort | undefined;
  @ViewChild('input', {static: true}) filterInput:ElementRef | undefined;

  constructor(public dialog: MatDialog, private router: Router, private detalleService: DetalleService){
    this.filter =new DetalleSearchFilter(0, 5, "id", "asc", "");
    this.dataSource = [] as Item[];
    this.totalItems = 0;
  }

  ngOnInit(): void {
    this.isLoadingResults = true;
    this.detalleService.getAllPageable(this.filter)
    .subscribe(
      response => {
        console.log(response);
        this.totalItems = response.totalItems;
        this.dataSource = response.items
        
        this.isLoadingResults = false;
      },
      error => {
        this.isLoadingResults = false;
        console.log("Ocurrio un error al recuperar los detalles del pedido =>", error);
      }
    );
  }
  editDetalle(detalle:DetalleData) {
    this.router.navigate(['details/'+ detalle.detalleId]);
  }
  
  deleteDetalle(detalle:DetalleData) {
    let deleteDialogRef = this.dialog.open(ItemDialogComponent, {
      width: '300px',
      data: {
        title: 'Eliminar Detalle',
        message:`Esta seguro que desea eliminar el registro detalle?`
      },
      
    });
  }
}
