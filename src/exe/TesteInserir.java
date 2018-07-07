package exe;
import entidade.Contato;
import javax.swing.JOptionPane;
import persistencia.ContatoDAO;
public class TesteInserir {
    public static void main(String[] args) {
        ///
        Contato contato = new Contato();
        contato.setNome("João");
        contato.setEmail("joaoj@gmail.com");
        
        boolean sucesso = ContatoDAO.inserir(contato);
        if (sucesso == true){
            JOptionPane.showMessageDialog(null, "Contato inserido com sucesso!");
        }else {
            JOptionPane.showMessageDialog(null, "Erro ao inserir contato!" , "Erro" , JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
}
