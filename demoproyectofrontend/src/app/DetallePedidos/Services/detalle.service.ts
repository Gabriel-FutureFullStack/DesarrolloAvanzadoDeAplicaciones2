import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { DetalleSearchFilter } from '../Models/detalle-search-filter';
import { DetallePage } from '../Models/detalle-page';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class DetalleService {
  apiUrlBasePath = "http://localhost:8080/api/v1/";
  httpOptions;

  constructor(private httpdetalle: HttpClient) {
    this.httpOptions = {
      headers: new HttpHeaders(
        {
          //'Authorization': 'Basic R2FicmllbDoxMjM=',
          'Content-Type': 'application/json'
        }
      )
    }
  }


  getAllPageable(filter: DetalleSearchFilter):Observable<DetallePage>{
    let filterparams = new HttpParams()
    .set('pageNumber', filter.pageNumber)
    .set('pageSize', filter.pageSize)
    .set('columnOrder', filter.columnOrder)
    .set('direction', filter.direction)
    .set('filter', filter.filter)
    
    return this.httpdetalle.get<DetallePage>(`${this.apiUrlBasePath}detalle-pedidos/page`, {params: filterparams, headers:this.httpOptions.headers});
  }

}
