package controller;

import model.ModelDiaAtivTeorica;
import DAO.DAODiaAtivTeorica;
import java.util.ArrayList;

/**
*
* @author Charles Müller
*/
public class ControllerDiaAtivTeorica {

    private DAODiaAtivTeorica daoDiaAtivTeorica = new DAODiaAtivTeorica();

    /**
    * grava DiaAtivTeorica
    * @param pModelDiaAtivTeorica
    * @return int
    */
    public int salvarDiaAtivTeoricaController(ModelDiaAtivTeorica pModelDiaAtivTeorica){
        return this.daoDiaAtivTeorica.salvarDiaAtivTeoricaDAO(pModelDiaAtivTeorica);
    }

    /**
    * recupera DiaAtivTeorica
    * @param pId
    * @return ModelDiaAtivTeorica
    */
    public ModelDiaAtivTeorica getDiaAtivTeoricaController(int pId){
        return this.daoDiaAtivTeorica.getDiaAtivTeoricaDAO(pId);
    }

    /**
    * recupera uma lista deDiaAtivTeorica
    * @param pId
    * @return ArrayList
    */
    public ArrayList<ModelDiaAtivTeorica> getListaDiaAtivTeoricaController(){
        return this.daoDiaAtivTeorica.getListaDiaAtivTeoricaDAO();
    }

    /**
    * atualiza DiaAtivTeorica
    * @param pModelDiaAtivTeorica
    * @return boolean
    */
    public boolean atualizarDiaAtivTeoricaController(ModelDiaAtivTeorica pModelDiaAtivTeorica){
        return this.daoDiaAtivTeorica.atualizarDiaAtivTeoricaDAO(pModelDiaAtivTeorica);
    }

    /**
    * exclui DiaAtivTeorica
    * @param pId
    * @return boolean
    */
    public boolean excluirDiaAtivTeoricaController(int pId){
        return this.daoDiaAtivTeorica.excluirDiaAtivTeoricaDAO(pId);
    }
}