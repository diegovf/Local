#pragma once
namespace SistemadeVentaseInventarios {

	using namespace System;
	using namespace System::ComponentModel;
	using namespace System::Collections;
	using namespace System::Windows::Forms;
	using namespace System::Data;
	using namespace System::Drawing;

	/// <summary>
	/// Resumen de ventanaCodProducto
	/// </summary>
	public ref class ventanaCodProducto : public System::Windows::Forms::Form
	{
	public:
		ventanaCodProducto(void)
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
		~ventanaCodProducto()
		{
			if (components)
			{
				delete components;
			}
		}
	public: int a = 0;
	private: System::Windows::Forms::Button^  botonAceptar;
	protected:
	private: System::Windows::Forms::Label^  label1;
	public: System::Windows::Forms::TextBox^  campoCodigoProducto;

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
			this->botonAceptar = (gcnew System::Windows::Forms::Button());
			this->label1 = (gcnew System::Windows::Forms::Label());
			this->campoCodigoProducto = (gcnew System::Windows::Forms::TextBox());
			this->SuspendLayout();
			// 
			// botonAceptar
			// 
			this->botonAceptar->BackColor = System::Drawing::SystemColors::Highlight;
			this->botonAceptar->Location = System::Drawing::Point(106, 127);
			this->botonAceptar->Name = L"botonAceptar";
			this->botonAceptar->Size = System::Drawing::Size(82, 30);
			this->botonAceptar->TabIndex = 0;
			this->botonAceptar->Text = L"Aceptar";
			this->botonAceptar->UseVisualStyleBackColor = false;
			this->botonAceptar->Click += gcnew System::EventHandler(this, &ventanaCodProducto::botonAceptar_Click);
			// 
			// label1
			// 
			this->label1->AutoSize = true;
			this->label1->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 9.75F, System::Drawing::FontStyle::Bold, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(0)));
			this->label1->Location = System::Drawing::Point(41, 38);
			this->label1->Name = L"label1";
			this->label1->Size = System::Drawing::Size(220, 16);
			this->label1->TabIndex = 1;
			this->label1->Text = L"Ingrese el código del producto";
			// 
			// campoCodigoProducto
			// 
			this->campoCodigoProducto->Location = System::Drawing::Point(73, 82);
			this->campoCodigoProducto->Name = L"campoCodigoProducto";
			this->campoCodigoProducto->Size = System::Drawing::Size(157, 20);
			this->campoCodigoProducto->TabIndex = 2;
			// 
			// ventanaCodProducto
			// 
			this->AutoScaleDimensions = System::Drawing::SizeF(6, 13);
			this->AutoScaleMode = System::Windows::Forms::AutoScaleMode::Font;
			this->ClientSize = System::Drawing::Size(304, 187);
			this->Controls->Add(this->campoCodigoProducto);
			this->Controls->Add(this->label1);
			this->Controls->Add(this->botonAceptar);
			this->Name = L"ventanaCodProducto";
			this->Text = L"Ingresar Código Producto";
			this->ResumeLayout(false);
			this->PerformLayout();

		}
#pragma endregion
	private: System::Void botonAceptar_Click(System::Object^  sender, System::EventArgs^  e) {
				 a = System::Convert::ToInt32(campoCodigoProducto->Text);
				 ventanaCodProducto::Close();
			 }
	};
}
