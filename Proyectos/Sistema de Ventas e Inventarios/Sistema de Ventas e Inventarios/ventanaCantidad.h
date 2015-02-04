#pragma once

namespace SistemadeVentaseInventarios {

	using namespace System;
	using namespace System::ComponentModel;
	using namespace System::Collections;
	using namespace System::Windows::Forms;
	using namespace System::Data;
	using namespace System::Drawing;

	/// <summary>
	/// Resumen de ventadaCantidad
	/// </summary>
	public ref class ventadaCantidad : public System::Windows::Forms::Form
	{
	public:
		ventadaCantidad(void)
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
		~ventadaCantidad()
		{
			if (components)
			{
				delete components;
			}
		}
	public: int cant = 0;
	private: System::Windows::Forms::Button^  botonAceptar;
	protected:
	private: System::Windows::Forms::Label^  label1;
	private: System::Windows::Forms::TextBox^  campoCantidad;


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
			this->botonAceptar = (gcnew System::Windows::Forms::Button());
			this->label1 = (gcnew System::Windows::Forms::Label());
			this->campoCantidad = (gcnew System::Windows::Forms::TextBox());
			this->SuspendLayout();
			// 
			// botonAceptar
			// 
			this->botonAceptar->Location = System::Drawing::Point(90, 116);
			this->botonAceptar->Name = L"botonAceptar";
			this->botonAceptar->Size = System::Drawing::Size(100, 30);
			this->botonAceptar->TabIndex = 0;
			this->botonAceptar->Text = L"Aceptar";
			this->botonAceptar->UseVisualStyleBackColor = true;
			this->botonAceptar->Click += gcnew System::EventHandler(this, &ventadaCantidad::botonAceptar_Click);
			// 
			// label1
			// 
			this->label1->AutoSize = true;
			this->label1->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 9, System::Drawing::FontStyle::Bold, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(0)));
			this->label1->Location = System::Drawing::Point(1, 37);
			this->label1->Name = L"label1";
			this->label1->Size = System::Drawing::Size(281, 15);
			this->label1->TabIndex = 1;
			this->label1->Text = L"Ingrese la cantidad de producto que desea";
			// 
			// campoCantidad
			// 
			this->campoCantidad->Location = System::Drawing::Point(90, 73);
			this->campoCantidad->Name = L"campoCantidad";
			this->campoCantidad->Size = System::Drawing::Size(100, 20);
			this->campoCantidad->TabIndex = 2;
			// 
			// ventadaCantidad
			// 
			this->AutoScaleDimensions = System::Drawing::SizeF(6, 13);
			this->AutoScaleMode = System::Windows::Forms::AutoScaleMode::Font;
			this->ClientSize = System::Drawing::Size(289, 178);
			this->Controls->Add(this->campoCantidad);
			this->Controls->Add(this->label1);
			this->Controls->Add(this->botonAceptar);
			this->Name = L"ventadaCantidad";
			this->Text = L"ventadaCantidad";
			this->ResumeLayout(false);
			this->PerformLayout();

		}
#pragma endregion
	private: System::Void botonAceptar_Click(System::Object^  sender, System::EventArgs^  e) {
				 cant = System::Convert::ToInt32(campoCantidad->Text);
				 ventadaCantidad::Close();
			 }
	};
}
