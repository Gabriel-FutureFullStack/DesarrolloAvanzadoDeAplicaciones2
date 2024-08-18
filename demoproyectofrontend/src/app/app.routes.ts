import { Routes } from '@angular/router';
import { ClientesComponent } from './Clientes/Components/clientes/clientes.component';
import { ClientesCreateComponent } from './Clientes/Components/clientes-create/clientes-create.component';
import { ClientesEditComponent } from './Clientes/Components/clientes-edit/clientes-edit.component';
import { DetallesPedidosComponent } from './DetallePedidos/Components/detalles-pedidos/detalles-pedidos.component';
import { ConfiguracionComponent } from './Config/Components/configuracion/configuracion.component';

export const routes: Routes = [

    {
        path: 'settings',
        component: ConfiguracionComponent
    },
    {
        path: 'clients',
        component: ClientesComponent
    },
    {
        path: 'clients/new',
        component: ClientesCreateComponent
    },
    {
        path: 'clients/:id',
        component: ClientesEditComponent
    },
    {
        path: 'details',
        component: DetallesPedidosComponent
    },
];
