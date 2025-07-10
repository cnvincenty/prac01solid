# Practica 01 SOLID
## Grupo C
Ing. Joaquin Gonzales Mosquera
Ing. Edson Mancilla Rodriguez
Ing. Juan Jose Miranda Mendoza
Ing. Milena Mollinedo Franco
Ing. César Nilton Vincenty Funes

## Problema
* Desarrollar una aplicación Escritorio/Web para poder registrar los datos maestro de un producto. Donde los campos mínimos son lo definido en la clase base de ejemplo. Aplique los principios SOLID.
* Aplicar programación en capas.
* Deben realizar una presentación donde mencione en que parte utilizaron los principios SOLID y exponer.

```
class Producto {
    private string cSku;
    private string cNombre;
    private string cNombreExtranjero;
    private string cCodGrupoProducto;
    private string cNombreGrupoProducto;
    private string cSkuFabricante;
    private string cNmbFabricante;
    private string cNmbProveedor;
    private decimal nPeso;
    private string cUM;
    private decimal nPrecioLista;
    private string cCodBarra;
    private string cSkuAlternante;
    public string CSku { get => cSku; set => cSku = value; }
    public string CNombre { get => cNombre; set => cNombre = value; }
    public string CSkuFabricante { get => cSkuFabricante; set => cSkuFabricante = value; }
    public string CNmbFabricante { get => cNmbFabricante; set => cNmbFabricante = value; }
    public string CNmbProveedor { get => cNmbProveedor; set => cNmbProveedor = value; }
    public decimal NPeso { get => nPeso; set => nPeso = value; }
    public string CUM { get => cUM; set => cUM = value; }
    public decimal NPrecioLista { get => nPrecioLista; set => nPrecioLista = value; }
    public string CCodBarra { get => cCodBarra; set => cCodBarra = value; }
    public string CSkuAlternante { get => cSkuAlternante; set => cSkuAlternante = value; }
    private Array GetSkuAlternante(string cSkuBase)
    {
    string[] aSkuAlternate = { "", "" };
    return aSkuAlternate;
    }
    public void RegistrarGrupoProduco() { }
    public void RegistrarProducto() { }
    public void RegistrarProveedorProducto(){ }
    public void RegistrarPrecioBaseProducto(){ }
    public void RegistrarMinimoMaximoMRPAlmacen(){ }
}
```

## Estilo de arquitectura por capas

## SOLID

S (Principio de Responsabilidad Única)

Aplicando:
Producto(cCodGrupoProducto, cNombreGrupoProducto) => Grupo(codigo, grupo)

