package ar.edu.unahur.obj2;

import java.util.List;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.filters.FiltroIdioma;
import ar.edu.unahur.obj2.filters.FiltroInsular;
import ar.edu.unahur.obj2.filters.FiltroPoblacion;
import ar.edu.unahur.obj2.filters.FiltroRegion;
import ar.edu.unahur.obj2.filters.IFiltro;
import ar.edu.unahur.obj2.model.Pais;
import ar.edu.unahur.obj2.service.IPaisService;
import ar.edu.unahur.obj2.service.PaisService;

public class FIltroTest {

    @Test
	void prueba() {
		IPaisService paisService = new PaisService();
        List<Pais> paises = paisService.getPaises();
        IFiltro filtros = new FiltroRegion("Americas")
                              .and(new FiltroPoblacion(100000000L))
                              .or(new FiltroRegion("Asia").and(new FiltroPoblacion(300000000L)))
                              .or(new FiltroInsular().and(new FiltroPoblacion(20000000L)));

        IFiltro filtrosBuilder = new FiltroInsular()
                .and(new FiltroRegion("Asia"))
                .and(new FiltroIdioma("English")
                .or(new FiltroPoblacion(50000000L)));

        System.out.println("Primer Filtro");
        paises.stream().filter(p -> filtros.apply(p)).forEach(System.out::println);
        
        System.out.println("Segundo Filtro");
        paises.stream().filter(p -> filtrosBuilder.apply(p)).forEach(System.out::println);
	}
    
}
