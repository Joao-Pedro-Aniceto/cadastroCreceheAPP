package com.exemplo.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private Button loginBtn, cadastrarBtn;
    private EditText cpfTxt, senhaTxt;
    private EventosDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBtn = (Button) findViewById(R.id.loginBtn);
        cadastrarBtn = (Button) findViewById(R.id.cadastroBtn);
        cpfTxt = (EditText) findViewById(R.id.cpfLogin);
        senhaTxt = (EditText) findViewById(R.id.senhaLogin);
        db = new EventosDB(this);

        //responsavel por implementar todos os eventos de botoes
        cadastroEventos();
    }

    private void cadastroEventos(){

        /* falta trabalhar com a sessão da conta do usuário logado */
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cpf = cpfTxt.getText().toString();
                String senha = senhaTxt.getText().toString();

                //checa se não tem nenhum campo em branco
                if(cpf.equals("") || senha.equals("")){
                    Toast.makeText(Login.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
                }else{

                    Boolean checkcpfsenha = db.checkCpfSenha(cpf, senha);
                    //vai checar se o cpf e a senha estão corretos
                    if (checkcpfsenha==true){
                        Toast.makeText(Login.this, "Logado com sucesso", Toast.LENGTH_SHORT).show();

                        Intent trocaAct = new Intent(Login.this, MainActivity.class);

                        //pedimos para iniciar a activity passada como parâmetro
                        startActivity(trocaAct);
                    }else{

                        Toast.makeText(Login.this, "CPF ou senha inválidos", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        // evendo do botão cadastrar: leva o usuário para uma tela de cadastro
        cadastrarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent trocaAct = new Intent(Login.this, cadastro2.class);

                //pedimos para iniciar a activity passada como parâmetro
                startActivity(trocaAct);
            }
        });

    }
}