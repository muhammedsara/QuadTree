
package Paket;

/**
 *Bu clası oluşturma nedenim işlemlerin kontrollu bir şekilde çalışmsını sağlamak
 * @author sara
 */
public class Kontrol {
    
    Goruntu olustur;
    
    /**
     *Tiklama clasından ve quadtree clasından fonksiyon oluşturdum. kullanmak için
     */
    public Kontrol(){

        
        Tiklanma tikla=new Tiklanma();
        QuadTree agac=new QuadTree();

        };

    /**
     *Tiklanma ve agaç fonksiyonumuzu çağırdık kullanmak için
     * @param o goruntu clasında gelen veridir.
     */
    public Kontrol(Goruntu o ){
       
        Tiklanma tikla=new Tiklanma();
        QuadTree agac=new QuadTree();
        olustur= o;

        };



    
    
}
