package controller;

import model.ModelCadEndereco;
import DAO.DAOCadEndereco;
import java.util.ArrayList;

/**
*
* @author Charles Müller
*/
public class ControllerCadEndereco {

    private DAOCadEndereco daoCadEndereco = new DAOCadEndereco();

    /**
    * grava CadEndereco
    * @param pModelCadEndereco
    * return int
    */
    public int salvarCadEnderecoController(ModelCadEndereco pModelCadEndereco){
        return this.daoCadEndereco.salvarCadEnderecoDAO(pModelCadEndereco);
    }

    /**
    * recupera CadEndereco
    * @param pEnd_cep
    * return ModelCadEndereco
    */
    public ModelCadEndereco getCadEnderecoController(String pEnd_cep){
        return this.daoCadEndereco.getCadEnderecoDAO(pEnd_cep);
    }
    /**
    * recupera CadEndereco
    * @param pEnd_cep
    * return ModelCadEndereco
    */
    public ModelCadEndereco getCadEnderecoCodController(int pEnd_codigo){
        return this.daoCadEndereco.getCadEnderecoCodDAO(pEnd_codigo);
    }

    /**
    * recupera uma lista deCadEndereco
    * @param pEnd_cep
    * return ArrayList
    */
    public ArrayList<ModelCadEndereco> getListaCadEnderecoController(String pCep){
        return this.daoCadEndereco.getListaCadEnderecoDAO(pCep);
    }
    /**
    * recupera uma lista deCadEndereco
    * @param pEnd_cep
    * return ArrayList
    */
    public ArrayList<ModelCadEndereco> getListaCadBairroController(String pBairro){
        return this.daoCadEndereco.getListaCadBairroDAO(pBairro);
    }
    /**
    * recupera uma lista deCadEndereco
    * @param pEnd_cep
    * return ArrayList
    */
    public ArrayList<ModelCadEndereco> getListaCadEnderecoController(){
        return this.daoCadEndereco.getListaCadEnderecoDAO();
    }


    /**
    * atualiza CadEndereco
    * @param pModelCadEndereco
    * return boolean
    */
    public boolean atualizarCadEnderecoController(ModelCadEndereco pModelCadEndereco){
        return this.daoCadEndereco.atualizarCadEnderecoDAO(pModelCadEndereco);
    }

    /**
    * exclui CadEndereco
    * @param pEnd_cep
    * return boolean
    */
    public boolean excluirCadEnderecoController(String pEnd_cep){
        return this.daoCadEndereco.excluirCadEnderecoDAO(pEnd_cep);
    }
}