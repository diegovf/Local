#ifndef ARBOLROJONEGRO_H
#define ARBOLROJONEGRO_H
#include <QtCore>
#include "matriz.h"
#include "ListaSimple.h"

class nodoRojoNegro
{ // los nodos del arbol
public:
       int CodProducto;
       int Costo;
       string Descripcion;
       char color; // donde r es rojo y n es negro
       nodoRojoNegro *izquierdo;
       nodoRojoNegro *derecho;
       nodoRojoNegro *padre;
       friend class arbolRojoNegro;
       nodoRojoNegro(int CodPro, int CodCost, string Descrip)
       {
            CodProducto = CodPro;
            Costo = CodCost;
            Descripcion = Descrip;
            izquierdo = derecho = padre = NULL;
       }

};
typedef nodoRojoNegro *nodo;


class arbolRojoNegro: public QThread
{
    Q_OBJECT
public:
    int frutosPorUnidadDeTiempo;
    bool habilitado;
    int unidadDeTiempo;
    int tiempoDeCrecimiento;
    int valorPorFruto;
    nodoRojoNegro* raiz;
    int vida;
    NodoMatriz* pertenezcoAlNodo;
    int cantidadFrutos;
    ListaSimple* listaParaBorrar;
    explicit arbolRojoNegro(NodoMatriz* sembradoEn, int pFrutosPorUnidadDeTiempo,int pUnidadDeTiempo,
                            int ptiempoDeCrecimiento, int pValorPorFruto,QObject* parent = 0) : QThread(parent)
    {
       raiz = NULL;
       listaParaBorrar = new ListaSimple();
       vida = 100;
       pertenezcoAlNodo = sembradoEn;
       frutosPorUnidadDeTiempo = pFrutosPorUnidadDeTiempo;
       unidadDeTiempo = pUnidadDeTiempo;
       tiempoDeCrecimiento = ptiempoDeCrecimiento;
       valorPorFruto = pValorPorFruto;
       cantidadFrutos = 0;
    }

    // funciones
    nodo buscar(int pKey);
    void ver(nodoRojoNegro *node, int esp, int h);
    void solucionarRojoRojo(nodoRojoNegro *node, int h);
    void insercion(int key, int pCosto, string Descrip);
    void run();
signals:
    int cambioDeVida(int);
    int cambioDeFrutos(int);


};


#endif // ARBOLROJONEGRO_H
