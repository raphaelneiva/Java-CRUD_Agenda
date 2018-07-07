package entidade;
public class Telefone {
///
private int id;
private int ddd;
private int numero;
Contato contato;
///

    public Telefone(Contato contato) {
        this.contato = contato;
    }

  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    ///
    @Override
    public String toString() {
        return "\nID Telefone: " + id + "\nDDD " + ddd + "\nNúmero " + numero + "\nID Contato " + contato.getId() + "\n < ..... > ";
    }

   
    
}