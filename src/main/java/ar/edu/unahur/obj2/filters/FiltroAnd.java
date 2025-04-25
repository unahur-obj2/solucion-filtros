package ar.edu.unahur.obj2.filters;

import java.util.List;

import ar.edu.unahur.obj2.model.Pais;

public class FiltroAnd extends FiltroCompuesto {

    public FiltroAnd(List<IFiltro> filtros) {
        this.filtros = filtros;
    }

    public FiltroAnd(IFiltro actual, IFiltro nuevo) {
        this.addFiltro(actual);
        this.addFiltro(nuevo);
    }

    @Override
    public Boolean apply(Pais pais) {
        return this.filtros.stream().allMatch(filtro -> filtro.apply(pais));
    }

    @Override
    public IFiltro or(IFiltro filtro) {
        return new FiltroOr(this, filtro);
    }

}
