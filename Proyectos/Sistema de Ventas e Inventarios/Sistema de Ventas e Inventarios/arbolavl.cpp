#include "arbolAVL.h"

// Poda: borrar todos los nodos a partir de uno, incluido
void ArbolAVL::Podar(nodoAVL* &nodo)
{
	// Algoritmo recursivo, recorrido en postorden
	if (nodo) {
		Podar(nodo->izquierdo); // Podar izquierdo
		Podar(nodo->derecho);   // Podar derecho
		delete nodo;            // Eliminar nodo
		nodo = NULL;
	}
}

// Insertar un dato en el �rbol AVL Llave: codProduc
void ArbolAVL::Insertar(const int CodSup, int CodPro, int Cant)
{
	nodoAVL *padre = NULL;
	cout << "Insertar: " << CodPro << endl;
	actual = raiz;
	// Buscar el dato en el �rbol, manteniendo un puntero al nodo padre
	while (!Vacio(actual) && (CodPro != actual->CodProducto || CodSup != actual->CodSupermercado)) {
		padre = actual;
		if (CodPro >= actual->CodProducto) actual = actual->derecho;
		else if (CodPro < actual->CodProducto) actual = actual->izquierdo;
	}
	// Si se ha encontrado el elemento, regresar sin insertar
	if (!Vacio(actual)) {
		return;
	}
	// Si padre es NULL, entonces el �rbol estaba vac�o, el nuevo nodo ser�
	// el nodo raiz
	if (Vacio(padre)) {
		raiz = new nodoAVL(CodSup, CodPro, Cant);
	}
	// Si el dato es menor que el que contiene el nodo padre, lo insertamos
	// en la rama izquierda
	else if (CodPro < padre->CodProducto) {

		padre->izquierdo = new nodoAVL(CodSup, CodPro, Cant, padre);
		Equilibrar(padre, IZQUIERDO, true);
	}
	// Si el dato es mayor que el que contiene el nodo padre, lo insertamos
	// en la rama derecha
	else if (CodPro >= padre->CodProducto) {
		padre->derecho = new nodoAVL(CodSup, CodPro, Cant, padre);
		Equilibrar(padre, DERECHO, true);
	}
}

// Equilibrar �rbol AVL partiendo del nodo nuevo
void ArbolAVL::Equilibrar(nodoAVL *nodo, int rama, bool nuevo)
{
	bool salir = false;

	// Recorrer camino inverso actualizando valores de FE:
	while (nodo && !salir) {
		if (nuevo)
		if (rama == IZQUIERDO) nodo->FE--; // Depende de si a�adimos ...
		else                  nodo->FE++;
		else
		if (rama == IZQUIERDO) nodo->FE++; // ... o borramos
		else                  nodo->FE--;
		if (nodo->FE == 0) salir = true; // La altura de las rama que
		// empieza en nodo no ha variado,
		// salir de Equilibrar
		else if (nodo->FE == -2) { // Rotar a derechas y salir:
			if (nodo->izquierdo->FE == 1) RDD(nodo); // Rotaci�n doble
			else RSD(nodo);                         // Rotaci�n simple
			salir = true;
		}
		else if (nodo->FE == 2) {  // Rotar a izquierdas y salir:
			if (nodo->derecho->FE == -1) RDI(nodo); // Rotaci�n doble
			else RSI(nodo);                        // Rotaci�n simple
			salir = true;
		}
		if (nodo->padre)
		if (nodo->padre->derecho == nodo) rama = DERECHO; else rama = IZQUIERDO;
		nodo = nodo->padre; // Calcular FE, siguiente nodo del camino.
	}
}

// Rotaci�n doble a derechas
void ArbolAVL::RDD(nodoAVL* nodo)
{
	cout << "RDD" << endl;
	nodoAVL *Padre = nodo->padre;
	nodoAVL *P = nodo;
	nodoAVL *Q = P->izquierdo;
	nodoAVL *R = Q->derecho;
	nodoAVL *B = R->izquierdo;
	nodoAVL *C = R->derecho;

	if (Padre)
	if (Padre->derecho == nodo) Padre->derecho = R;
	else Padre->izquierdo = R;
	else raiz = R;

	// Reconstruir �rbol:
	Q->derecho = B;
	P->izquierdo = C;
	R->izquierdo = Q;
	R->derecho = P;

	// Reasignar padres:
	R->padre = Padre;
	P->padre = Q->padre = R;
	if (B) B->padre = Q;
	if (C) C->padre = P;

	// Ajustar valores de FE:
	switch (R->FE) {
	case - 1: Q->FE = 0; P->FE = 1; break;
	case 0:  Q->FE = 0; P->FE = 0; break;
	case 1:  Q->FE = -1; P->FE = 0; break;
	}
	R->FE = 0;
}

// Rotaci�n doble a izquierdas
void ArbolAVL::RDI(nodoAVL* nodo)
{
	cout << "RDI" << endl;
	nodoAVL *Padre = nodo->padre;
	nodoAVL *P = nodo;
	nodoAVL *Q = P->derecho;
	nodoAVL *R = Q->izquierdo;
	nodoAVL *B = R->izquierdo;
	nodoAVL *C = R->derecho;

	if (Padre)
	if (Padre->derecho == nodo) Padre->derecho = R;
	else Padre->izquierdo = R;
	else raiz = R;

	// Reconstruir �rbol:
	P->derecho = B;
	Q->izquierdo = C;
	R->izquierdo = P;
	R->derecho = Q;

	// Reasignar padres:
	R->padre = Padre;
	P->padre = Q->padre = R;
	if (B) B->padre = P;
	if (C) C->padre = Q;

	// Ajustar valores de FE:
	switch (R->FE) {
	case - 1: P->FE = 0; Q->FE = 1; break;
	case 0:  P->FE = 0; Q->FE = 0; break;
	case 1:  P->FE = -1; Q->FE = 0; break;
	}
	R->FE = 0;
}

// Rotaci�n simple a derechas
void ArbolAVL::RSD(nodoAVL* nodo)
{
	cout << "RSD" << endl;
	nodoAVL *Padre = nodo->padre;
	nodoAVL *P = nodo;
	nodoAVL *Q = P->izquierdo;
	nodoAVL *B = Q->derecho;

	if (Padre)
	if (Padre->derecho == P) Padre->derecho = Q;
	else Padre->izquierdo = Q;
	else raiz = Q;

	// Reconstruir �rbol:
	P->izquierdo = B;
	Q->derecho = P;

	// Reasignar padres:
	P->padre = Q;
	if (B) B->padre = P;
	Q->padre = Padre;

	// Ajustar valores de FE:
	P->FE = 0;
	Q->FE = 0;
}

// Rotaci�n simple a izquierdas
void ArbolAVL::RSI(nodoAVL* nodo)
{
	cout << "RSI" << endl;
	nodoAVL *Padre = nodo->padre;
	nodoAVL *P = nodo;
	nodoAVL *Q = P->derecho;
	nodoAVL *B = Q->izquierdo;

	if (Padre)
	if (Padre->derecho == P) Padre->derecho = Q;
	else Padre->izquierdo = Q;
	else raiz = Q;

	// Reconstruir �rbol:
	P->derecho = B;
	Q->izquierdo = P;

	// Reasignar padres:
	P->padre = Q;
	if (B) B->padre = P;
	Q->padre = Padre;

	// Ajustar valores de FE:
	P->FE = 0;
	Q->FE = 0;
}

/*// Eliminar un elemento de un �rbol AVL
void ArbolAVL::Borrar(const int dat)
{
Nodo *padre = NULL;
Nodo *nodo;
int aux;

actual = raiz;
// Mientras sea posible que el valor est� en el �rbol
while (!Vacio(actual)) {
if (dat == actual->dato) { // Si el valor est� en el nodo actual
if (EsHoja(actual)) { // Y si adem�s es un nodo hoja: lo borramos
if (padre) // Si tiene padre (no es el nodo raiz)
// Anulamos el puntero que le hace referencia
if (padre->derecho == actual) padre->derecho = NULL;
else if (padre->izquierdo == actual) padre->izquierdo = NULL;
delete actual; // Borrar el nodo
actual = NULL;
// El nodo padre del actual puede ser ahora un nodo hoja, por lo tanto su
// FE es cero, pero debemos seguir el camino a partir de su padre, si existe.
if ((padre->derecho == actual && padre->FE == 1) ||
(padre->izquierdo == actual && padre->FE == -1)) {
padre->FE = 0;
actual = padre;
padre = actual->padre;
}
if (padre)
if (padre->derecho == actual) Equilibrar(padre, DERECHO, false);
else                         Equilibrar(padre, IZQUIERDO, false);
return;
}
else { // Si el valor est� en el nodo actual, pero no es hoja
// Buscar nodo
padre = actual;
// Buscar nodo m�s izquierdo de rama derecha
if (actual->derecho) {
nodo = actual->derecho;
while (nodo->izquierdo) {
padre = nodo;
nodo = nodo->izquierdo;
}
}
// O buscar nodo m�s derecho de rama izquierda
else {
nodo = actual->izquierdo;
while (nodo->derecho) {
padre = nodo;
nodo = nodo->derecho;
}
}
// Intercambiar valores de no a borrar u nodo encontrado
// y continuar, cerrando el bucle. El nodo encontrado no tiene
// por qu� ser un nodo hoja, cerrando el bucle nos aseguramos
// de que s�lo se eliminan nodos hoja.
aux = actual->dato;
actual->dato = nodo->dato;
nodo->dato = aux;
actual = nodo;
}
}
else { // Todav�a no hemos encontrado el valor, seguir busc�ndolo
padre = actual;
if (dat > actual->dato) actual = actual->derecho;
else if (dat < actual->dato) actual = actual->izquierdo;
}
}
}
*/


// Recorrido de �rbol en inorden, aplicamos la funci�n func, que tiene
// el prototipo:
// void func(int&, int);
void ArbolAVL::InOrden(void(*func)(int&, int), nodoAVL *nodo, bool r)
{
	if (r) nodo = raiz;
	if (nodo->izquierdo) InOrden(func, nodo->izquierdo, false);
	func(nodo->CodProducto, nodo->FE);
	if (nodo->derecho) InOrden(func, nodo->derecho, false);
}


// Recorrido de �rbol en preorden, aplicamos la funci�n func, que tiene
// el prototipo:
// void func(int&, int);
void ArbolAVL::PreOrden(void(*func)(int&, int), nodoAVL *nodo, bool r)
{
	if (r) nodo = raiz;
	func(nodo->CodProducto, nodo->FE);
	if (nodo->izquierdo) PreOrden(func, nodo->izquierdo, false);
	if (nodo->derecho) PreOrden(func, nodo->derecho, false);
}

// Recorrido de �rbol en preorden para generar un reporte, aplicamos la funci�n func, que tiene
// el prototipo:
// void func(int&, int);
void ArbolAVL::reportePreOrden(void(*func)(int&, int), nodoAVL *nodo, bool r)
{
	if (!Vacio(raiz)){
		if (r) nodo = raiz;
		func(nodo->CodProducto, nodo->Cantidad);
		if (nodo->izquierdo) reportePreOrden(func, nodo->izquierdo, false);
		if (nodo->derecho) reportePreOrden(func, nodo->derecho, false);
	}
}

// Recorrido de �rbol en postorden, aplicamos la funci�n func, que tiene
// el prototipo:
// void func(int&, int);
void ArbolAVL::PostOrden(void(*func)(int&, int), nodoAVL *nodo, bool r)
{
	if (r) nodo = raiz;
	if (nodo->izquierdo) PostOrden(func, nodo->izquierdo, false);
	if (nodo->derecho) PostOrden(func, nodo->derecho, false);
	func(nodo->CodSupermercado, nodo->CodProducto);
}


// Buscar un valor en el �rbol
bool ArbolAVL::Buscar(const int dat)
{
	actual = raiz;

	// Todav�a puede aparecer, ya que quedan nodos por mirar
	while (!Vacio(actual)) {
		if (dat == actual->CodProducto) return true; // dato encontrado
		else if (dat > actual->CodProducto) actual = actual->derecho; // Seguir
		else if (dat < actual->CodProducto) actual = actual->izquierdo;
	}
	return false; // No est� en �rbol
}

// Buscar un codigo de producto por supermercado en el �rbol
bool ArbolAVL::Buscar(const int codSuper, const int codProduc)
{
	actual = raiz;

	// Todav�a puede aparecer, ya que quedan nodos por mirar
	while (!Vacio(actual)) {
		if (codProduc == actual->CodProducto && codSuper == actual->CodSupermercado) return true; // dato encontrado
		else if (codProduc >= actual->CodProducto) actual = actual->derecho; // Seguir
		else if (codProduc < actual->CodProducto) actual = actual->izquierdo;
	}
	return false; // No est� en �rbol
}

// obntener cantidad de productos en un supermercado y por un producto en espec�fico
int ArbolAVL::obtenerCantidad(const int codSuper, const int codProduc)
{
	actual = raiz;

	// Todav�a puede aparecer, ya que quedan nodos por mirar
	while (!Vacio(actual)) {
		if (codProduc == actual->CodProducto && codSuper == actual->CodSupermercado) return actual->Cantidad; // dato encontrado
		else if (codProduc >= actual->CodProducto) actual = actual->derecho; // Seguir
		else if (codProduc < actual->CodProducto) actual = actual->izquierdo;
	}
	return false; // No est� en �rbol
}

// re-establecer la cantidad de un producto
void ArbolAVL::cambiarCantidad(const int codSuper, const int codProduc, int cantidad)
{
	actual = raiz;

	// Todav�a puede aparecer, ya que quedan nodos por mirar
	while (!Vacio(actual)) {
		if (codProduc == actual->CodProducto && codSuper == actual->CodSupermercado) {
			actual->Cantidad = cantidad; // dato encontrado
			break;
		}
		else if (codProduc >= actual->CodProducto) actual = actual->derecho; // Seguir
		else if (codProduc < actual->CodProducto) actual = actual->izquierdo;
	}
}

/*
// Calcular la altura del nodo que contiene el dato dat
int ArbolAVL::Altura(const int dat)
{
int altura = 0;
actual = raiz;

// Todav�a puede aparecer, ya que quedan nodos por mirar
while (!Vacio(actual)) {
if (dat == actual->dato) return altura; // dato encontrado
else {
altura++; // Incrementamos la altura, seguimos buscando
if (dat > actual->dato) actual = actual->derecho;
else if (dat < actual->dato) actual = actual->izquierdo;
}
}
return -1; // No est� en �rbol
}
*/

// Contar el n�mero de nodos
const int ArbolAVL::NumeroNodos()
{
	contador = 0;

	auxContador(raiz); // FUnci�n auxiliar
	return contador;
}

// Funci�n auxiliar para contar nodos. Funci�n recursiva de recorrido en
//   preorden, el proceso es aumentar el contador
void ArbolAVL::auxContador(nodoAVL *nodo)
{
	contador++;  // Otro nodo
	// Continuar recorrido
	if (nodo->izquierdo) auxContador(nodo->izquierdo);
	if (nodo->derecho)   auxContador(nodo->derecho);
}

// Calcular la altura del �rbol, que es la altura del nodo de mayor altura.
const int ArbolAVL::AlturaArbol()
{
	altura = 0;

	auxAltura(raiz, 0); // Funci�n auxiliar
	return altura;
}

// Funci�n auxiliar para calcular altura. Funci�n recursiva de recorrido en
// postorden, el proceso es actualizar la altura s�lo en nodos hojas de mayor
// altura de la m�xima actual
void ArbolAVL::auxAltura(nodoAVL *nodo, int a)
{
	// Recorrido postorden
	if (nodo->izquierdo) auxAltura(nodo->izquierdo, a + 1);
	if (nodo->derecho)   auxAltura(nodo->derecho, a + 1);
	// Proceso, si es un nodo hoja, y su altura es mayor que la actual del
	// �rbol, actualizamos la altura actual del �rbol
	if (EsHoja(nodo) && a > altura) altura = a;
}