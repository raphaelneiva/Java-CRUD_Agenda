package persistencia;

import entidade.Contato;
import entidade.Telefone;


import java.util.ArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TelefoneDAO {
    
    public static ArrayList<Telefone> listar() {
        ArrayList<Telefone> resultado = new ArrayList<Telefone>();
        try {
            // Abre a conexão com o BD
            Connection conexao = GerenteDeConexao.getConexao();
            // Abre um objeto para realizar consulta
            Statement st = conexao.createStatement();
            // Executa uma consulta e retorna um resultado
            ResultSet rs = st.executeQuery("SELECT * FROM telefone");
            // Transformando o resultado na lista de objetos de Contato
            while(rs.next()) {
                // Cria o objeto de contato
                Contato c = new Contato();
                c.setId(rs.getInt("id_contato"));
                
                Telefone t = new Telefone(c);
                t.setId(rs.getInt("id"));
                t.setDdd(rs.getInt("ddd"));
                t.setNumero(rs.getInt("numero"));            
                // Adiciona contato na lista
                resultado.add(t);
            }           
            rs.close();
            st.close();
            conexao.close();            
        } catch(Exception e) {
            e.printStackTrace();
            
        }
        
        return resultado;
    }
    
    public static boolean inserir(Telefone telefone) {
        try {
            // Abre a conexão com o BD
            Connection conexao = GerenteDeConexao.getConexao();
            // Instrução de inclusão
            String sql = "INSERT INTO telefone (ddd, numero, id_contato) VALUES (?, ?, ?)";
            // Abre um objeto para realizar inclusão
            PreparedStatement ps = conexao.prepareStatement(sql);
            // Passa os valores para o PS.
            ps.setInt(1, telefone.getDdd());
            ps.setInt(2, telefone.getNumero());
            ps.setInt(3, telefone.getContato().getId());
            // Executa o comando no banco de dados
            ps.execute();
            ps.close();
            conexao.close();
            return true;
            
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean alterar(Telefone telefone) {
        try {
            // Abre a conexão com o BD
            Connection con = GerenteDeConexao.getConexao();
            // Instrução de inclusão
            String sql = "UPDATE telefone SET "
                        + "ddd = ? "
                        + "numero = ? "
                        + "WHERE Id = ?";
            // Abre um objeto para realizar inclusão
            PreparedStatement ps = con.prepareStatement(sql);
            // Passa os valores para o PS.
            ps.setInt(1, telefone.getDdd());
            ps.setInt(2, telefone.getNumero());
            ps.setInt(3, telefone.getId());
            
            // Executa o comando no banco de dados
            ps.execute();
            
            int qtdAlterados = ps.getUpdateCount();
            
            ps.close();
            con.close();
            return qtdAlterados > 0;
        } catch(Exception e) {
         
            return false;
        }
    }
    
    public static boolean excluir(int id) {
        try {
            // Abre a conexão com o BD
            Connection con = GerenteDeConexao.getConexao();
            // Instrução de inclusão
            String sql = "DELETE FROM telefone WHERE id = ?";
            // Abre um objeto para realizar exclusão
            PreparedStatement ps = con.prepareStatement(sql);
            // Passa os valores para o PS.
            ps.setInt(1, id);
            // Executa o comando no banco de dados
            ps.execute();
            
            int qtdExcluidos = ps.getUpdateCount();
            
            ps.close();
            con.close();
            // Retorna true se qtdExcluidos > 0
            return qtdExcluidos > 0;
        } catch(Exception e) {
         
            return false;
        }
    }
}
