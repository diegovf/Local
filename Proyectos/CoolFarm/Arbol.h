#ifndef ARBOL_H
#define ARBOL_H
#include <QtCore>
class Arbol: public QThread
{
       Q_OBJECT
public:
       int vida;
       int frutosPorUnidadDeTiempo;
       bool habilitado;
       int unidadDeTiempo;
       int tiempoDeCrecimiento;
       int valorPorFruto;
       int cantidadFrutos;
       int dineroProducido;
       explicit Arbol(int pFrutosPorUnidadDeTiempo,int pUnidadDeTiempo,
                          int ptiempoDeCrecimiento, int pValorPorFruto,QObject* parent = 0) : QThread(parent)
       {
           habilitado = true;
           vida = 100;
           frutosPorUnidadDeTiempo = pFrutosPorUnidadDeTiempo;
           unidadDeTiempo = pUnidadDeTiempo;
           tiempoDeCrecimiento = ptiempoDeCrecimiento;
           valorPorFruto = pValorPorFruto;
           cantidadFrutos = 0;
           dineroProducido =  0;
       }
       void run();
    signals:
       int cambioDeVida(int);
       int cambioDeFrutos(int);

    public slots:

};

#endif // ARBOL_H
