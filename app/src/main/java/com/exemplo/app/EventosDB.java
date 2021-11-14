package com.exemplo.app;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class EventosDB extends SQLiteOpenHelper {

    private Context contexto;

    public EventosDB(Context cont){
        super(cont, "evento", null, 1);
        contexto = cont;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        final String criaTabela = "CREATE TABLE IF NOT EXISTS evento(id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, " +
                "nomeCrianca TEXT, cpf TEXT, senha TEXT)";

        db.execSQL(criaTabela);


    }

    public void insereEvento(Evento novoEvento){

        try(SQLiteDatabase db = this.getWritableDatabase()) {
            String nome = novoEvento.getNome();
            String nomeCrianca = novoEvento.getNomeCrianca();
            String cpf = novoEvento.getCpf();
            String senha = novoEvento.getSenha();
            String sql = "INSERT into evento (nome, nomeCrianca, cpf, senha) VALUES ('"+nome+"', '"+nomeCrianca+
                    "', '"+cpf+"', '"+senha+"')";

            db.execSQL(sql);

        }catch (SQLiteException ex){
            ex.printStackTrace();
        }

    }

    public void atuaizaEvento(){

    }

    //função para verificar se já existe esse cpf cadastrado
    //não está em uso ainda
    public Boolean checkCpf(String cpf){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM evento WHERE cpf = ?", new String[] {cpf});
        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }

    //checa se cpf e senha estão corretos
    public Boolean checkCpfSenha(String cpf, String senha){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM evento WHERE cpf = ? and senha = ?", new String[] {cpf, senha});
        if(cursor.getCount()>0){
            return true;
        }else{
            return false;
        }
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
