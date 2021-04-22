package controller;

import model.ModelHorasTrabalhadas;
import DAO.DAOHorasTrabalhadas;
import java.util.ArrayList;

/**
*
* @author Charles Müller
*/
public class ControllerHorasTrabalhadas {

    private DAOHorasTrabalhadas daoHorasTrabalhadas = new DAOHorasTrabalhadas();

    /**
    * grava HorasTrabalhadas
    * @param pModelHorasTrabalhadas
    * @return int
    */
    public int salvarHorasTrabalhadasController(ModelHorasTrabalhadas pModelHorasTrabalhadas){
        return this.daoHorasTrabalhadas.salvarHorasTrabalhadasDAO(pModelHorasTrabalhadas);
    }

    /**
    * recupera HorasTrabalhadas
    * @param pId
    * @return ModelHorasTrabalhadas
    */
    public ModelHorasTrabalhadas getHorasTrabalhadasController(int pId){
        return this.daoHorasTrabalhadas.getHorasTrabalhadasDAO(pId);
    }

    /**
    * recupera uma lista deHorasTrabalhadas
    * @param pId
    * @return ArrayList
    */
    public ArrayList<ModelHorasTrabalhadas> getListaHorasTrabalhadasController(){
        return this.daoHorasTrabalhadas.getListaHorasTrabalhadasDAO();
    }

    /**
    * atualiza HorasTrabalhadas
    * @param pModelHorasTrabalhadas
    * @return boolean
    */
    public boolean atualizarHorasTrabalhadasController(ModelHorasTrabalhadas pModelHorasTrabalhadas){
        return this.daoHorasTrabalhadas.atualizarHorasTrabalhadasDAO(pModelHorasTrabalhadas);
    }

    /**
    * exclui HorasTrabalhadas
    * @param pId
    * @return boolean
    */
    public boolean excluirHorasTrabalhadasController(int pId){
        return this.daoHorasTrabalhadas.excluirHorasTrabalhadasDAO(pId);
    }
}