#include <iostream>
#include <stdlib.h> 
#include <string.h>
#include <stdio.h>
#include <conio.h>
#include <windows.h>
#include <fstream>
#include <iostream>

using namespace std;

class nodoRojoNegro
{ // los nodos del arbol
public:
	int CodProducto;
	int Costo;
	string Descripcion;
	char color; // donde r es rojo y n es negro
	nodoRojoNegro *izquierdo;
	nodoRojoNegro *derecho;
	nodoRojoNegro *padre;
	friend class arbolRojoNegro;
	nodoRojoNegro(int CodPro, int CodCost, string Descrip)
	{
		CodProducto = CodPro;
		Costo = CodCost;
		Descripcion = Descrip;
		izquierdo = derecho = padre = NULL;
	}

};
typedef nodoRojoNegro *nodoRN;

class arbolRojoNegro
{
public:
	nodoRojoNegro* raiz;
	arbolRojoNegro()
	{
		raiz = NULL;
	}
	//nodoRojoNegro *buscar(int key); // para buscar un numero en el arbolito
	//void ver(nodoRojoNegro *node, int esp, int h); // ver el arbol
	// funciones
	nodoRN buscar(int pKey);
	void ver(nodoRojoNegro *node, int esp, int h);
	void solucionarRojoRojo(nodoRojoNegro *node, int h);
	void insercion(int key, int pCosto, string Descrip);
	void insertar(int codS, int codP, int pCosto, string pDescripcion);
	int obtenerCosto(int key);
};
typedef arbolRojoNegro *RojiNegro;