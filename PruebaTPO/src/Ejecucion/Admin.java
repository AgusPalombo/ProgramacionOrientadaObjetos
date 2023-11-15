package Ejecucion;

public class Admin {
    private String password;

    public Admin() {
      this.password = "admin123";
    }

    public boolean verificarPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }
    
    
}

