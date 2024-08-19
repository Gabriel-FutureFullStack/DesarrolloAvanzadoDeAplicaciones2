export interface DetallePage {
    totalItems: number;
    totalPages: number;
    items:Item[];
}

export interface Item {
  detalleId: number;
  pedidoID: number; 
  producto: string; 
  cantidad: number;
  precioUnitario: number;
  estado: string;
}


