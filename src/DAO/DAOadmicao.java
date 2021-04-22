package DAO;

import model.Modeladmicao;
import conexoes.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Charles
*/
public class DAOadmicao extends ConexaoMySql {

    /**
    * grava admicao
    * @param pModeladmicao
    * return int
    */
    public int salvaradmicaoDAO(Modeladmicao pModeladmicao){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO cad_aluno ("
                    + "empresa,"
                    + "rgm,"
                    + "situacao,"
                    + "formacao_basica,"
                    + "admicao,"
                    + "recisao,"
                    + "local,"
                    + "dia_2,"
                    + "qual_curso,"
                    + "dt_cadastro,"
                    + "inicio_ppi,"
                    + "periodo,"
                    + "apresentacao_ppi,"
                    + "observacao,"
                    + "carga,"
                    + "t,"
                    + "turma,"
                    + "horario"
                + ") VALUES ("
                    + "'" + pModeladmicao.getEmpresa() + "',"
                    + "'" + pModeladmicao.getRgm() + "',"
                    + "'" + pModeladmicao.getSituacao() + "',"
                    + "'" + pModeladmicao.getFormacao_basica() + "',"
                    + "'" + pModeladmicao.getAdmicao() + "',"
                    + "'" + pModeladmicao.getRecisao() + "',"
                    + "'" + pModeladmicao.getLocal() + "',"
                    + "'" + pModeladmicao.getDia_2() + "',"
                    + "'" + pModeladmicao.getQual_curso() + "',"
                    + "'" + pModeladmicao.getDt_cadastro() + "',"
                    + "'" + pModeladmicao.getInicio_ppi() + "',"
                    + "'" + pModeladmicao.getPeriodo() + "',"
                    + "'" + pModeladmicao.getApresentacao_ppi() + "',"
                    + "'" + pModeladmicao.getObservacao() + "',"
                    + "'" + pModeladmicao.getCarga() + "',"
                    + "'" + pModeladmicao.getT() + "',"
                    + "'" + pModeladmicao.getTurma() + "',"
                    + "'" + pModeladmicao.getHorario() + "'"
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
    * recupera admicao
    * @param pEmpresa
    * return Modeladmicao
    */
    public Modeladmicao getadmicaoDAO(int pEmpresa){
        Modeladmicao modeladmicao = new Modeladmicao();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "empresa,"
                    + "rgm,"
                    + "situacao,"
                    + "formacao_basica,"
                    + "admicao,"
                    + "recisao,"
                    + "local,"
                    + "dia_2,"
                    + "qual_curso,"
                    + "dt_cadastro,"
                    + "inicio_ppi,"
                    + "periodo,"
                    + "apresentacao_ppi,"
                    + "observacao,"
                    + "carga,"
                    + "t,"
                    + "turma,"
                    + "horario"
                 + " FROM"
                     + " cad_aluno"
                 + " WHERE"
                     + " empresa = '" + pEmpresa + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modeladmicao.setEmpresa(this.getResultSet().getInt(1));
                modeladmicao.setRgm(this.getResultSet().getString(2));
                modeladmicao.setSituacao(this.getResultSet().getInt(3));
                modeladmicao.setFormacao_basica(this.getResultSet().getInt(4));
                modeladmicao.setAdmicao(this.getResultSet().getString(5));
                modeladmicao.setRecisao(this.getResultSet().getString(6));
                modeladmicao.setLocal(this.getResultSet().getInt(7));
                modeladmicao.setDia_2(this.getResultSet().getString(8));
                modeladmicao.setQual_curso(this.getResultSet().getInt(9));
                modeladmicao.setDt_cadastro(this.getResultSet().getString(10));
                modeladmicao.setInicio_ppi(this.getResultSet().getString(11));
                modeladmicao.setPeriodo(this.getResultSet().getString(12));
                modeladmicao.setApresentacao_ppi(this.getResultSet().getString(13));
                modeladmicao.setObservacao(this.getResultSet().getString(14));
                modeladmicao.setCarga(this.getResultSet().getInt(15));
                modeladmicao.setT(this.getResultSet().getInt(16));
                modeladmicao.setTurma(this.getResultSet().getInt(17));
                modeladmicao.setHorario(this.getResultSet().getInt(18));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modeladmicao;
    }

    /**
    * recupera uma lista de admicao
        * return ArrayList
    */
    public ArrayList<Modeladmicao> getListaadmicaoDAO(){
        ArrayList<Modeladmicao> listamodeladmicao = new ArrayList();
        Modeladmicao modeladmicao = new Modeladmicao();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "empresa,"
                    + "rgm,"
                    + "situacao,"
                    + "formacao_basica,"
                    + "admicao,"
                    + "recisao,"
                    + "local,"
                    + "dia_2,"
                    + "qual_curso,"
                    + "dt_cadastro,"
                    + "inicio_ppi,"
                    + "periodo,"
                    + "apresentacao_ppi,"
                    + "observacao,"
                    + "carga,"
                    + "t,"
                    + "turma,"
                    + "horario"
                 + " FROM"
                     + " cad_aluno"
                + ";"
            );

            while(this.getResultSet().next()){
                modeladmicao = new Modeladmicao();
                modeladmicao.setEmpresa(this.getResultSet().getInt(1));
                modeladmicao.setRgm(this.getResultSet().getString(2));
                modeladmicao.setSituacao(this.getResultSet().getInt(3));
                modeladmicao.setFormacao_basica(this.getResultSet().getInt(4));
                modeladmicao.setAdmicao(this.getResultSet().getString(5));
                modeladmicao.setRecisao(this.getResultSet().getString(6));
                modeladmicao.setLocal(this.getResultSet().getInt(7));
                modeladmicao.setDia_2(this.getResultSet().getString(8));
                modeladmicao.setQual_curso(this.getResultSet().getInt(9));
                modeladmicao.setDt_cadastro(this.getResultSet().getString(10));
                modeladmicao.setInicio_ppi(this.getResultSet().getString(11));
                modeladmicao.setPeriodo(this.getResultSet().getString(12));
                modeladmicao.setApresentacao_ppi(this.getResultSet().getString(13));
                modeladmicao.setObservacao(this.getResultSet().getString(14));
                modeladmicao.setCarga(this.getResultSet().getInt(15));
                modeladmicao.setT(this.getResultSet().getInt(16));
                modeladmicao.setTurma(this.getResultSet().getInt(17));
                modeladmicao.setHorario(this.getResultSet().getInt(18));
                listamodeladmicao.add(modeladmicao);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodeladmicao;
    }

    /**
    * atualiza admicao
    * @param pModeladmicao
    * return boolean
    */
    public boolean atualizaradmicaoDAO(Modeladmicao pModeladmicao){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE cad_aluno SET "
                    + "empresa = '" + pModeladmicao.getEmpresa() + "',"
                    + "rgm = '" + pModeladmicao.getRgm() + "',"
                    + "situacao = '" + pModeladmicao.getSituacao() + "',"
                    + "formacao_basica = '" + pModeladmicao.getFormacao_basica() + "',"
                    + "admicao = '" + pModeladmicao.getAdmicao() + "',"
                    + "recisao = '" + pModeladmicao.getRecisao() + "',"
                    + "local = '" + pModeladmicao.getLocal() + "',"
                    + "dia_2 = '" + pModeladmicao.getDia_2() + "',"
                    + "qual_curso = '" + pModeladmicao.getQual_curso() + "',"
                    + "dt_cadastro = '" + pModeladmicao.getDt_cadastro() + "',"
                    + "inicio_ppi = '" + pModeladmicao.getInicio_ppi() + "',"
                    + "periodo = '" + pModeladmicao.getPeriodo() + "',"
                    + "apresentacao_ppi = '" + pModeladmicao.getApresentacao_ppi() + "',"
                    + "observacao = '" + pModeladmicao.getObservacao() + "',"
                    + "carga = '" + pModeladmicao.getCarga() + "',"
                    + "t = '" + pModeladmicao.getT() + "',"
                    + "turma = '" + pModeladmicao.getTurma() + "',"
                    + "horario = '" + pModeladmicao.getHorario() + "'"
                + " WHERE "
                    + "empresa = '" + pModeladmicao.getEmpresa() + "'"
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
    * exclui admicao
    * @param pEmpresa
    * return boolean
    */
    public boolean excluiradmicaoDAO(int pEmpresa){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM cad_aluno "
                + " WHERE "
                    + "empresa = '" + pEmpresa + "'"
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