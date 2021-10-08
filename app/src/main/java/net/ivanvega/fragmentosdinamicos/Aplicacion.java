package net.ivanvega.fragmentosdinamicos;

import android.app.Application;

import java.util.Vector;

public class Aplicacion extends Application {
    private Vector<Libro> vectorLibros;
    private AdaptadorFiltro adaptador;

    @Override
    public void onCreate() {
        super.onCreate();
        vectorLibros = Libro.ejemplosLibros();
        adaptador = new AdaptadorFiltro(this, vectorLibros);
    }

    public AdaptadorFiltro getAdaptador(){
        return adaptador;
    }

    public Vector<Libro> getVectorLibros(){
        return vectorLibros;
    }

}

