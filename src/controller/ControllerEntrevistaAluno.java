package controller;

import model.ModelEntrevistaAluno;
import DAO.DAOEntrevistaAluno;
import java.util.ArrayList;

/**
*
* @author Charles
*/
public class ControllerEntrevistaAluno {

    private DAOEntrevistaAluno daoEntrevistaAluno = new DAOEntrevistaAluno();

    /**
    * grava EntrevistaAluno
    * @param pModelEntrevistaAluno
    * return int
    */
    public int salvarEntrevistaAlunoController(ModelEntrevistaAluno pModelEntrevistaAluno){
        return this.daoEntrevistaAluno.salvarEntrevistaAlunoDAO(pModelEntrevistaAluno);
    }

    /**
    * recupera EntrevistaAluno
    * @param pId
    * return ModelEntrevistaAluno
    */
    public ModelEntrevistaAluno getEntrevistaAlunoController(int pId){
        return this.daoEntrevistaAluno.getEntrevistaAlunoDAO(pId);
    }

    /**
    * recupera uma lista deEntrevistaAluno
    * @param pId
    * return ArrayList
    */
    public ArrayList<ModelEntrevistaAluno> getListaEntrevistaAlunoController(){
        return this.daoEntrevistaAluno.getListaEntrevistaAlunoDAO();
    }
    /**
    * recupera uma lista deEntrevistaAluno
    * @param pId
    * return ArrayList
    */
    public ArrayList<ModelEntrevistaAluno> getListaEntrevistaAlunoController(int pCodAluno){
        return this.daoEntrevistaAluno.getListaEntrevistaAlunoDAO(pCodAluno);
    }

    /**
    * atualiza EntrevistaAluno
    * @param pModelEntrevistaAluno
    * return boolean
    */
    public boolean atualizarEntrevistaAlunoController(ModelEntrevistaAluno pModelEntrevistaAluno){
        return this.daoEntrevistaAluno.atualizarEntrevistaAlunoDAO(pModelEntrevistaAluno);
    }

    /**
    * exclui EntrevistaAluno
    * @param pId
    * return boolean
    */
    public boolean excluirEntrevistaAlunoController(int pId){
        return this.daoEntrevistaAluno.excluirEntrevistaAlunoDAO(pId);
    }
}