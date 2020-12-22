package Model;
import Entity.UserEntity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
public class UserModel implements ModelInterfaces{
    private ArrayList <UserEntity> userEntityArrayList;

    public UserModel(){
        userEntityArrayList = new ArrayList <UserEntity>();
    }
    
    public void insert (UserEntity userEntity){
        userEntityArrayList.add(userEntity);
    }
    
    @Override
    public void view(int index){
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println(" ID             : "+userEntityArrayList.get(index).getIndex());
            System.out.println(" Nama           : "+userEntityArrayList.get(index).getNama());
            System.out.println(" Notelp         : "+userEntityArrayList.get(index).getNotelp());
            System.out.println(" Tanggal Lahir  : "+new SimpleDateFormat("dd-MM-yyyy").format(userEntityArrayList.get(index).getTgl()));
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
    
    public int cekdata(String nama, String password){
        int loop = 0;
        while(!userEntityArrayList.get(loop).getNama().equals(nama)&&
                !userEntityArrayList.get(loop).getPassword().equals(password)){
            loop++;
        }
        return loop;
    }
    
    public UserEntity getUserEntityArrayList(int index){
        return userEntityArrayList.get(index);
    }
    
    public boolean cekempty(boolean cek){
        while(userEntityArrayList.isEmpty()){
            System.out.println("\nBELUM ADA AKUN YANG TERDAFTAR\n");
            cek=true;
            break;
        }
        while(!userEntityArrayList.isEmpty()){
            cek=false;
            break;
        }
        return cek;
    }
}