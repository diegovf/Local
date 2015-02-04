#include "nodoavl.h"
#include <fstream>
#pragma once

class ArbolAVL {
private:
	enum { IZQUIERDO, DERECHO };
	// Punteros de la lista, para cabeza y nodo actual:
	nodoAVL *raiz;
	nodoAVL *actual;
	int contador;
	int altura;

public:
	// Constructor y destructor básicos:
	ArbolAVL() : raiz(NULL), actual(NULL) {}
	~ArbolAVL() { Podar(raiz); }
	// Insertar en árbol ordenado:
	void Insertar(const int CodSup, int CodPro, int Cant);
	nodoAVL * obtenerRaiz(){ return raiz; }
	// Borrar un elemento del árbol:
	void Borrar(const int dat);
	// Función de búsqueda:
	bool Buscar(const int dat);
	bool Buscar(const int codigo, const int codProduc);
	int obtenerCantidad(int codSuper, int codProduc);
	void cambiarCantidad(int codSuper, int codProduc, int cant);
	// Comprobar si el árbol está vacío:
	bool Vacio(nodoAVL *r) { return r == NULL; }
	// Comprobar si es un nodo hoja:
	bool EsHoja(nodoAVL *r) { return !r->derecho && !r->izquierdo; }
	// Contar número de nodos:
	const int NumeroNodos();
	const int AlturaArbol();
	// Calcular altura de un dato:
	int Altura(const int dat);
	// Devolver referencia al dato del nodo actual:
	int &ValorActual() { return actual->CodProducto; }
	// Moverse al nodo raiz:
	void Raiz() { actual = raiz; }
	// Aplicar una función a cada elemento del árbol:
	void InOrden(void(*func)(int&, int), nodoAVL *nodo = NULL, bool r = true);
	void PreOrden(void(*func)(int&, int), nodoAVL *nodo = NULL, bool r = true);
	void reportePreOrden(void(*func)(int&, int), nodoAVL *nodo, bool);
	void PostOrden(void(*func)(int&, int), nodoAVL *nodo = NULL, bool r = true);

private:
	// Funciones de equilibrado:
	void Equilibrar(nodoAVL *nodo, int, bool);
	void RSI(nodoAVL* nodo);
	void RSD(nodoAVL* nodo);
	void RDI(nodoAVL* nodo);
	void RDD(nodoAVL* nodo);
	// Funciones auxiliares
	void Podar(nodoAVL* &);
	void auxContador(nodoAVL*);
	void auxAltura(nodoAVL*, int);
};