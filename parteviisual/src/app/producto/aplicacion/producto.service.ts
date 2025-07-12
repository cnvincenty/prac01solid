import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment.development';
import { HttpClient } from '@angular/common/http';
import { Producto } from '../dominio/producto';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  private readonly url = `${environment.apiUrl}/productos`;

  constructor(private httpCliente: HttpClient) {}

  obtenerTodos(): Observable<Producto[]> {
    return this.httpCliente.get<Producto[]>(this.url);
  }

  obtenerPorId(id: number): Observable<Producto> {
    return this.httpCliente.get<Producto>(`${this.url}/${id}`);
  }

  crear(producto: Producto): Observable<Producto> {
    return this.httpCliente.post<Producto>(this.url, producto);
  }

  actualizar(producto: Producto): Observable<Producto> {
    return this.httpCliente.put<Producto>(`${this.url}/${producto.id}`, producto);
  }

  eliminarPorId(id: number): Observable<Producto> {
    return this.httpCliente.delete<Producto>(`${this.url}/${id}`);
  }

}
