#include "ListaSimple.h"

void ListaSimple::insertarAlInicio (int dato)
{
     // si no hay elementos
     if (primerNodo == NULL)
     {
         // ambos apuntan al nuevo en memoria
         primerNodo = new Nodo(dato);
         ultimoNodo = primerNodo; // ambos apuntan al nuevo
     }
     else
     {
         Nodo *nuevo = new Nodo(dato);
         // a lo que apunta pN ahora es el segundo
         // por eso, nuevo->siguiente es pN
         nuevo->siguiente = primerNodo;
         // ahora devolvemos pN a que apunte al nuevo
         // y primero de las lista
         primerNodo = nuevo;
         // el puntero nuevo deja de existir, no se libera
         // memoria porque se pierde la info
     }
}

// funcion que elimina el primer elemento de las lista
// entradas: no tiene
// salidas: el puntero al primer nodo. Este puntero
// en siguiente apuntara a null. No se libera memoria

Nodo* ListaSimple::borrarAlInicio(void)
{
      // si no hay elementos, no borra nada, retorna null
      if (primerNodo == NULL)
      {
         return NULL;
      }
      else
      {
          // un puntero que apunta al nodo que se
          // "despegara" de la lista y se retorna
          Nodo* borrado = primerNodo;
          // pN se pasa al segundo de la lista
          // porque el primero se eliminara
          primerNodo = primerNodo->siguiente;
          // el nodo borrado, se debe despegar
          // entonces siguiente apunta a null y no
          // al segundo de la lista que ahora es pN
          borrado->siguiente = NULL;
          // aca se deberia liberar la memoria si no se
          // retornara el borrado
          return borrado;
      }
}


// funcion que recorre toda la lista con pt tmp
// imprimiendo en consola cada dato de nodos
// entradas no tiene
// salidas: no tiene, solo imprime en consola
void ListaSimple::imprimir(void)
{
     // puntero temporal que avanza
     // por toda la lista
     // apunta a los mismo que pN
     Nodo *tmp = primerNodo;

     // mientras tmp no sea nulo, avanza
     while (tmp != NULL)
     {
           // imprime el dato del nodo en el que esta tmp
           cout << tmp->dato << "  " << endl;
           // tmp avanza al siguiente nodo
           // esto no puede faltar porque se encicla
           tmp = tmp->siguiente;
     }
}

// funcion que inserta un nodo nuevo al final de la lista
// entradas: el dato a guardar
// salidas: no tiene
void ListaSimple::insertarAlFinal (int dato)
{
     // si no hay elementos
     if (primerNodo == NULL)
     {
         // ambos apuntan al nuevo en memoria
         primerNodo = new Nodo(dato);
         ultimoNodo = primerNodo; // ambos apuntan al nuevo
     }
     else
     {
         // se crea el nuevo nodo
         Nodo *nuevo = new Nodo(dato);
         // uN siguiente debe apuntar al nuevo nodo
         // uN debe apuntar al nuevo nodo enlazado
         ultimoNodo->siguiente = nuevo;
         ultimoNodo = nuevo;
         // el puntero nuevo deja de existir, no se libera
         // memoria porque se pierde la info
     }
}

// busca un nodo y lo retorna como puntero
// entrada: el dato a buscar en la lista
// salida: puntero a nodo encontrado o null

Nodo* ListaSimple::buscar (int dato)
{
      // puntero temporal que inicia en pN
      Nodo* tmp = primerNodo;

      // se hace la pregunta en el while de una vez
      // si se encuentra el dato, sino queda en null
      while (tmp!=NULL && tmp->dato != dato)
      {
            // debe avanzar al siguiente
            tmp = tmp->siguiente;
      }

      return tmp; // retorna a lo que apunta tmp
      // que es el nodo encontrado o null si no
}

// funcion que retorna la cantidad de elementos de
// una lista simple
int ListaSimple::largo(void)
{
    // para recorrer la lista
    Nodo *tmp = primerNodo;
    int largo = 0;

    while (tmp != NULL)
    {
         largo++; // incrementa contador
         tmp = tmp->siguiente; // avanza al siguiente
    }
    return largo;
}

// funcion que retorna true si la lista es vacia
// entradas: ninguna
// salidas: true si es no tiene elmentos, false otro caso
bool ListaSimple::vacia()
{
     // si primerNodo es nulo, no hay elementos
     if (primerNodo == NULL)
        return true;
     else
         return false;
}

// funcion que inserta al final sin hacer uso de ultimonodo
// entrada: el dato a insertar
// salida: no hay, solo a~nade en la lista
void ListaSimple::insertarAlFinalConRecorrido(int dato)
{
     if (vacia())
     {
          primerNodo = ultimoNodo = new Nodo(dato);
     }
     else
     {
         // un nodo tmp que recorre la lista hasta ubicarse
         // en el 'ultimo
         Nodo *actual = primerNodo;

         // este ciclo deja actual posicionado en el
         // nodo final
         while (actual->siguiente != NULL)
         {
               actual = actual->siguiente;
         }
         // al slair actual esta apuntando al ultimo nodo
         // actual siguiente ya no sera nulo, sera un nuevo
         // nodo
         actual->siguiente = new Nodo(dato);
         // se pasa el punto uN al nuevo ultimo
         ultimoNodo = actual->siguiente;
     }
}









Nodo* ListaSimple::borrarAlFinal(void)
{
      if (vacia())
         return NULL;
      // este caso es cuando tiene un solo elemento
      else if (primerNodo->siguiente == NULL)
      {
            Nodo* actual = primerNodo;
            primerNodo = ultimoNodo = NULL;
            return actual;
      }
      else
      {
            // referencia al primero para recorrer la lista
            Nodo* actual = primerNodo;
            // recorre la lista hasta llegar al penultimo nodo
            //while (actual->siguiente != NULL)
            while (actual->siguiente->siguiente != NULL)
              actual = actual->siguiente;

            // al salir actual referencia al penultimo nodo
            // refencia nueva al ultimo nodo para despues retornarlo
            Nodo* tmp = ultimoNodo;
            // ultimo nodo pasa al penultimo
            ultimoNodo = actual;
            //le quita el enlace al que era ultimo
            actual->siguiente = NULL;
            // retorna el que desenlazo al final
            return tmp;
        }
}

// funcion que crea una nueva lista con el orden invertido
// entrada: ninguna
// salida: puntero a la nueva lista
ListaSimple* ListaSimple::retornaNuevaListaInvertida(void)
{
     // debe reservar memoria y crear el puntero
     ListaSimple* lista = new ListaSimple();

     // crea un puntero que recorra toda la lista
     // para obtener cada elemento
     Nodo *tmp = primerNodo;

     // recorre toda la lista
     while (tmp != NULL)
     {
          // cada elemento de la lista lo inserta al inicio
          // de la nueva lista
          lista->insertarAlInicio(tmp->dato);
          // avanza en la lista
          tmp = tmp->siguiente;
     }
     return lista;
}

// funcion que inserta en la lista, en la pos 0...n
// entradas: dato a insertar y posicion
// salida: ninguna, se inserta
void ListaSimple::insertarEnPosicion(int dato, int pos)
{
     // si esta vacia o pos cero, llama a insertar al inicio
     if (vacia() || pos == 0)
     {
        insertarAlInicio(dato);
     }
     else
     {
         // recorre la lista hasta quedar en el nodo previo a
         // la posici�n
         Nodo* actual = primerNodo;
         // este for recorre la lista para posicionarse en el nodo
         // previo a donde vamos a insertar
         // inicia en 1, para antes de pos o al final
         for (int i=1; i < pos && actual->siguiente != NULL;i++)
             actual=actual->siguiente;
         // al terminar el for, el puntero esta en el nodo previo a
         // donde insertamos o al final
         // si es el ultimo nodo inserta al final
         if (actual->siguiente == NULL)
            insertarAlFinal(dato);
         else
         {
            // si no es el ultimo, esta en medio
            // crea un nuevo nodo
            Nodo* nuevo = new Nodo(dato);
            // Se coloca el nuevo despues de actual
            nuevo->siguiente = actual->siguiente;
            actual->siguiente=nuevo;
         }
     }
}


// Funcion que elimina el elmento de la lista en una posicion
// esta funcion no retorna el nodo eliminado, por lo que
// si libera memoria
void ListaSimple::borrarEnPosicion(int pos)
{
     // si esta vacia no borra
        if (vacia())
        { }
        // pos 0 borra el inicio
        else
        if (pos == 0)
        {
            // borrar al inicial no libera memoria, se hace
            // luego de llamar a la funcion
            Nodo* borrado = borrarAlInicio();

            if (borrado != NULL)
               delete borrado;

        }
        else
        {
            //recorre la lista hasta el nodo previo a eliminar
            Nodo *actual = primerNodo;
            // deja el puntero en el nodo antes a eliminar
            for (int i=1; i < pos && actual->siguiente != NULL;i++)
                actual=actual->siguiente;

            // si es el ultimo borra el final
            if (actual->siguiente == NULL)
            {
                 // borrar al final no libera memoria, se hace
                 // luego de llamar a la funcion
                 Nodo* borrado = borrarAlFinal();
                 if (borrado != NULL)
                        delete borrado;
            }
            else
            {
                //referencia tmp que apunta al que se eliminara
                Nodo *tmp = actual->siguiente;
                // anterior a borrar siguiente ser� el sig.sig
                actual->siguiente = actual->siguiente->siguiente;
                // el que se eliminara.sig sera null
                tmp->siguiente = NULL;
                delete tmp;
            }
        }
    }






