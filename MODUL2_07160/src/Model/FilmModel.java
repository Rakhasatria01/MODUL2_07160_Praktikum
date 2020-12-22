package Model;
import Entity.FilmEntity;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
public class FilmModel implements ModelInterfaces{
    private ArrayList <FilmEntity> filmEntityArrayList;

    public FilmModel(){
        filmEntityArrayList = new ArrayList <FilmEntity>();
    }
    
    public void insert (FilmEntity filmEntity){
        filmEntityArrayList.add(filmEntity);
    }
    
    @Override
    public void view(int index){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println(" Judul           : "+filmEntityArrayList.get(index).getNama());
            System.out.println(" Harga           : "+filmEntityArrayList.get(index).getHarga());
            System.out.println(" Tanggal tayang  : "+new SimpleDateFormat("dd-MM-yyyy").format(filmEntityArrayList.get(index).getTanggaltayang()));
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    public FilmEntity getFilmEntityArrayList(int index){
        return filmEntityArrayList.get(index);
    }
    
    public void delete(int index){
        filmEntityArrayList.remove(index);
    }
}
