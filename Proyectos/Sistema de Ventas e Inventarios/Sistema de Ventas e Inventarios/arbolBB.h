#include <iostream>
#include <string>
#include <string.h>
using namespace std;
#pragma once

using namespace System;
class nodo {
public:
	// Constructor:
	nodo(const int ced, string nom, string dir, nodo *izq = NULL, nodo *der = NULL) :
		cedula(ced), izquierdo(izq), derecho(der), direccion(dir), nombre(nom) {}
	// Miembros:
	int cedula;
	string nombre, direccion;
	nodo *izquierdo;
	nodo *derecho;
	friend class ArbolABB;
};
typedef nodo* pnb;

#pragma	once
class ArbolABB {
private:
	//// Clase local de Lista para Nodo de ArbolBinario:
	

	// Punteros de la lista, para cabeza y nodo actual:
	nodo *raiz;
	nodo *actual;
	int contador;
	int altura;

public:
	// Constructor y destructor básicos:
	ArbolABB() : raiz(NULL), actual(NULL) {}
	~ArbolABB() { Podar(raiz); }
	// Insertar en árbol ordenado:
	void Insertar(const int ced, string nom, string dir);
	// Borrar un elemento del árbol:
	void Borrar(const int dat);
	// Función de búsqueda:
	bool Buscar(const int ced);
	// Función para obtener un cliente
	nodo* obtenerCliente(const int ced);
	// Comprobar si el árbol está vacío:
	bool Vacio(nodo *r) { return r == NULL; }
	// Comprobar si es un nodo hoja:
	bool EsHoja(nodo *r) { return !r->derecho && !r->izquierdo; }
	// Contar número de nodos:
	const int NumeroNodos();
	const int AlturaArbol();
	// Calcular altura de un int:
	int Altura(const int dat);
	// Devolver referencia al int del nodo actual:
	int &ValorActual() { return actual->cedula; }
	// Moverse al nodo raiz:
	void Raiz() { actual = raiz; }
	// Aplicar una función a cada elemento del árbol:
	void InOrden(void(*func)(int&), nodo *nodo = NULL, bool r = true);
	void PreOrden(void(*func)(int&), nodo *nodo = NULL, bool r = true);
	void PostOrden(void(*func)(int&), nodo *nodo = NULL, bool r = true);
private:
	// Funciones auxiliares
	void Podar(nodo* &);
	void auxContador(nodo*);
	void auxAltura(nodo*, int);
};
