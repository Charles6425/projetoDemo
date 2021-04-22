package controller;

import model.ModelEmpresaVirtual;
import DAO.DAOEmpresaVirtual;
import java.util.ArrayList;

/**
*
* @author Charles Müller
*/
public class ControllerEmpresaVirtual {

    private DAOEmpresaVirtual daoEmpresaVirtual = new DAOEmpresaVirtual();

    /**
    * grava EmpresaVirtual
    * @param pModelEmpresaVirtual
    * @return int
    */
    public int salvarEmpresaVirtualController(ModelEmpresaVirtual pModelEmpresaVirtual){
        return this.daoEmpresaVirtual.salvarEmpresaVirtualDAO(pModelEmpresaVirtual);
    }

    /**
    * recupera EmpresaVirtual
    * @param pId
    * @return ModelEmpresaVirtual
    */
    public ModelEmpresaVirtual getEmpresaVirtualController(int pId){
        return this.daoEmpresaVirtual.getEmpresaVirtualDAO(pId);
    }

    /**
    * recupera uma lista deEmpresaVirtual
    * @param pId
    * @return ArrayList
    */
    public ArrayList<ModelEmpresaVirtual> getListaEmpresaVirtualController(){
        return this.daoEmpresaVirtual.getListaEmpresaVirtualDAO();
    }

    /**
    * atualiza EmpresaVirtual
    * @param pModelEmpresaVirtual
    * @return boolean
    */
    public boolean atualizarEmpresaVirtualController(ModelEmpresaVirtual pModelEmpresaVirtual){
        return this.daoEmpresaVirtual.atualizarEmpresaVirtualDAO(pModelEmpresaVirtual);
    }

    /**
    * exclui EmpresaVirtual
    * @param pId
    * @return boolean
    */
    public boolean excluirEmpresaVirtualController(int pId){
        return this.daoEmpresaVirtual.excluirEmpresaVirtualDAO(pId);
    }
}