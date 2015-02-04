#include "plagas.h"
#include "rojiNegro.h"
#include "arbolHeap.h"
#include "estructuraBinario.h"
#include "matriz.h"
#include "arbolHeap.h"

void Plagas::run()
{
    this->sleep(9);
    int robar = 0;
        while(true)
        {
            if(tipoPlaga == "plaga")
            {
                int destruirVida = 100%comeOdestruyeCada;
                while(true)
                {
                    while(!habilitado)
                    {
                        this->sleep(2);
                    }
                    finca->dato->habilitado = false;
                    while(comeOdestruyeCada!=0)
                    {
                        qDebug()<<"estoy matando";
                        comeOdestruyeCada--;
                        finca->dato->vida -= destruirVida;
                        this->sleep(1);
                    }
                    qDebug()<<"mate al arbol";
                }
            }
            else
            {
            while(comeNumeroFrutos && finca->dato->dineroProducido > 0)
            {
            robar = rand()%finca->dato->valorPorFruto;
            finca->dato->habilitado = false;
            finca->dato->dineroProducido -= robar;
            finca->dato->cantidadFrutos--;
            qDebug()<<"Cantidad de frutos"<<finca->dato->cantidadFrutos;
            qDebug()<<"dinero: "<<finca->dato->dineroProducido;
            this->sleep(comeOdestruyeCada);
            }
            finca->dato->cantidadFrutos = 0;
            finca->dato->dineroProducido = 0;
            this->sleep(5);
            }
        }
    }



