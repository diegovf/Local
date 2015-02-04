#pragma once
namespace SistemadeVentaseInventarios {

	using namespace System;
	using namespace System::ComponentModel;
	using namespace System::Collections;
	using namespace System::Windows::Forms;
	using namespace System::Data;
	using namespace System::Drawing;

	/// <summary>
	/// Resumen de ventanaSupermercado
	/// </summary>
	public ref class ventanaSupermercado : public System::Windows::Forms::Form
	{
	public:
		ventanaSupermercado(void)
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
		~ventanaSupermercado()
		{
			if (components)
			{
				delete components;
			}
		}
	public: int cod = 0;
	private: System::Windows::Forms::Label^  label1;
	private: System::Windows::Forms::TextBox^  campoCodigo;
	private: System::Windows::Forms::Button^  botonAceptar;
	protected:

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
			this->campoCodigo = (gcnew System::Windows::Forms::TextBox());
			this->botonAceptar = (gcnew System::Windows::Forms::Button());
			this->SuspendLayout();
			// 
			// label1
			// 
			this->label1->AutoSize = true;
			this->label1->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 9.75F, System::Drawing::FontStyle::Bold, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(0)));
			this->label1->Location = System::Drawing::Point(12, 42);
			this->label1->Name = L"label1";
			this->label1->Size = System::Drawing::Size(242, 16);
			this->label1->TabIndex = 0;
			this->label1->Text = L"Ingrese codigo del supermercado";
			// 
			// campoCodigo
			// 
			this->campoCodigo->Location = System::Drawing::Point(54, 89);
			this->campoCodigo->Name = L"campoCodigo";
			this->campoCodigo->Size = System::Drawing::Size(145, 20);
			this->campoCodigo->TabIndex = 1;
			// 
			// botonAceptar
			// 
			this->botonAceptar->BackColor = System::Drawing::SystemColors::Highlight;
			this->botonAceptar->Location = System::Drawing::Point(74, 126);
			this->botonAceptar->Name = L"botonAceptar";
			this->botonAceptar->Size = System::Drawing::Size(100, 27);
			this->botonAceptar->TabIndex = 2;
			this->botonAceptar->Text = L"Aceptar";
			this->botonAceptar->UseVisualStyleBackColor = false;
			this->botonAceptar->Click += gcnew System::EventHandler(this, &ventanaSupermercado::botonAceptar_Click);
			// 
			// ventanaSupermercado
			// 
			this->AutoScaleDimensions = System::Drawing::SizeF(6, 13);
			this->AutoScaleMode = System::Windows::Forms::AutoScaleMode::Font;
			this->ClientSize = System::Drawing::Size(265, 233);
			this->Controls->Add(this->botonAceptar);
			this->Controls->Add(this->campoCodigo);
			this->Controls->Add(this->label1);
			this->Name = L"ventanaSupermercado";
			this->Text = L"ventanaSupermercado";
			this->ResumeLayout(false);
			this->PerformLayout();

		}
#pragma endregion
	private: System::Void botonAceptar_Click(System::Object^  sender, System::EventArgs^  e) {
				 cod = System::Convert::ToInt32(campoCodigo->Text);
				 ventanaSupermercado::Close();
			 }
	};
}
