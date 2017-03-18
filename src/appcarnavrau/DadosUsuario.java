package appcarnavrau;

import com.restfb.types.ProfilePictureSource;

public class DadosUsuario {

    //Atributos da classe

    private String nome;
    private String genero;
    private String aniversario;
    private ProfilePictureSource foto;

    //Construtor
    public DadosUsuario(String nome, String genero, String aniversario, ProfilePictureSource foto) {

        this.nome = nome;
        this.genero = genero;
        this.aniversario = aniversario;
        this.foto = foto;

    }

    //Gets e Sets da classe

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAniversario() {
        return aniversario;
    }

    public void setAniversario(String aniversario) {
        this.aniversario = aniversario;
    }

    public ProfilePictureSource getFoto() {
        return foto;
    }

    public void setFoto(ProfilePictureSource foto) {
        this.foto = foto;
    }

    //Método que retorna todos os dados da classe

    public String imprimir() {
        return "\nNome:" + nome + "\nGênero: " + genero + "\nAniversário: " + getAniversario();
    }

}
