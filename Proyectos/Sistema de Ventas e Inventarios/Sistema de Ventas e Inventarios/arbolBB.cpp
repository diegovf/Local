#include "arbolBB.h"
#include "ventanaInfo.h"

using namespace System::Windows::Forms;
using namespace System;
// Poda: borrar todos los nodos a partir de uno, incluido
void ArbolABB::Podar(nodo* &nodo)
{
	// Algoritmo recursivo, recorrido en postorden
	if (nodo) {
		Podar(nodo->izquierdo); // Podar izquierdo
		Podar(nodo->derecho);   // Podar derecho
		delete nodo;            // Eliminar nodo
		nodo = NULL;
	}
}

// Insertar un int en el �rbol ABB
void ArbolABB::Insertar(const int ced, string nom, string dir)
{
	nodo *padre = NULL;

	actual = raiz;
	// Buscar el int en el �rbol, manteniendo un puntero al nodo padre
	while (!Vacio(actual) && ced != actual->cedula) {
		padre = actual;
		if (ced > actual->cedula) actual = actual->derecho;
		else if (ced< actual->cedula) actual = actual->izquierdo;
	}

	// Si se ha encontrado el elemento, regresar sin insertar
	if (!Vacio(actual)) return;
	// Si padre es NULL, entonces el �rbol estaba vac�o, el nuevo nodo ser�
	// el nodo raiz
	if (Vacio(padre)) raiz = new nodo(ced, nom, dir);
	// Si el int es menor que el que contiene el nodo padre, lo insertamos
	// en la rama izquierda
	else if (ced < padre->cedula) padre->izquierdo = new nodo(ced, nom, dir);
	// Si el int es mayor que el que contiene el nodo padre, lo insertamos
	// en la rama derecha
	else if (ced > padre->cedula) padre->derecho = new nodo(ced, nom, dir);
}

// Eliminar un elemento de un �rbol ABB
void ArbolABB::Borrar(const int ced)
{
	nodo *padre = NULL;
	nodo *pnodo;
	int cedu;
	string nom, dir;

	actual = raiz;
	// Mientras sea posible que el valor est� en el �rbol
	while (!Vacio(actual)) {
		if (ced == actual->cedula) { // Si el valor est� en el nodo actual
			if (EsHoja(actual)) { // Y si adem�s es un nodo hoja: lo borramos
				if (padre) // Si tiene padre (no es el nodo raiz)
					// Anulamos el puntero que le hace referencia
				if (padre->derecho == actual) padre->derecho = NULL;
				else if (padre->izquierdo == actual) padre->izquierdo = NULL;
				delete actual; // Borrar el nodo
				actual = NULL;
				return;
			}
			else { // Si el valor est� en el nodo actual, pero no es hoja
				// Buscar nodo
				padre = actual;
				// Buscar nodo m�s izquierdo de rama derecha
				if (actual->derecho) {
					pnodo = actual->derecho;
					while (pnodo->izquierdo) {
						padre = pnodo;
						pnodo = pnodo->izquierdo;
					}
				}
				// O buscar nodo m�s derecho de rama izquierda
				else {
					pnodo = actual->izquierdo;
					while (pnodo->derecho) {
						padre = pnodo;
						pnodo = pnodo->derecho;
					}
				}
				// Intercambiar valores de no a borrar u nodo encontrado
				// y continuar, cerrando el bucle. El nodo encontrado no tiene
				// por qu� ser un nodo hoja, cerrando el bucle nos aseguramos
				// de que s�lo se eliminan nodos hoja.
				cedu = actual->cedula;
				nom = actual->nombre;
				dir = actual->direccion;

				actual->cedula = pnodo->cedula;
				actual->nombre = pnodo->nombre;
				actual->direccion = pnodo->direccion;

				pnodo->cedula = cedu;
				pnodo->nombre = nom;
				pnodo->direccion = dir;
				actual = pnodo;
			}
		}
		else { // Todav�a no hemos encontrado el valor, seguir busc�ndolo
			padre = actual;
			if (ced > actual->cedula) actual = actual->derecho;
			else if (ced < actual->cedula) actual = actual->izquierdo;
		}
	}
}

// Recorrido de �rbol en inorden, aplicamos la funci�n func, que tiene
// el prototipo:
// void func(int&);
void ArbolABB::InOrden(void(*func)(int&), nodo *nodo, bool r)
{
	if (r) nodo = raiz;
	if (nodo->izquierdo) InOrden(func, nodo->izquierdo, false);
	func(nodo->cedula);
	if (nodo->derecho) InOrden(func, nodo->derecho, false);
}

// Recorrido de �rbol en preorden, aplicamos la funci�n func, que tiene
// el prototipo:
// void func(int&);
void ArbolABB::PreOrden(void(*func)(int&), nodo *nodo, bool r)
{
	if (r) nodo = raiz;
	func(nodo->cedula);
	if (nodo->izquierdo) PreOrden(func, nodo->izquierdo, false);
	if (nodo->derecho) PreOrden(func, nodo->derecho, false);
}

// Recorrido de �rbol en postorden, aplicamos la funci�n func, que tiene
// el prototipo:
// void func(int&);
void ArbolABB::PostOrden(void(*func)(int&), nodo *nodo, bool r)
{
	if (r) nodo = raiz;
	if (nodo->izquierdo) PostOrden(func, nodo->izquierdo, false);
	if (nodo->derecho) PostOrden(func, nodo->derecho, false);
	func(nodo->cedula);
}

// Buscar un valor en el �rbol
bool ArbolABB::Buscar(const int dat)
{
	actual = raiz;

	// Todav�a puede aparecer, ya que quedan nodos por mirar
	while (!Vacio(actual)) {
		if (dat == actual->cedula) return true; // int encontrado
		else if (dat > actual->cedula) actual = actual->derecho; // Seguir
		else if (dat < actual->cedula) actual = actual->izquierdo;
	}
	return false; // No est� en �rbol
}

// Buscar un cliente en el �rbol
[STAThread]
nodo* ArbolABB::obtenerCliente(const int dat)
{
	actual = raiz;

	// Todav�a puede aparecer, ya que quedan nodos por mirar
	while (!Vacio(actual)) {
		if (dat == actual->cedula) return actual; // int encontrado
		else if (dat > actual->cedula) actual = actual->derecho; // Seguir
		else if (dat < actual->cedula) actual = actual->izquierdo;
	}
	return actual; // No est� en �rbol
}

// Calcular la altura del nodo que contiene el int dat
int ArbolABB::Altura(const int dat)
{
	int altura = 0;
	actual = raiz;

	// Todav�a puede aparecer, ya que quedan nodos por mirar
	while (!Vacio(actual)) {
		if (dat == actual->cedula) return altura; // int encontrado
		else {
			altura++; // Incrementamos la altura, seguimos buscando
			if (dat > actual->cedula) actual = actual->derecho;
			else if (dat < actual->cedula) actual = actual->izquierdo;
		}
	}
	return -1; // No est� en �rbol
}

// Contar el n�mero de nodos
const int ArbolABB::NumeroNodos()
{
	contador = 0;

	auxContador(raiz); // FUnci�n auxiliar
	return contador;
}

// Funci�n auxiliar para contar nodos. Funci�n recursiva de recorrido en
//   preorden, el proceso es aumentar el contador
void ArbolABB::auxContador(nodo *nodo)
{
	contador++;  // Otro nodo
	// Continuar recorrido
	if (nodo->izquierdo) auxContador(nodo->izquierdo);
	if (nodo->derecho)   auxContador(nodo->derecho);
}

// Calcular la altura del �rbol, que es la altura del nodo de mayor altura.
const int ArbolABB::AlturaArbol()
{
	altura = 0;

	auxAltura(raiz, 0); // Funci�n auxiliar
	return altura;
}

// Funci�n auxiliar para calcular altura. Funci�n recursiva de recorrido en
// postorden, el proceso es actualizar la altura s�lo en nodos hojas de mayor
// altura de la m�xima actual
void ArbolABB::auxAltura(nodo *nodo, int a)
{
	// Recorrido postorden
	if (nodo->izquierdo) auxAltura(nodo->izquierdo, a + 1);
	if (nodo->derecho)   auxAltura(nodo->derecho, a + 1);
	// Proceso, si es un nodo hoja, y su altura es mayor que la actual del
	// �rbol, actualizamos la altura actual del �rbol
	if (EsHoja(nodo) && a > altura) altura = a;
}