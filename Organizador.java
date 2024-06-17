
public class Organizador extends Pessoa{
	private String empresa;

    public Organizador() {}

    public Organizador(int id, String nome, String email, String empresa) {
        super(id, nome, email);
        this.empresa = empresa;
    }
    
    public void detalhes() {
        System.out.println("Organizador ID: " + getId()
        		+ "\nNome: " + getNome()
        		+ "\nEmail: " + getEmail()
        		+ "\nDepartamento: " + empresa
        		+ "\n");
    }

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	
}
