#include "matriz.h"

Matriz::Matriz(int x, int y)
{
        primerNodo = new NodoMatriz();
        x--;

        NodoMatriz* nuevo;
        NodoMatriz* tmp = primerNodo;
        while(x != 0)
        {
               nuevo = new NodoMatriz();
               tmp->derecha = nuevo;
               nuevo->izquierda = tmp;

               crearY(tmp, nuevo, y);

               tmp = tmp->derecha;
               x--;
        }
}

void Matriz::crearY(NodoMatriz* tmp1, NodoMatriz* tmp2, int cont)
{
    NodoMatriz* nuevo1;
    NodoMatriz* nuevo2;
    cont--;

    while(cont != 0)
    {
        if(tmp1->abajo == 0)
        {
            nuevo1 = new NodoMatriz();
            tmp1->abajo = nuevo1;
            nuevo1->arriba = tmp1;
        }
        else
            nuevo1 = tmp1->abajo;

        if(tmp2->abajo == 0)
        {
            nuevo2 = new NodoMatriz();
            tmp2->abajo = nuevo2;
            nuevo2->arriba = tmp2;
        }
        else
            nuevo2 = tmp2->abajo;

        nuevo1->derecha = nuevo2;
        nuevo2->izquierda = nuevo1;

        tmp1 = nuevo1;
        tmp2 = nuevo2;

        cont--;
    }
}

NodoMatriz* Matriz::conseguirNodoEnPosicion(int posX, int posY)
{
    NodoMatriz* tmp = primerNodo;
    while(posX != 0)
    {
        if(tmp == 0)
            break;
        else
        {
            tmp = tmp->derecha;
            posX--;
        }
    }
    while(posY != 0)
    {
        if(tmp == 0)
            break;
        else
        {
            tmp = tmp->abajo;
            posY--;
        }
    }

    return tmp;
}

void Matriz::insertarEnPosicion(int posX, int posY, void *pDato, QString soy)
{
    NodoMatriz* nodo = conseguirNodoEnPosicion(posX, posY);
    nodo->SoyUn = soy;

}

void* Matriz::consultarEnPosicion(int posX, int posY)
{
    NodoMatriz* nodo = conseguirNodoEnPosicion(posX, posY);
    return nodo->dato;
}

void* Matriz::eliminarEnPosicion(int posX, int posY)
{
    NodoMatriz* nodo = conseguirNodoEnPosicion(posX, posY);
    void* aRetornar = nodo->dato;

    return aRetornar;
}


