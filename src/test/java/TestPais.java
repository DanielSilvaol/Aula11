import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import pacote.Pais;
import service.PaisService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPais {
	
	Pais pais, copia;
	PaisService paisService;
	static int id = 0 ;
	
	
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		pais = new Pais(id, "Italia", 204, 301338);
		copia = new Pais(id, "Italia", 204, 301338);
		paisService = new PaisService();
		System.out.println(pais);
		System.out.println(copia);
		System.out.println(id);
	}
	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		//para funcionar o pais 1 deve ter sido carregado no banco por fora
		Pais fixture = new Pais(1, "Brasil", 208, 8516000);
		PaisService novoService = new PaisService();
		Pais novo = novoService.carregar(1);
		assertEquals("testa inclusao", novo, fixture);
	}
	@Test
	public void test01Criar() {
		System.out.println("criar");
		id = paisService.criar(pais);
		System.out.println(id);
		copia.setId(id);
		assertEquals("testa criacao", pais, copia);
		
	}
	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		pais.setArea(301338);
		copia.setArea(301338);		
		paisService.atualizar(pais);
		pais = paisService.carregar(pais.getId());
		assertEquals("testa atualizacao", pais, copia);

	}
	@Test
	public void test03Excluir() {
		System.out.println("excluir");
		copia.setId(-1);
		copia.setNome(null);
		copia.setPopulacao(-1);
		copia.setArea(-1);
		paisService.excluir(id);
		pais = paisService.carregar(id);
		assertEquals("testa exclusao", pais, copia);
	}
	@Test
	public void test04MaiorPopulacao() {
		System.out.println("Maior popula��o");
		Pais fixture = new Pais(4, "Estados Unidos", 323, 9834000.00);
		PaisService novoService = new PaisService();
		paisService.Maiorpais(id);
		Pais novoPais = novoService.carregar(4);
		assertEquals("Teste de maior popula��o", novoPais, fixture);
	}
	@Test
	public void test06menorArea() {
		System.out.println("menor �rea");
		Pais fixture = new Pais(5,"Portugal",10,92212);
		PaisService novoService = new PaisService();
		novoService.MenorArea(id);
		Pais novoPais = novoService.carregar(5);
		assertEquals("Teste de menor �rea", novoPais, fixture);
	}
	@Test
	public void test05vetorTresPaises() {
		System.out.println("vetorTresPaises");
		Pais fixture = new Pais(6,"Alemanha",83,357376);
		Pais fixture1 = new Pais(2,"Argentina",44,2780000); 
		Pais fixture2 = new Pais(3,"Bolivia",11,1099000);
		PaisService novoService = new PaisService();
		novoService.Vetor3Paise(id);
		Pais novoPais = novoService.carregar(6);
		Pais novoPais1 = novoService.carregar(2);
		Pais novoPais2 = novoService.carregar(3);
		assertEquals("Teste de Vetor de tres paises", novoPais, fixture);
		assertEquals("Teste de Vetor de tres paises1", novoPais1, fixture1);
		assertEquals("Teste de Vetor de tres paises2", novoPais2, fixture2);
	  
	}
}
