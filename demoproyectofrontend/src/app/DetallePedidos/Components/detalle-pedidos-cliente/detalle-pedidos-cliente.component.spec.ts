import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetallePedidosClienteComponent } from './detalle-pedidos-cliente.component';

describe('DetallePedidosClienteComponent', () => {
  let component: DetallePedidosClienteComponent;
  let fixture: ComponentFixture<DetallePedidosClienteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DetallePedidosClienteComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DetallePedidosClienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
