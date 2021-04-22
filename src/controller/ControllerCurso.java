package controller;

import model.ModelCurso;
import DAO.DAOCurso;
import java.util.ArrayList;

/**
*
* @author Charles Müller
*/
public class ControllerCurso {

    private DAOCurso daoCurso = new DAOCurso();

    /**
    * grava Curso
    * @param pModelCurso
    * @return int
    */
    public int salvarCursoController(ModelCurso pModelCurso){
        return this.daoCurso.salvarCursoDAO(pModelCurso);
    }

    /**
    * recupera Curso
    * @param pId
    * @return ModelCurso
    */
    public ModelCurso getCursoController(int pId){
        return this.daoCurso.getCursoDAO(pId);
    }

    /**
    * recupera uma lista deCurso
    * @param pId
    * @return ArrayList
    */
    public ArrayList<ModelCurso> getListaCursoController(){
        return this.daoCurso.getListaCursoDAO();
    }

    /**
    * atualiza Curso
    * @param pModelCurso
    * @return boolean
    */
    public boolean atualizarCursoController(ModelCurso pModelCurso){
        return this.daoCurso.atualizarCursoDAO(pModelCurso);
    }

    /**
    * exclui Curso
    * @param pId
    * @return boolean
    */
    public boolean excluirCursoController(int pId){
        return this.daoCurso.excluirCursoDAO(pId);
    }
}