package controller;

import model.ModelOrigemAluno;
import DAO.DAOOrigemAluno;
import java.util.ArrayList;

/**
*
* @author Charles Müller
*/
public class ControllerOrigemAluno {

    private DAOOrigemAluno daoOrigemAluno = new DAOOrigemAluno();

    /**
    * grava OrigemAluno
    * @param pModelOrigemAluno
    * @return int
    */
    public int salvarOrigemAlunoController(ModelOrigemAluno pModelOrigemAluno){
        return this.daoOrigemAluno.salvarOrigemAlunoDAO(pModelOrigemAluno);
    }

    /**
    * recupera OrigemAluno
    * @param pId
    * @return ModelOrigemAluno
    */
    public ModelOrigemAluno getOrigemAlunoController(int pId){
        return this.daoOrigemAluno.getOrigemAlunoDAO(pId);
    }

    /**
    * recupera uma lista deOrigemAluno
    * @param pId
    * @return ArrayList
    */
    public ArrayList<ModelOrigemAluno> getListaOrigemAlunoController(){
        return this.daoOrigemAluno.getListaOrigemAlunoDAO();
    }

    /**
    * atualiza OrigemAluno
    * @param pModelOrigemAluno
    * @return boolean
    */
    public boolean atualizarOrigemAlunoController(ModelOrigemAluno pModelOrigemAluno){
        return this.daoOrigemAluno.atualizarOrigemAlunoDAO(pModelOrigemAluno);
    }

    /**
    * exclui OrigemAluno
    * @param pId
    * @return boolean
    */
    public boolean excluirOrigemAlunoController(int pId){
        return this.daoOrigemAluno.excluirOrigemAlunoDAO(pId);
    }
}