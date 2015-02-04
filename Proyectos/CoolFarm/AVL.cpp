#include "arbolAVL.h"






// Insertar un dato en el árbol AVL
void ArbolAVL::Insertar(const int dat)
{
    NodoAVL *padre = NULL;

    actual = raiz;
    // Buscar el dato en el árbol, manteniendo un puntero al nodo padre
    while (!Vacio(actual) && dat != actual->dato) {
        padre = actual;
        if (dat > actual->dato) actual = actual->derecho;
        else if (dat < actual->dato) actual = actual->izquierdo;
    }

    // Si se ha encontrado el elemento, regresar sin insertar
    if (!Vacio(actual)) return;
    // Si padre es NULL, entonces el árbol estaba vacío, el nuevo nodo será
    // el nodo raiz
    if (Vacio(padre)) raiz = new NodoAVL(dat);
    // Si el dato es menor que el que contiene el nodo padre, lo insertamos
    // en la rama izquierda
    else if (dat < padre->dato) {
        padre->izquierdo = new NodoAVL(dat, padre);
        Equilibrar(padre, IZQUIERDO, true);
    }
    // Si el dato es mayor que el que contiene el nodo padre, lo insertamos
    // en la rama derecha
    else if (dat > padre->dato) {
        padre->derecho = new NodoAVL(dat, padre);
        Equilibrar(padre, DERECHO, true);
    }
}

// Equilibrar árbol AVL partiendo del nodo nuevo
void ArbolAVL::Equilibrar(NodoAVL *nodo, int rama, bool nuevo)
{
    bool salir = false;

    // Recorrer camino inverso actualizando valores de FE:
    while (nodo && !salir) {
        if (nuevo)
        if (rama == IZQUIERDO) nodo->FE--; // Depende de si añadimos ...
        else                  nodo->FE++;
        else
        if (rama == IZQUIERDO) nodo->FE++; // ... o borramos
        else                  nodo->FE--;
        if (nodo->FE == 0) salir = true; // La altura de las rama que
        // empieza en nodo no ha variado,
        // salir de Equilibrar
        else if (nodo->FE == -2) { // Rotar a derechas y salir:
            if (nodo->izquierdo->FE == 1) RDD(nodo); // Rotación doble
            else RSD(nodo);                         // Rotación simple
            salir = true;
        }
        else if (nodo->FE == 2) {  // Rotar a izquierdas y salir:
            if (nodo->derecho->FE == -1) RDI(nodo); // Rotación doble
            else RSI(nodo);                        // Rotación simple
            salir = true;
        }
        if (nodo->padre)
        if (nodo->padre->derecho == nodo) rama = DERECHO; else rama = IZQUIERDO;
        nodo = nodo->padre; // Calcular FE, siguiente nodo del camino.
    }
}

// Rotación doble a derechas
void ArbolAVL::RDD(NodoAVL* nodo)
{
    NodoAVL *Padre = nodo->padre;
    NodoAVL *P = nodo;
    NodoAVL *Q = P->izquierdo;
    NodoAVL *R = Q->derecho;
    NodoAVL *B = R->izquierdo;
    NodoAVL *C = R->derecho;

    if (Padre)
    if (Padre->derecho == nodo) Padre->derecho = R;
    else Padre->izquierdo = R;
    else raiz = R;

    // Reconstruir árbol:
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

// Rotación doble a izquierdas
void ArbolAVL::RDI(NodoAVL* nodo)
{
    NodoAVL *Padre = nodo->padre;
    NodoAVL *P = nodo;
    NodoAVL *Q = P->derecho;
    NodoAVL *R = Q->izquierdo;
    NodoAVL *B = R->izquierdo;
    NodoAVL *C = R->derecho;

    if (Padre)
    if (Padre->derecho == nodo) Padre->derecho = R;
    else Padre->izquierdo = R;
    else raiz = R;

    // Reconstruir árbol:
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

// Rotación simple a derechas
void ArbolAVL::RSD(NodoAVL* nodo)
{
    NodoAVL *Padre = nodo->padre;
    NodoAVL *P = nodo;
    NodoAVL *Q = P->izquierdo;
    NodoAVL *B = Q->derecho;

    if (Padre)
    if (Padre->derecho == P) Padre->derecho = Q;
    else Padre->izquierdo = Q;
    else raiz = Q;

    // Reconstruir árbol:
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

// Rotación simple a izquierdas
void ArbolAVL::RSI(NodoAVL* nodo)
{
    cout << "RSI" << endl;
    NodoAVL *Padre = nodo->padre;
    NodoAVL *P = nodo;
    NodoAVL *Q = P->derecho;
    NodoAVL *B = Q->izquierdo;

    if (Padre)
    if (Padre->derecho == P) Padre->derecho = Q;
    else Padre->izquierdo = Q;
    else raiz = Q;

    // Reconstruir árbol:
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

// Eliminar un elemento de un árbol AVL

void ArbolAVL::run()
{

    int valorFruto;
    while(true)
    {
        while(tiempoDeCrecimiento!=0)
        {
            this->sleep(1);
            tiempoDeCrecimiento--;
        }
        while(habilitado)
        {
            int tempProduccionDeFrutos = frutosPorUnidadDeTiempo;
            while(tempProduccionDeFrutos!=0)
            {
                tempProduccionDeFrutos--;
                valorFruto = rand()%valorPorFruto+1;//HACERLE GET A LA CONFIGURACION
                pertenezcoAlNodo->dineroProducido += valorFruto;
                Insertar(valorFruto);
                pertenezcoAlNodo->cantidadDeFrutos += 1;
            }
             qDebug()<<"En este momento este nodo le produce a la finca: "<<pertenezcoAlNodo->dineroProducido;
             this->sleep(unidadDeTiempo);
        }
   }
}
