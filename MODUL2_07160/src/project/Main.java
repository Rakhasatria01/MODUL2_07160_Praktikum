package project;
import Entity.*;
import Model.*;
import java.util.Date;
import java.util.Scanner;
public class Main {
    private static Scanner input = new Scanner(System.in);  
    private static UserModel userModel = new UserModel();
    private static FilmModel filmModel = new FilmModel();
    private static int cekdata,loop=-1;
    public static void main(String[] args) {
        daftarfilm();
        int pilih;
        do{
            System.out.println("Selamat Datang di RPL XXI!!!");
            System.out.println("1. Daftar");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Masukkan Pilihan = ");
            pilih = input.nextInt();
            switch(pilih){
                case 1 :
                    daftar();
                    break;
                case 2 :
                    login();
                    break;
            }
        }while(pilih!=3);
    }
    private static void daftar(){
        System.out.print("Masukkan nama          : ");
        String nama = input.next();
        System.out.print("Masukkan password      : ");
        String password = input.next();
        System.out.print("Masukkan no telp       : ");
        String notelp = input.next();
        System.out.print("Masukkan tanggal lahir : ");
        Date tanggal = new Date(input.next());
        userModel.insert(new UserEntity(nama,password,notelp,tanggal));
    }
    
    private static void login(){
        int pil;
        System.out.print("Masukkan nama          : ");
        String nama = input.next();
        System.out.print("Masukkan password      : ");
        String password = input.next();
        cekdata = userModel.cekdata(nama, password);
        System.out.println("\nSelamat datang "+userModel.getUserEntityArrayList(cekdata).getNama()+"\n");
        do{
        System.out.println("Menu ");
        System.out.println("1. Beli tiket");
        System.out.println("2. Cetak tiket");
        pil = input.nextInt();
        switch(pil){
            case 1:
                belitiket();
                break;
            case 2:
                cetaktiket();
                break;
        }
        }while(pil<=2);
    }
    
    private static void daftarfilm(){
        String namaFilm[] = {"Titanic", "IT", "UP"};
        String tanggaltayang [] = {"12/08/2021","03/07/2021","08/10/2021"};
        for(int i=0;i<namaFilm.length;i++){
        filmModel.insert(new FilmEntity (namaFilm[i],25000,new Date (tanggaltayang[i])));
        }
    }
    
    private static void belitiket(){
        System.out.println("List Film Tahun 2021 : ");
        for(int i=0;i<3;i++){
            System.out.println(i+1);
            filmModel.view(i);
        }
        System.out.print("Film no berapa yang ingin ditonton? no ");
        int idx=input.nextInt();
        loop++;
        userModel.getUserEntityArrayList(loop).setIndex(cekdata);
        filmModel.getFilmEntityArrayList(loop).setIndex(idx-1);
        System.out.println("Tiket untuk film "+filmModel.getFilmEntityArrayList(filmModel.getFilmEntityArrayList(loop).getIndex()).getNama()+"berhasil dibeli");
    }
    
    private static void cetaktiket(){
        System.out.println("Tiket yang anda miliki :");
        if(loop<0){
            System.out.println("Belum ada tiket yang dibeli");
        }
        else{
            for(int i=0;i<=loop;i++){
                if(userModel.getUserEntityArrayList(i).getIndex()==cekdata){
                    System.out.println("No tiket : "+filmModel.getFilmEntityArrayList(i).getIndex());
                    filmModel.view(filmModel.getFilmEntityArrayList(loop).getIndex());
                }
            }
            System.out.println("No tiket yang ingin dicetak = ");
            int notiket = input.nextInt();
            System.out.println("\nNama pembeli : "+userModel.getUserEntityArrayList(cekdata).getNama());
            filmModel.view(notiket-1);
            filmModel.delete(notiket-1);
        } 
    }
    
    
}
