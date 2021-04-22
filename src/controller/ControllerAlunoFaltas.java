package controller;

import model.ModelAlunoFaltas;
import DAO.DAOAlunoFaltas;
import java.util.ArrayList;

/**
*
* @author Charles Müller
*/
public class ControllerAlunoFaltas {

    private DAOAlunoFaltas daoAlunoFaltas = new DAOAlunoFaltas();

    /**
    * grava AlunoFaltas
    * @param pModelAlunoFaltas
    * @return int
    */
    public int salvarAlunoFaltasController(ModelAlunoFaltas pModelAlunoFaltas){
        return this.daoAlunoFaltas.salvarAlunoFaltasDAO(pModelAlunoFaltas);
    }

    /**
    * recupera AlunoFaltas
    * @param pId
    * @return ModelAlunoFaltas
    */
    public ModelAlunoFaltas getAlunoFaltasController(int pId){
        return this.daoAlunoFaltas.getAlunoFaltasDAO(pId);
    }

    /**
    * recupera uma lista deAlunoFaltas
    * @param pId
    * @return ArrayList
    */
    public ArrayList<ModelAlunoFaltas> getListaAlunoFaltasController(){
        return this.daoAlunoFaltas.getListaAlunoFaltasDAO();
    }

    /**
    * atualiza AlunoFaltas
    * @param pModelAlunoFaltas
    * @return boolean
    */
    public boolean atualizarAlunoFaltasController(ModelAlunoFaltas pModelAlunoFaltas){
        return this.daoAlunoFaltas.atualizarAlunoFaltasDAO(pModelAlunoFaltas);
    }

    /**
    * exclui AlunoFaltas
    * @param pId
    * @return boolean
    */
    public boolean excluirAlunoFaltasController(int pId){
        return this.daoAlunoFaltas.excluirAlunoFaltasDAO(pId);
    }
}