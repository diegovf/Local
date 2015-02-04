#include <iostream>
#include <stdlib.h>

using namespace std;
#pragma once
class nodoAVL {
public:
	// Constructor:
	nodoAVL(const int CodSup, int CodPro, int Cant, nodoAVL *pad = NULL, nodoAVL *izq = NULL, nodoAVL *der = NULL) :
		CodSupermercado(CodSup), CodProducto(CodPro), Cantidad(Cant), padre(pad), izquierdo(izq), derecho(der), FE(0) {}
	// Miembros:
	int CodSupermercado;
	int CodProducto;
	int Cantidad;
	int FE;
	nodoAVL *izquierdo;
	nodoAVL *derecho;
	nodoAVL *padre;
};