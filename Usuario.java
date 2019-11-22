
package modelo;

public class Usuario {
    private String nome;
    private double altura, peso;
    
    enum Sexos {
        MASC,
        FEM
    }
    Sexos sexo;
    
    private int idade;

    public Usuario(String nome, int idade, Sexos sexo,double altura, double peso) {
        this.nome = nome;
        this.idade = idade;
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Sexos getSexo() {
        return sexo;
    }

    public void setSexo(Sexos sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + ", altura=" + altura + ", peso=" + peso + '}';
    }
    
    public double calcularIMC(double pesoIMC, double alturaIMC) {
       return pesoIMC / (alturaIMC*alturaIMC);
    }
    
    public String verificaIMC(double imc){
        
        String resultadoIMC;
        
        if(imc < 18.5){
            return resultadoIMC = "Abaixo do peso";
        }else if(imc > 18.6 && imc < 24.9){
            return resultadoIMC = "Normal";
        }else if(imc >25 && imc < 29.9){
            return resultadoIMC = "Acima do peso";
        }else if(imc > 30 && imc < 39.9){
            return resultadoIMC = "Obeso I";
        }else {
            return resultadoIMC = "Obesidade Mórbida";
        }
    }
}
