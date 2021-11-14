package com.exemplo.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class cadastro2 extends AppCompatActivity {

    private EditText nome, nomeCrianca, cpf, senha;
    private Button salvarBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro2);

        nome = (EditText) findViewById(R.id.nomeCad);
        nomeCrianca = (EditText) findViewById(R.id.nomeCriancaCad);
        cpf = (EditText) findViewById(R.id.cpfCad);
        senha = (EditText) findViewById(R.id.senhaCad);

        salvarBtn = (Button) findViewById(R.id.salvarCadBtn);

        //responsavel por implementar todos os eventos de botoes
        cadastroEventos();
    }

    private void cadastroEventos(){

        /*
        (------------------------------------------------------------------------)
        o botão salvar muda diretamente para tela inicial (MainActivity) sem
        nenhuma verificação apenas enquanto está feito só os protótipos das telas
        (------------------------------------------------------------------------) */
        salvarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent trocaAct = new Intent(cadastro2.this, MainActivity.class);

                //pedimos para iniciar a activity passada como parâmetro
                startActivity(trocaAct);
            }
        });

        /*salvarBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                EventosDB db = new EventosDB(cadastro2.this);
                db.insereEvento(novoEvento);

                Toast.makeText(cadastro2.this, db.getDatabaseName(),Toast.LENGTH_LONG).show();

            }
        });*/

        //ao clicar no botão salvar, irá inserir os dados no banco de dados
        salvarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastrarNovoEvento();
                limparCampos();
            }
        });


    }
    private void cadastrarNovoEvento(){

        String name = nome.getText().toString();
        String nameCrianca = nomeCrianca.getText().toString();
        String Cpf = cpf.getText().toString();
        String Senha = senha.getText().toString();

        if(name.equals("") || nameCrianca.equals("") || Cpf.equals("") || Senha.equals("")){
            Toast.makeText(cadastro2.this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
        }else{
            Evento novoEvento = new Evento(name, nameCrianca, Cpf, Senha);
            EventosDB bd = new EventosDB(cadastro2.this);
            bd.insereEvento(novoEvento);
        }
    }

    private void limparCampos(){
        nome.setText("");
        nomeCrianca.setText("");
        cpf.setText("");
        senha.setText("");
    }
}