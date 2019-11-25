
package persistence;

import java.sql.*;

public class Conexao {
    //ATRIBUTOS DA CLASSE
	private static final String USUARIO = "sa";	/*Iremos alterar*/
	private static final String SENHA = ""; /*Iremos alterar*/
	private static final String CAMINHO = "jdbc:h2:~/bancoDeDados/calculadoraIMC;INIT=runscript from '~/bancoDeDados/createTable.sql'"; /*Nao sei no que da dando errado
        mas eu to ligado que tud deixa eu pensar... vc ta usando modo embutido la o h2? .Pra atualizar tem que desconectar la, e dps att aqui ele ta aberto? abre o locallhost ai*/
        /*Alterar runSCRIPT*/
	private static final String DRIVER = "org.h2.Driver";
	private Connection conexao;	
	
	//METODO QUE EFETUA A CONEXAO COM O BANCO DE DADOS
	public void conecta() {
		try {
			Class.forName(DRIVER); //Carrega o driver (inicializa um objeto da classe org.postgresql.Driver) 
			conexao = DriverManager.getConnection(CAMINHO, USUARIO,SENHA); //Cria a conexao
		} catch (ClassNotFoundException | SQLException e) {
			System.err.println(e);
		}
	}

	//METODO QUE DESCONECTA O BANCO DE DADOS
	public void desconecta() {
		try {
			conexao.close();//fecha a conexao
		} catch (SQLException ex) {
			System.err.println(ex);
		}
	}

	public Connection getConexao() {
		return conexao;
	}
}
