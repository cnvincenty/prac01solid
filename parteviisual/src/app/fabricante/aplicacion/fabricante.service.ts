import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment.development';
import { Fabricante } from '../dominio/fabricante';

@Injectable({
  providedIn: 'root'
})
export class FabricanteService {

  private readonly url = `${environment.apiUrl}/v1/fabricante`;

  constructor(private httpCliente: HttpClient) {}

  obtenerTodos(): Observable<Fabricante[]> {
    return this.httpCliente.get<Fabricante[]>(this.url);
  }

  obtenerPorId(id: number): Observable<Fabricante> {
    return this.httpCliente.get<Fabricante>(`${this.url}/${id}`);
  }

  crear(fabricante: Fabricante): Observable<Fabricante> {
    return this.httpCliente.post<Fabricante>(this.url, fabricante);
  }

  actualizar(fabricante: Fabricante): Observable<Fabricante> {
    return this.httpCliente.put<Fabricante>(`${this.url}/${fabricante.id}`, fabricante);
  }

  eliminarPorId(id: number): Observable<Fabricante> {
    return this.httpCliente.delete<Fabricante>(`${this.url}/${id}`);
  }
}
