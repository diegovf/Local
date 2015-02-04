#pragma once
#include "ventanaCodProducto.h"
#include "archivos.h"
#include "arbolB.h"
#include <string>
#include <stdlib.h>
#include <string.h>
#include <msclr\marshal_cppstd.h>
#include <fstream>
#include "arbolBB.h"
#include <iostream>
#include "arbolavl.h"
#include "arbolAA.h"
#include "ventanaSupermercado.h"
#include "ventanaCantidad.h"


using namespace std;
using namespace msclr::interop;

ArbolAVL avl;
ArbolABB abb;
btree arbolB(4);
stclave structClave;
Archivos archivos;
AA *aa = new AA();
int cont = 0;
int cont1 = 0;
namespace SistemadeVentaseInventarios {

	using namespace System;
	using namespace System::ComponentModel;
	using namespace System::Collections;
	using namespace System::Windows::Forms;
	using namespace System::Data;
	using namespace System::Drawing;
	
	/// <summary>
	/// Resumen de ventanaPrincipal
	/// </summary>
	public ref class ventanaPrincipal : public System::Windows::Forms::Form
	{
	public:
		ventanaPrincipal(void)
		{
			InitializeComponent();
			//
			//TODO: agregar código de constructor aquí
			//
		}

	protected:
		/// <summary>
		/// Limpiar los recursos que se estén utilizando.
		/// </summary>
		~ventanaPrincipal()
		{
			if (components)
			{
				delete components;
			}
		}

	protected:

	private: System::Windows::Forms::TextBox^  campoDireccion;
	private: System::Windows::Forms::TextBox^  campoNombre;
	private: System::Windows::Forms::TextBox^  campoCedula;
	private: System::Windows::Forms::Label^  label3;
	private: System::Windows::Forms::Label^  label2;
	private: System::Windows::Forms::Label^  label1;
	private: System::Windows::Forms::Button^  botonAgregarCliente;
	private: System::Windows::Forms::Panel^  panel1;
	private: System::Windows::Forms::LinkLabel^  linkLabel1;
	private: System::Windows::Forms::Label^  label4;
	private: System::Windows::Forms::Panel^  panel2;
	private: System::Windows::Forms::Button^  botonBuscarCliente;
	private: System::Windows::Forms::TextBox^  campoCedulaBuscar;
	private: System::Windows::Forms::Label^  label6;
	private: System::Windows::Forms::Label^  label5;
	private: System::Windows::Forms::TextBox^  campoDireccionSupermercado;

	private: System::Windows::Forms::TextBox^  campoNombreSupermercado;

	private: System::Windows::Forms::TextBox^  campoCodigoSupermercado;


	private: System::Windows::Forms::Label^  label10;
	private: System::Windows::Forms::Label^  label9;
	private: System::Windows::Forms::Label^  label8;
	private: System::Windows::Forms::Label^  label7;
	private: System::Windows::Forms::Button^  botonAgregarSupermercado;
	public: System::Windows::Forms::TextBox^  campoBuscarCodigoSupermercado;
	private: System::Windows::Forms::Label^  label12;
	private: System::Windows::Forms::Label^  label11;
	private: System::Windows::Forms::Button^  botonBuscarSupermercado;
	private: System::Windows::Forms::Button^  botonBuscarCantidadProducto;

	private: System::Windows::Forms::TextBox^  campoBuscarCantProducto;

	private: System::Windows::Forms::Label^  label14;
	private: System::Windows::Forms::Label^  label13;
	private: System::Windows::Forms::Label^  label15;
	private: System::Windows::Forms::Button^  botonGenerarReporte;
	private: System::Windows::Forms::TextBox^  campoGenerarReporte;


	private: System::Windows::Forms::Label^  label16;
	private: System::Windows::Forms::Button^  botonBuscarProducto;
	private: System::Windows::Forms::TextBox^  campoProductoBuscar;

	private: System::Windows::Forms::Label^  label18;
	private: System::Windows::Forms::Label^  label17;
	private: System::Windows::Forms::TextBox^  textDescripcion;

	private: System::Windows::Forms::TextBox^  textCosto;

	private: System::Windows::Forms::TextBox^  textProducto;

	private: System::Windows::Forms::TextBox^  textSuper;

	private: System::Windows::Forms::Label^  label23;
	private: System::Windows::Forms::Label^  label22;
	private: System::Windows::Forms::Label^  label21;
	private: System::Windows::Forms::Label^  label20;
	private: System::Windows::Forms::Label^  label19;
	private: System::Windows::Forms::Button^  botonAgregarProducto;
	private: System::Windows::Forms::Label^  label24;
	private: System::Windows::Forms::Button^  button1;
	private: System::Windows::Forms::TextBox^  textCedula;


	private: System::Windows::Forms::Label^  label25;
	private: System::Windows::Forms::Label^  label26;
	private: System::Windows::Forms::Label^  label27;
	private: System::Windows::Forms::Label^  label28;
	private: System::Windows::Forms::LinkLabel^  linkLabel2;


	private:
		/// <summary>
		/// Variable del diseñador requerida.
		/// </summary>
		System::ComponentModel::Container ^components;

#pragma region Windows Form Designer generated code
		/// <summary>
		/// Método necesario para admitir el Diseñador. No se puede modificar
		/// el contenido del método con el editor de código.
		/// </summary>
		void InitializeComponent(void)
		{
			System::ComponentModel::ComponentResourceManager^  resources = (gcnew System::ComponentModel::ComponentResourceManager(ventanaPrincipal::typeid));
			this->campoDireccion = (gcnew System::Windows::Forms::TextBox());
			this->campoNombre = (gcnew System::Windows::Forms::TextBox());
			this->campoCedula = (gcnew System::Windows::Forms::TextBox());
			this->label3 = (gcnew System::Windows::Forms::Label());
			this->label2 = (gcnew System::Windows::Forms::Label());
			this->label1 = (gcnew System::Windows::Forms::Label());
			this->botonAgregarCliente = (gcnew System::Windows::Forms::Button());
			this->panel1 = (gcnew System::Windows::Forms::Panel());
			this->button1 = (gcnew System::Windows::Forms::Button());
			this->textCedula = (gcnew System::Windows::Forms::TextBox());
			this->label25 = (gcnew System::Windows::Forms::Label());
			this->label24 = (gcnew System::Windows::Forms::Label());
			this->botonAgregarProducto = (gcnew System::Windows::Forms::Button());
			this->textDescripcion = (gcnew System::Windows::Forms::TextBox());
			this->textCosto = (gcnew System::Windows::Forms::TextBox());
			this->textProducto = (gcnew System::Windows::Forms::TextBox());
			this->textSuper = (gcnew System::Windows::Forms::TextBox());
			this->label23 = (gcnew System::Windows::Forms::Label());
			this->label22 = (gcnew System::Windows::Forms::Label());
			this->label21 = (gcnew System::Windows::Forms::Label());
			this->label20 = (gcnew System::Windows::Forms::Label());
			this->label19 = (gcnew System::Windows::Forms::Label());
			this->botonAgregarSupermercado = (gcnew System::Windows::Forms::Button());
			this->campoDireccionSupermercado = (gcnew System::Windows::Forms::TextBox());
			this->campoNombreSupermercado = (gcnew System::Windows::Forms::TextBox());
			this->campoCodigoSupermercado = (gcnew System::Windows::Forms::TextBox());
			this->label10 = (gcnew System::Windows::Forms::Label());
			this->label9 = (gcnew System::Windows::Forms::Label());
			this->label8 = (gcnew System::Windows::Forms::Label());
			this->label7 = (gcnew System::Windows::Forms::Label());
			this->label4 = (gcnew System::Windows::Forms::Label());
			this->linkLabel1 = (gcnew System::Windows::Forms::LinkLabel());
			this->panel2 = (gcnew System::Windows::Forms::Panel());
			this->botonBuscarProducto = (gcnew System::Windows::Forms::Button());
			this->campoProductoBuscar = (gcnew System::Windows::Forms::TextBox());
			this->label18 = (gcnew System::Windows::Forms::Label());
			this->label17 = (gcnew System::Windows::Forms::Label());
			this->botonGenerarReporte = (gcnew System::Windows::Forms::Button());
			this->campoGenerarReporte = (gcnew System::Windows::Forms::TextBox());
			this->label16 = (gcnew System::Windows::Forms::Label());
			this->label15 = (gcnew System::Windows::Forms::Label());
			this->botonBuscarCantidadProducto = (gcnew System::Windows::Forms::Button());
			this->campoBuscarCantProducto = (gcnew System::Windows::Forms::TextBox());
			this->label14 = (gcnew System::Windows::Forms::Label());
			this->label13 = (gcnew System::Windows::Forms::Label());
			this->botonBuscarSupermercado = (gcnew System::Windows::Forms::Button());
			this->campoBuscarCodigoSupermercado = (gcnew System::Windows::Forms::TextBox());
			this->label12 = (gcnew System::Windows::Forms::Label());
			this->label11 = (gcnew System::Windows::Forms::Label());
			this->botonBuscarCliente = (gcnew System::Windows::Forms::Button());
			this->campoCedulaBuscar = (gcnew System::Windows::Forms::TextBox());
			this->label6 = (gcnew System::Windows::Forms::Label());
			this->label5 = (gcnew System::Windows::Forms::Label());
			this->label26 = (gcnew System::Windows::Forms::Label());
			this->label27 = (gcnew System::Windows::Forms::Label());
			this->label28 = (gcnew System::Windows::Forms::Label());
			this->linkLabel2 = (gcnew System::Windows::Forms::LinkLabel());
			this->panel1->SuspendLayout();
			this->panel2->SuspendLayout();
			this->SuspendLayout();
			// 
			// campoDireccion
			// 
			this->campoDireccion->Location = System::Drawing::Point(61, 111);
			this->campoDireccion->Name = L"campoDireccion";
			this->campoDireccion->Size = System::Drawing::Size(188, 20);
			this->campoDireccion->TabIndex = 5;
			// 
			// campoNombre
			// 
			this->campoNombre->Location = System::Drawing::Point(61, 85);
			this->campoNombre->Name = L"campoNombre";
			this->campoNombre->Size = System::Drawing::Size(188, 20);
			this->campoNombre->TabIndex = 4;
			// 
			// campoCedula
			// 
			this->campoCedula->Location = System::Drawing::Point(61, 55);
			this->campoCedula->Name = L"campoCedula";
			this->campoCedula->Size = System::Drawing::Size(188, 20);
			this->campoCedula->TabIndex = 3;
			// 
			// label3
			// 
			this->label3->AutoSize = true;
			this->label3->Location = System::Drawing::Point(3, 111);
			this->label3->Name = L"label3";
			this->label3->Size = System::Drawing::Size(52, 13);
			this->label3->TabIndex = 2;
			this->label3->Text = L"Dirección";
			// 
			// label2
			// 
			this->label2->AutoSize = true;
			this->label2->Location = System::Drawing::Point(3, 85);
			this->label2->Name = L"label2";
			this->label2->Size = System::Drawing::Size(44, 13);
			this->label2->TabIndex = 1;
			this->label2->Text = L"Nombre";
			// 
			// label1
			// 
			this->label1->AutoSize = true;
			this->label1->Location = System::Drawing::Point(3, 55);
			this->label1->Name = L"label1";
			this->label1->Size = System::Drawing::Size(40, 13);
			this->label1->TabIndex = 0;
			this->label1->Text = L"Cédula";
			// 
			// botonAgregarCliente
			// 
			this->botonAgregarCliente->BackColor = System::Drawing::SystemColors::Highlight;
			this->botonAgregarCliente->Location = System::Drawing::Point(47, 146);
			this->botonAgregarCliente->Name = L"botonAgregarCliente";
			this->botonAgregarCliente->Size = System::Drawing::Size(167, 39);
			this->botonAgregarCliente->TabIndex = 6;
			this->botonAgregarCliente->Text = L"Agregar Cliente";
			this->botonAgregarCliente->UseVisualStyleBackColor = false;
			this->botonAgregarCliente->Click += gcnew System::EventHandler(this, &ventanaPrincipal::botonAgregarCliente_Click);
			// 
			// panel1
			// 
			this->panel1->Controls->Add(this->button1);
			this->panel1->Controls->Add(this->textCedula);
			this->panel1->Controls->Add(this->label25);
			this->panel1->Controls->Add(this->label24);
			this->panel1->Controls->Add(this->botonAgregarProducto);
			this->panel1->Controls->Add(this->textDescripcion);
			this->panel1->Controls->Add(this->textCosto);
			this->panel1->Controls->Add(this->textProducto);
			this->panel1->Controls->Add(this->textSuper);
			this->panel1->Controls->Add(this->label23);
			this->panel1->Controls->Add(this->label22);
			this->panel1->Controls->Add(this->label21);
			this->panel1->Controls->Add(this->label20);
			this->panel1->Controls->Add(this->label19);
			this->panel1->Controls->Add(this->botonAgregarSupermercado);
			this->panel1->Controls->Add(this->campoDireccionSupermercado);
			this->panel1->Controls->Add(this->campoNombreSupermercado);
			this->panel1->Controls->Add(this->campoCodigoSupermercado);
			this->panel1->Controls->Add(this->label10);
			this->panel1->Controls->Add(this->label9);
			this->panel1->Controls->Add(this->label8);
			this->panel1->Controls->Add(this->label7);
			this->panel1->Controls->Add(this->label4);
			this->panel1->Controls->Add(this->campoNombre);
			this->panel1->Controls->Add(this->label3);
			this->panel1->Controls->Add(this->botonAgregarCliente);
			this->panel1->Controls->Add(this->label2);
			this->panel1->Controls->Add(this->campoCedula);
			this->panel1->Controls->Add(this->label1);
			this->panel1->Controls->Add(this->campoDireccion);
			this->panel1->Dock = System::Windows::Forms::DockStyle::Right;
			this->panel1->Location = System::Drawing::Point(1096, 0);
			this->panel1->Name = L"panel1";
			this->panel1->Size = System::Drawing::Size(254, 729);
			this->panel1->TabIndex = 7;
			// 
			// button1
			// 
			this->button1->BackColor = System::Drawing::SystemColors::Highlight;
			this->button1->Location = System::Drawing::Point(87, 664);
			this->button1->Name = L"button1";
			this->button1->Size = System::Drawing::Size(87, 33);
			this->button1->TabIndex = 31;
			this->button1->Text = L"Aceptar";
			this->button1->UseVisualStyleBackColor = false;
			this->button1->Click += gcnew System::EventHandler(this, &ventanaPrincipal::button1_Click_1);
			// 
			// textCedula
			// 
			this->textCedula->Location = System::Drawing::Point(84, 631);
			this->textCedula->Name = L"textCedula";
			this->textCedula->Size = System::Drawing::Size(157, 20);
			this->textCedula->TabIndex = 30;
			// 
			// label25
			// 
			this->label25->AutoSize = true;
			this->label25->Location = System::Drawing::Point(20, 634);
			this->label25->Name = L"label25";
			this->label25->Size = System::Drawing::Size(40, 13);
			this->label25->TabIndex = 29;
			this->label25->Text = L"Cédula";
			// 
			// label24
			// 
			this->label24->AutoSize = true;
			this->label24->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 9.75F, System::Drawing::FontStyle::Bold, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(0)));
			this->label24->ForeColor = System::Drawing::Color::Red;
			this->label24->Location = System::Drawing::Point(78, 534);
			this->label24->Name = L"label24";
			this->label24->Size = System::Drawing::Size(67, 16);
			this->label24->TabIndex = 28;
			this->label24->Text = L"Comprar";
			// 
			// botonAgregarProducto
			// 
			this->botonAgregarProducto->BackColor = System::Drawing::SystemColors::Highlight;
			this->botonAgregarProducto->Location = System::Drawing::Point(61, 553);
			this->botonAgregarProducto->Name = L"botonAgregarProducto";
			this->botonAgregarProducto->Size = System::Drawing::Size(127, 34);
			this->botonAgregarProducto->TabIndex = 27;
			this->botonAgregarProducto->Text = L"Agregar Producto";
			this->botonAgregarProducto->UseVisualStyleBackColor = false;
			this->botonAgregarProducto->Click += gcnew System::EventHandler(this, &ventanaPrincipal::botonAgregarProducto_Click);
			// 
			// textDescripcion
			// 
			this->textDescripcion->Location = System::Drawing::Point(11, 526);
			this->textDescripcion->Multiline = true;
			this->textDescripcion->Name = L"textDescripcion";
			this->textDescripcion->Size = System::Drawing::Size(230, 21);
			this->textDescripcion->TabIndex = 26;
			// 
			// textCosto
			// 
			this->textCosto->Location = System::Drawing::Point(112, 475);
			this->textCosto->Name = L"textCosto";
			this->textCosto->Size = System::Drawing::Size(130, 20);
			this->textCosto->TabIndex = 25;
			// 
			// textProducto
			// 
			this->textProducto->Location = System::Drawing::Point(112, 446);
			this->textProducto->Name = L"textProducto";
			this->textProducto->Size = System::Drawing::Size(130, 20);
			this->textProducto->TabIndex = 24;
			// 
			// textSuper
			// 
			this->textSuper->Location = System::Drawing::Point(112, 420);
			this->textSuper->Name = L"textSuper";
			this->textSuper->Size = System::Drawing::Size(130, 20);
			this->textSuper->TabIndex = 23;
			// 
			// label23
			// 
			this->label23->AutoSize = true;
			this->label23->Location = System::Drawing::Point(82, 509);
			this->label23->Name = L"label23";
			this->label23->Size = System::Drawing::Size(63, 13);
			this->label23->TabIndex = 22;
			this->label23->Text = L"Descripción";
			// 
			// label22
			// 
			this->label22->AutoSize = true;
			this->label22->Location = System::Drawing::Point(8, 475);
			this->label22->Name = L"label22";
			this->label22->Size = System::Drawing::Size(34, 13);
			this->label22->TabIndex = 21;
			this->label22->Text = L"Costo";
			// 
			// label21
			// 
			this->label21->AutoSize = true;
			this->label21->Location = System::Drawing::Point(8, 449);
			this->label21->Name = L"label21";
			this->label21->Size = System::Drawing::Size(85, 13);
			this->label21->TabIndex = 20;
			this->label21->Text = L"Código producto";
			// 
			// label20
			// 
			this->label20->AutoSize = true;
			this->label20->Location = System::Drawing::Point(8, 423);
			this->label20->Name = L"label20";
			this->label20->Size = System::Drawing::Size(106, 13);
			this->label20->TabIndex = 19;
			this->label20->Text = L"Código Supermerado";
			// 
			// label19
			// 
			this->label19->AutoSize = true;
			this->label19->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 9.75F, System::Drawing::FontStyle::Bold, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(0)));
			this->label19->Location = System::Drawing::Point(58, 388);
			this->label19->Name = L"label19";
			this->label19->Size = System::Drawing::Size(130, 16);
			this->label19->TabIndex = 18;
			this->label19->Text = L"Agregar Producto";
			// 
			// botonAgregarSupermercado
			// 
			this->botonAgregarSupermercado->BackColor = System::Drawing::SystemColors::Highlight;
			this->botonAgregarSupermercado->Location = System::Drawing::Point(47, 321);
			this->botonAgregarSupermercado->Name = L"botonAgregarSupermercado";
			this->botonAgregarSupermercado->Size = System::Drawing::Size(165, 39);
			this->botonAgregarSupermercado->TabIndex = 17;
			this->botonAgregarSupermercado->Text = L"Agregar Supermercado";
			this->botonAgregarSupermercado->UseVisualStyleBackColor = false;
			this->botonAgregarSupermercado->Click += gcnew System::EventHandler(this, &ventanaPrincipal::botonAgregarSupermercado_Click);
			// 
			// campoDireccionSupermercado
			// 
			this->campoDireccionSupermercado->Location = System::Drawing::Point(61, 284);
			this->campoDireccionSupermercado->Name = L"campoDireccionSupermercado";
			this->campoDireccionSupermercado->Size = System::Drawing::Size(188, 20);
			this->campoDireccionSupermercado->TabIndex = 16;
			// 
			// campoNombreSupermercado
			// 
			this->campoNombreSupermercado->Location = System::Drawing::Point(61, 257);
			this->campoNombreSupermercado->Name = L"campoNombreSupermercado";
			this->campoNombreSupermercado->Size = System::Drawing::Size(188, 20);
			this->campoNombreSupermercado->TabIndex = 15;
			// 
			// campoCodigoSupermercado
			// 
			this->campoCodigoSupermercado->Location = System::Drawing::Point(61, 231);
			this->campoCodigoSupermercado->Name = L"campoCodigoSupermercado";
			this->campoCodigoSupermercado->Size = System::Drawing::Size(188, 20);
			this->campoCodigoSupermercado->TabIndex = 14;
			// 
			// label10
			// 
			this->label10->AutoSize = true;
			this->label10->Location = System::Drawing::Point(8, 287);
			this->label10->Name = L"label10";
			this->label10->Size = System::Drawing::Size(52, 13);
			this->label10->TabIndex = 13;
			this->label10->Text = L"Dirección";
			// 
			// label9
			// 
			this->label9->AutoSize = true;
			this->label9->Location = System::Drawing::Point(8, 257);
			this->label9->Name = L"label9";
			this->label9->Size = System::Drawing::Size(44, 13);
			this->label9->TabIndex = 12;
			this->label9->Text = L"Nombre";
			// 
			// label8
			// 
			this->label8->AutoSize = true;
			this->label8->Location = System::Drawing::Point(8, 231);
			this->label8->Name = L"label8";
			this->label8->Size = System::Drawing::Size(40, 13);
			this->label8->TabIndex = 11;
			this->label8->Text = L"Código";
			// 
			// label7
			// 
			this->label7->AutoSize = true;
			this->label7->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 9.75F, System::Drawing::FontStyle::Bold, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(0)));
			this->label7->Location = System::Drawing::Point(44, 197);
			this->label7->Name = L"label7";
			this->label7->Size = System::Drawing::Size(170, 16);
			this->label7->TabIndex = 10;
			this->label7->Text = L"Agregar Supermercado";
			// 
			// label4
			// 
			this->label4->AutoSize = true;
			this->label4->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 9.75F, System::Drawing::FontStyle::Bold, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(0)));
			this->label4->Location = System::Drawing::Point(58, 25);
			this->label4->Name = L"label4";
			this->label4->Size = System::Drawing::Size(116, 16);
			this->label4->TabIndex = 9;
			this->label4->Text = L"Agregar Cliente";
			// 
			// linkLabel1
			// 
			this->linkLabel1->AutoSize = true;
			this->linkLabel1->Location = System::Drawing::Point(932, 649);
			this->linkLabel1->Name = L"linkLabel1";
			this->linkLabel1->Size = System::Drawing::Size(55, 13);
			this->linkLabel1->TabIndex = 8;
			this->linkLabel1->TabStop = true;
			this->linkLabel1->Text = L"Facebook";
			this->linkLabel1->LinkClicked += gcnew System::Windows::Forms::LinkLabelLinkClickedEventHandler(this, &ventanaPrincipal::linkLabel1_LinkClicked);
			// 
			// panel2
			// 
			this->panel2->Controls->Add(this->botonBuscarProducto);
			this->panel2->Controls->Add(this->campoProductoBuscar);
			this->panel2->Controls->Add(this->label18);
			this->panel2->Controls->Add(this->label17);
			this->panel2->Controls->Add(this->botonGenerarReporte);
			this->panel2->Controls->Add(this->campoGenerarReporte);
			this->panel2->Controls->Add(this->label16);
			this->panel2->Controls->Add(this->label15);
			this->panel2->Controls->Add(this->botonBuscarCantidadProducto);
			this->panel2->Controls->Add(this->campoBuscarCantProducto);
			this->panel2->Controls->Add(this->label14);
			this->panel2->Controls->Add(this->label13);
			this->panel2->Controls->Add(this->botonBuscarSupermercado);
			this->panel2->Controls->Add(this->campoBuscarCodigoSupermercado);
			this->panel2->Controls->Add(this->label12);
			this->panel2->Controls->Add(this->label11);
			this->panel2->Controls->Add(this->botonBuscarCliente);
			this->panel2->Controls->Add(this->campoCedulaBuscar);
			this->panel2->Controls->Add(this->label6);
			this->panel2->Controls->Add(this->label5);
			this->panel2->Dock = System::Windows::Forms::DockStyle::Left;
			this->panel2->Location = System::Drawing::Point(0, 0);
			this->panel2->Name = L"panel2";
			this->panel2->Size = System::Drawing::Size(228, 729);
			this->panel2->TabIndex = 8;
			// 
			// botonBuscarProducto
			// 
			this->botonBuscarProducto->BackColor = System::Drawing::SystemColors::MenuHighlight;
			this->botonBuscarProducto->Location = System::Drawing::Point(54, 664);
			this->botonBuscarProducto->Name = L"botonBuscarProducto";
			this->botonBuscarProducto->Size = System::Drawing::Size(97, 31);
			this->botonBuscarProducto->TabIndex = 19;
			this->botonBuscarProducto->Text = L"Buscar Producto";
			this->botonBuscarProducto->UseVisualStyleBackColor = false;
			this->botonBuscarProducto->Click += gcnew System::EventHandler(this, &ventanaPrincipal::botonBuscarProducto_Click);
			// 
			// campoProductoBuscar
			// 
			this->campoProductoBuscar->Location = System::Drawing::Point(54, 638);
			this->campoProductoBuscar->Name = L"campoProductoBuscar";
			this->campoProductoBuscar->Size = System::Drawing::Size(100, 20);
			this->campoProductoBuscar->TabIndex = 18;
			// 
			// label18
			// 
			this->label18->AutoSize = true;
			this->label18->Location = System::Drawing::Point(51, 622);
			this->label18->Name = L"label18";
			this->label18->Size = System::Drawing::Size(112, 13);
			this->label18->TabIndex = 17;
			this->label18->Text = L"Código Supermercado";
			// 
			// label17
			// 
			this->label17->AutoSize = true;
			this->label17->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 9.75F, System::Drawing::FontStyle::Bold, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(0)));
			this->label17->Location = System::Drawing::Point(48, 591);
			this->label17->Name = L"label17";
			this->label17->Size = System::Drawing::Size(122, 16);
			this->label17->TabIndex = 16;
			this->label17->Text = L"Buscar Producto";
			// 
			// botonGenerarReporte
			// 
			this->botonGenerarReporte->BackColor = System::Drawing::SystemColors::MenuHighlight;
			this->botonGenerarReporte->Location = System::Drawing::Point(51, 526);
			this->botonGenerarReporte->Name = L"botonGenerarReporte";
			this->botonGenerarReporte->Size = System::Drawing::Size(100, 33);
			this->botonGenerarReporte->TabIndex = 15;
			this->botonGenerarReporte->Text = L"Generar Reporte";
			this->botonGenerarReporte->UseVisualStyleBackColor = false;
			this->botonGenerarReporte->Click += gcnew System::EventHandler(this, &ventanaPrincipal::botonGenerarReporte_Click);
			// 
			// campoGenerarReporte
			// 
			this->campoGenerarReporte->Location = System::Drawing::Point(54, 491);
			this->campoGenerarReporte->Name = L"campoGenerarReporte";
			this->campoGenerarReporte->Size = System::Drawing::Size(100, 20);
			this->campoGenerarReporte->TabIndex = 14;
			// 
			// label16
			// 
			this->label16->AutoSize = true;
			this->label16->Location = System::Drawing::Point(48, 475);
			this->label16->Name = L"label16";
			this->label16->Size = System::Drawing::Size(112, 13);
			this->label16->TabIndex = 13;
			this->label16->Text = L"Codigo Supermercado";
			// 
			// label15
			// 
			this->label15->AutoSize = true;
			this->label15->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 9.75F, System::Drawing::FontStyle::Bold, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(0)));
			this->label15->Location = System::Drawing::Point(1, 442);
			this->label15->Name = L"label15";
			this->label15->Size = System::Drawing::Size(224, 16);
			this->label15->TabIndex = 12;
			this->label15->Text = L"Productos de un supermercado";
			// 
			// botonBuscarCantidadProducto
			// 
			this->botonBuscarCantidadProducto->BackColor = System::Drawing::SystemColors::MenuHighlight;
			this->botonBuscarCantidadProducto->Location = System::Drawing::Point(62, 380);
			this->botonBuscarCantidadProducto->Name = L"botonBuscarCantidadProducto";
			this->botonBuscarCantidadProducto->Size = System::Drawing::Size(92, 33);
			this->botonBuscarCantidadProducto->TabIndex = 11;
			this->botonBuscarCantidadProducto->Text = L"Buscar";
			this->botonBuscarCantidadProducto->UseVisualStyleBackColor = false;
			this->botonBuscarCantidadProducto->Click += gcnew System::EventHandler(this, &ventanaPrincipal::button1_Click);
			// 
			// campoBuscarCantProducto
			// 
			this->campoBuscarCantProducto->Location = System::Drawing::Point(60, 340);
			this->campoBuscarCantProducto->Name = L"campoBuscarCantProducto";
			this->campoBuscarCantProducto->Size = System::Drawing::Size(100, 20);
			this->campoBuscarCantProducto->TabIndex = 10;
			// 
			// label14
			// 
			this->label14->AutoSize = true;
			this->label14->Location = System::Drawing::Point(57, 321);
			this->label14->Name = L"label14";
			this->label14->Size = System::Drawing::Size(112, 13);
			this->label14->TabIndex = 9;
			this->label14->Text = L"Codigo Supermercado";
			// 
			// label13
			// 
			this->label13->AutoSize = true;
			this->label13->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 9.75F, System::Drawing::FontStyle::Bold, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(0)));
			this->label13->Location = System::Drawing::Point(16, 284);
			this->label13->Name = L"label13";
			this->label13->Size = System::Drawing::Size(178, 16);
			this->label13->TabIndex = 8;
			this->label13->Text = L"Cantidad de un Producto";
			// 
			// botonBuscarSupermercado
			// 
			this->botonBuscarSupermercado->BackColor = System::Drawing::SystemColors::Highlight;
			this->botonBuscarSupermercado->Location = System::Drawing::Point(62, 209);
			this->botonBuscarSupermercado->Name = L"botonBuscarSupermercado";
			this->botonBuscarSupermercado->Size = System::Drawing::Size(92, 35);
			this->botonBuscarSupermercado->TabIndex = 7;
			this->botonBuscarSupermercado->Text = L"Buscar Supermercado";
			this->botonBuscarSupermercado->UseVisualStyleBackColor = false;
			this->botonBuscarSupermercado->Click += gcnew System::EventHandler(this, &ventanaPrincipal::botonBuscarSupermercado_Click);
			// 
			// campoBuscarCodigoSupermercado
			// 
			this->campoBuscarCodigoSupermercado->Location = System::Drawing::Point(62, 171);
			this->campoBuscarCodigoSupermercado->Name = L"campoBuscarCodigoSupermercado";
			this->campoBuscarCodigoSupermercado->Size = System::Drawing::Size(142, 20);
			this->campoBuscarCodigoSupermercado->TabIndex = 6;
			// 
			// label12
			// 
			this->label12->AutoSize = true;
			this->label12->Location = System::Drawing::Point(16, 171);
			this->label12->Name = L"label12";
			this->label12->Size = System::Drawing::Size(40, 13);
			this->label12->TabIndex = 5;
			this->label12->Text = L"Codigo";
			// 
			// label11
			// 
			this->label11->AutoSize = true;
			this->label11->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 9.75F, System::Drawing::FontStyle::Bold, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(0)));
			this->label11->Location = System::Drawing::Point(26, 133);
			this->label11->Name = L"label11";
			this->label11->Size = System::Drawing::Size(162, 16);
			this->label11->TabIndex = 4;
			this->label11->Text = L"Buscar Supermercado";
			// 
			// botonBuscarCliente
			// 
			this->botonBuscarCliente->BackColor = System::Drawing::SystemColors::Highlight;
			this->botonBuscarCliente->Location = System::Drawing::Point(60, 73);
			this->botonBuscarCliente->Name = L"botonBuscarCliente";
			this->botonBuscarCliente->Size = System::Drawing::Size(94, 37);
			this->botonBuscarCliente->TabIndex = 3;
			this->botonBuscarCliente->Text = L"Buscar Cliente";
			this->botonBuscarCliente->UseVisualStyleBackColor = false;
			this->botonBuscarCliente->Click += gcnew System::EventHandler(this, &ventanaPrincipal::botonBuscarCliente_Click);
			// 
			// campoCedulaBuscar
			// 
			this->campoCedulaBuscar->Location = System::Drawing::Point(60, 35);
			this->campoCedulaBuscar->Name = L"campoCedulaBuscar";
			this->campoCedulaBuscar->Size = System::Drawing::Size(144, 20);
			this->campoCedulaBuscar->TabIndex = 2;
			// 
			// label6
			// 
			this->label6->AutoSize = true;
			this->label6->Location = System::Drawing::Point(13, 35);
			this->label6->Name = L"label6";
			this->label6->Size = System::Drawing::Size(40, 13);
			this->label6->TabIndex = 1;
			this->label6->Text = L"Cédula";
			// 
			// label5
			// 
			this->label5->AutoSize = true;
			this->label5->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 9.75F, System::Drawing::FontStyle::Bold, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(0)));
			this->label5->Location = System::Drawing::Point(46, 9);
			this->label5->Name = L"label5";
			this->label5->Size = System::Drawing::Size(108, 16);
			this->label5->TabIndex = 0;
			this->label5->Text = L"Buscar Cliente";
			// 
			// label26
			// 
			this->label26->AutoSize = true;
			this->label26->Font = (gcnew System::Drawing::Font(L"Forte", 9.75F, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(0)));
			this->label26->ForeColor = System::Drawing::Color::Black;
			this->label26->Location = System::Drawing::Point(796, 664);
			this->label26->Name = L"label26";
			this->label26->Size = System::Drawing::Size(71, 14);
			this->label26->TabIndex = 9;
			this->label26->Text = L"Creado por:";
			// 
			// label27
			// 
			this->label27->AutoSize = true;
			this->label27->Font = (gcnew System::Drawing::Font(L"Forte", 9, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(0)));
			this->label27->Location = System::Drawing::Point(868, 649);
			this->label27->Name = L"label27";
			this->label27->Size = System::Drawing::Size(55, 14);
			this->label27->TabIndex = 10;
			this->label27->Text = L"Diego V.F";
			// 
			// label28
			// 
			this->label28->AutoSize = true;
			this->label28->Font = (gcnew System::Drawing::Font(L"Forte", 9, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(0)));
			this->label28->Location = System::Drawing::Point(862, 673);
			this->label28->Name = L"label28";
			this->label28->Size = System::Drawing::Size(64, 14);
			this->label28->TabIndex = 11;
			this->label28->Text = L"Pablo M.C";
			// 
			// linkLabel2
			// 
			this->linkLabel2->AutoSize = true;
			this->linkLabel2->Location = System::Drawing::Point(932, 673);
			this->linkLabel2->Name = L"linkLabel2";
			this->linkLabel2->Size = System::Drawing::Size(55, 13);
			this->linkLabel2->TabIndex = 12;
			this->linkLabel2->TabStop = true;
			this->linkLabel2->Text = L"Facebook";
			this->linkLabel2->LinkClicked += gcnew System::Windows::Forms::LinkLabelLinkClickedEventHandler(this, &ventanaPrincipal::linkLabel2_LinkClicked);
			// 
			// ventanaPrincipal
			// 
			this->AutoScaleDimensions = System::Drawing::SizeF(6, 13);
			this->AutoScaleMode = System::Windows::Forms::AutoScaleMode::Font;
			this->BackColor = System::Drawing::Color::White;
			this->BackgroundImage = (cli::safe_cast<System::Drawing::Image^>(resources->GetObject(L"$this.BackgroundImage")));
			this->BackgroundImageLayout = System::Windows::Forms::ImageLayout::Center;
			this->ClientSize = System::Drawing::Size(1350, 729);
			this->Controls->Add(this->linkLabel2);
			this->Controls->Add(this->label28);
			this->Controls->Add(this->label27);
			this->Controls->Add(this->label26);
			this->Controls->Add(this->panel2);
			this->Controls->Add(this->panel1);
			this->Controls->Add(this->linkLabel1);
			this->Icon = (cli::safe_cast<System::Drawing::Icon^>(resources->GetObject(L"$this.Icon")));
			this->Name = L"ventanaPrincipal";
			this->Text = L"ventanaPrincipal";
			this->Load += gcnew System::EventHandler(this, &ventanaPrincipal::ventanaPrincipal_Load);
			this->panel1->ResumeLayout(false);
			this->panel1->PerformLayout();
			this->panel2->ResumeLayout(false);
			this->panel2->PerformLayout();
			this->ResumeLayout(false);
			this->PerformLayout();

		}
#pragma endregion
	private: System::Void ventanaPrincipal_Load(System::Object^  sender, System::EventArgs^  e) {
			 }
	private: System::Void botonAgregarCliente_Click(System::Object^  sender, System::EventArgs^  e) {
				 String^ nombre = campoNombre->Text;
				 String^ direc = campoDireccion->Text;
				 string nom = marshal_as<std::string>(nombre);
				 string dir = marshal_as<std::string>(direc);
				 int ced = Convert::ToInt32(campoCedula->Text);
				 archivos.guardarCliente(ced, nom, dir);

			 }
private: System::Void linkLabel1_LinkClicked(System::Object^  sender, System::Windows::Forms::LinkLabelLinkClickedEventArgs^  e) {
			 System::Diagnostics::Process::Start("https://www.facebook.com/dflores11?ref=tn_tnmn");
		 }
	private: System::Void botonBuscarCliente_Click(System::Object^  sender, System::EventArgs^  e) {
				 if (campoCedulaBuscar->Text == ""){
					 MessageBox::Show("Debe llenar el campo", "Lo sentimos", MessageBoxButtons::OK, MessageBoxIcon::Error);
				 }
				 else
				 {
					 int cedu = System::Convert::ToInt32(campoCedulaBuscar->Text);
					 archivos.buscarCliente(cedu);
				 }
				 
			 }
	private: System::Void botonAgregarSupermercado_Click(System::Object^  sender, System::EventArgs^  e) {
				 String^ nombre = campoNombreSupermercado->Text;
				 String^ direc = campoDireccionSupermercado->Text;
				 string nom = marshal_as<std::string>(nombre);
				 string dir = marshal_as<std::string>(direc);
				 int ced = Convert::ToInt32(campoCodigoSupermercado->Text);
				 archivos.guardarSupermercado(ced, nom, dir);
			 }
private: System::Void botonBuscarSupermercado_Click(System::Object^  sender, System::EventArgs^  e) {
			 if (campoBuscarCodigoSupermercado->Text == ""){
				MessageBox::Show("Debe llenar el campo", "Lo sentimos", MessageBoxButtons::OK, MessageBoxIcon::Error);
			 }
			 else
			 {
				 int codigo = System::Convert::ToInt32(campoBuscarCodigoSupermercado->Text);
				 archivos.buscarSupermercado(codigo);
			 }
			 
		 }
private: System::Void button1_Click(System::Object^  sender, System::EventArgs^  e) {
			 int codSuper = System::Convert::ToInt32(campoBuscarCantProducto->Text);
			 if (arbolB.Buscar(codSuper) == true){
				 SistemadeVentaseInventarios::ventanaCodProducto ventanaCodigo;
				 ventanaCodigo.ShowDialog();
				 int codProduc = ventanaCodigo.a;
				 archivos.buscarCantidadDeProducto(codSuper, codProduc);			 }
			 else{
				 MessageBox::Show("No se ha podido encontrar el supermercado", "Lo sentimos", MessageBoxButtons::OK, MessageBoxIcon::Error);
			 }
			 
		 }
private: System::Void botonGenerarReporte_Click(System::Object^  sender, System::EventArgs^  e) {
			 int codSuper = System::Convert::ToInt32(campoGenerarReporte->Text);
			 if (arbolB.Buscar(codSuper) == true){
				 archivos.generarReporteProductos(codSuper);
			 }
			 else{
				 MessageBox::Show("No se ha podido encontrar el supermercado", "Lo sentimos", MessageBoxButtons::OK, MessageBoxIcon::Error);
			 }

		 }
private: System::Void botonBuscarProducto_Click(System::Object^  sender, System::EventArgs^  e) {
			 int codSuper = System::Convert::ToInt32(campoProductoBuscar->Text);
			 NodoAA *nodo = aa->Buscar(aa->raiz, codSuper, NULL);
			 if (nodo != NULL){
				 SistemadeVentaseInventarios::ventanaCodProducto ventanaCodigo;
				 ventanaCodigo.ShowDialog();
				 int codProduc = ventanaCodigo.a;
				 archivos.buscarProducto(codSuper, codProduc);
			 }
			 else
			 {
				 MessageBox::Show("Supermercado no encontrado", "IFO", MessageBoxButtons::OK, MessageBoxIcon::Information);
			 }
		 }
private: System::Void botonAgregarProducto_Click(System::Object^  sender, System::EventArgs^  e) {
			 int codS, codP, cost;
			 codS = System::Convert::ToInt32(textSuper->Text);
			 codP = System::Convert::ToInt32(textProducto->Text);
			 cost = System::Convert::ToInt32(textCosto->Text);
			 String^ de = textDescripcion->Text;
			 string des = marshal_as<std::string>(de);
			 archivos.agregarProducto(codS, codP, cost, des);
		 }
private: System::Void button1_Click_1(System::Object^  sender, System::EventArgs^  e) {
			 int cedula = System::Convert::ToInt32(textCedula->Text);
			 int codS, codP, cant, cantidad, costo;
			 if (abb.Buscar(cedula) == true){
				 pnb cliente = abb.obtenerCliente(cedula);
				 SistemadeVentaseInventarios::ventanaSupermercado super;
				 super.ShowDialog();
				 codS = super.cod;
				 if (arbolB.Buscar(codS) == true){
					 SistemadeVentaseInventarios::ventanaCodProducto producto;
					 producto.ShowDialog();
					 codP = producto.a;
					 if (arbolB.BuscarEnAVL(codS, codP) == true){
						 SistemadeVentaseInventarios::ventadaCantidad vcantidad;
						 vcantidad.ShowDialog();
						 cant = vcantidad.cant;
						 cantidad = arbolB.obtenerCantidadProducto(codS, codP);
						 if (cant <= cantidad && cant != 0){
							 cantidad = cantidad - cant;
							 arbolB.cambiarCantidadProducto(codS, codP, cantidad);
							 NodoAA* doble = aa->BuscarCosto(aa->raiz, codS, NULL);
							 costo = doble->rojiNegro->obtenerCosto(codP);
							 String^ xy = System::Convert::ToString(costo);
							 MessageBox::Show("El costo del producto: " + xy, "Lo sentimos",
								 MessageBoxButtons::OK, MessageBoxIcon::Information);
							 ofstream factura("Factura.txt", ofstream::app);
							 factura << "------------------- Inicio Factura -------------------" << endl
								 << "Código de Supermercado: " << codS << endl
								 << "Código de Producto:     " << codP << endl
								 << "Cantidad de Producto:   " << cant << endl
								 << "Costo unitario.         " << costo << endl
								 << "Total a pagar:          " << costo*cant << endl
								 << "-------------------- Fin Factura ----------------------" << endl;
							 factura.close();
							 MessageBox::Show("Factura Genera ", "Info",
								 MessageBoxButtons::OK, MessageBoxIcon::Information);

						 }
						 else{
							 if (cant == 0){
								 MessageBox::Show("No se facturará por 0 productos", "Lo sentimos",
									 MessageBoxButtons::OK, MessageBoxIcon::Error);
							 }else
							 MessageBox::Show("El supermercado no cuenta con esa cantidad de producto", "Lo sentimos",
								 MessageBoxButtons::OK, MessageBoxIcon::Information);
						 }
						 int cantidad = arbolB.obtenerCantidadProducto(codS, codP);
					 }
					 else{
						 MessageBox::Show("No se pudo encontrar el producto", "Lo sentimos",
							 MessageBoxButtons::OK, MessageBoxIcon::Information);
					 }
						
				 }
				 else{
					 MessageBox::Show("No se pudo encontrar el supermercado", "Lo sentimos",
						 MessageBoxButtons::OK, MessageBoxIcon::Information);
				 }
			 }
			 else{
				 MessageBox::Show("No se pudo encontrar al cliente", "Lo sentimos", 
					 MessageBoxButtons::OK, MessageBoxIcon::Information);
			 }
		 }
private: System::Void linkLabel2_LinkClicked(System::Object^  sender, System::Windows::Forms::LinkLabelLinkClickedEventArgs^  e) {
			 System::Diagnostics::Process::Start("https://www.facebook.com/pablo.moracalderon.9?fref=ts");
		 }
};
}
