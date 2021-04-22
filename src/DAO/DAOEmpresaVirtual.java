package DAO;

import model.ModelEmpresaVirtual;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Charles Müller
*/
public class DAOEmpresaVirtual extends ConexaoMySql {

    /**
    * grava EmpresaVirtual
    * @param pModelEmpresaVirtual
    * @return int
    */
    public int salvarEmpresaVirtualDAO(ModelEmpresaVirtual pModelEmpresaVirtual){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO cad_emp_virtual ("
                    + "id,"
                    + "descricao"
                + ") VALUES ("
                    + "'" + pModelEmpresaVirtual.getId() + "',"
                    + "'" + pModelEmpresaVirtual.getDescricao() + "'"
                + ");"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * recupera EmpresaVirtual
    * @param pId
    * @return ModelEmpresaVirtual
    */
    public ModelEmpresaVirtual getEmpresaVirtualDAO(int pId){
        ModelEmpresaVirtual modelEmpresaVirtual = new ModelEmpresaVirtual();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "descricao"
                 + " FROM"
                     + " cad_emp_virtual"
                 + " WHERE"
                     + " id = '" + pId + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelEmpresaVirtual.setId(this.getResultSet().getInt(1));
                modelEmpresaVirtual.setDescricao(this.getResultSet().getString(2));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelEmpresaVirtual;
    }

    /**
    * recupera uma lista de EmpresaVirtual
        * @return ArrayList
    */
    public ArrayList<ModelEmpresaVirtual> getListaEmpresaVirtualDAO(){
        ArrayList<ModelEmpresaVirtual> listamodelEmpresaVirtual = new ArrayList();
        ModelEmpresaVirtual modelEmpresaVirtual = new ModelEmpresaVirtual();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "descricao"
                 + " FROM"
                     + " cad_emp_virtual"
                + ";"
            );

            while(this.getResultSet().next()){
                modelEmpresaVirtual = new ModelEmpresaVirtual();
                modelEmpresaVirtual.setId(this.getResultSet().getInt(1));
                modelEmpresaVirtual.setDescricao(this.getResultSet().getString(2));
                listamodelEmpresaVirtual.add(modelEmpresaVirtual);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelEmpresaVirtual;
    }

    /**
    * atualiza EmpresaVirtual
    * @param pModelEmpresaVirtual
    * @return boolean
    */
    public boolean atualizarEmpresaVirtualDAO(ModelEmpresaVirtual pModelEmpresaVirtual){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE cad_emp_virtual SET "
                    + "id = '" + pModelEmpresaVirtual.getId() + "',"
                    + "descricao = '" + pModelEmpresaVirtual.getDescricao() + "'"
                + " WHERE "
                    + "id = '" + pModelEmpresaVirtual.getId() + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * exclui EmpresaVirtual
    * @param pId
    * @return boolean
    */
    public boolean excluirEmpresaVirtualDAO(int pId){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM cad_emp_virtual "
                + " WHERE "
                    + "id = '" + pId + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }
}