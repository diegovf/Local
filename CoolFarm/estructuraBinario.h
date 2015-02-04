#ifndef ESTRUCTURABINARIO_H
#define ESTRUCTURABINARIO_H

#include <cstdlib>
#include <iostream>
#include <QtCore>
#include "ListaSimple.h"
#include "matriz.h"

using namespace std;

struct NodoBinario
{
       int dato;
       NodoBinario* hijoizquierdo;
       NodoBinario* hijoderecho;

       NodoBinario (int d)
       {
            dato = d;
            hijoizquierdo = hijoderecho = NULL;
       }
};




class ArbolBinario: public QThread
{
       Q_OBJECT
public:
       NodoBinario* raiz;
       int vida;
       NodoMatriz* pertenezcoAlNodo;
       int frutosPorUnidadDeTiempo;
       ListaSimple* listaParaBorrar;
       bool habilitado;
       int unidadDeTiempo;
       int tiempoDeCrecimiento;
       int valorPorFruto;
       int cantidadFrutos;
       explicit ArbolBinario(NodoMatriz* sembradoEn, int pFrutosPorUnidadDeTiempo,int pUnidadDeTiempo,
                          int ptiempoDeCrecimiento, int pValorPorFruto,QObject* parent = 0) : QThread(parent)
       {
           habilitado = true;
           listaParaBorrar = new ListaSimple();
           vida = 100;
           pertenezcoAlNodo = sembradoEn;
           frutosPorUnidadDeTiempo = pFrutosPorUnidadDeTiempo;
           unidadDeTiempo = pUnidadDeTiempo;
           tiempoDeCrecimiento = ptiempoDeCrecimiento;
           valorPorFruto = pValorPorFruto;
           cantidadFrutos = 0;
       }
       NodoBinario* insertar(int, NodoBinario*);
       void convertirDeNuevo(ListaSimple* arbol,NodoMatriz* nodo);
       void run();
       void insertar(int);
       void pasandoALista(NodoBinario*,NodoMatriz* nodo);
       int desenColando(NodoBinario *arbol, int dinero);
    signals:
       int cambioDeVida(int);
       int cambioDeFrutos(int);

    public slots:

};


#endif // ESTRUCTURABINARIO_H
