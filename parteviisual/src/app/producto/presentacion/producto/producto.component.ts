import { CommonModule } from '@angular/common';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Modal } from 'bootstrap';
import { Producto } from '../../dominio/producto';
import { ProductoService } from '../../aplicacion/producto.service';
import { Grupo } from '../../../grupo/dominio/grupo';
import { Fabricante } from '../../../fabricante/dominio/fabricante';
import { Proveedor } from '../../../proveedor/dominio/proveedor';
import { GrupoService } from '../../../grupo/aplicacion/grupo.service';
import { FabricanteService } from '../../../fabricante/aplicacion/fabricante.service';
import { ProveedorService } from '../../../proveedor/aplicacion/proveedor.service';

@Component({
  selector: 'app-producto.component',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './producto.component.html',
  styleUrl: './producto.component.css'
})
export class ProductoComponent implements OnInit {

  @ViewChild('modalProducto') modalProductoRef!: ElementRef;
  modal?: Modal;

  productos: Producto[] = [];
  producto: Producto = this.crearProductoVacio();
  editando = false;

  grupos: Grupo[] = [];
  fabricantes: Fabricante[] = [];
  proveedores: Proveedor[] = [];

  constructor(
    private productoService: ProductoService,
    private grupoService: GrupoService,
    private fabricanteService: FabricanteService,
    private proveedorService: ProveedorService
  ) { }

  ngOnInit(): void {
    this.cargarProductos();
    this.cargarCombos();
  }

  crearProductoVacio(): Producto {
    return {
      nombre: '',
      nombreExtranjero: '',
      codBarra: '',
      codAlternativo: '',
      peso: 0,
      unidadMedida: '',
      precio: 0,
      grupoId: 0,
      fabricanteId: 0,
      proveedorId: 0
    };
  }

  abrirNuevo(): void {
    this.producto = this.crearProductoVacio();
    this.editando = false;
    if (!this.modal) {
      this.modal = new Modal(this.modalProductoRef.nativeElement);
    }
    this.modal.show();
  }

  cargarProductos(): void {
    this.productoService.obtenerTodos().subscribe(data => this.productos = data);
  }

  guardar(): void {
    const obs = this.editando && this.producto.id
      ? this.productoService.actualizar(this.producto)
      : this.productoService.crear(this.producto);

    obs.subscribe(() => {
      this.reset();
      this.cargarProductos();
      this.cerrarModal();
    });
  }

  editar(producto: Producto): void {
    this.producto = { ...producto };
    this.editando = true;
    if (!this.modal) {
      this.modal = new Modal(this.modalProductoRef.nativeElement);
    }
    this.modal.show();
  }

  eliminar(id: number): void {
    if (confirm('¿Deseas eliminar este producto?')) {
      this.productoService.eliminarPorId(id).subscribe(() => this.cargarProductos());
    }
  }

  reset(): void {
    this.producto = this.crearProductoVacio();
    this.editando = false;
  }

  cerrarModal(): void {
    this.modal?.hide();
    this.reset();
  }

  cargarCombos(): void {
    this.grupoService.obtenerTodos().subscribe(data => this.grupos = data);
    this.fabricanteService.obtenerTodos().subscribe(data => this.fabricantes = data);
    this.proveedorService.obtenerTodos().subscribe(data => this.proveedores = data);
  }
}
