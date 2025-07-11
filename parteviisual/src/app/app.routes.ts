import { Routes } from '@angular/router';
import { Index } from './principal/index';

export const routes: Routes = [
    {
        path: "",
        component: Index
    },
    {
        path: 'grupo',
        loadComponent: () => import('./grupo/presentacion/grupo/grupo.component').then(m => m.GrupoComponent),
    },
    {
        path: 'fabricante',
        loadComponent: () => import('./fabricante/presentacion/fabricante/fabricante.component').then(m => m.FabricanteComponent),
    },
    {
        path: 'proveedor',
        loadComponent: () => import('./proveedor/presentacion/proveedor/proveedor.component').then(m => m.ProveedorComponent),
    },
    {
        path: 'producto',
        loadComponent: () => import('./producto/presentacion/producto/producto.component').then(m => m.ProductoComponent),
    },
];
