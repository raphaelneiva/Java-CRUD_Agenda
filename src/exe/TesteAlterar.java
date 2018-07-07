package exe;
import entidade.Contato;
import javax.swing.JOptionPane;
import persistencia.ContatoDAO;
public class TesteAlterar {
    public static void main(String[] args) {
    ///
    Contato contato = new Contato ();
    contato.setId(4);
    contato.setNome("João Lucas");
    contato.setEmail("joaolucas@gmail.com");
    
    boolean sucesso = ContatoDAO.alterar(contato);
    if (sucesso){
        JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        
    }else{
        JOptionPane.showMessageDialog(null, "Erro ao alterar!", "Erro", JOptionPane.ERROR_MESSAGE);
        
    }
    
    

    }
    
}