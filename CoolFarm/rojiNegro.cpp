#include "rojiNegro.h"
#include "stdafx.h"
#include <string>

using namespace std;

void arbolRojoNegro::solucionarRojoRojo(nodoRojoNegro *node, int h){
    int ladohijo;
    nodoRojoNegro *abuelo; // en node traemos al padre, en h 1 si el hijo rojo es el izquierdo 2 si no
    nodoRojoNegro *tio;
    nodoRojoNegro *ayudante;
    abuelo = node->padre;
    if(abuelo->izquierdo && abuelo->derecho)
    {
        if(node==abuelo->izquierdo)
        {
            tio = abuelo->derecho;
        }
        else
        {
            tio = abuelo->izquierdo;
        }
        if(tio->color =='r')
        {
            // caso uno y dos
            tio->color = 'n';
            node->color = 'n';
            if(abuelo!=raiz)
            {
                abuelo->color='r';
            }
            if(abuelo->padre)
            {
                ayudante = abuelo->padre;
                if(ayudante->izquierdo==abuelo)
                {
                    ladohijo=1;
                }
                else
                {
                    ladohijo=2;
                }
                if(ayudante->color =='r')
                {
                    solucionarRojoRojo(ayudante, ladohijo);
                }
            }
            return;
        }
    }
    if(h==1 && abuelo->izquierdo==node)
    { // caso tres
        node->color ='n';
        abuelo->color='r';
        ayudante = node->derecho;
        node->derecho = abuelo;
        node->padre = abuelo->padre;
        abuelo->padre = node;
        abuelo->izquierdo = ayudante;
        if(ayudante)
        {
            ayudante->padre = abuelo;
        }
        if(node->padre)
        {
            ayudante = node->padre;
            if(ayudante->izquierdo == node->derecho)
            {
                ayudante->izquierdo=node;
            }
            else
            {
                ayudante->derecho=node;
            }
        }
        else
        {
            raiz = node;
        }
    }
    else if(h == 2 && abuelo->derecho == node)
    { // caso cuatro
        node->color = 'n';
        abuelo->color ='r';
        ayudante = node->izquierdo;
        node->izquierdo = abuelo;
        node->padre = abuelo->padre;
        abuelo->padre = node;
        abuelo->derecho = ayudante;
        if(ayudante)
        {
            ayudante->padre=abuelo;
        }
        if(node->padre)
        {
            ayudante = node->padre;
            if(ayudante->izquierdo == node->izquierdo)
            {
                ayudante->izquierdo=node;
            }
            else
            {
                ayudante->derecho=node;
            }
        }
        else
        {
            raiz = node;
        }
    }
    else if(h == 2 && abuelo->izquierdo == node)
    {
        // caso cinco
        tio = node->derecho;
        ayudante = tio->izquierdo;
        abuelo->izquierdo = tio;
        tio->padre = abuelo;
        tio->izquierdo = node;
        node->padre = tio;
        node->derecho = ayudante;
        if(ayudante)
        {
            ayudante->padre=node;
        }
        solucionarRojoRojo(tio, 1);
    }
    else if(h == 1 && abuelo->derecho == node)
    {
        // caso seis
        tio = node->izquierdo;
        ayudante = tio->derecho;
        abuelo->derecho = tio;
        tio->padre = abuelo;
        tio->derecho = node;
        node->padre = tio;
        node->izquierdo = ayudante;
        if(ayudante)
        {
            ayudante->padre=node;
        }
        solucionarRojoRojo(tio, 2);
    }
}

void arbolRojoNegro::insercion(int m){
    int ladohijo;
    nodoRojoNegro *hijo;
    nodoRojoNegro *ayudante;
    int bandera;
    if(!raiz)
    { // el arbol esta vacio cargando como raiz
        raiz = new nodoRojoNegro(m);
        raiz->padre=NULL;
        raiz->izquierdo=NULL;
        raiz->derecho=NULL;
        raiz->color='n';
    }
    else
    { // el arbol no esta vacio buscando su lugar
        hijo = new nodoRojoNegro(m);
        hijo->padre=NULL;
        hijo->izquierdo=NULL;
        hijo->derecho=NULL;
        hijo->color='r';
        ayudante = raiz;
        do
        {
            hijo->padre = ayudante,
                bandera = 1;
            if(keyT < ayudante->keyCard)
            {
                if(ayudante->izquierdo)
                {
                    ayudante = ayudante->izquierdo;
                }
                else
                {
                    ayudante->izquierdo = hijo;
                    bandera = 0;
                    ladohijo = 1;
                }
            }
            else
            {
                if(ayudante->derecho)
                {
                    ayudante = ayudante->derecho;
                }
                else
                {
                    ayudante->derecho=hijo;
                    bandera=0;
                    ladohijo=2;
                }
            }
        }
        while(bandera==1);
        {
            if(ayudante->color=='r')
            {
                solucionarRojoRojo(ayudante, ladohijo);
            }
        }
    }
}

void arbolRojoNegro::run()
{
    int valorFruto;
    while(true)
    {
    valorFruto = rand()%5;//HACERLE GET A LA CONFIGURACION
    dineroFrutos += valorFruto;
    insercion(valorFruto);
    }
}
