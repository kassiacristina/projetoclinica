/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDao;

import modeloConection.ConexaoBD;
import modeloBeans.BeansMedico;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
/**
 *
 * @author Bruno
 */
public class DaoMedico {/*metodo responsavel pelo CRUD DA TABELA MEDICOS*/
 ConexaoBD conex = new ConexaoBD();/*intanciando a conexão*/
    BeansMedico mod = new BeansMedico();/*instanciando o modelo*/
 public void Salvar(BeansMedico mod ){
     conex.conexao();
     try {
         PreparedStatement pst= conex.con.prepareStatement("insert into medico(nome_medico,especialidade,crm)"
                 + "                                        values(?,?,?)  ");
         pst.setString(1, mod.getNome());
         pst.setString(2, mod.getEspecialidade());
         pst.setInt(3, mod.getCrm());
         pst.execute();
         JOptionPane.showMessageDialog(null, "Dados Inseridos Com Sucesso");
     } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, "Erro ao Inserir Dados\nErro"+ex);
     }
             
     
     
     conex.desconecta();
}
 public BeansMedico buscaM(BeansMedico mod){
     conex.conexao();
     conex.executaSql("select * from medico where nome_medico like'%"+mod.getPesquisa()+"%'");
     try {
         conex.rs.first();
         mod.setCodigo(conex.rs.getInt("id_medico"));
         mod.setNome(conex.rs.getString("nome_medico"));
         mod.setEspecialidade(conex.rs.getString("especialidade"));
         mod.setCrm(conex.rs.getInt("crm"));
         
     } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex+"Erro ao buscar medico/nErro"+ex);
     }
     
     
    conex.desconecta();
     return mod;
 }
 public void Editar(BeansMedico mod){
   conex.conexao();  
     try {
         PreparedStatement pst = conex.con.prepareStatement("update medico set nome_medico=?,especialidade=?,crm=? where id_medico = ?");
         pst.setString(1, mod.getNome());
         pst.setString(2, mod.getEspecialidade());
         pst.setInt(3,mod.getCrm());
         pst.setInt(4,mod.getCodigo());
         pst.execute();
         JOptionPane.showMessageDialog(null,"dados Alerados com sucesso");
                 
     } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null,"erro na alteração dos dados\nErro:"+ex);
     }
   
   
   
   conex.desconecta();
 
 }
 public void Excluir(BeansMedico mod){
   conex.conexao();
     try {
         PreparedStatement pst = conex.con.prepareStatement("delete from medico where id_medico =?");
         pst.setInt(1, mod.getCodigo());
         pst.execute();
          JOptionPane.showMessageDialog(null,"Registro Deletado Com Sucesso");
     } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,"Erro ao Excluir Registro /nErro"+ex);
     }
   conex.desconecta();
   
   
   
 }
 
}