#include <string>
using namespace std;

#include <string>
#pragma once
struct Archivos{
	// metodos arbol binario de busqueda
	void leerArchivoCliente();
	void guardarCliente(int ced, string nom, string dir);
	void buscarCliente(int ced);

	// metodos arbol B
	void leerArchivoSupermercado();
	void guardarSupermercado(int cod, string nom, string dir);
	void buscarSupermercado(int codigo);

	// metodos arbol avl
	void leerArchivoInventario();
	void buscarCantidadDeProducto(int codSuper, int codProduc);
	void generarReporteProductos(int codSuper);

	// metodos arbol AA
	void leerArchivoProducto();
	void buscarProducto(int codS, int codProduc);
	void agregarProducto(int codS, int codP, int cost, string des);

	friend int main();
};