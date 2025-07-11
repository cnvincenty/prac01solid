import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Grupo } from '../../dominio/grupo';
import { GrupoService } from '../../aplicacion/grupo.service';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Modal } from 'bootstrap';

@Component({
  selector: 'app-grupo.component',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './grupo.component.html',
  styleUrl: './grupo.component.css'
})
export class GrupoComponent implements OnInit {

  @ViewChild('modalGrupo') modalGrupoRef!: ElementRef; modal?: Modal;

  grupos: Grupo[] = [];
  grupo: Grupo = { codigo: '', nombre: '' };
  editando: boolean = false;

  constructor(private grupoService: GrupoService) { }

  ngOnInit(): void {
    this.cargarGrupos();
  }

  abrirNuevo(): void {
    this.grupo = { codigo: '', nombre: '' };
    this.editando = false;

    if (!this.modal) {
      this.modal = new Modal(this.modalGrupoRef.nativeElement);
    }

    this.modal.show();
  }

  cargarGrupos(): void {
    this.grupoService.obtenerTodos().subscribe((data) => (this.grupos = data));
  }

  guardar(): void {
    if (this.editando && this.grupo.id) {
      this.grupoService.actualizar(this.grupo).subscribe(() => {
        this.reset();
        this.cargarGrupos();
        this.cerrarModal();
      });
    } else {
      this.grupoService.crear(this.grupo).subscribe(() => {
        this.reset();
        this.cargarGrupos();
        this.cerrarModal();
      });
    }
  }

  editar(grupo: Grupo): void {
    this.grupo = { ...grupo };
    this.editando = true;

    if (!this.modal) {
      this.modal = new Modal(this.modalGrupoRef.nativeElement);
    }
    this.modal.show();
  }


  eliminar(id: number): void {
    if (confirm('¿Deseas eliminar este grupo?')) {
      this.grupoService.eliminarPorId(id).subscribe(() => {
        this.cargarGrupos();
      });
    }
  }

  reset(): void {
    this.grupo = { codigo: '', nombre: '' };
    this.editando = false;
  }

  cerrarModal(): void {
    this.modal?.hide();
    this.reset();
  }
}
