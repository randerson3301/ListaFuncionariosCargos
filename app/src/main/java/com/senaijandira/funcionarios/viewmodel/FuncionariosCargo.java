package com.senaijandira.funcionarios.viewmodel;

import android.arch.persistence.room.Embedded;

import com.senaijandira.funcionarios.model.Funcionario;


public class FuncionariosCargo {
    //pega os dados da tabela, e insere na variável
    @Embedded
    private Funcionario funcionario;
    private String cargo;



    //encapsulamento
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
