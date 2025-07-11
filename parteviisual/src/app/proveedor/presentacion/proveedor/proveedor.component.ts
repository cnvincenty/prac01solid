import { CommonModule } from '@angular/common';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Modal } from 'bootstrap';
import { Proveedor } from '../../dominio/proveedor';
import { ProveedorService } from '../../aplicacion/proveedor.service';

@Component({
  selector: 'app-proveedor.component',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './proveedor.component.html',
  styleUrl: './proveedor.component.css'
})
export class ProveedorComponent implements OnInit{
  @ViewChild('modalProveedor') modalProveedorRef!: ElementRef; modal?: Modal;

  proveedores: Proveedor[] = [];
  proveedor: Proveedor = { nombre: '' };
  editando: boolean = false;

  constructor(private proveedorService: ProveedorService) { }

  ngOnInit(): void {
    this.cargarProveedors();
  }

  abrirNuevo(): void {
    this.proveedor = { nombre: '' };
    this.editando = false;

    if (!this.modal) {
      this.modal = new Modal(this.modalProveedorRef.nativeElement);
    }

    this.modal.show();
  }

  cargarProveedors(): void {
    this.proveedorService.obtenerTodos().subscribe((data) => (this.proveedores = data));
  }

  guardar(): void {
    if (this.editando && this.proveedor.id) {
      this.proveedorService.actualizar(this.proveedor).subscribe(() => {
        this.reset();
        this.cargarProveedors();
        this.cerrarModal();
      });
    } else {
      this.proveedorService.crear(this.proveedor).subscribe(() => {
        this.reset();
        this.cargarProveedors();
        this.cerrarModal();
      });
    }
  }

  editar(proveedor: Proveedor): void {
    this.proveedor = { ...proveedor };
    this.editando = true;

    if (!this.modal) {
      this.modal = new Modal(this.modalProveedorRef.nativeElement);
    }
    this.modal.show();
  }


  eliminar(id: number): void {
    if (confirm('¿Deseas eliminar este proveedor?')) {
      this.proveedorService.eliminarPorId(id).subscribe(() => {
        this.cargarProveedors();
      });
    }
  }

  reset(): void {
    this.proveedor = { nombre: '' };
    this.editando = false;
  }

  cerrarModal(): void {
    this.modal?.hide();
    this.reset();
  }
}
