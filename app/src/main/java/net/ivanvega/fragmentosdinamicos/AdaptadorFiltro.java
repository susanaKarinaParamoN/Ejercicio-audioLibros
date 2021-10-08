package net.ivanvega.fragmentosdinamicos;

import android.content.Context;

import java.util.Locale;
import java.util.Vector;

public class AdaptadorFiltro extends MiAdaptadorPersonalizado {
    private Vector<Libro> vectorSinFiltro;
    private Vector<Integer> indiceFiltro;

    private String busqueda = "";
    private String genero = "";
    private boolean novedad = false;
    private boolean leido = false;

    public AdaptadorFiltro(Context contexto, Vector<Libro> vectorLibros) {
        super(contexto, vectorLibros);
        vectorSinFiltro = vectorLibros;
        recalcularFiltro();
    }

    public void setBusqueda(String busqueda) {
        this.busqueda = busqueda.toLowerCase();
        recalcularFiltro();
    }

    public void setGenero(String genero) {
        this.genero = genero;
        recalcularFiltro();
    }

    public void setNovedad(boolean novedad) {
        this.novedad = novedad;
        recalcularFiltro();
    }

    public void setLeido(boolean leido) {
        this.leido = leido;
        recalcularFiltro();
    }

    public void recalcularFiltro() {
        libros = new Vector<Libro>();
        indiceFiltro = new Vector<Integer>();
        for (int i = 0; i < vectorSinFiltro.size(); i++) {
            Libro libro = vectorSinFiltro.elementAt(i);
            if ((libro.getTitulo().contains(busqueda) ||
                    libro.getAutor().contains(busqueda))
                    && (libro.getGenero().startsWith(genero))
                    && (!novedad || (novedad && libro.getNovedad()))
                    && (!leido || (leido && libro.getLeido()))) {
                libros.add(libro);
                indiceFiltro.add(i);
            }
        }
        //super.libros = libros;
    }

    public Libro getItem(int posicion) {
        return vectorSinFiltro.elementAt(indiceFiltro.elementAt(posicion));
    }

    public long getItemId(int posicion) {
        return indiceFiltro.elementAt(posicion);
    }
    public void borrar(int posicion) {
        vectorSinFiltro.remove((int) getItemId(posicion));
        recalcularFiltro();
    }
    public void insertar(Libro libro) {
        vectorSinFiltro.add(libro);
        recalcularFiltro();
    }
}
