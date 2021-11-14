package com.example.ej_ud02_dialogos;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ej_ud02_dialogos.modelo.Libro;
import com.example.ej_ud02_dialogos.modelo.LibroListener;

public class FragmentListado extends Fragment {

    private Libro[] libros = new Libro[]{
            new Libro("El alquimista", "Paulo Coelho", "Literatura fantástica", "El Alquimista relata las aventuras de Santiago, un joven pastor andaluz que un día emprende un viaje por las arenas del desierto en busca de un tesoro. Lo que empieza como la búsqueda de bienes mundanos se convertirá en el descubrimiento del tesoro interior.", R.drawable.el_alquimista, true),
            new Libro("Una educación mortal", "Naomi Novik","Literatura fantástica","Sinopsis", R.drawable.una_educacion_mortal, true),
            new Libro("El encuadernador", "Bridget Collins","Literatura fantástica","Sinopsis", R.drawable.el_encuadernador, true),
            new Libro("Harry portter y la piedra filosofal", "J.K Rowling","Literatura fantástica", "Sinopsis", R.drawable.hp_piedra_filosofal, false),
            new Libro("Harry portter y la cámara secreta", "J.K Rowling","Literatura fantástica","Sinopsis", R.drawable.hp_camara_secreta, false),
            new Libro("Harry portter y el prisionero de Azkaban", "J.K Rowling","Literatura fantástica","Sinopsis", R.drawable.hp_prisionero_azkaban, false),
    };

    private ListView lstListado;
    private LibroListener listener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listado, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lstListado = (ListView) getView().findViewById(R.id.lstListado);
        lstListado.setAdapter(new AdaptadorLibros(this));
        //Asignamos el evento onItemClick() a la lista de los correos
        lstListado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view, int position, long id) {
                if (listener != null)
                    listener.onLibroSeleccionado(
                            (Libro) lstListado.getAdapter().getItem(position));
            }
        });
    }

    class AdaptadorLibros extends ArrayAdapter<Libro> {
        Activity context;

        AdaptadorLibros(Fragment context) {
            super(context.getActivity(), R.layout.listitem_libro, libros);
            this.context = context.getActivity();
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView,@NonNull ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_libro, null);

            ImageView imageView = item.findViewById(R.id.imagenLibro);
            imageView.setImageResource(libros[position].getImagen());

            TextView lblDe = (TextView) item.findViewById(R.id.lblTitulo);
            lblDe.setText(libros[position].getTitulo());

            TextView lblAsunto = (TextView) item.findViewById(R.id.lblAutor);
            lblAsunto.setText(libros[position].getAutor());

            return (item);
        }
    }

    public void setLibroListener(LibroListener listener) {
        this.listener = listener;
    }
}