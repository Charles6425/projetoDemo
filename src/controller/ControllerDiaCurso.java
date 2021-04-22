package controller;

import model.ModelDiaCurso;
import DAO.DAODiaCurso;
import java.util.ArrayList;

/**
*
* @author Charles Müller
*/
public class ControllerDiaCurso {

    private DAODiaCurso daoDiaCurso = new DAODiaCurso();

    /**
    * grava DiaCurso
    * @param pModelDiaCurso
    * @return int
    */
    public int salvarDiaCursoController(ModelDiaCurso pModelDiaCurso){
        return this.daoDiaCurso.salvarDiaCursoDAO(pModelDiaCurso);
    }

    /**
    * recupera DiaCurso
    * @param pId
    * @return ModelDiaCurso
    */
    public ModelDiaCurso getDiaCursoController(int pId){
        return this.daoDiaCurso.getDiaCursoDAO(pId);
    }

    /**
    * recupera uma lista deDiaCurso
    * @param pId
    * @return ArrayList
    */
    public ArrayList<ModelDiaCurso> getListaDiaCursoController(){
        return this.daoDiaCurso.getListaDiaCursoDAO();
    }

    /**
    * atualiza DiaCurso
    * @param pModelDiaCurso
    * @return boolean
    */
    public boolean atualizarDiaCursoController(ModelDiaCurso pModelDiaCurso){
        return this.daoDiaCurso.atualizarDiaCursoDAO(pModelDiaCurso);
    }

    /**
    * exclui DiaCurso
    * @param pId
    * @return boolean
    */
    public boolean excluirDiaCursoController(int pId){
        return this.daoDiaCurso.excluirDiaCursoDAO(pId);
    }
}