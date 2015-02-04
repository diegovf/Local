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
	// Constructor y destructor b�sicos:
	ArbolABB() : raiz(NULL), actual(NULL) {}
	~ArbolABB() { Podar(raiz); }
	// Insertar en �rbol ordenado:
	void Insertar(const int ced, string nom, string dir);
	// Borrar un elemento del �rbol:
	void Borrar(const int dat);
	// Funci�n de b�squeda:
	bool Buscar(const int ced);
	// Funci�n para obtener un cliente
	nodo* obtenerCliente(const int ced);
	// Comprobar si el �rbol est� vac�o:
	bool Vacio(nodo *r) { return r == NULL; }
	// Comprobar si es un nodo hoja:
	bool EsHoja(nodo *r) { return !r->derecho && !r->izquierdo; }
	// Contar n�mero de nodos:
	const int NumeroNodos();
	const int AlturaArbol();
	// Calcular altura de un int:
	int Altura(const int dat);
	// Devolver referencia al int del nodo actual:
	int &ValorActual() { return actual->cedula; }
	// Moverse al nodo raiz:
	void Raiz() { actual = raiz; }
	// Aplicar una funci�n a cada elemento del �rbol:
	void InOrden(void(*func)(int&), nodo *nodo = NULL, bool r = true);
	void PreOrden(void(*func)(int&), nodo *nodo = NULL, bool r = true);
	void PostOrden(void(*func)(int&), nodo *nodo = NULL, bool r = true);
private:
	// Funciones auxiliares
	void Podar(nodo* &);
	void auxContador(nodo*);
	void auxAltura(nodo*, int);
};
