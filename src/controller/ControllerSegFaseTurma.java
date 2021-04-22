package controller;

import model.ModelSegFaseTurma;
import DAO.DAOSegFaseTurma;
import java.util.ArrayList;

/**
*
* @author Charles Müller
*/
public class ControllerSegFaseTurma {

    private DAOSegFaseTurma daoSegFaseTurma = new DAOSegFaseTurma();

    /**
    * grava SegFaseTurma
    * @param pModelSegFaseTurma
    * @return int
    */
    public int salvarSegFaseTurmaController(ModelSegFaseTurma pModelSegFaseTurma){
        return this.daoSegFaseTurma.salvarSegFaseTurmaDAO(pModelSegFaseTurma);
    }

    /**
    * recupera SegFaseTurma
    * @param pId
    * @return ModelSegFaseTurma
    */
    public ModelSegFaseTurma getSegFaseTurmaController(int pId){
        return this.daoSegFaseTurma.getSegFaseTurmaDAO(pId);
    }

    /**
    * recupera uma lista deSegFaseTurma
    * @param pId
    * @return ArrayList
    */
    public ArrayList<ModelSegFaseTurma> getListaSegFaseTurmaController(){
        return this.daoSegFaseTurma.getListaSegFaseTurmaDAO();
    }

    /**
    * atualiza SegFaseTurma
    * @param pModelSegFaseTurma
    * @return boolean
    */
    public boolean atualizarSegFaseTurmaController(ModelSegFaseTurma pModelSegFaseTurma){
        return this.daoSegFaseTurma.atualizarSegFaseTurmaDAO(pModelSegFaseTurma);
    }

    /**
    * exclui SegFaseTurma
    * @param pId
    * @return boolean
    */
    public boolean excluirSegFaseTurmaController(int pId){
        return this.daoSegFaseTurma.excluirSegFaseTurmaDAO(pId);
    }
}