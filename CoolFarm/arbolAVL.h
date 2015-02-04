#ifndef ARBOLAVL_H
#define ARBOLAVL_H
#include <QtCore>

#include "matriz.h"
#include "ListaSimple.h"
#pragma once

#include <iostream>
#include <stdlib.h>
using namespace std;

class NodoAVL {
public:
    // Constructor:
    NodoAVL(const int dat, NodoAVL *pad = NULL, NodoAVL *izq = NULL, NodoAVL *der = NULL) :
        dato(dat), padre(pad), izquierdo(izq), derecho(der), FE(0) {}
    // Miembros:
    int dato;
    int FE;
    NodoAVL *izquierdo;
    NodoAVL *derecho;
    NodoAVL *padre;
    friend class AVL;
};

class ArbolAVL : public QThread
{

public:
    // Constructor y destructor básicos:
    ArbolAVL() : raiz(NULL), actual(NULL) {}

    // Insertar en árbol ordenado:
    void Insertar(const int dat);

    enum { IZQUIERDO, DERECHO };
    int vida;
    NodoMatriz* pertenezcoAlNodo;
    int frutosPorUnidadDeTiempo;
    ListaSimple* listaParaBorrar;
    bool habilitado;
    int unidadDeTiempo;
    int tiempoDeCrecimiento;
    int valorPorFruto;
    NodoAVL *raiz;
    NodoAVL *actual;
    int contador;
    int altura;
    int cantidadFrutos;
    explicit ArbolAVL(NodoMatriz* sembradoEn, int pFrutosPorUnidadDeTiempo,int pUnidadDeTiempo,
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

    // Funciones de equilibrado:
    void Equilibrar(NodoAVL *nodo, int, bool);
    void RSI(NodoAVL* nodo);
    void RSD(NodoAVL* nodo);
    void RDI(NodoAVL* nodo);
    void RDD(NodoAVL* nodo);
    void Podar(NodoAVL* &);
    void auxContador(NodoAVL*);
    void auxAltura(NodoAVL*, int);
    bool Vacio(NodoAVL *r) { return r == NULL; }
    void run();
};

#endif // ARBOLAVL_H
