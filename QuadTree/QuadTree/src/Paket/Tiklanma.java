
package Paket;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *Bu classta tıklanıldıgı zaman calışan atraksiyonları yaptım, rast gele 
 * renk olayları gibi işlemler gerçekleştirildi
 * @author sara
 */
public class Tiklanma implements MouseListener {
    public static int nokta_sayisi,

    /**
     *Burada mosenin tıklanıldığı yere göre işlem yapılmasını saglattık, 
     *mausenin x y koordinatlarını alma işlemini yaptırdık
     */
    i;
    
        
           static  Color randomColor ;
    
    QuadTree gonder;

    Goruntu g;
    int x,y;
   
    /**
     *Burada kullanıcının girdiği nokta adedini buldurma işlemini yaptırdık.
     * x ve y koordinatlarını 0 a eşitledik.
     */
    public Tiklanma() {
        x=0;
        y=0;       
        nokta_sayisi=0;
    }

    /**
     *Kordinatlarımızı ve quadtreemizden geln verileri alıp işleme sokmaya yarar.
     * @param gel goruntude oluştudugumuz cizme, nokta oluşturma gibi 
     * fonksiyonalrı kullanmak için oluşturuldu.
     */
    public Tiklanma(Goruntu gel) {
        x=0;
        y=0;
        g=gel;
        gonder=new QuadTree();
        nokta_sayisi=0;
    }
   
    /**
     *Kordinatlarımızı ve quadtreemizden geln verileri alıp işleme sokmaya yarar.
     * @param goruntude oluştudugumuz cizme, nokta oluşturma gibi 
     * fonksiyonalrı kullanmak için oluşturuldu.
     */
    public Tiklanma(Goruntu gel,QuadTree q) {
        x=0;
        y=0;
        g=gel;
        gonder=q;
        nokta_sayisi=0;
    }
       public void mouseClicked(MouseEvent e) {
  
           if(!Goruntu.modarama){
           System.out.println("Mouse Clicked: ("+e.getX()+", "+e.getY() +")");
                 int R = (int) (Math.random( )*256);
                 int G = (int)(Math.random( )*256);
                 int B= (int)(Math.random( )*256);
           new Color(R, G, B);
           gonder.Ekle_Dugum(e.getX(), e.getY());
           
           x=e.getX();
           y=e.getY();
           
                 
           }
           else {
               Goruntu.cemberx=e.getX();
               Goruntu.cembery=e.getY();
               Goruntu.arama=true;
           
           
           }
         
           g.repaint();
          
           
           

       }
      public void mousePressed(MouseEvent e) {
      }
      public void mouseReleased(MouseEvent e) {
      }
      public void mouseEntered(MouseEvent e) {
      }
      public void mouseExited(MouseEvent e) {
      }
      

      
    
    
}
