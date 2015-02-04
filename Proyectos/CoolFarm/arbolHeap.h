#ifndef ARBOLHEAP_H
#define ARBOLHEAP_H
#include <QtCore>
#include "ListaSimple.h"
#include "matriz.h"

class arbolHeap : public QThread
{
    Q_OBJECT
public:
    Nodo* primerNodo;
    Nodo* ultimoNodo;
    int vida;
    NodoMatriz* pertenezcoAlNodo;
    int frutosPorUnidadDeTiempo;
    bool habilitado;
    int unidadDeTiempo;
    int tiempoDeCrecimiento;
    int valorPorFruto;
    int cantidadFrutos;
    QMutex mutex;
    //constructor
    explicit arbolHeap(NodoMatriz* sembradoEn, int pFrutosPorUnidadDeTiempo,int pUnidadDeTiempo,
                       int ptiempoDeCrecimiento, int pValorPorFruto,QObject* parent = 0)
        : QThread(parent)
    {
        pertenezcoAlNodo = sembradoEn;
        frutosPorUnidadDeTiempo = pFrutosPorUnidadDeTiempo;
        habilitado = true;
        tiempoDeCrecimiento = ptiempoDeCrecimiento;
        valorPorFruto = pValorPorFruto;
        unidadDeTiempo = pUnidadDeTiempo;
        vida = 100;
        primerNodo = 0;
        ultimoNodo = 0;
        cantidadFrutos = 0;

    }

    //declaracion de funciones
    bool vaciaHeap();

    void encolarOrdenada(int);
    int desencolar(int borrarTantos);
    void run();
signals:
    int cambioDeVida(int);
    int cambioDeFrutos(int);
public slots:
    void conectarComer();
};

#endif // ARBOLHEAP_H
