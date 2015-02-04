#include "arbolRN.h"
#include <fstream>

class NodoAA
{
public:
	NodoAA(int codigo)
	{
		codigo_super = codigo;
		nivel = 1;
		hizq = NULL;
		hder = NULL;
	}

	int nivel;
	int codigo_super;
	arbolRojoNegro *rojiNegro;
	NodoAA *hizq, *hder, *padre;

	friend class AA;
};
class AA
{
public:
	AA() { raiz = NULL; }
	NodoAA* Giro(NodoAA *R);
	NodoAA* Reparto(NodoAA *R);
	void insert(int);
	NodoAA* Insertar(int codigo, NodoAA *raiz);
	void Inorden(NodoAA *n);
	bool Recorrer(NodoAA *nodo, int valor, bool valido);
	NodoAA* Buscar(NodoAA *raiz, int valor, NodoAA *nodo);
	NodoAA* BuscarEnRN(NodoAA *raiz, int valor, int codS, NodoAA *nodo);
	NodoAA* BuscarCosto(NodoAA *raiz, int valor, NodoAA *nodo);
	NodoAA* InsertarEnRN(NodoAA *raiz, int valor, int codP, int cost, string des, NodoAA *nodo);
	NodoAA* CrearRN(NodoAA *raiz, int valor, int codP, int cost, string des, NodoAA *nodo);
	NodoAA* agregarEnRN(NodoAA *raiz, int valor, int codP, int cost, string des, NodoAA *nodo);
	NodoAA* crearrn(NodoAA *raiz, int valor, int codP, int cost, string des, NodoAA *nodo);

	NodoAA *raiz;
};