package controller;

import model.ModelBucarImagem;
import DAO.DAOBucarImagem;
import java.util.ArrayList;

/**
*
* @author Charles
*/
public class ControllerBucarImagem {

    private DAOBucarImagem daoBucarImagem = new DAOBucarImagem();

    /**
    * grava BucarImagem
    * @param pModelBucarImagem
    * return int
    */
    public int salvarBucarImagemController(ModelBucarImagem pModelBucarImagem){
        return this.daoBucarImagem.salvarBucarImagemDAO(pModelBucarImagem);
    }

    /**
    * recupera BucarImagem
    * @param pId
    * return ModelBucarImagem
    */
    public ModelBucarImagem getBucarImagemController(int pId){
        return this.daoBucarImagem.getBucarImagemDAO(pId);
    }

    /**
    * recupera uma lista deBucarImagem
    * @param pId
    * return ArrayList
    */
    public ArrayList<ModelBucarImagem> getListaBucarImagemController(){
        return this.daoBucarImagem.getListaBucarImagemDAO();
    }

    /**
    * atualiza BucarImagem
    * @param pModelBucarImagem
    * return boolean
    */
    public boolean atualizarBucarImagemController(ModelBucarImagem pModelBucarImagem){
        return this.daoBucarImagem.atualizarBucarImagemDAO(pModelBucarImagem);
    }

    /**
    * exclui BucarImagem
    * @param pId
    * return boolean
    */
    public boolean excluirBucarImagemController(int pId){
        return this.daoBucarImagem.excluirBucarImagemDAO(pId);
    }
}