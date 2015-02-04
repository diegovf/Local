#include "arbolHeap.h"
#include "ListaSimple.h"



void arbolHeap::run()
{
    int valorFruto;
    while(true)
    {
        while(tiempoDeCrecimiento!=0)
        {
            this->sleep(1);
            tiempoDeCrecimiento--;
        }
        while(habilitado)
        {
            int tempProduccionDeFrutos = frutosPorUnidadDeTiempo;
            while(tempProduccionDeFrutos!=0)
            {
                tempProduccionDeFrutos--;
                valorFruto = rand()%valorPorFruto+1;//HACERLE GET A LA CONFIGURACION
                pertenezcoAlNodo->dineroProducido += valorFruto;
                pertenezcoAlNodo->cantidadDeFrutos++;
                qDebug()<<pertenezcoAlNodo->cantidadDeFrutos++;
            }
             qDebug()<<"En este momento este nodo le produce a la finca: "<<pertenezcoAlNodo->dineroProducido;
             this->sleep(unidadDeTiempo);
        }

        this->sleep(1);
   }
}

void arbolHeap::conectarComer()
{

}

