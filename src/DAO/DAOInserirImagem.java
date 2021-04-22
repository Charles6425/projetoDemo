/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexoes.ConexaoMySql;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import model.ModelInserirImagem;

public class DAOInserirImagem extends ConexaoMySql {

    public Boolean salvarImagemDAO(ModelInserirImagem pImagem) {
       
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "INSERT INTO imagens_perfil("
                    + " imagem,"
                    + " id_aluno"
                    + ") VALUES ("
                    + "'" +pImagem.getImagem() + "',"
                    + "'" + pImagem.getId_aluno() + "'"
                    + ");"
            );

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }

    }

    /**
     * codigo antigo para inseririmagem
     *
     * @param exemplo
     * @return
     */
    public Boolean inserir(ModelInserirImagem exemplo) throws SQLException {
        Boolean retorno = false;
        //  String sql = "INSERT INTO exemplo (imagem) values (?)";
        String sql = "INSERT INTO imagens_perfil (imagem, id_aluno) values (?,?)";
        
        //this.conectar();

        PreparedStatement pst = ConexaoMySql.getPreparedStatement2(sql);

        try {
        //    
            pst.setBytes(1, exemplo.getImagem());
            pst.setInt(2, exemplo.getId_aluno());

            pst.executeUpdate();
            retorno = true;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return retorno;
    }

    public ModelInserirImagem getImagem(int pIdAluno) {
        ModelInserirImagem modelInserirImagem = new ModelInserirImagem();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "id,"
                    + "imagem,"
                    + "id_aluno"
                    + " FROM"
                    + " imagens_perfil"
                    + " WHERE"
                    + " id_aluno = '" + pIdAluno + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelInserirImagem.setId(this.getResultSet().getInt(1));
                modelInserirImagem.setImagem(this.getResultSet().getBytes(2));
                modelInserirImagem.setId_aluno(this.getResultSet().getInt(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelInserirImagem;
    }

    /**
     * codigo antigo para buscar imagem
     *
     * @param id
     * @return
     */
    public ModelInserirImagem buscar(Integer id) {
        ModelInserirImagem retorno = null;
        String sql = "SELECT id,imagem from imagens_perfil where id_aluno=?";
        PreparedStatement pst = ConexaoMySql.getPreparedStatement2(sql);

        try {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                retorno = new ModelInserirImagem();
                retorno.setId(rs.getInt("id"));
                retorno.setImagem(rs.getBytes("imagem"));

            }

        } catch (Exception e) {
            e.printStackTrace();
            retorno = null;
        }

        return retorno;

    }

    /**
     * exclui Aluno
     *
     * @param pId return boolean
     */
    public boolean excluir(int pId) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM imagens_perfil "
                    + " WHERE "
                    + "id_aluno = '" + pId + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

}
