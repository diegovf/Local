#include "mainwindow.h"
#include <QApplication>
#include <time.h>
#include "arbolHeap.h"
#include "estructuraBinario.h"
#include "plagas.h"
#include "ListaSimple.h"
#include <QDebug>
#include "arbolRojoNegro.h"
#include "arbolAVL.h"
#include "Arbol.h"

int main(int argc, char *argv[])
{
    QApplication a(argc, argv);
    MainWindow w;
    w.show();
    srand(time(0));

    Matriz* finca = new Matriz(8,8);

    //NodoMatriz *nodoFincaArbol1 = finca->conseguirNodoEnPosicion(1,0);
    NodoMatriz *nodoFincaArbol2 = finca->conseguirNodoEnPosicion(3,0);
    //arbolRojoNegro *arbol2 = new arbolRojoNegro(nodoFincaArbol2,20,5,5,8);
    Arbol *arbol2 = new Arbol(2,3,4,5);
    nodoFincaArbol2->dato = arbol2;
    //ArbolBinario *arbol3 = new ArbolBinario(nodoFincaArbol2,5,3,3,8);
    //nodoFincaArbol2->dato = arbol3;
    //nodoFincaArbol1->SoyUn = "rojinegro";
    //arbol1->start();
    //arbol2->start();
    //ArbolAVL *arbol2 = new ArbolAVL(nodoFincaArbol2,10,4,5,80);
    arbol2->start();
    //PRUEBA DE QUE LA PLAGA ENCUENTRAUN ARBOL PARA LLEGAR
    Plagas *aguila = new Plagas(2,8,nodoFincaArbol2,"plaga");
    aguila->start();
    aguila->habilitado = true;
    int x;
    qDebug()<<"SOY X"<<x;
    return a.exec();

}
