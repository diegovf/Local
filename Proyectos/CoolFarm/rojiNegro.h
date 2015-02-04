#ifndef ROJINEGRO_H
#define ROJINEGRO_H

#include<string>
#include <QtCore>
#include "ListaSimple.h"
using namespace std;

class nodoRojoNegro
{						      // los nodos del arbol
public:

    int monto;
    char color; 				    // donde r es rojo y n es negro
    nodoRojoNegro *izquierdo;
    nodoRojoNegro *derecho;
    nodoRojoNegro *padre;
    nodoRojoNegro(int valor)
    {
        monto = valor;
        izquierdo = derecho = padre = NULL;
    }
    friend class arbolRojoNegro;

};

class arbolRojoNegro: public QThread
{
public:
    nodoRojoNegro* raiz;

    int vida;
    int dineroFrutos;


    ListaSimple* listaParaBorrar;
    explicit arbolRojoNegro(QObject* parent = 0) : QThread(parent)
    {
        listaParaBorrar = new ListaSimple();
        vida = 0;
        dineroFrutos = 0;
    }

    void run();
    void insercion( int m);
    void solucionarRojoRojo(nodoRojoNegro *node, int h);
 signals:
    void ingresarEnBinario();
    void pasandoArbolALista(Nodo* arbol);
    int desenColando(Nodo *arbol, int dinero);





};

#endif // ROJINEGRO_H
