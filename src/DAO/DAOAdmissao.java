package DAO;

import model.ModelAdmissao;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Charles Müller
*/
public class DAOAdmissao extends ConexaoMySql {

    /**
    * grava Admissao
    * @param pModelAdmissao
    * @return int
    */
    public int salvarAdmissaoDAO(ModelAdmissao pModelAdmissao){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO admissao ("
                    + "id,"
                    + "empresa,"
                    + "aprendiz,"
                    + "horario,"
                    + "inicio,"
                    + "termino,"
                    + "cbo,"
                    + "tipo_admissao,"
                    + "salario,"
                    + "curso,"
                    + "convenio_odont,"
                    + "desconto_vt,"
                    + "insalubre,"
                    + "insalubre_percentual"
                + ") VALUES ("
                    + "'" + pModelAdmissao.getId() + "',"
                    + "'" + pModelAdmissao.getEmpresa() + "',"
                    + "'" + pModelAdmissao.getAprendiz() + "',"
                    + "'" + pModelAdmissao.getHorario() + "',"
                    + "'" + pModelAdmissao.getInicio() + "',"
                    + "'" + pModelAdmissao.getTermino() + "',"
                    + "'" + pModelAdmissao.getCbo() + "',"
                    + "'" + pModelAdmissao.getTipo_admissao() + "',"
                    + "'" + pModelAdmissao.getSalario() + "',"
                    + "'" + pModelAdmissao.getCurso() + "',"
                    + "'" + pModelAdmissao.getConvenio_odont() + "',"
                    + "'" + pModelAdmissao.getDesconto_vt() + "',"
                    + "'" + pModelAdmissao.getInsalubre() + "',"
                    + "'" + pModelAdmissao.getInsalubre_percentual() + "'"
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
    * recupera Admissao
    * @param pId
    * @return ModelAdmissao
    */
    public ModelAdmissao getAdmissaoDAO(int pId){
        ModelAdmissao modelAdmissao = new ModelAdmissao();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "empresa,"
                    + "aprendiz,"
                    + "horario,"
                    + "inicio,"
                    + "termino,"
                    + "cbo,"
                    + "tipo_admissao,"
                    + "salario,"
                    + "curso,"
                    + "convenio_odont,"
                    + "desconto_vt,"
                    + "insalubre,"
                    + "insalubre_percentual"
                 + " FROM"
                     + " admissao"
                 + " WHERE"
                     + " aprendiz = '" + pId + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelAdmissao.setId(this.getResultSet().getInt(1));
                modelAdmissao.setEmpresa(this.getResultSet().getInt(2));
                modelAdmissao.setAprendiz(this.getResultSet().getInt(3));
                modelAdmissao.setHorario(this.getResultSet().getString(4));
                modelAdmissao.setInicio(this.getResultSet().getString(5));
                modelAdmissao.setTermino(this.getResultSet().getString(6));
                modelAdmissao.setCbo(this.getResultSet().getInt(7));
                modelAdmissao.setTipo_admissao(this.getResultSet().getInt(8));
                modelAdmissao.setSalario(this.getResultSet().getFloat(9));
                modelAdmissao.setCurso(this.getResultSet().getInt (10));
                modelAdmissao.setConvenio_odont(this.getResultSet().getInt(11));
                modelAdmissao.setDesconto_vt(this.getResultSet().getInt(12));
                modelAdmissao.setInsalubre(this.getResultSet().getInt(13));
                modelAdmissao.setInsalubre_percentual(this.getResultSet().getFloat(14));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelAdmissao;
    }

    /**
    * recupera uma lista de Admissao
        * @return ArrayList
    */
    public ArrayList<ModelAdmissao> getListaAdmissaoDAO(){
        ArrayList<ModelAdmissao> listamodelAdmissao = new ArrayList();
        ModelAdmissao modelAdmissao = new ModelAdmissao();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id,"
                    + "empresa,"
                    + "aprendiz,"
                    + "horario,"
                    + "inicio,"
                    + "termino,"
                    + "cbo,"
                    + "tipo_admissao,"
                    + "salario,"
                    + "curso,"
                    + "convenio_odont,"
                    + "desconto_vt,"
                    + "insalubre,"
                    + "insalubre_percentual"
                 + " FROM"
                     + " admissao"
                + ";"
            );

            while(this.getResultSet().next()){
                modelAdmissao = new ModelAdmissao();
                modelAdmissao.setId(this.getResultSet().getInt(1));
                modelAdmissao.setEmpresa(this.getResultSet().getInt(2));
                modelAdmissao.setAprendiz(this.getResultSet().getInt(3));
                modelAdmissao.setHorario(this.getResultSet().getString(4));
                modelAdmissao.setInicio(this.getResultSet().getString(5));
                modelAdmissao.setTermino(this.getResultSet().getString(6));
                modelAdmissao.setCbo(this.getResultSet().getInt(7));
                modelAdmissao.setTipo_admissao(this.getResultSet().getInt(8));
                modelAdmissao.setSalario(this.getResultSet().getFloat(9));
                modelAdmissao.setCurso(this.getResultSet().getInt (10));
                modelAdmissao.setConvenio_odont(this.getResultSet().getInt(11));
                modelAdmissao.setDesconto_vt(this.getResultSet().getInt(12));
                modelAdmissao.setInsalubre(this.getResultSet().getInt(13));
                modelAdmissao.setInsalubre_percentual(this.getResultSet().getFloat(14));
                listamodelAdmissao.add(modelAdmissao);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelAdmissao;
    }

    /**
    * atualiza Admissao
    * @param pModelAdmissao
    * @return boolean
    */
    public boolean atualizarAdmissaoDAO(ModelAdmissao pModelAdmissao){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE admissao SET "
                    + "id = '" + pModelAdmissao.getId() + "',"
                    + "empresa = '" + pModelAdmissao.getEmpresa() + "',"
                    + "aprendiz = '" + pModelAdmissao.getAprendiz() + "',"
                    + "horario = '" + pModelAdmissao.getHorario() + "',"
                    + "inicio = '" + pModelAdmissao.getInicio() + "',"
                    + "termino = '" + pModelAdmissao.getTermino() + "',"
                    + "cbo = '" + pModelAdmissao.getCbo() + "',"
                    + "tipo_admissao = '" + pModelAdmissao.getTipo_admissao() + "',"
                    + "salario = '" + pModelAdmissao.getSalario() + "',"
                    + "curso = '" + pModelAdmissao.getCurso() + "',"
                    + "convenio_odont = '" + pModelAdmissao.getConvenio_odont() + "',"
                    + "desconto_vt = '" + pModelAdmissao.getDesconto_vt() + "',"
                    + "insalubre = '" + pModelAdmissao.getInsalubre() + "',"
                    + "insalubre_percentual = '" + pModelAdmissao.getInsalubre_percentual() + "'"
                + " WHERE "
                    + "id = '" + pModelAdmissao.getId() + "'"
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
    * exclui Admissao
    * @param pId
    * @return boolean
    */
    public boolean excluirAdmissaoDAO(int pId){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM admissao "
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