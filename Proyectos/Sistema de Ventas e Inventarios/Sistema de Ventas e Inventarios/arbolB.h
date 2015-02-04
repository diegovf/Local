#include "arbolavl.h"
#include <iostream>
#include <stdlib.h>
#include <string>
#include <fstream>

using namespace std;

#pragma once;
struct stclave {
	int codSuper;
	string nombre;
	string direccion;
	long registro;
	ArbolAVL *avl;
};

class bnodo {
public:
	bnodo(int nClaves); // Constructor
	~bnodo();           // Destructor

private:
	int clavesUsadas;   // Claves usadas en el nodo
	stclave *clave;     // Array de claves del nodo
	bnodo **puntero;    // Array de punteros a bnodo
	bnodo *padre;       // Puntero a nodo padre

	friend class btree;
};

typedef bnodo *pbnodo;

#pragma once
class btree {
public:
	btree(int nClv);
	~btree();
	bool Buscar(int clave);
	string Buscar(int codSuper, int codProduc);
	stclave obtenerSupermercado(int clave);
	bool Insertar(stclave clave);
	void InsertarEnAVL(int, int, int);
	bool BuscarEnAVL(int cosSuper, int codProducto);
	int obtenerCantidadProducto(int, int);
	void cambiarCantidadProducto(int codS, int codP, int cant);
	void generarReporte(int);
	void Borrar(int clave);
	void Mostrar();

private:
	stclave *lista;
	pbnodo *listapunt;
	void Inserta(stclave clave, pbnodo nodo, pbnodo hijo1, pbnodo hijo2);
	void BorrarClave(pbnodo nodo, int valor);
	void BorrarNodo(pbnodo nodo);
	void PasarClaveDerecha(pbnodo derecha, pbnodo padre, pbnodo nodo, int posClavePadre);
	void PasarClaveIzquierda(pbnodo izquierda, pbnodo padre, pbnodo nodo, int posClavePadre);
	void FundirNodo(pbnodo izquierda, pbnodo &padre, pbnodo derecha, int posClavePadre);
	void Ver(pbnodo nodo);
	int nClaves, nodosMinimos;
	pbnodo Entrada;
};