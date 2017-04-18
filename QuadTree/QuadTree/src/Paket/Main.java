
package Paket;

import com.sun.javafx.geom.Quat4f;

/**
 *Bu clasta işlemlerin gerçekleşme sırasını belirtiyor.
 * @author sara
 */
public class Main {

    /**
     *Burada işlemlerin sıra ile gerçekleşmesini sağlıyor.
     * @param args
     */
    public static void main(String[] args) {
      Goruntu olustur=new Goruntu();
       olustur.setVisible(true);
         QuadTree quadtree=new QuadTree();
         
       Kontrol kontrol=new Kontrol(olustur);
     
        
    }
    
    
}
