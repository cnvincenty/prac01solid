import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Modal } from 'bootstrap';
import { Fabricante } from '../../dominio/fabricante';
import { FabricanteService } from '../../aplicacion/fabricante.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-fabricante.component',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './fabricante.component.html',
  styleUrl: './fabricante.component.css'
})
export class FabricanteComponent implements OnInit{

  @ViewChild('modalFabricante') modalFabricanteRef!: ElementRef; modal?: Modal;

  fabricantes: Fabricante[] = [];
  fabricante: Fabricante = { nombre: '' };
  editando: boolean = false;

  constructor(private fabricanteService: FabricanteService) { }

  ngOnInit(): void {
    this.cargarFabricantes();
  }

  abrirNuevo(): void {
    this.fabricante = { nombre: '' };
    this.editando = false;

    if (!this.modal) {
      this.modal = new Modal(this.modalFabricanteRef.nativeElement);
    }

    this.modal.show();
  }

  cargarFabricantes(): void {
    this.fabricanteService.obtenerTodos().subscribe((data) => (this.fabricantes = data));
  }

  guardar(): void {
    if (this.editando && this.fabricante.id) {
      this.fabricanteService.actualizar(this.fabricante).subscribe(() => {
        this.reset();
        this.cargarFabricantes();
        this.cerrarModal();
      });
    } else {
      this.fabricanteService.crear(this.fabricante).subscribe(() => {
        this.reset();
        this.cargarFabricantes();
        this.cerrarModal();
      });
    }
  }

  editar(fabricante: Fabricante): void {
    this.fabricante = { ...fabricante };
    this.editando = true;

    if (!this.modal) {
      this.modal = new Modal(this.modalFabricanteRef.nativeElement);
    }
    this.modal.show();
  }


  eliminar(id: number): void {
    if (confirm('¿Deseas eliminar este fabricante?')) {
      this.fabricanteService.eliminarPorId(id).subscribe(() => {
        this.cargarFabricantes();
      });
    }
  }

  reset(): void {
    this.fabricante = { nombre: '' };
    this.editando = false;
  }

  cerrarModal(): void {
    this.modal?.hide();
    this.reset();
  }
}
