export interface Producto {
    id?: number;
    nombre: string;
    nombreExtranjero: string;
    codBarra: string;
    codAlternativo: string;
    peso: number;
    unidadMedida: string;
    precio: number;
    fabricanteId: number;
    proveedorId: number;
    grupoId: number;
}
