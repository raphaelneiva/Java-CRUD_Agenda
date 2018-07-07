package exe;

import javax.swing.JOptionPane;
import persistencia.ContatoDAO;

public class TesteExcluir {
    public static void main(String[] args) {
    ///
    boolean sucesso = ContatoDAO.excluir(4);
    if (sucesso){
        JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
    }else{
        JOptionPane.showMessageDialog(null, "Erro ao excluír!","Erro",JOptionPane.WARNING_MESSAGE);
    }
        


    }
    
}