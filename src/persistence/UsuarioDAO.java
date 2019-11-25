
package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import modelo.Usuario;

public class UsuarioDAO {
    
    private final Conexao con = new Conexao();
    
    private final String INSERTUSUARIO = "INSERT INTO TRABALHO (nome, altura, peso, idade, novaconsulta) VALUES (?,?,?,?,?)";
    private final String UPDATEPESO = "UPDATE TRABALHO SET peso = ? WHERE nome = ?";
    private final String UPDATEALTURA = "UPDATE TRABALHO SET altura = ? WHERE nome = ?";
    private final String DELETEUSUARIO = "DELETE FROM TRABALHO WHERE nome = ?";
    
    private final String UPDATECONSULTA = "UPDATE TRABALHO SET novaconsulta = ? WHERE nome =?";
    private final String UPDATEANTIGACONSULTA = "UPDATE TRABALHO SET antigaconsulta = novaconsulta WHERE nome = ?";
    
    
    public boolean insertUsuario(Usuario u){
        try{
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(INSERTUSUARIO);
            
            preparaInstrucao.setString(1, u.getNome().toUpperCase());
            preparaInstrucao.setDouble(2, u.getAltura());
            preparaInstrucao.setDouble(3, u.getPeso());
            preparaInstrucao.setInt(4, u.getIdade());
            preparaInstrucao.setDouble(6, u.calcularIMC(u.getPeso(), u.getAltura()));
            
            preparaInstrucao.execute();
            
            con.desconecta();
            
            return true;
            
        } catch (SQLException e){
            return false;
        }
    }
    
    
    public boolean updatePeso(Usuario u){
    
        try{
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(UPDATEPESO);
            
            preparaInstrucao.setDouble(1, u.getPeso());
            preparaInstrucao.setString(2, u.getNome().toUpperCase());
            
            preparaInstrucao.execute();
            
            con.desconecta();
            
            return true;
        } 
        catch(SQLException e){
            return false;
        }
 
    }
    
    public boolean updateAltura(Usuario u){
        try{
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(UPDATEALTURA);
            
            preparaInstrucao.setDouble(1, u.getPeso());
            preparaInstrucao.setString(2, u.getNome().toUpperCase());
            
            preparaInstrucao.execute();
            
            con.desconecta();
            
            return true;
        }
        catch (SQLException e){
            return false;
        }
    
    }
    
    public boolean deleteUsuario(Usuario u){
        try{
            
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(DELETEUSUARIO);
            
            preparaInstrucao.setString(1, u.getNome().toUpperCase());
            
            preparaInstrucao.execute();
            
            con.desconecta();
            
            return true;
        }
        catch(SQLException e) {
            return false;
        }
    }
    
    public boolean updateIMC(Usuario u) {
        try{
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao =  con.getConexao().prepareStatement(UPDATECONSULTA);
            
            preparaInstrucao.setDouble(1, u.calcularIMC(u.getPeso(), u.getAltura()));
            preparaInstrucao.setString(2, u.getNome().toUpperCase());
            
            preparaInstrucao.execute();
            
            con.desconecta();
            
            return true;
        }catch (SQLException e) {
            return false;
        }
    }
    
    public boolean updateAntigoIMC(Usuario u) {
        try{
            con.conecta();
            PreparedStatement preparaInstrucao;
            preparaInstrucao = con.getConexao().prepareStatement(UPDATEANTIGACONSULTA);
            
            preparaInstrucao.setString(1, u.getNome().toUpperCase());
            
            preparaInstrucao.execute();
            
            con.desconecta();
            
            return true;
        }catch (SQLException e) {
            return false;
        }
    }
}