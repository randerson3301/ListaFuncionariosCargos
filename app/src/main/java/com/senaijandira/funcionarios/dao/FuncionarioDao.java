package com.senaijandira.funcionarios.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.senaijandira.funcionarios.viewmodel.FuncionariosCargo;


@Dao
public interface FuncionarioDao {

    @Insert
    void inserir(com.senaijandira.funcionarios.model.Funcionario func);

    @Update
    void atualizar(com.senaijandira.funcionarios.model.Funcionario func);

    @Delete
    void deletar(com.senaijandira.funcionarios.model.Funcionario func);

    @Query("SELECT * FROM funcionarios")
    com.senaijandira.funcionarios.model.Funcionario[] selecionarTodos();

    @Query("SELECT f.*,c.titulo as cargo FROM funcionarios f inner join cargos c on " +
            "f.idCargo = c.id")
    FuncionariosCargo[] selecionarFuncionarioCargo();

}
