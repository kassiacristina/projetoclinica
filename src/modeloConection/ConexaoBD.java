/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloConection;
import java.sql.*;



import javax.swing.JOptionPane;
/**
 *
 * @author Bruno
 */
public class ConexaoBD {
    public  Statement stm;/*realizar pesquisas no banco*/
    
    public ResultSet rs; /*armazena o resultado da pesquisa*/
    
    private String driver = "org.apache.derby.jdbc.ClientDriver";/*identifica o serviço de DB*/
    
    private  String caminho = "jdbc:derby://localhost:1527/ProjetoClinica";/*onde esta alocado o BD*/
    
    private  String usuario ="root";/*usuario do bd patrao postgress */
    
     private String senha="root";/*senha determinada no banco de dados*/
     
    public Connection con;/*variavel que faz a conecção com bd*/
    
    public void conexao(){/*metodo responsavel pela conecção com banco*/
        System.setProperty("jdbc.Drivers", driver);
        try {
            System.setProperty("jdbc.Drivers", driver);
            con=DriverManager.getConnection(caminho,usuario,senha);
          //  JOptionPane.showMessageDialog(null, "Conectado ao banco de dados ");
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ERRO AO CONECTAR COM BANCO DE DADOS\n"+ex.getMessage());
        }
    }  
    
        public void executaSql(String sql){
        try {
            stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
            rs=stm.executeQuery(sql);
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"ERRO AO CONECTAR COM BANCO DE DADOS"); 
        }
        
        }    
    
    
    public void desconecta (){try {
        /*metodo responsavel por desconectar do banco */
        con.close();
        //JOptionPane.showMessageDialog(null,"Bd desconectado com sucesso");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"erro ao fechar conecção com banco de dados \n"+ex.getMessage());
            
        }
    }
        }
        
        
