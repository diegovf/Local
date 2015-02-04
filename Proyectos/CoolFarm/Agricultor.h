#ifndef AGRICULTOR_H
#define AGRICULTOR_H

#include <QtCore>
#include "matriz.h"

class Agricultor : public QThread
{
    Q_OBJECT
public:
    int dinero;

    explicit Agricultor(QObject* parent = 0) : QThread(parent)
    {
        dinero = 0;    
    }

    void run();
    void llegarAPunto(int xActual, int yActual, int xNuevo, int yNuevo);

};

#endif // AGRICULTOR_H
