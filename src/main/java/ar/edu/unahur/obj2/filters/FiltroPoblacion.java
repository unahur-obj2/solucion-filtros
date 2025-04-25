package ar.edu.unahur.obj2.filters;


import ar.edu.unahur.obj2.model.Pais;

public class FiltroPoblacion extends Filtro {
    private Long poblacion;

    public FiltroPoblacion(Long poblacion) {
        this.poblacion = poblacion;
    }

    @Override
    public Boolean apply(Pais pais) {
        return pais.getPoblacion() >= this.poblacion;
    }

}
