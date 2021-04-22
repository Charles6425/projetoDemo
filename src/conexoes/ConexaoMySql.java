package conexoes;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Br
 */
public class ConexaoMySql {

    private boolean status = false;
    private String mensagem = "";   //variavel que vai informar o status da conexao
    private Connection con = null;  //variavel para conexao
    private Statement statement;
    private ResultSet resultSet;

    private String servidor = "localhost";
    private String nomeDoBanco = "gmz";
    private String usuario = "root";
    private String senha = "dbServer2017";

    public ConexaoMySql() {
    }

    public static PreparedStatement getPreparedStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ConexaoMySql(String pServidor, String pNomeDoBanco, String pUsuario, String pSenha) {
        this.servidor = pServidor;
        this.nomeDoBanco = pNomeDoBanco;
        this.usuario = pUsuario;
        this.senha = pSenha;
    }

    /**
     * Abre uma conexao com o banco
     *
     * @return Connection
     */
    public Connection conectar() throws SQLException {
        try {
            //Driver do Postgre
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            //local do banco, nome do banco, usuario e senha
            String url = "jdbc:mysql://" + servidor + "/" + nomeDoBanco;
            //this.setCon((Connection) DriverManager.getConnection(url, usuario, senha));            
            ConexaoXml jdbc = new ConexaoXml();
            jdbc.getProps();
            if (jdbc.getUrl() == null) {
                jdbc.setProps();
                jdbc.getProps();
            }
            this.setCon((Connection) DriverManager.getConnection(jdbc.getUrl() + "/" + jdbc.getDatabase(), jdbc.getUser(), jdbc.getPasswd()));

            //se ocorrer tudo bem, ou seja, se conectar a linha a segui é executada
            this.status = true;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return this.getCon();
    }

    /**
     * Executa consultas SQL
     *
     * @param pSQL
     * @return int
     */
    public boolean executarSQL(String pSQL) {
        try {
            //createStatement de con para criar o Statement
            this.setStatement(getCon().createStatement());

            // Definido o Statement, executamos a query no banco de dados
            this.setResultSet(getStatement().executeQuery(pSQL));

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean executarUpdateDeleteSQL(String pSQL) {
        try {

            //createStatement de con para criar o Statement
            this.setStatement(getCon().createStatement());

            // Definido o Statement, executamos a query no banco de dados
            getStatement().executeUpdate(pSQL);

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Executa insert SQL
     *
     * @param pSQL
     * @return boolean
     */
    public int insertSQL(String pSQL) {
        int status = 0;
        try {
            //createStatement de con para criar o Statement
            this.setStatement(getCon().createStatement());

            // Definido o Statement, executamos a query no banco de dados
            this.getStatement().executeUpdate(pSQL);

            //consulta o ultimo id inserido
            this.setResultSet(this.getStatement().executeQuery("SELECT last_insert_id();"));
            //recupera o ultimo id inserido
            while (this.resultSet.next()) {
                status = this.resultSet.getInt(1);
            }
            //retorna o ultimo id inserido
            return status;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return status;
        }
    }

    /**
     * encerra a conexão corrente
     *
     * @return boolean
     */
    public boolean fecharConexao() {
        try {
            if ((this.getResultSet() != null) && (this.statement != null)) {
                this.getResultSet().close();
                this.statement.close();
            }
            this.getCon().close();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return false;
    }

    /**
     * @return the status
     */
    public boolean isStatus() {
        return this.status;
    }

    /**
     * @return the mensagem
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     * @return the statement
     */
    public Statement getStatement() {
        return statement;
    }

    /**
     * @return the resultSet
     */
    public ResultSet getResultSet() {
        return resultSet;
    }

    /**
     * @param mensagem the mensagem to set
     */
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    /**
     * @return the con
     */
    public Connection getCon() {
        return con;
    }

    /**
     * @param con the con to set
     */
    public void setCon(Connection con) {
        this.con = con;
    }

    /**
     * @param statement the statement to set
     */
    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    /**
     * @param resultSet the resultSet to set
     */
    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    /**
     * @return the servidor
     */
    public String getServidor() {
        return servidor;
    }

    /**
     * @param servidor the servidor to set
     */
    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    /**
     * @return the nomeDoBanco
     */
    public String getNomeDoBanco() {
        return nomeDoBanco;
    }

    /**
     * @param nomeDoBanco the nomeDoBanco to set
     */
    public void setNomeDoBanco(String nomeDoBanco) {
        this.nomeDoBanco = nomeDoBanco;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * teste para envio de imagem
     * *****************************************************
     * *******************************************************
     * *******************************************************
     */
    private static final String banco
            = "jdbc:mysql://localhost/gmz";
    /**
     * O atributo driver representa a classe do Driver JDBC que será usada na
     * conexão. Quando se utiliza outros bancos usa-se a classe apropriada a
     * cada banco
     */
    private static final String driver
            = "com.mysql.jdbc.Driver";
    /**
     * Os atributos usuario e senha representam usuario e senha do SGBD a ser
     * usado na conexão
     */
    private static final String usuario1 = "root";
    private static final String senha1 = "dbServer2017";
    /**
     * O atributo con representa um objeto que contém a conexão com o banco de
     * dados em si
     */
    private static Connection con1 = null;

    public static Connection getConexao() {
        // primeiro testo se o objeto con não foi inicializado
        if (con1 == null) {
            try {
                // defino a classe do driver a ser usado
                Class.forName(driver);
                // criação da conexão com o BD
                con1 = DriverManager.getConnection(banco, usuario1, senha1);

            } catch (ClassNotFoundException ex) {
                System.out.println("Não encontrou o driver");
            } catch (SQLException ex) {
                System.out.println("Erro ao conectar: "
                        + ex.getMessage());
            }
        }
        return con1;
    }

    public static PreparedStatement getPreparedStatement2(String sql) {
        // testo se a conexão já foi criada
        if (con1 == null) {
            // cria a conexão
            con1 = getConexao();
        }
        try {
            // retorna um objeto java.sql.PreparedStatement
            return con1.prepareStatement(sql);
        } catch (SQLException e) {
            System.out.println("Erro de sql: "
                    + e.getMessage());
        }
        return null;
    }
}
