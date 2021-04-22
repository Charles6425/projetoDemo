package controller;

import model.ModelMotivoSaida;
import DAO.DAOMotivoSaida;
import java.util.ArrayList;

/**
*
* @author Charles Müller
*/
public class ControllerMotivoSaida {

    private DAOMotivoSaida daoMotivoSaida = new DAOMotivoSaida();

    /**
    * grava MotivoSaida
    * @param pModelMotivoSaida
    * @return int
    */
    public int salvarMotivoSaidaController(ModelMotivoSaida pModelMotivoSaida){
        return this.daoMotivoSaida.salvarMotivoSaidaDAO(pModelMotivoSaida);
    }

    /**
    * recupera MotivoSaida
    * @param pId
    * @return ModelMotivoSaida
    */
    public ModelMotivoSaida getMotivoSaidaController(int pId){
        return this.daoMotivoSaida.getMotivoSaidaDAO(pId);
    }

    /**
    * recupera uma lista deMotivoSaida
    * @param pId
    * @return ArrayList
    */
    public ArrayList<ModelMotivoSaida> getListaMotivoSaidaController(){
        return this.daoMotivoSaida.getListaMotivoSaidaDAO();
    }

    /**
    * atualiza MotivoSaida
    * @param pModelMotivoSaida
    * @return boolean
    */
    public boolean atualizarMotivoSaidaController(ModelMotivoSaida pModelMotivoSaida){
        return this.daoMotivoSaida.atualizarMotivoSaidaDAO(pModelMotivoSaida);
    }

    /**
    * exclui MotivoSaida
    * @param pId
    * @return boolean
    */
    public boolean excluirMotivoSaidaController(int pId){
        return this.daoMotivoSaida.excluirMotivoSaidaDAO(pId);
    }
}