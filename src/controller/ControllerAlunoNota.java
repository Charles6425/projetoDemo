package controller;

import model.ModelAlunoNota;
import DAO.DAOAlunoNota;
import java.util.ArrayList;

/**
*
* @author Charles
*/
public class ControllerAlunoNota {

    private DAOAlunoNota daoAlunoNota = new DAOAlunoNota();

    /**
    * grava AlunoNota
    * @param pModelAlunoNota
    * return int
    */
    public int salvarAlunoNotaController(ModelAlunoNota pModelAlunoNota){
        return this.daoAlunoNota.salvarAlunoNotaDAO(pModelAlunoNota);
    }

    /**
    * recupera AlunoNota
    * @param pId
    * return ModelAlunoNota
    */
    public ModelAlunoNota getAlunoNotaController(int pId){
        return this.daoAlunoNota.getAlunoNotaDAO(pId);
    }

    /**
    * recupera uma lista deAlunoNota
    * @param pId
    * return ArrayList
    */
    public ArrayList<ModelAlunoNota> getListaAlunoNotaController(){
        return this.daoAlunoNota.getListaAlunoNotaDAO();
    }
    /**
    * recupera uma lista deAlunoNota
    * @param pId
    * return ArrayList
    */
    public ArrayList<ModelAlunoNota> getListaAlunoNotaCodController(int pCod){
        return this.daoAlunoNota.getListaAlunoNotaCodDAO(pCod);
    }
    /**
    * recupera uma lista deAlunoNota
    * @param pId
    * return ArrayList
    */
    public ArrayList<ModelAlunoNota> getListaAlunoNotaRGMController(String pRGM){
        return this.daoAlunoNota.getListaAlunoNotaRGMDAO(pRGM);
    }

    /**
    * atualiza AlunoNota
    * @param pModelAlunoNota
    * return boolean
    */
    public boolean atualizarAlunoNotaController(ModelAlunoNota pModelAlunoNota){
        return this.daoAlunoNota.atualizarAlunoNotaDAO(pModelAlunoNota);
    }

    /**
    * exclui AlunoNota
    * @param pId
    * return boolean
    */
    public boolean excluirAlunoNotaController(int pId){
        return this.daoAlunoNota.excluirAlunoNotaDAO(pId);
    }
}