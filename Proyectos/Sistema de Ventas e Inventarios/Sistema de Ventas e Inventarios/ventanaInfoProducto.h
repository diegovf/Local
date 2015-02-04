#pragma once

namespace SistemadeVentaseInventarios {

	using namespace System;
	using namespace System::ComponentModel;
	using namespace System::Collections;
	using namespace System::Windows::Forms;
	using namespace System::Data;
	using namespace System::Drawing;

	/// <summary>
	/// Resumen de ventanaInfoProducto
	/// </summary>
	public ref class ventanaInfoProducto : public System::Windows::Forms::Form
	{
	public:
		ventanaInfoProducto(void)
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
		~ventanaInfoProducto()
		{
			if (components)
			{
				delete components;
			}
		}
	private: System::Windows::Forms::Label^  label1;
	protected:
	private: System::Windows::Forms::Label^  label2;
	private: System::Windows::Forms::Label^  label3;
	public: System::Windows::Forms::Label^  labelCodigo;
	public: System::Windows::Forms::Label^  labelDescripcion;
	public: System::Windows::Forms::Label^  labelPrecio;

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
			this->label1 = (gcnew System::Windows::Forms::Label());
			this->label2 = (gcnew System::Windows::Forms::Label());
			this->label3 = (gcnew System::Windows::Forms::Label());
			this->labelCodigo = (gcnew System::Windows::Forms::Label());
			this->labelDescripcion = (gcnew System::Windows::Forms::Label());
			this->labelPrecio = (gcnew System::Windows::Forms::Label());
			this->SuspendLayout();
			// 
			// label1
			// 
			this->label1->AutoSize = true;
			this->label1->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 9, System::Drawing::FontStyle::Bold, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(0)));
			this->label1->Location = System::Drawing::Point(13, 36);
			this->label1->Name = L"label1";
			this->label1->Size = System::Drawing::Size(56, 15);
			this->label1->TabIndex = 0;
			this->label1->Text = L"Código:";
			// 
			// label2
			// 
			this->label2->AutoSize = true;
			this->label2->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 9, System::Drawing::FontStyle::Bold, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(0)));
			this->label2->Location = System::Drawing::Point(13, 86);
			this->label2->Name = L"label2";
			this->label2->Size = System::Drawing::Size(87, 15);
			this->label2->TabIndex = 1;
			this->label2->Text = L"Descripción:";
			// 
			// label3
			// 
			this->label3->AutoSize = true;
			this->label3->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 9, System::Drawing::FontStyle::Bold, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(0)));
			this->label3->Location = System::Drawing::Point(19, 141);
			this->label3->Name = L"label3";
			this->label3->Size = System::Drawing::Size(52, 15);
			this->label3->TabIndex = 2;
			this->label3->Text = L"Precio:";
			// 
			// labelCodigo
			// 
			this->labelCodigo->AutoSize = true;
			this->labelCodigo->Location = System::Drawing::Point(76, 36);
			this->labelCodigo->Name = L"labelCodigo";
			this->labelCodigo->Size = System::Drawing::Size(35, 13);
			this->labelCodigo->TabIndex = 3;
			this->labelCodigo->Text = L"NULL";
			// 
			// labelDescripcion
			// 
			this->labelDescripcion->AutoSize = true;
			this->labelDescripcion->Location = System::Drawing::Point(106, 88);
			this->labelDescripcion->Name = L"labelDescripcion";
			this->labelDescripcion->Size = System::Drawing::Size(35, 13);
			this->labelDescripcion->TabIndex = 4;
			this->labelDescripcion->Text = L"NULL";
			// 
			// labelPrecio
			// 
			this->labelPrecio->AutoSize = true;
			this->labelPrecio->Location = System::Drawing::Point(76, 143);
			this->labelPrecio->Name = L"labelPrecio";
			this->labelPrecio->Size = System::Drawing::Size(35, 13);
			this->labelPrecio->TabIndex = 5;
			this->labelPrecio->Text = L"NULL";
			// 
			// ventanaInfoProducto
			// 
			this->AutoScaleDimensions = System::Drawing::SizeF(6, 13);
			this->AutoScaleMode = System::Windows::Forms::AutoScaleMode::Font;
			this->ClientSize = System::Drawing::Size(305, 204);
			this->Controls->Add(this->labelPrecio);
			this->Controls->Add(this->labelDescripcion);
			this->Controls->Add(this->labelCodigo);
			this->Controls->Add(this->label3);
			this->Controls->Add(this->label2);
			this->Controls->Add(this->label1);
			this->Name = L"ventanaInfoProducto";
			this->Text = L"Información del Producto";
			this->ResumeLayout(false);
			this->PerformLayout();

		}
#pragma endregion
	};
}
