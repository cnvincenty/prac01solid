import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment.development';
import { HttpClient } from '@angular/common/http';
import { Proveedor } from '../dominio/proveedor';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProveedorService {

  private readonly url = `${environment.apiUrl}/proveedores`;

  constructor(private httpCliente: HttpClient) {}

  obtenerTodos(): Observable<Proveedor[]> {
    return this.httpCliente.get<Proveedor[]>(this.url);
  }

  obtenerPorId(id: number): Observable<Proveedor> {
    return this.httpCliente.get<Proveedor>(`${this.url}/${id}`);
  }

  crear(proveedor: Proveedor): Observable<Proveedor> {
    return this.httpCliente.post<Proveedor>(this.url, proveedor);
  }

  actualizar(proveedor: Proveedor): Observable<Proveedor> {
    return this.httpCliente.put<Proveedor>(`${this.url}/${proveedor.id}`, proveedor);
  }

  eliminarPorId(id: number): Observable<Proveedor> {
    return this.httpCliente.delete<Proveedor>(`${this.url}/${id}`);
  }
}
