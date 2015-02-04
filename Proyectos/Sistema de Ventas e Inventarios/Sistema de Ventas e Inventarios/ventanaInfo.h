#pragma once

namespace SistemadeVentaseInventarios {

	using namespace System;
	using namespace System::ComponentModel;
	using namespace System::Collections;
	using namespace System::Windows::Forms;
	using namespace System::Data;
	using namespace System::Drawing;

	/// <summary>
	/// Resumen de ventanaInfo
	/// </summary>
	public ref class ventanaInfo : public System::Windows::Forms::Form
	{
	public:
		ventanaInfo(void)
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
		~ventanaInfo()
		{
			if (components)
			{
				delete components;
			}
		}
	public: System::Windows::Forms::Label^  labelNombre;
	public: System::Windows::Forms::Label^  labelCedula;
	public: System::Windows::Forms::Label^  labelDireccion;
	public: System::Windows::Forms::Label^  labelMotivo;
	private: System::Windows::Forms::Label^  label1;
	public:
	private: System::Windows::Forms::Label^  label2;
	private: System::Windows::Forms::Label^  label3;
	public:


	protected:

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
			this->labelNombre = (gcnew System::Windows::Forms::Label());
			this->labelCedula = (gcnew System::Windows::Forms::Label());
			this->labelDireccion = (gcnew System::Windows::Forms::Label());
			this->labelMotivo = (gcnew System::Windows::Forms::Label());
			this->label1 = (gcnew System::Windows::Forms::Label());
			this->label2 = (gcnew System::Windows::Forms::Label());
			this->label3 = (gcnew System::Windows::Forms::Label());
			this->SuspendLayout();
			// 
			// labelNombre
			// 
			this->labelNombre->AutoSize = true;
			this->labelNombre->BorderStyle = System::Windows::Forms::BorderStyle::Fixed3D;
			this->labelNombre->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 9.75F, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(0)));
			this->labelNombre->Location = System::Drawing::Point(70, 59);
			this->labelNombre->Name = L"labelNombre";
			this->labelNombre->Size = System::Drawing::Size(30, 18);
			this->labelNombre->TabIndex = 0;
			this->labelNombre->Text = L"null";
			// 
			// labelCedula
			// 
			this->labelCedula->AutoSize = true;
			this->labelCedula->BorderStyle = System::Windows::Forms::BorderStyle::Fixed3D;
			this->labelCedula->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 9.75F, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(0)));
			this->labelCedula->Location = System::Drawing::Point(70, 96);
			this->labelCedula->Name = L"labelCedula";
			this->labelCedula->Size = System::Drawing::Size(30, 18);
			this->labelCedula->TabIndex = 1;
			this->labelCedula->Text = L"null";
			// 
			// labelDireccion
			// 
			this->labelDireccion->AutoSize = true;
			this->labelDireccion->BorderStyle = System::Windows::Forms::BorderStyle::Fixed3D;
			this->labelDireccion->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 9.75F, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(0)));
			this->labelDireccion->Location = System::Drawing::Point(70, 131);
			this->labelDireccion->Name = L"labelDireccion";
			this->labelDireccion->Size = System::Drawing::Size(30, 18);
			this->labelDireccion->TabIndex = 2;
			this->labelDireccion->Text = L"null";
			// 
			// labelMotivo
			// 
			this->labelMotivo->AutoSize = true;
			this->labelMotivo->BorderStyle = System::Windows::Forms::BorderStyle::FixedSingle;
			this->labelMotivo->Font = (gcnew System::Drawing::Font(L"Microsoft Sans Serif", 9.75F, System::Drawing::FontStyle::Regular, System::Drawing::GraphicsUnit::Point,
				static_cast<System::Byte>(0)));
			this->labelMotivo->ForeColor = System::Drawing::SystemColors::HotTrack;
			this->labelMotivo->Location = System::Drawing::Point(70, 19);
			this->labelMotivo->Name = L"labelMotivo";
			this->labelMotivo->Size = System::Drawing::Size(30, 18);
			this->labelMotivo->TabIndex = 3;
			this->labelMotivo->Text = L"null";
			// 
			// label1
			// 
			this->label1->AutoSize = true;
			this->label1->Location = System::Drawing::Point(13, 61);
			this->label1->Name = L"label1";
			this->label1->Size = System::Drawing::Size(44, 13);
			this->label1->TabIndex = 4;
			this->label1->Text = L"Nombre";
			// 
			// label2
			// 
			this->label2->AutoSize = true;
			this->label2->Location = System::Drawing::Point(13, 96);
			this->label2->Name = L"label2";
			this->label2->Size = System::Drawing::Size(40, 13);
			this->label2->TabIndex = 5;
			this->label2->Text = L"Cédula";
			// 
			// label3
			// 
			this->label3->AutoSize = true;
			this->label3->Location = System::Drawing::Point(12, 133);
			this->label3->Name = L"label3";
			this->label3->Size = System::Drawing::Size(52, 13);
			this->label3->TabIndex = 6;
			this->label3->Text = L"Dirección";
			// 
			// ventanaInfo
			// 
			this->AutoScaleDimensions = System::Drawing::SizeF(6, 13);
			this->AutoScaleMode = System::Windows::Forms::AutoScaleMode::Font;
			this->ClientSize = System::Drawing::Size(317, 170);
			this->Controls->Add(this->label3);
			this->Controls->Add(this->label2);
			this->Controls->Add(this->label1);
			this->Controls->Add(this->labelMotivo);
			this->Controls->Add(this->labelDireccion);
			this->Controls->Add(this->labelCedula);
			this->Controls->Add(this->labelNombre);
			this->Name = L"ventanaInfo";
			this->Text = L"ventanaInfo";
			this->Load += gcnew System::EventHandler(this, &ventanaInfo::ventanaInfo_Load);
			this->ResumeLayout(false);
			this->PerformLayout();

		}
#pragma endregion
	private: System::Void ventanaInfo_Load(System::Object^  sender, System::EventArgs^  e) {
			 }
	};
}
