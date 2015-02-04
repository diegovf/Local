#include "arbolRN.h"
#include "ventanaInfoProducto.h"
#include <string.h>

using namespace std;
using namespace System;
using namespace System::ComponentModel;
using namespace System::Collections;
using namespace System::Windows::Forms;
using namespace System::Data;
using namespace System::Drawing;

nodoRN arbolRojoNegro::buscar(int key){
	nodoRN ayudante;
	ayudante = raiz;
	if (!ayudante) return NULL;
	do{
		if (key == ayudante->CodProducto) {
			SistemadeVentaseInventarios::ventanaInfoProducto ventana;
			String^ codigo = System::Convert::ToString(ayudante->CodProducto);
			String^ des = gcnew String(ayudante->Descripcion.c_str());
			String^ cost = System::Convert::ToString(ayudante->Costo);
			ventana.labelCodigo->Text = codigo;
			ventana.labelPrecio->Text = cost;
			ventana.labelDescripcion->Text = des;
			ventana.ShowDialog();
			return ayudante;
		}
		else if (key<ayudante->CodProducto) ayudante = ayudante->izquierdo;
		else if (key>ayudante->CodProducto) ayudante = ayudante->derecho;
	} while (ayudante);

	MessageBox::Show("No se encontró el producto", "Lo sentimios", MessageBoxButtons::OK, MessageBoxIcon::Information);
	return NULL;
}

// metodo que devuelve el costo de un producto
int arbolRojoNegro::obtenerCosto(int key){
	nodoRN ayudante;
	ayudante = raiz;
	if (!ayudante) return NULL;
	do{
		if (key == ayudante->CodProducto) {
			return ayudante->Costo;
		}
		else if (key<ayudante->CodProducto) ayudante = ayudante->izquierdo;
		else if (key>ayudante->CodProducto) ayudante = ayudante->derecho;
	} while (ayudante);

	MessageBox::Show("No se encontró el producto", "Lo sentimios", MessageBoxButtons::OK, MessageBoxIcon::Information);
	return NULL;
}

void arbolRojoNegro::ver(nodoRojoNegro *node, int esp, int h)
{
	int conter = -1;
	char descripcion[15];
	if (!node && node == raiz)
	{
		cout << "El arbol esta vacio" << endl;
		return;
	}
	if (node == raiz)
	{
		strcpy_s(descripcion, "raiz");
	}
	else if (h == 1)
	{
		strcpy_s(descripcion, "hijo izquierdo");
	}
	else
	{
		strcpy_s(descripcion, "hijo derecho");
	}
	while (++conter < esp)
	{
	}
	if (node)
	{
		if (node->color == 'n')
		{
		}
		else
		{
		}
	}
	else
	{
	}
	if (node)
	{
		if (node->padre != NULL)
		{
			cout << "CodProducto = " << node->CodProducto << "Color: " << node->color << " " << descripcion << " " << " y su padre es: " << node->padre->CodProducto << "Color: " << node->padre->color << endl;
		}
		else
		{
			cout << "CodProducto = " << node->CodProducto << " " << descripcion << "Color: " << node->color << endl;
		}
	}
	else
	{
	}
	if (node && (node->izquierdo || node->derecho))
	{
		ver(node->izquierdo, esp + 1, 1);
		ver(node->derecho, esp + 1, 2);
	}
}

void arbolRojoNegro::solucionarRojoRojo(nodoRojoNegro *node, int h)
{
	int ladohijo;
	nodoRojoNegro *abuelo; // en node traemos al padre, en h 1 si el hijo rojo es el izquierdo 2 si no
	nodoRojoNegro *tio;
	nodoRojoNegro *ayudante;
	abuelo = node->padre;
	if (abuelo->izquierdo && abuelo->derecho)
	{
		if (node == abuelo->izquierdo)
		{
			tio = abuelo->derecho;
		}
		else
		{
			tio = abuelo->izquierdo;
		}
		if (tio->color == 'r')
		{
			// caso uno y dos
			tio->color = 'n';
			node->color = 'n';
			if (abuelo != raiz)
			{
				abuelo->color = 'r';
			}
			if (abuelo->padre)
			{
				ayudante = abuelo->padre;
				if (ayudante->izquierdo == abuelo)
				{
					ladohijo = 1;
				}
				else
				{
					ladohijo = 2;
				}
				if (ayudante->color == 'r')
				{
					solucionarRojoRojo(ayudante, ladohijo);
				}
			}
			return;
		}
	}
	if (h == 1 && abuelo->izquierdo == node)
	{ // caso tres
		node->color = 'n';
		abuelo->color = 'r';
		ayudante = node->derecho;
		node->derecho = abuelo;
		node->padre = abuelo->padre;
		abuelo->padre = node;
		abuelo->izquierdo = ayudante;
		if (ayudante)
		{
			ayudante->padre = abuelo;
		}
		if (node->padre)
		{
			ayudante = node->padre;
			if (ayudante->izquierdo == node->derecho)
			{
				ayudante->izquierdo = node;
			}
			else
			{
				ayudante->derecho = node;
			}
		}
		else
		{
			raiz = node;
		}
	}
	else if (h == 2 && abuelo->derecho == node)
	{ // caso cuatro
		node->color = 'n';
		abuelo->color = 'r';
		ayudante = node->izquierdo;
		node->izquierdo = abuelo;
		node->padre = abuelo->padre;
		abuelo->padre = node;
		abuelo->derecho = ayudante;
		if (ayudante)
		{
			ayudante->padre = abuelo;
		}
		if (node->padre)
		{
			ayudante = node->padre;
			if (ayudante->izquierdo == node->izquierdo)
			{
				ayudante->izquierdo = node;
			}
			else
			{
				ayudante->derecho = node;
			}
		}
		else
		{
			raiz = node;
		}
	}
	else if (h == 2 && abuelo->izquierdo == node)
	{
		// caso cinco
		tio = node->derecho;
		ayudante = tio->izquierdo;
		abuelo->izquierdo = tio;
		tio->padre = abuelo;
		tio->izquierdo = node;
		node->padre = tio;
		node->derecho = ayudante;
		if (ayudante)
		{
			ayudante->padre = node;
		}
		solucionarRojoRojo(tio, 1);
	}
	else if (h == 1 && abuelo->derecho == node)
	{
		// caso seis
		tio = node->izquierdo;
		ayudante = tio->derecho;
		abuelo->derecho = tio;
		tio->padre = abuelo;
		tio->derecho = node;
		node->padre = tio;
		node->izquierdo = ayudante;
		if (ayudante)
		{
			ayudante->padre = node;
		}
		solucionarRojoRojo(tio, 2);
	}
}

void arbolRojoNegro::insercion(int key, int pCosto, string pDescripcion)
{
	int ladohijo;
	nodoRojoNegro *hijo;
	nodoRojoNegro *ayudante;
	int bandera;
	if (!raiz)
	{ // el arbol esta vacio cargando como raiz
		raiz = new nodoRojoNegro(key, pCosto, pDescripcion);
		raiz->padre = NULL;
		raiz->izquierdo = NULL;
		raiz->derecho = NULL;
		raiz->color = 'n';
	}
	else
	{ // el arbol no esta vacio buscando su lugar
		hijo = new nodoRojoNegro(key, pCosto, pDescripcion);
		hijo->padre = NULL;
		hijo->izquierdo = NULL;
		hijo->derecho = NULL;
		hijo->color = 'r';
		ayudante = raiz;
		do
		{
			hijo->padre = ayudante,
				bandera = 1;
			if (key == ayudante->CodProducto) break;
			if (key < ayudante->CodProducto)
			{
				if (ayudante->izquierdo)
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
				if (ayudante->derecho)
				{
					ayudante = ayudante->derecho;
				}
				else
				{
					ayudante->derecho = hijo;
					bandera = 0;
					ladohijo = 2;
				}
			}
		} while (bandera == 1);
		{
			if (ayudante->color == 'r')
			{
				solucionarRojoRojo(ayudante, ladohijo);
			}
				}
	}
}

void arbolRojoNegro::insertar(int codS, int key, int pCosto, string pDescripcion)
{
	ofstream file("Producto.txt", ofstream::app);
	int cont = 0;

	int ladohijo;
	nodoRojoNegro *hijo;
	nodoRojoNegro *ayudante;
	int bandera;
	if (!raiz)
	{ // el arbol esta vacio cargando como raiz
		raiz = new nodoRojoNegro(key, pCosto, pDescripcion);
		raiz->padre = NULL;
		raiz->izquierdo = NULL;
		raiz->derecho = NULL;
		raiz->color = 'n';
		file << endl << codS << ";" << key << ";" << pDescripcion.c_str() << ";" << pCosto;
		MessageBox::Show("Producto ingresado", "Info", MessageBoxButtons::OK, MessageBoxIcon::Exclamation);
	}
	else
	{ // el arbol no esta vacio buscando su lugar
		hijo = new nodoRojoNegro(key, pCosto, pDescripcion);
		hijo->padre = NULL;
		hijo->izquierdo = NULL;
		hijo->derecho = NULL;
		hijo->color = 'r';
		ayudante = raiz;
		do
		{
			hijo->padre = ayudante,
				bandera = 1;
			if (key == ayudante->CodProducto) {
				MessageBox::Show("El producto ya se encuentra registrado", "Info", 
				MessageBoxButtons::OK, MessageBoxIcon::Exclamation);
				cont++;
				break;
			}
			if (key < ayudante->CodProducto)
			{
				if (ayudante->izquierdo)
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
				if (ayudante->derecho)
				{
					ayudante = ayudante->derecho;
				}
				else
				{
					ayudante->derecho = hijo;
					bandera = 0;
					ladohijo = 2;
				}
			}
		} while (bandera == 1);
		{
			if (cont == 0){
				file << endl << codS << ";" << key << ";" << pDescripcion.c_str() << ";" << pCosto;
				MessageBox::Show("Producto ingresado", "Info", MessageBoxButtons::OK, MessageBoxIcon::Exclamation);
			}
			if (ayudante->color == 'r')
			{
				solucionarRojoRojo(ayudante, ladohijo);
			}
				}
	}
}