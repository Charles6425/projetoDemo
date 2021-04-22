package controller;

import model.ModelHorario;
import DAO.DAOHorario;
import java.util.ArrayList;

/**
*
* @author Charles
*/
public class ControllerHorario {

    private DAOHorario daoHorario = new DAOHorario();

    /**
    * grava Horario
    * @param pModelHorario
    * return int
    */
    public int salvarHorarioController(ModelHorario pModelHorario){
        return this.daoHorario.salvarHorarioDAO(pModelHorario);
    }

    /**
    * recupera Horario
    * @param pId
    * return ModelHorario
    */
    public ModelHorario getHorarioController(int pId){
        return this.daoHorario.getHorarioDAO(pId);
    }

    /**
    * recupera uma lista deHorario
    * @param pId
    * return ArrayList
    */
    public ArrayList<ModelHorario> getListaHorarioController(){
        return this.daoHorario.getListaHorarioDAO();
    }

    /**
    * atualiza Horario
    * @param pModelHorario
    * return boolean
    */
    public boolean atualizarHorarioController(ModelHorario pModelHorario){
        return this.daoHorario.atualizarHorarioDAO(pModelHorario);
    }

    /**
    * exclui Horario
    * @param pId
    * return boolean
    */
    public boolean excluirHorarioController(int pId){
        return this.daoHorario.excluirHorarioDAO(pId);
    }
}