#include "arbolAA.h"

NodoAA* AA::Giro(NodoAA *R)
{
	if (R->hizq != NULL)
	{
		if (R->hizq->nivel == R->nivel)
		{
			NodoAA *L = R->hizq;
			R->hizq = L->hder;
			L->hder = R;
			R->padre = L;
			return L;
		}
		else
			return R;
	}
	return R;
}

NodoAA* AA::Reparto(NodoAA *R)
{
	if (R->hder != NULL && R->hder->hder != NULL)
	{
		if (R->nivel == R->hder->hder->nivel)
		{
			NodoAA *S = R->hder;
			R->hder = S->hizq;
			S->hizq = R;
			R->padre = S;
			S->nivel++;
			return S;
		}
		else
			return R;
	}
	return R;
}

void AA::insert(int codigo){
	raiz = Insertar(codigo, raiz);
}

NodoAA* AA::Insertar(int codigo, NodoAA *raiz)
{
	if (raiz == NULL)
		return new NodoAA(codigo);
	else
	{
		if (codigo < raiz->codigo_super)
			raiz->hizq = Insertar(codigo, raiz->hizq);
		else
		{
			if (codigo > raiz->codigo_super)
				raiz->hder = Insertar(codigo, raiz->hder);
		}
	}
	raiz = Giro(raiz);
	raiz = Reparto(raiz);
	return raiz;
}

void AA::Inorden(NodoAA *n)
{
	if (n != NULL)
	{
		Inorden(n->hizq);
		cout << n->codigo_super << " - ";
		Inorden(n->hder);
	}
}

bool AA::Recorrer(NodoAA *nodo, int valor, bool valido)
{
	cout << "entro" << endl;
	if (nodo != NULL && !valido)
	{
		cout << "entro2" << endl;
		valido = Recorrer(nodo->hizq, valor, valido);
		if (valor == nodo->codigo_super || valido)
		{
			cout << "valido" << endl;
			return true;
		}
		valido = Recorrer(nodo->hder, valor, valido);
	}
	if (valido)
	{
		cout << "valido = true" << endl;
		return true;
	}
	else
	{
		cout << "valido = false" << endl;
		return false;
	}
}

NodoAA* AA::Buscar(NodoAA *raiz, int valor, NodoAA *nodo)
{
	if (raiz != NULL)
	{
		nodo = Buscar(raiz->hizq, valor, nodo);
		if (valor == raiz->codigo_super)
			return raiz;
		nodo = Buscar(raiz->hder, valor, nodo);
	}
	return nodo;
}


NodoAA* AA::InsertarEnRN(NodoAA *raiz, int valor, int codP, int cost, string des, NodoAA *nodo)
{
	if (raiz != NULL)
	{
		nodo = InsertarEnRN(raiz->hizq, valor, codP, cost, des, nodo);
		if (valor == raiz->codigo_super){
			raiz->rojiNegro->insercion(codP, cost, des);
			return raiz;
		}
		nodo = InsertarEnRN(raiz->hder, valor, codP, cost, des, nodo);
	}
	return nodo;
}

// metodo utulizado por agregarProducto
NodoAA* AA::agregarEnRN(NodoAA *raiz, int valor, int codP, int cost, string des, NodoAA *nodo)
{
	if (raiz != NULL)
	{
		nodo = agregarEnRN(raiz->hizq, valor, codP, cost, des, nodo);
		if (valor == raiz->codigo_super){
			raiz->rojiNegro->insertar(valor, codP, cost, des);
			return raiz;
		}
		nodo = agregarEnRN(raiz->hder, valor, codP, cost, des, nodo);
	}
	return nodo;
}

NodoAA* AA::CrearRN(NodoAA *raiz, int valor, int codP, int cost, string des, NodoAA *nodo)
{
	if (raiz != NULL)
	{
		nodo = CrearRN(raiz->hizq, valor, codP, cost, des, nodo);
		if (valor == raiz->codigo_super){
			raiz->rojiNegro = new arbolRojoNegro();
			raiz->rojiNegro->insercion(codP, cost, des);
			return raiz;
		}
		nodo = CrearRN(raiz->hder, valor, codP, cost, des, nodo);
	}
	return nodo;
}


NodoAA* AA::crearrn(NodoAA *raiz, int valor, int codP, int cost, string des, NodoAA *nodo)
{
	if (raiz != NULL)
	{
		nodo = crearrn(raiz->hizq, valor, codP, cost, des, nodo);
		if (valor == raiz->codigo_super){
			raiz->rojiNegro = new arbolRojoNegro();
			raiz->rojiNegro->insertar(valor, codP, cost, des);
			return raiz;
		}
		nodo = crearrn(raiz->hder, valor, codP, cost, des, nodo);
	}
	return nodo;
}

NodoAA* AA::BuscarEnRN(NodoAA *raiz, int valor, int codP, NodoAA *nodo)
{
	if (raiz != NULL)
	{
		nodo = BuscarEnRN(raiz->hizq, valor, codP, nodo);
		if (valor == raiz->codigo_super){
			raiz->rojiNegro->buscar(codP);
			return raiz;
		}
		nodo = BuscarEnRN(raiz->hder, valor, codP, nodo);
	}
	return nodo;
}

// metodo para buscar el costo de un producto 
NodoAA* AA::BuscarCosto(NodoAA *raiz, int valor, NodoAA *nodo)
{
	if (raiz != NULL)
	{
		nodo = BuscarCosto(raiz->hizq, valor, nodo);
		if (valor == raiz->codigo_super){
			return raiz;
		}
		nodo = BuscarCosto(raiz->hder, valor, nodo);
	}
	return nodo;
}