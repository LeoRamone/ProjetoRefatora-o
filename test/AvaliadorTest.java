package test;

import static org.junit.Assert.assertEquals;

import model.AvaliadorTO;
import model.areaTO;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import service.AvaliadorService;
import service.areaService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AvaliadorTest {
	AvaliadorTO area, copia;
	AvaliadorService avaliadorService;
	static int id = 0;

	/*
	 * Antes de rodar este teste, certifique-se que nao ha no banco nenhuma
	 * linha com o id igual ao do escolhido para o to instanciado abaixo. Se
	 * houver, delete. 
	 * Certifique-se também que sobrecarregou o equals na classe
	 * Cliente. 
	 * Certifique-se que a fixture cliente1 foi criada no banco.
	 * Além disso, a ordem de execução dos testes é importante; por
	 * isso a anotação FixMethodOrder logo acima do nome desta classe
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		area = new AvaliadorTO();
		area.setNome("Estrutura");
		copia = new AvaliadorTO();
		copia.setId(id);
		copia.setNome("Estrutura");
		avaliadorService = new AvaliadorService();
		System.out.println(area);
		System.out.println(copia);
		System.out.println(id);
	}
	
	@Test
	public void test00Carregar() {
		System.out.println("carregar");
		//para funcionar o area 1 deve ter sido carregado no banco por fora
		areaTO fixture = new areaTO();
		fixture.setId(1);
		fixture.setNome("Estrutura");
		areaService novoService = new areaService();
		areaTO novo = novoService.carregar(1);
		assertEquals("testa inclusao", novo, fixture);
	}

}
