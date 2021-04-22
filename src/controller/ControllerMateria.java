package controller;

import model.ModelMateria;
import DAO.DAOMateria;
import java.util.ArrayList;

/**
*
* @author Charles
*/
public class ControllerMateria {

    private DAOMateria daoMateria = new DAOMateria();

    /**
    * grava Materia
    * @param pModelMateria
    * return int
    */
    public int salvarMateriaController(ModelMateria pModelMateria){
        return this.daoMateria.salvarMateriaDAO(pModelMateria);
    }

    /**
    * recupera Materia
    * @param pId
    * return ModelMateria
    */
    public ModelMateria getMateriaController(int pId){
        return this.daoMateria.getMateriaDAO(pId);
    }

    /**
    * recupera uma lista deMateria
    * @param pId
    * return ArrayList
    */
    public ArrayList<ModelMateria> getListaMateriaController(){
        return this.daoMateria.getListaMateriaDAO();
    }

    /**
    * atualiza Materia
    * @param pModelMateria
    * return boolean
    */
    public boolean atualizarMateriaController(ModelMateria pModelMateria){
        return this.daoMateria.atualizarMateriaDAO(pModelMateria);
    }

    /**
    * exclui Materia
    * @param pId
    * return boolean
    */
    public boolean excluirMateriaController(int pId){
        return this.daoMateria.excluirMateriaDAO(pId);
    }
}