package br.edu.utfpr.cp.sa.AppClientePaisSB;

import br.edu.utfpr.cp.sa.AppClientePaisSB.persistencia.Cliente;
import br.edu.utfpr.cp.sa.AppClientePaisSB.persistencia.ClienteDAO;
import br.edu.utfpr.cp.sa.AppClientePaisSB.persistencia.Pais;
import br.edu.utfpr.cp.sa.AppClientePaisSB.persistencia.PaisDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.Stream;

@SpringBootApplication
public class AppClientePaisSbApplication implements CommandLineRunner {

	private final PaisDAO paisDAO;
	private final ClienteDAO clienteDAO;

	@Autowired
	public AppClientePaisSbApplication (PaisDAO paisDAO, ClienteDAO clienteDAO) {
		this.paisDAO = paisDAO;
		this.clienteDAO = clienteDAO;
	}

	public static void main(String[] args) {
		SpringApplication.run(AppClientePaisSbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		var brasil = new Pais(null, "Brasil", "BR");
//		var eua = Pais.builder().nome("Estados Unidos").sigla("EUA").build();

		Stream.of(
				Pais.builder().nome("Brasil").sigla("BR").build(),
				Pais.builder().nome("Estados Unidos").sigla("EUA").build()
		).forEach(paisDAO::save);

		paisDAO.findAll().forEach(System.out::println);

		var brasil = paisDAO.findByNome("Brasil");

		Stream.of(
				Cliente.builder().nome("John Connor").pais(brasil).build(),
				Cliente.builder().nome("Sara Connor").pais(brasil).build()
		).forEach(clienteDAO::save);

		clienteDAO.findAll().forEach(System.out::println);
	}
}
