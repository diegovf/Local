#ifndef PLAGAS_H
#define PLAGAS_H

#include <QtCore>
#include "matriz.h"
#include <QList>
class Plagas : public QThread
{
    Q_OBJECT
public:



    int comeNumeroFrutos;
    int comeOdestruyeCada;
    bool habilitado;
    QString tipoPlaga;
    NodoMatriz * finca;

    explicit Plagas(int pComeNumeroFrutos, int pComeODestruyeCada, NodoMatriz *pFinca,QString pTipoPlaga,QObject* parent = 0)
        : QThread(parent)
    {
        tipoPlaga = pTipoPlaga;
        comeNumeroFrutos = pComeNumeroFrutos;
        comeOdestruyeCada = pComeODestruyeCada;
        habilitado = false;
        finca = pFinca;
        tipoPlaga = pTipoPlaga;
    }
    
    void run();
    void revisarMatriz(Matriz*);
    void llegarAPunto(int xActual, int yActual, int xNuevo, int yNuevo,QString arbol,NodoMatriz* nodo);
    void empiezaAComer(QString arbol, NodoMatriz* dato);
signals:
    void plagaEmpiezaComer();



};


#endif // PLAGAS_H
