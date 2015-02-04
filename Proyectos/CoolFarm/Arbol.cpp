#include "Arbol.h"

void Arbol::run()
{   int valorFruto;
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
            dineroProducido += valorFruto;
            cantidadFrutos += 1;
        }
         qDebug()<<"En este momento este nodo le produce a la finca: "<<dineroProducido;
         this->sleep(unidadDeTiempo);
    }
}
