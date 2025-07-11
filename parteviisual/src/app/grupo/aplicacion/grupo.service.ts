import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment.development';
import { Grupo } from '../dominio/grupo';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class GrupoService {

  private readonly url = `${environment.apiUrl}/v1/grupo`;

  constructor(private httpCliente: HttpClient) {}

  obtenerTodos(): Observable<Grupo[]> {
    return this.httpCliente.get<Grupo[]>(this.url);
  }

  obtenerPorId(id: number): Observable<Grupo> {
    return this.httpCliente.get<Grupo>(`${this.url}/${id}`);
  }

  crear(grupo: Grupo): Observable<Grupo> {
    return this.httpCliente.post<Grupo>(this.url, grupo);
  }

  actualizar(grupo: Grupo): Observable<Grupo> {
    return this.httpCliente.put<Grupo>(`${this.url}/${grupo.id}`, grupo);
  }

  eliminarPorId(id: number): Observable<Grupo> {
    return this.httpCliente.delete<Grupo>(`${this.url}/${id}`);
  }

}
