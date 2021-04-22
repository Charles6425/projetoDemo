package controller;

import model.Modeladmicao;
import DAO.DAOadmicao;
import java.util.ArrayList;

/**
*
* @author Charles
*/
public class Controlleradmicao {

    private DAOadmicao daoadmicao = new DAOadmicao();

    /**
    * grava admicao
    * @param pModeladmicao
    * return int
    */
    public int salvaradmicaoController(Modeladmicao pModeladmicao){
        return this.daoadmicao.salvaradmicaoDAO(pModeladmicao);
    }

    /**
    * recupera admicao
    * @param pEmpresa
    * return Modeladmicao
    */
    public Modeladmicao getadmicaoController(int pEmpresa){
        return this.daoadmicao.getadmicaoDAO(pEmpresa);
    }

    /**
    * recupera uma lista deadmicao
    * @param pEmpresa
    * return ArrayList
    */
    public ArrayList<Modeladmicao> getListaadmicaoController(){
        return this.daoadmicao.getListaadmicaoDAO();
    }

    /**
    * atualiza admicao
    * @param pModeladmicao
    * return boolean
    */
    public boolean atualizaradmicaoController(Modeladmicao pModeladmicao){
        return this.daoadmicao.atualizaradmicaoDAO(pModeladmicao);
    }

    /**
    * exclui admicao
    * @param pEmpresa
    * return boolean
    */
    public boolean excluiradmicaoController(int pEmpresa){
        return this.daoadmicao.excluiradmicaoDAO(pEmpresa);
    }
}