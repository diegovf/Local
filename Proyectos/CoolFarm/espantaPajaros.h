#ifndef ESPANTAPAJAROS_H
#define ESPANTAPAJAROS_H

#include <QtCore>
#include "matriz.h"

class Espantapajaros : public QThread
{
    Q_OBJECT
public:
    Matriz* finca;
    int x;
    int y;
    explicit Espantapajaros(int pX, int pY,Matriz* pFinca, QObject* parent = 0) : QThread(parent)
    {
        x = pX;
        y = pY;
        finca = pFinca;
    }
    void run();
    void protegerNodos(int,int,Matriz*);
};

#endif // ESPANTAPAJAROS_H
