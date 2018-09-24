package com.senaijandira.funcionarios.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;


@Dao
public interface CargoDao {
    @Insert
    long inserir(com.senaijandira.funcionarios.model.Cargo cargo);

    @Update
    void atualizar(com.senaijandira.funcionarios.model.Cargo cargo);

    @Delete
    void deletar(com.senaijandira.funcionarios.model.Cargo cargo);

    @Query("SELECT * FROM cargos")
    com.senaijandira.funcionarios.model.Cargo[] selecionarTodos();
}
