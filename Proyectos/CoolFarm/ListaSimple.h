#ifndef LISTASIMPLE_H
#define LISTASIMPLE_H

#include <cstdlib>
#include <iostream>
using namespace std;

// estructura nodo para lista simple
struct Nodo {
       int dato; // parte de datos
       Nodo* siguiente;// puntero para enlazar nodos
       // constructor
       Nodo(int d)
       {
                dato = d; // asigna los datos
                siguiente = NULL; // sig es null
       }
}
;


struct ListaSimple {
       Nodo *primerNodo, *ultimoNodo;
       ListaSimple(){primerNodo = ultimoNodo = NULL;}

       // encabezados de funcion
       void insertarAlInicio (int dato);
       Nodo* borrarAlInicio(void);
       void imprimir(void);
       void insertarAlFinal(int dato);
       Nodo* borrarAlFinal(void);
       Nodo* buscar (int dato);
       void encolarOrdenada(int);
       int largo (void);
       void insertarAlFinalConRecorrido(int dato);
       bool vacia();
       ListaSimple* retornaNuevaListaInvertida(void);
       void insertarEnPosicion(int dato, int pos);
       void borrarEnPosicion(int pos);



};


#endif // LISTASIMPLE_H
