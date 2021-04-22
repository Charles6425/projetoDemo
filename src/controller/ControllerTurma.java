package controller;

import model.ModelTurma;
import DAO.DAOTurma;
import java.util.ArrayList;

/**
*
* @author Charles Müller
*/
public class ControllerTurma {

    private DAOTurma daoTurma = new DAOTurma();

    /**
    * grava Turma
    * @param pModelTurma
    * @return int
    */
    public int salvarTurmaController(ModelTurma pModelTurma){
        return this.daoTurma.salvarTurmaDAO(pModelTurma);
    }

    /**
    * recupera Turma
    * @param pId
    * @return ModelTurma
    */
    public ModelTurma getTurmaController(int pId){
        return this.daoTurma.getTurmaDAO(pId);
    }

    /**
    * recupera uma lista deTurma
    * @param pId
    * @return ArrayList
    */
    public ArrayList<ModelTurma> getListaTurmaController(){
        return this.daoTurma.getListaTurmaDAO();
    }

    /**
    * atualiza Turma
    * @param pModelTurma
    * @return boolean
    */
    public boolean atualizarTurmaController(ModelTurma pModelTurma){
        return this.daoTurma.atualizarTurmaDAO(pModelTurma);
    }

    /**
    * exclui Turma
    * @param pId
    * @return boolean
    */
    public boolean excluirTurmaController(int pId){
        return this.daoTurma.excluirTurmaDAO(pId);
    }
}