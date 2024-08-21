export interface DetallePage {
  totalPages: number;
  totalElements: number;
  size: number;
  content: Item[];  // Este campo corresponde al array de detalles
  number: number;
  sort: Sort;
  first: boolean;
  last: boolean;
  numberOfElements: number;
  pageable: Pageable;
  empty: boolean;
}

export interface Item {
  detalleId: number;
  pedido: {
      pedidoId: number;
      cliente: {
          clienteId: number;
          nombreCliente: string;
          direccion: string;
          usuario: string;
          clave: string;
          email: string;
          telefono: string;
          estado: string;
      };
      fecha: string;
      total: number;
      estado: string;
  };
  producto: {
      productoId: number;
      nombreProducto: string;
      descripcion: string;
      precio: number;
      stock: number;
      estado: string;
  };
  cantidad: number;
  precioUnitario: number;
  estado: string;
}

export interface Sort {
  empty: boolean;
  sorted: boolean;
  unsorted: boolean;
}

export interface Pageable {
  pageNumber: number;
  pageSize: number;
  sort: Sort;
  offset: number;
  paged: boolean;
  unpaged: boolean;
}