#include "estructuraBinario.h"



// PRINCIPAL DE INSERTA,
//INSERTA UN NUMERO ENTERO

void ArbolBinario::insertar(int dato)
{
     raiz = insertar(dato, raiz);
}

//  INSERTA RECURSIVAMENTE
NodoBinario* ArbolBinario::insertar(int valor, NodoBinario* nodo)
{
    // cuando el nodo es nulo, raiz o hijos de hojas
    //quiere decir que all� debe
   // ubicar el valor, en un nuevo nodo

      if (nodo == NULL)
      {

                return new NodoBinario(valor);
      }
      // si el valor es mayor,
      //llama recursivamente a insertar en el hijo
      // derecho
      else if (nodo->dato < valor)
      {
        nodo->hijoderecho = insertar(valor, nodo->hijoderecho);
      }
      // en caso contrario, va al lado izquierdo
      else if (nodo->dato >= valor)
      {
         nodo->hijoizquierdo = insertar(valor, nodo->hijoizquierdo);
      }

      return nodo;
}



void ArbolBinario::convertirDeNuevo(ListaSimple *arbol, NodoMatriz *nodo)
{

}

void ArbolBinario::pasandoALista(NodoBinario* raiz, NodoMatriz *nodo) //ARREGLAR LO DE LA CANTIDAD DE VECES CON WHILE
{
    ListaSimple *listaArbol = new ListaSimple();
     if (raiz == 0)
     {

         nodo->dineroProducido -= listaArbol->borrarAlFinal()->dato;
         qDebug()<<nodo->dineroProducido;
         convertirDeNuevo(listaArbol,nodo);
     }

     else{
         listaArbol->insertarAlFinal(raiz->dato);
         pasandoALista(raiz->hijoderecho,nodo);
         pasandoALista(raiz->hijoizquierdo,nodo);
         raiz = 0;

     }
}


void ArbolBinario::run()
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
                insertar(valorFruto);
                pertenezcoAlNodo->cantidadDeFrutos += 1;
            }
             qDebug()<<"En este momento este nodo le produce a la finca: "<<pertenezcoAlNodo->dineroProducido;
             this->sleep(unidadDeTiempo);
        }
   }
}
