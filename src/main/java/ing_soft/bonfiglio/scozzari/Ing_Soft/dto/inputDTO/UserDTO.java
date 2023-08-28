package ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO;

public class UserDTO {

    private String nome;
    private String cognome;
    private String codiceFiscale;
    private String email;
    private String username;
    private String password;

    public UserDTO(String nome, String cognome, String codiceFiscale, String email, String username, String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
