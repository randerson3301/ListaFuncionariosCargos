package com.senaijandira.funcionarios.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;


@Database(entities = {com.senaijandira.funcionarios.model.Funcionario.class, com.senaijandira.funcionarios.model.Cargo.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract com.senaijandira.funcionarios.dao.FuncionarioDao daoFuncionario();
    public abstract com.senaijandira.funcionarios.dao.CargoDao daoCargo();

}
