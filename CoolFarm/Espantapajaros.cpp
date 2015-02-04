#include "espantaPajaros.h"
#include "matriz.h"
void Espantapajaros::protegerNodos(int x, int y, Matriz* finca)
{
        NodoMatriz *nodoEspanta = finca->conseguirNodoEnPosicion(x,y);
        nodoEspanta->protegido = true;
        if(nodoEspanta->abajo !=0)
        {
            if(nodoEspanta->izquierda!=0)
            {
                if(nodoEspanta->derecha!=0)
                {
                    if(nodoEspanta->arriba!=0)
                    {
                        nodoEspanta->abajo->protegido = true;
                        nodoEspanta->izquierda->protegido = true;
                        nodoEspanta->derecha->protegido = true;
                        nodoEspanta->arriba->protegido = true;
                        nodoEspanta->arriba->izquierda->protegido = true;
                        nodoEspanta->arriba->derecha->protegido = true;
                        nodoEspanta->abajo->derecha->protegido = true;
                        nodoEspanta->abajo->izquierda->protegido = true;
                    }
                    nodoEspanta->abajo->protegido = true;
                    nodoEspanta->izquierda->protegido = true;
                    nodoEspanta->derecha->protegido = true;
                }
                nodoEspanta->abajo->protegido = true;
                nodoEspanta->izquierda->protegido = true;
            }
            nodoEspanta->abajo->protegido = true;
        }
}

void Espantapajaros::run(){}
