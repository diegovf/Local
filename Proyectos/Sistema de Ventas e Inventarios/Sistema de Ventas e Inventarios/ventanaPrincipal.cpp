#include "ventanaPrincipal.h"
#include "ventanaInfo.h"

using namespace System;
using namespace System::Windows::Forms;

// Metodo para convertir de String^ a string
void MarshalString(String ^ s, string& os) {
	using namespace Runtime::InteropServices;
	const char* chars =
		(const char*)(Marshal::StringToHGlobalAnsi(s)).ToPointer();
	os = chars;
	Marshal::FreeHGlobal(IntPtr((void*)chars));
}

// Metodo para leer el archivo Cliente
void Archivos::leerArchivoCliente(){
	ifstream cliente("Cliente.txt");
	char info[256];
	string nom, dir, cedula;
	int ced;
	while (cliente.good()){
		cliente.getline(info, 256, ';');
		cedula = string(info);
		cliente.getline(info, 256, ';');
		nom = string(info);
		cliente.getline(info, 256, '\n');
		dir = string(info);
		ced = atoi(cedula.c_str());
		if (abb.Buscar(ced) == false){
			abb.Insertar(ced, nom, dir);
		}
	}
	//listaFuncionarios.Mostrar();
	cliente.close();
}

// Metodo para guardar un cliente en el archivo Cliente y el abb
void Archivos::guardarCliente(int ced, string nom, string dir){
	ofstream cliente;
	cliente.open("Cliente.txt", ofstream::app );
	if (abb.Buscar(ced) == false){
		cliente << endl << ced << ";" << nom << ";" << dir;
		abb.Insertar(ced, nom, dir);
		MessageBox::Show("Usuario ingresado satisfactoriamente", "Atención", MessageBoxButtons::OK, MessageBoxIcon::Information);
	}
	else{
		MessageBox::Show("El usuario ya está registrado",
			"Atención!!", MessageBoxButtons::OKCancel,
			MessageBoxIcon::Asterisk);
	}


}

//Metodo para buscar un cliente en el arbo binario de búsqueda
void Archivos::buscarCliente(int ced){
	if (abb.Buscar(ced) == true){
		pnb nodo = abb.obtenerCliente(ced);
		int cedu = nodo->cedula;
		string cedula = to_string(cedu);
		String^ nombre = gcnew String(nodo->nombre.c_str());
		String^ ced = gcnew String(cedula.c_str());
		String^ direccion = gcnew String(nodo->direccion.c_str());
		SistemadeVentaseInventarios::ventanaInfo info;
		info.labelNombre->Text = nombre;
		info.labelCedula->Text = ced;
		info.labelDireccion->Text = direccion;
		info.labelMotivo->Text = "Los datos del cliente son:";
		info.ShowDialog();

	}
	else{
		MessageBox::Show("No se ha encontrado el cliente", "Atención", MessageBoxButtons::OK, MessageBoxIcon::Information);
	}
}

// Metodo para leer el archivo de supermercado e inserta los datos en el arbol B
void Archivos::leerArchivoSupermercado(){
	ifstream cliente("Supermercado.txt");
	char info[256];
	string nom, dir, codSuper;
	int codigo;
	while (cliente.good()){
		cliente.getline(info, 256, ';');
		codSuper = string(info);
		cliente.getline(info, 256, ';');
		nom = string(info);
		cliente.getline(info, 256, '\n');
		dir = string(info);
		codigo = atoi(codSuper.c_str());
		if (arbolB.Buscar(codigo) == false){
			structClave.codSuper = codigo;
			structClave.nombre = nom;
			structClave.direccion = dir;
			structClave.avl = new ArbolAVL();
			arbolB.Insertar(structClave);
		}
	}
	//listaFuncionarios.Mostrar();
	cliente.close();
}

// Método para guardar un supermercado
void Archivos::guardarSupermercado(int codSuper, string nom, string dir){
	ofstream cliente;
	cliente.open("Supermercado.txt", ofstream::app);
	if (arbolB.Buscar(codSuper) == false){
		cliente << endl << codSuper << ";" << nom << ";" << dir;
		structClave.codSuper = codSuper;
		structClave.nombre= nom;
		structClave.direccion = dir;
		structClave.avl = new ArbolAVL();
		arbolB.Insertar(structClave);
		MessageBox::Show("Supermercado ingresado saisfactoriamente", "Atención", 
			MessageBoxButtons::OK, MessageBoxIcon::Information);
	}
	else{
		MessageBox::Show("El Supermercado ya se encuentra registrado",
			"Atención!!", MessageBoxButtons::OK, MessageBoxIcon::Information);
	}
}
// Metodo para buscar un supermercado mediante su código
void Archivos::buscarSupermercado(int codigo){
	if (arbolB.Buscar(codigo) == true){
		
		stclave nodo = arbolB.obtenerSupermercado(codigo);
		int codigoSuper = nodo.codSuper;
		string cedula = to_string(codigoSuper);
		String^ nombre = gcnew String(nodo.nombre.c_str());
		String^ ced = gcnew String(cedula.c_str());
		String^ direccion = gcnew String(nodo.direccion.c_str());
		SistemadeVentaseInventarios::ventanaInfo info;
		info.labelNombre->Text = nombre;
		info.labelCedula->Text = ced;
		info.labelDireccion->Text = direccion;
		info.labelMotivo->Text = "Los datos del Supermercado son:";
		info.ShowDialog();

	}
	else{
		MessageBox::Show("No se ha encontrado el supermercado", "Atención", MessageBoxButtons::OK, MessageBoxIcon::Information);
	}
}

// Metodo para leer el archivo Inventarios
void Archivos::leerArchivoInventario(){
	ifstream cliente("Inventarios.txt");
	char info[256];
	string codSupermercado, codProducto, cantidad;
	int codSuper, codProduc, cant;
	while (cliente.good()){
		cliente.getline(info, 256, ';');
		codSupermercado = string(info);
		cliente.getline(info, 256, ';');
		codProducto = string(info);
		cliente.getline(info, 256, '\n');
		cantidad = string(info);
		codSuper = atoi(codSupermercado.c_str());
		codProduc = atoi(codProducto.c_str());
		cant = atoi(cantidad.c_str());
		if (arbolB.Buscar(codSuper) == true){
			if (!arbolB.BuscarEnAVL(codSuper, codProduc)){
				arbolB.InsertarEnAVL(codSuper, codProduc, cant);
			}else
				MessageBox::Show("El producto ya existe en el avl", "Atención", MessageBoxButtons::OK, MessageBoxIcon::Information);
		}else{
			MessageBox::Show("No se ha encontrado el supermecado", "Atención", MessageBoxButtons::OK, MessageBoxIcon::Information);
		}
	}
	//listaFuncionarios.Mostrar();
	cliente.close();
}


// Méto que busca la cantidad de un producto en un supermercado en específio
void Archivos::buscarCantidadDeProducto(int codSuper, int codProduc){
	if (arbolB.BuscarEnAVL(codSuper, codProduc)){
		int cantidad = arbolB.obtenerCantidadProducto(codSuper, codProduc);
		String^ cant = System::Convert::ToString(cantidad);
		MessageBox::Show("La cantidad de producto es: " + cant, "Info", MessageBoxButtons::OK, MessageBoxIcon::Information);
	}
	else{
		MessageBox::Show("El producto no ha sido encontrado en el supermercado especificado",
			"INFO", MessageBoxButtons::OK, MessageBoxIcon::Error);
	}
		
}

// Método para generar un reporte de productos de un supermercado en específico y guartda en txt
void Archivos::generarReporteProductos(int codSuper){
	stclave a = arbolB.obtenerSupermercado(codSuper);
	if (a.avl->obtenerRaiz()){
		ofstream fichero("Reporte de Productos.txt", ofstream::app);
		fichero << "--------------" << "Código de Supermercado: " << codSuper << "--------------" << endl;
		arbolB.generarReporte(codSuper);
		fichero << "-------------------------------------------------------" << endl << endl;
		MessageBox::Show("Reporte generado", "Info", MessageBoxButtons::OK, MessageBoxIcon::Information);
	}else{
		MessageBox::Show("El supermercado se encuentra vacio", "Info", MessageBoxButtons::OK, MessageBoxIcon::Information);
	}
}

// Metodo para leer el archivo de Productos en ingrearlos AA->RojiNegro;
void Archivos::leerArchivoProducto(){
	ifstream producto("Producto.txt");
	char info[256];
	string codS, codP, des, precio ;
	int codSuper, codProducto, costo;
	while (producto.good()){
		producto.getline(info, 256, ';');
		codS = string(info);
		producto.getline(info, 256, ';');
		codP = string(info);
		producto.getline(info, 256, ';');
		des = string(info);
		producto.getline(info, 256, '\n');
		precio = string(info);

		codSuper = atoi(codS.c_str());
		codProducto = atoi(codP.c_str());
		costo = atoi(precio.c_str());

		if (arbolB.Buscar(codSuper) == true){
			NodoAA* nodo = aa->Buscar(aa->raiz, codSuper, NULL);
			if (nodo != NULL){
				aa->InsertarEnRN(aa->raiz, codSuper, codProducto, costo, des, NULL);
			}
			else
			{
				String^ a = System::Convert::ToString(codSuper);
				aa->insert(codSuper);
				aa->CrearRN(aa->raiz, codSuper, codProducto, costo, des, NULL);
			}
		}
		else{
			MessageBox::Show("No se encontro registrado", "Info", MessageBoxButtons::OK, MessageBoxIcon::Information);
		}
	}
	//listaFuncionarios.Mostrar();
	producto.close();
}

// metodo para buscar un producto en el arbol roji negro
void Archivos::buscarProducto(int codS, int codP){
	aa->BuscarEnRN(aa->raiz, codS, codP, NULL);
}

void mostrar(int x, int b, string c){
	ofstream a("Producto", ofstream::app);
	int e = 2;
	a << x << b << c;
}
void Archivos::agregarProducto(int codS, int codP, int cost, string des){
	if (arbolB.Buscar(codS) == true){
		NodoAA* nodo = aa->Buscar(aa->raiz, codS, NULL);
		if (nodo != NULL){
			aa->agregarEnRN(aa->raiz, codS, codP, cost, des, NULL);		
		}
		else{
			String^ a = System::Convert::ToString(codS);
			aa->insert(codS);
			aa->crearrn(aa->raiz, codS, codP, cost, des, NULL);
		}
	}
	else{
		MessageBox::Show("El Supermercado no se encontró registrado", "Info", 
			MessageBoxButtons::OK, MessageBoxIcon::Information);
	}

}

[STAThread]
int main() {
	archivos.leerArchivoCliente();
	archivos.leerArchivoSupermercado();
	archivos.leerArchivoInventario();
	archivos.leerArchivoProducto();
	Application::EnableVisualStyles();
	Application::SetCompatibleTextRenderingDefault(false);

	SistemadeVentaseInventarios::ventanaPrincipal principal;
	Application::Run(%principal);

	return 0;
}

