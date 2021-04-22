/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexoes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author charles
 */
public class ConexaoXml {

    private String user;
    private String passwd;
    private String url;
    private String database;
    private String timeZone;
//Criar getters e setters

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the passwd
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     * @param passwd the passwd to set
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the database
     */
    public String getDatabase() {
        return database;
    }

    /**
     * @param database the database to set
     */
    public void setDatabase(String database) {
        this.database = database;
    }

    public void setProps() {
        Properties props = new Properties();
////jdbc:mysql://localhost:3306/Peoples?autoReconnect=true&useSSL=false
        props.setProperty("jdbc.user", "sistema");
        props.setProperty("jdbc.passwd", "dbServer2017");
        props.setProperty("jdbc.url", "jdbc:mysql://localhost");
        props.setProperty("jdbc.dataBase", "gmz");
        props.setProperty("jdbc.timeZone", "useSSL=false&serverTimezone;=UTC");

        try {
            FileOutputStream fos = new FileOutputStream("config.xml");
            props.storeToXML(fos, "FILE JDBC PROPERTIES:", "ISO-8859-1");
            fos.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    public void getProps (){
    Properties props = new Properties();
 
    try {
        //Setamos o arquivo que ser� lido
        FileInputStream fis = new FileInputStream("config.xml");
        //m�todo load faz a leitura atrav�s do objeto fis
        props.loadFromXML(fis);
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }
    //Captura o valor da propriedade, atrav�s do nome da propriedade(Key)
    this.setUser(props.getProperty("jdbc.user"));
    this.setPasswd(props.getProperty("jdbc.passwd"));
    this.setUrl(props.getProperty("jdbc.url"));
    this.setDatabase(props.getProperty("jdbc.dataBase"));
    this.setTimeZone(props.getProperty("jdbc.timeZone"));
 
}

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }
}
