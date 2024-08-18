import { Component } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatListModule} from '@angular/material/list';
import {MatSidenavModule} from '@angular/material/sidenav';
import { Menu } from './Models/Menu';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,
    MatIconModule,
    MatButtonModule,
    MatToolbarModule,
    MatSidenavModule,
    MatListModule,
    ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'Demo Proyecto Frontend V2';
  menu: Menu[];
  showFiller = false;
  constructor(private router: Router){
    this.menu = this.populateMenu();
  }
  
  populateMenu(){
    let menu: Menu[]=[
      new Menu('Configuracion', 'settings', 'settings'),
      new Menu('Clientes', 'clients', 'person'),
      new Menu('Productos', 'productos', 'person'),
      new Menu('Pedidos', 'orders', 'person'),
      new Menu('Detalle de Pedidos', 'details', 'person'),
    ];
    return menu;
  }
  redirectTo(path: string){
    this.router.navigate([path]);
  }

}
