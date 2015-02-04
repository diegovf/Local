#ifndef MATRIZ_H
#define MATRIZ_H

#include "Arbol.h"
#include <QtCore>

struct NodoMatriz
{
       Arbol *dato;
       QString Estado;
       int dineroProducido;
       bool protegido;
       NodoMatriz* arriba;
       NodoMatriz* abajo;
       NodoMatriz* derecha;
       NodoMatriz* izquierda;
       int cantidadDeFrutos;
       QString SoyUn;

       NodoMatriz()
       {

              protegido = false;
              Estado = "vacio";
              arriba = 0;
              abajo = 0;
              derecha = 0;
              izquierda = 0;


       }
};

struct Matriz
{
       NodoMatriz* primerNodo;

       Matriz(int x, int y);
       void crearY(NodoMatriz* primero, NodoMatriz* segundo, int cont);

       NodoMatriz* conseguirNodoEnPosicion(int posX, int posY);
       void* consultarEnPosicion(int posX, int posY);

       void insertarEnPosicion(int posX, int posY, void* pDato, QString);
       void* eliminarEnPosicion(int posX, int posY);
};

#endif // MATRIZ_H
