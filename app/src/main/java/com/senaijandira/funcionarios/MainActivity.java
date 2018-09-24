package com.senaijandira.funcionarios;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.senaijandira.funcionarios.db.AppDatabase;
import com.senaijandira.funcionarios.model.Cargo;
import com.senaijandira.funcionarios.model.Funcionario;
import com.senaijandira.funcionarios.viewmodel.FuncionariosCargo;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ListView lstViewFuncionarios;

    FuncionariosAdapter adapter;

    //variavel do banco de dados
    AppDatabase appDb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instanciando o banco de dados
        appDb = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "funcionarios.db")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();

        lstViewFuncionarios = findViewById(R.id.lstViewFuncionarios);

        //instanciando adapter
        adapter = new FuncionariosAdapter(this);
        lstViewFuncionarios.setAdapter(adapter);

        //carregarFuncionarios();
    }

    public void inserirDados(View v){

        long idAnalista = appDb.daoCargo().inserir(new Cargo("Analista"));
        long idGer = appDb.daoCargo().inserir(new Cargo("Gerente"));

        //Fakes
        Funcionario f1 = new Funcionario("Joesley", (int)idAnalista);
        Funcionario f2 = new Funcionario("Jovi", (int) idGer);
        Funcionario f3 = new Funcionario("Richard", (int)idGer);
        Funcionario f4 = new Funcionario("Linus", (int)idAnalista);

        appDb.daoFuncionario().inserir(f1);
        appDb.daoFuncionario().inserir(f2);
        appDb.daoFuncionario().inserir(f3);
        appDb.daoFuncionario().inserir(f4);
    }

    public void carregarFuncionarios(View v){

        FuncionariosCargo[] funcionarios = appDb.daoFuncionario().selecionarFuncionarioCargo();

        //preenchendo o array de funcionarios
        adapter.addAll(funcionarios);
    }

    private class FuncionariosAdapter extends ArrayAdapter<FuncionariosCargo>{
        public FuncionariosAdapter(Context ctx) {
            super(ctx, 0, new ArrayList<FuncionariosCargo>());
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View v = convertView;

            if(v == null) {
                v = LayoutInflater.from(getContext()).inflate(R.layout.list_item_funcionario,
                        parent, false);
            }

            FuncionariosCargo func = getItem(position);

            TextView txtNomeFunc = v.findViewById(R.id.txtNomeFuncionario);
            TextView txtCargo = v.findViewById(R.id.txtTituloCargo);

            txtNomeFunc.setText(func.getFuncionario().getNome());
            txtCargo.setText(func.getCargo());

            return v;
        }
    }
}
