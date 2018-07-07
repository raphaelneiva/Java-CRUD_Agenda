package persistencia;
import entidade.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
public class ContatoDAO {
///
    public static ArrayList<Contato> listar(){ 
        ArrayList<Contato> lista = new  ArrayList<Contato> ();
        try{
            //Abertura da conexão
            Connection conexao = GerenteDeConexao.getConexao();
            //Criar objeto para realizar a consulta 
            Statement st = conexao.createStatement();
            //Realiza a consulta
            ResultSet rs = st.executeQuery("SELECT * FROM contato");
            //Realiza a repetição para listar os dados retornados
            while (rs.next()) {
                Contato contato = new Contato();
                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                lista.add(contato);
            }
             rs.close();
             st.close();
             conexao.close();
            
            
        }catch (Exception e){
         e.printStackTrace();
            
        }
         
         
         return lista;
    }

    public static boolean inserir (Contato contato){
        try{
          Connection conexao = GerenteDeConexao.getConexao();
          String sql = "INSERT INTO contato (nome, email) VALUES (?, ?) " ;
          //Criar um objeto responsável por executar o SQL com parâmetros 
          PreparedStatement ps = conexao.prepareStatement(sql);
          //Passar os parametros para a instrução/objeto
          ps.setString(1, contato.getNome());
          ps.setString(2, contato.getEmail());
          //Executar a instrução
          ps.executeUpdate();
          //Fechar o objeto
          ps.close();
          conexao.close();
          return true;
          
        }catch(Exception e){
            e.printStackTrace();
            return false;
                   
                    
            }
            
        }
    
    public static boolean alterar (Contato contato){
        try{
            Connection conexao = GerenteDeConexao.getConexao();
            String sql = "UPDATE contato SET nome=?, email=? WHERE id=?";   
            //Criar um objeto responsável por executar o SQL com parâmetros 
            PreparedStatement ps = conexao.prepareStatement(sql);
            //Passar os parametros para a instrução/objeto
            ps.setString(1, contato.getNome());
            ps.setString(2, contato.getEmail());
            ps.setInt(3, contato.getId());
            int qtdAlterados = ps.executeUpdate();
          
            ps.close();//fechar
            conexao.close();
            //Se qtdAlterados > 0 significa que ele alterou o registro
            return qtdAlterados > 0;
          
           }catch(Exception e){
              e.printStackTrace();
              return false;
           } 
              
        } 
    
    
    public static boolean excluir(int id){
        try{
        Connection conexao = GerenteDeConexao.getConexao();
        String sql = "DELETE FROM contato WHERE id = ?";
        //Criar um objeto responsável por executar o SQL com parâmetros 
        PreparedStatement ps = conexao.prepareStatement(sql);      
        //Passar os parametros para a instrução/objeto
        ps.setInt(1, id);
        int qtdExcluidos = ps.executeUpdate();
        ps.close();//fechar
        conexao.close();
        
        return qtdExcluidos > 0;
        
            
        }catch(Exception e){
          e.printStackTrace();
          return false;  
            
        }
        
        
            
            
    }
    
    
    
}