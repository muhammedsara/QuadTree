
package Paket;

import java.awt.Color;

/**
 *Bu clasımızda quadtree-dortlu arama ağacımızın kollarını, ekleme işlemlerini, 
 * arama işlemlerini, arama yapılacak koordinatların belirlenmesini sağlatıyoruz.
 * @author sara
 */
public class QuadTree {
    static int MAX=999;
                
            static int[] dizix=new int[MAX];
            static int[] diziy=new int[MAX];
            static int dizi_sayac=0;

            static int[] x1_dizi=new int[MAX];
            static int[] y1_dizi=new int[MAX];
            static int[] x2_dizi=new int[MAX];
            static int[] y2_dizi=new int[MAX];
            static int[] x3_dizi=new int[MAX];
            static int[] y3_dizi=new int[MAX];
            static int[] x4_dizi=new int[MAX];
            static int[] y4_dizi=new int[MAX];
            static int linessayac=0;

            static Dugum kok;
            
    /**
     *Reset işelminde verilerimizi temizliyoruz, reset düğmesine tıklanıldığı
     * zaman tumağacımızı temizleme işlemini yapıyor.
     */
    public void reset(){
                linessayac=0;
                
                kok=null;
            dizix=new int[MAX];
            diziy=new int[MAX];
            dizi_sayac=0;

            x1_dizi=new int[MAX];
            y1_dizi=new int[MAX];
            x2_dizi=new int[MAX];
            y2_dizi=new int[MAX];
            x3_dizi=new int[MAX];
            y3_dizi=new int[MAX];
            x4_dizi=new int[MAX];
            y4_dizi=new int[MAX];
                //MAX=0;
            }

    /**
     *
     * @param x
     * @param y
     */
    public  void Ekle_Dugum(int x,int y){
        
        
        if(kok==null){
            kok=new Dugum(x,y,0,0,512,0,0,512,512,512);
            x1_dizi[linessayac]=x;
            y1_dizi[linessayac]=0;
            x2_dizi[linessayac]=x;
            y2_dizi[linessayac]=512;
            linessayac++;
            x3_dizi[linessayac]=0;
            y3_dizi[linessayac]=y;
            x4_dizi[linessayac]=512;
            y4_dizi[linessayac]=y;
            linessayac++;
            
              dizix[dizi_sayac]=x;
           diziy[dizi_sayac]=y;
           dizi_sayac++;
            
            
            
            System.out.println("<---girdii--->");
        }
        else{
            
            Dugum odakDugum=kok;
            Dugum anaDugum;
            while(true){
                
                anaDugum=odakDugum;
                
               if(x>odakDugum.x && y>odakDugum.y){
                   
                   odakDugum=odakDugum.sagalt;
                   
                   
                   
                   if(odakDugum==null){   
                       anaDugum.sagalt=new Dugum(x,y,anaDugum.x,anaDugum.y,anaDugum.kose2_x,anaDugum.y,anaDugum.x,anaDugum.kose3_y,anaDugum.kose4_x,anaDugum.kose4_y );
            x1_dizi[linessayac]=x;
            y1_dizi[linessayac]=anaDugum.y;
            x2_dizi[linessayac]=x;
            y2_dizi[linessayac]=anaDugum.kose4_y;
            linessayac++; 
            x3_dizi[linessayac]=anaDugum.x;
            y3_dizi[linessayac]=y;
            x4_dizi[linessayac]=anaDugum.kose4_x;
            y4_dizi[linessayac]=y;  
            linessayac++;
            
              dizix[dizi_sayac]=x;
           diziy[dizi_sayac]=y;
           dizi_sayac++;
                       
                      // System.out.println("sagalt EKLENDİ");
                        return;
                   }        
               }
               else if(x<odakDugum.x && y>odakDugum.y){
                   
                   odakDugum=odakDugum.solalt;
                   if(odakDugum==null){
                       anaDugum.solalt=new Dugum(x,y,anaDugum.kose1_x,anaDugum.y,anaDugum.x,anaDugum.y,anaDugum.kose1_x,anaDugum.kose4_y,anaDugum.x,anaDugum.kose4_y);
                         x1_dizi[linessayac]=x;
                         y1_dizi[linessayac]=anaDugum.y;
                         x2_dizi[linessayac]=x;
                         y2_dizi[linessayac]=anaDugum.kose4_y;
                         linessayac++; 
                         x3_dizi[linessayac]=anaDugum.kose1_x;
                         y3_dizi[linessayac]=y;
                         x4_dizi[linessayac]=anaDugum.x;
                         y4_dizi[linessayac]=y; 
                         linessayac++;
                         dizix[dizi_sayac]=x;
                         diziy[dizi_sayac]=y;
                         dizi_sayac++;      
                      // anaDugum.solalt=yeniDugum;
                       //System.out.println("solalt EKLENDİ");
                       return;     
                   }        
               }
               else if(x<odakDugum.x && y<odakDugum.y){
                   odakDugum=odakDugum.solust;
                   if(odakDugum==null){
                       
                       anaDugum.solust=new Dugum(x, y,anaDugum.kose1_x,anaDugum.kose1_y,anaDugum.x,anaDugum.kose1_y,anaDugum.kose1_x,anaDugum.y,anaDugum.x,anaDugum.y);
                        x1_dizi[linessayac]=x;
                        y1_dizi[linessayac]=anaDugum.kose1_y;
                        x2_dizi[linessayac]=x;
                        y2_dizi[linessayac]=anaDugum.y;
                        linessayac++; 
                         x3_dizi[linessayac]=anaDugum.kose1_x;
                         y3_dizi[linessayac]=y;
                         x4_dizi[linessayac]=anaDugum.x;
                         y4_dizi[linessayac]=y;
                          linessayac++;
                         dizix[dizi_sayac]=x;
                         diziy[dizi_sayac]=y;
                         dizi_sayac++;              
                     // anaDugum.solust=yeniDugum;
                     //  System.out.println("solust EKLENDİ");
                       return;        
                   }  
               }
               else if(x>odakDugum.x && y<odakDugum.y){              
                   odakDugum=odakDugum.sagust;  
                   if(odakDugum==null){
                       anaDugum.sagust=new Dugum(x,y,anaDugum.x,anaDugum.kose1_y,anaDugum.kose2_x,anaDugum.kose2_y,anaDugum.x,anaDugum.y,anaDugum.kose4_x,anaDugum.y);
                       
                       x1_dizi[linessayac]=x;
                       y1_dizi[linessayac]=anaDugum.kose1_y;
                       x2_dizi[linessayac]=x;
                       y2_dizi[linessayac]=anaDugum.y;
                       linessayac++;
                       x3_dizi[linessayac]=anaDugum.x;
                       y3_dizi[linessayac]=y;
                       x4_dizi[linessayac]=anaDugum.kose4_x;
                       y4_dizi[linessayac]=y;
                         linessayac++;
                         dizix[dizi_sayac]=x;
                         diziy[dizi_sayac]=y;
                         dizi_sayac++; 
                       
                       
                     //  anaDugum.sagust=yeniDugum;     
                       //System.out.println("sagust EKLENDİ");
                       return;
                       
                   }
                       
                   
               }
               else{
                //System.out.println("hiçgirmedi");
               break;
               }
                
            }
            
        }
    
    
    }

    /**
     *
     * @param x imlecin clik yaptıgı koordinatın x noktasını alıp düğüme ekleme işlemini yapar
     * @param y imlecin clik yaptıgı koordinatın y noktasını alıp düğüme ekleme işlemini yapar
     * @return
     */
    public Dugum Ara_Dugum(int x,int y){
        
        Dugum odakDugum=kok;
        
        while((odakDugum.x!=x && odakDugum.y!=y)||(odakDugum.x==x && odakDugum.y!=y)||(odakDugum.x!=x && odakDugum.y==y) ){
            
            if(x>odakDugum.x && y>odakDugum.y){
                odakDugum=odakDugum.sagalt;
            }
            else if(x<odakDugum.x && y>odakDugum.y){
                odakDugum=odakDugum.solalt;
            }
            else if(x<odakDugum.x && y<odakDugum.y){
                odakDugum=odakDugum.solust;
            }
            else if(x>odakDugum.x && y<odakDugum.y){
                odakDugum=odakDugum.sagust;
            }
         
            else //(odakDugum == null)
          return null;  
            
             if(odakDugum == null)
          return null;
        }
        
        return odakDugum;
        
    }
      
    class Dugum{
         
    int x,y;
    
    Dugum sagust;
    Dugum solust;
    Dugum solalt;
    Dugum sagalt;
    
    int kose1_x,kose1_y,kose2_x,kose2_y,kose3_x,kose3_y,kose4_x,kose4_y;
    
    Dugum(int x, int y, int kose1_x,int kose1_y,int kose2_x, int kose2_y, int kose3_x, int kose3_y, int kose4_x, int kose4_y){
        this.x=x;
        this.y=y;
        
        this.kose1_x=kose1_x;
        this.kose1_y=kose1_y;
        
         this.kose2_x=kose2_x;
        this.kose2_y=kose2_y;
        
         this.kose3_x=kose3_x;
        this.kose3_y=kose3_y;
        
         this.kose4_x=kose4_x;
        this.kose4_y=kose4_y;
        
    }



}
    
    
   
}
