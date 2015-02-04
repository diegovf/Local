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

// Insertar un int en el árbol ABB
void ArbolABB::Insertar(const int ced, string nom, string dir)
{
	nodo *padre = NULL;

	actual = raiz;
	// Buscar el int en el árbol, manteniendo un puntero al nodo padre
	while (!Vacio(actual) && ced != actual->cedula) {
		padre = actual;
		if (ced > actual->cedula) actual = actual->derecho;
		else if (ced< actual->cedula) actual = actual->izquierdo;
	}

	// Si se ha encontrado el elemento, regresar sin insertar
	if (!Vacio(actual)) return;
	// Si padre es NULL, entonces el árbol estaba vacío, el nuevo nodo será
	// el nodo raiz
	if (Vacio(padre)) raiz = new nodo(ced, nom, dir);
	// Si el int es menor que el que contiene el nodo padre, lo insertamos
	// en la rama izquierda
	else if (ced < padre->cedula) padre->izquierdo = new nodo(ced, nom, dir);
	// Si el int es mayor que el que contiene el nodo padre, lo insertamos
	// en la rama derecha
	else if (ced > padre->cedula) padre->derecho = new nodo(ced, nom, dir);
}

// Eliminar un elemento de un árbol ABB
void ArbolABB::Borrar(const int ced)
{
	nodo *padre = NULL;
	nodo *pnodo;
	int cedu;
	string nom, dir;

	actual = raiz;
	// Mientras sea posible que el valor esté en el árbol
	while (!Vacio(actual)) {
		if (ced == actual->cedula) { // Si el valor está en el nodo actual
			if (EsHoja(actual)) { // Y si además es un nodo hoja: lo borramos
				if (padre) // Si tiene padre (no es el nodo raiz)
					// Anulamos el puntero que le hace referencia
				if (padre->derecho == actual) padre->derecho = NULL;
				else if (padre->izquierdo == actual) padre->izquierdo = NULL;
				delete actual; // Borrar el nodo
				actual = NULL;
				return;
			}
			else { // Si el valor está en el nodo actual, pero no es hoja
				// Buscar nodo
				padre = actual;
				// Buscar nodo más izquierdo de rama derecha
				if (actual->derecho) {
					pnodo = actual->derecho;
					while (pnodo->izquierdo) {
						padre = pnodo;
						pnodo = pnodo->izquierdo;
					}
				}
				// O buscar nodo más derecho de rama izquierda
				else {
					pnodo = actual->izquierdo;
					while (pnodo->derecho) {
						padre = pnodo;
						pnodo = pnodo->derecho;
					}
				}
				// Intercambiar valores de no a borrar u nodo encontrado
				// y continuar, cerrando el bucle. El nodo encontrado no tiene
				// por qué ser un nodo hoja, cerrando el bucle nos aseguramos
				// de que sólo se eliminan nodos hoja.
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
		else { // Todavía no hemos encontrado el valor, seguir buscándolo
			padre = actual;
			if (ced > actual->cedula) actual = actual->derecho;
			else if (ced < actual->cedula) actual = actual->izquierdo;
		}
	}
}

// Recorrido de árbol en inorden, aplicamos la función func, que tiene
// el prototipo:
// void func(int&);
void ArbolABB::InOrden(void(*func)(int&), nodo *nodo, bool r)
{
	if (r) nodo = raiz;
	if (nodo->izquierdo) InOrden(func, nodo->izquierdo, false);
	func(nodo->cedula);
	if (nodo->derecho) InOrden(func, nodo->derecho, false);
}

// Recorrido de árbol en preorden, aplicamos la función func, que tiene
// el prototipo:
// void func(int&);
void ArbolABB::PreOrden(void(*func)(int&), nodo *nodo, bool r)
{
	if (r) nodo = raiz;
	func(nodo->cedula);
	if (nodo->izquierdo) PreOrden(func, nodo->izquierdo, false);
	if (nodo->derecho) PreOrden(func, nodo->derecho, false);
}

// Recorrido de árbol en postorden, aplicamos la función func, que tiene
// el prototipo:
// void func(int&);
void ArbolABB::PostOrden(void(*func)(int&), nodo *nodo, bool r)
{
	if (r) nodo = raiz;
	if (nodo->izquierdo) PostOrden(func, nodo->izquierdo, false);
	if (nodo->derecho) PostOrden(func, nodo->derecho, false);
	func(nodo->cedula);
}

// Buscar un valor en el árbol
bool ArbolABB::Buscar(const int dat)
{
	actual = raiz;

	// Todavía puede aparecer, ya que quedan nodos por mirar
	while (!Vacio(actual)) {
		if (dat == actual->cedula) return true; // int encontrado
		else if (dat > actual->cedula) actual = actual->derecho; // Seguir
		else if (dat < actual->cedula) actual = actual->izquierdo;
	}
	return false; // No está en árbol
}

// Buscar un cliente en el árbol
[STAThread]
nodo* ArbolABB::obtenerCliente(const int dat)
{
	actual = raiz;

	// Todavía puede aparecer, ya que quedan nodos por mirar
	while (!Vacio(actual)) {
		if (dat == actual->cedula) return actual; // int encontrado
		else if (dat > actual->cedula) actual = actual->derecho; // Seguir
		else if (dat < actual->cedula) actual = actual->izquierdo;
	}
	return actual; // No está en árbol
}

// Calcular la altura del nodo que contiene el int dat
int ArbolABB::Altura(const int dat)
{
	int altura = 0;
	actual = raiz;

	// Todavía puede aparecer, ya que quedan nodos por mirar
	while (!Vacio(actual)) {
		if (dat == actual->cedula) return altura; // int encontrado
		else {
			altura++; // Incrementamos la altura, seguimos buscando
			if (dat > actual->cedula) actual = actual->derecho;
			else if (dat < actual->cedula) actual = actual->izquierdo;
		}
	}
	return -1; // No está en árbol
}

// Contar el número de nodos
const int ArbolABB::NumeroNodos()
{
	contador = 0;

	auxContador(raiz); // FUnción auxiliar
	return contador;
}

// Función auxiliar para contar nodos. Función recursiva de recorrido en
//   preorden, el proceso es aumentar el contador
void ArbolABB::auxContador(nodo *nodo)
{
	contador++;  // Otro nodo
	// Continuar recorrido
	if (nodo->izquierdo) auxContador(nodo->izquierdo);
	if (nodo->derecho)   auxContador(nodo->derecho);
}

// Calcular la altura del árbol, que es la altura del nodo de mayor altura.
const int ArbolABB::AlturaArbol()
{
	altura = 0;

	auxAltura(raiz, 0); // Función auxiliar
	return altura;
}

// Función auxiliar para calcular altura. Función recursiva de recorrido en
// postorden, el proceso es actualizar la altura sólo en nodos hojas de mayor
// altura de la máxima actual
void ArbolABB::auxAltura(nodo *nodo, int a)
{
	// Recorrido postorden
	if (nodo->izquierdo) auxAltura(nodo->izquierdo, a + 1);
	if (nodo->derecho)   auxAltura(nodo->derecho, a + 1);
	// Proceso, si es un nodo hoja, y su altura es mayor que la actual del
	// árbol, actualizamos la altura actual del árbol
	if (EsHoja(nodo) && a > altura) altura = a;
}