public class Participante extends Pessoa {
    private String tipoIngresso;

    public Participante() {}

    public Participante(int id, String nome, String email, String tipoIngresso) {
        super(id, nome, email);
        this.tipoIngresso = tipoIngresso;
    }

    public void detalhes() {
        System.out.println("Participante ID: " + getId() 
        		+ "\nNome: " + getNome() 
        		+ "\nEmail: " + getEmail() 
        		+ "\nTipo de Ingresso: " + tipoIngresso
        		+ "\n");
    }

	public String getTipoIngresso() {
		return tipoIngresso;
	}

	public void setTipoIngresso(String tipoIngresso) {
		this.tipoIngresso = tipoIngresso;
	}

	public String toString() {
        return "\nNome: " + getNome() 
                + "\nID : " + getId() 
                + "\nEmail: " + getEmail() 
                + "\nTipo de Ingresso: " + tipoIngresso 
                + "\n";
    }
}