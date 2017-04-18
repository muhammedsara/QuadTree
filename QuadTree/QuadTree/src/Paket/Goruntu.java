
package Paket;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.PopupMenu;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *Bu classda tüm görüntü işlemleri yapıldı, arama cizgileri noktalrı cizildi, 
 * butuon clik olayları, text veri alam combobax işlemleri yapıldı. Renklendirme işlemleri aypıldı
 * @author sara
 */
public class Goruntu extends javax.swing.JFrame {
     static QuadTree.Dugum dugumyedek;
     QuadTree quadtree=new QuadTree();
    static int x_tut, y_tut;
    
    static int cemberx;
    static int cembery;
    
    static boolean arama=false;
    
    static boolean modarama=false;
    static Color[] renkler=new Color[1000];

    /**
     *Graphics işlemlerini kullanmak için oluşturuldu.
     */
    public Graphics gor;
    
    Tiklanma point;
    private Object g;
    private PopupMenu clear;

    /**
     *Constructor tanımlandı rast gele renk atama 
     * işlemlerinin yapılması için, mause olayları ve nokta işlemlerinin 
     * yapılması için
     */
    public Goruntu() {
        
        
        for(int i=0;i<1000;i++)
        {
        renkler[i]=new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
        
        }
       
        initComponents();
        point= new Tiklanma(this);
        quadtree_panel.addMouseListener(point);
        
        
        
    }

  

    
  public void paint(Graphics g) {
        super.paint(g); 
        String[] liste = new String[100];
        
        
        String tut ="";
    
        
         for(int i=0;i<QuadTree.dizi_sayac;i++){
             String koordinat_yaz=null;
             koordinat_yaz=("("+QuadTree.dizix[i]+" , "+QuadTree.diziy[i]+")");
              g.setColor(renkler[i*2]); 
              g.drawString(koordinat_yaz, QuadTree.dizix[i]+20, QuadTree.diziy[i]+70);
             g.fillOval(QuadTree.dizix[i]+14-5,QuadTree.diziy[i]+76-5, 10, 10);
         }
         int a;
         a=QuadTree.linessayac;
         
         for(int j=0; j<=a; j+=2){
             g.setColor(renkler[j]);
             g.drawLine(QuadTree.x1_dizi[j]+14, QuadTree.y1_dizi[j]+76, QuadTree.x2_dizi[j]+14, QuadTree.y2_dizi[j]+76);
             g.drawLine(QuadTree.x3_dizi[j+1]+14, QuadTree.y3_dizi[j+1]+76, QuadTree.x4_dizi[j+1]+14, QuadTree.y4_dizi[j+1]+76);
         }
         
        
           if(arama)
       {
           g.setColor(Color.blue);
           String text_rnd = al_txt1.getText();
           int sayi = (Integer.parseInt(text_rnd));
           
           g.drawOval(cemberx+14-sayi/2, cembery+76-sayi/2, sayi, sayi);
           System.out.println("------------>aranılan nokta = "+cemberx+" "+cembery);
          arama=false;
          int l=0;
          
          int bul=0,r_int=0,yaz_Say=0;
           
            for(int i=cemberx-sayi/2; i<=cemberx+sayi/2; i++){
                
            for (int j=cembery-sayi/2; j<=cembery+sayi/2; j++){
                
                dugumyedek= quadtree.Ara_Dugum(i, j);
        if(dugumyedek!=null){
            
           
        System.out.println("bulunan nokta-> "+dugumyedek.x+"-"+dugumyedek.y+" ------>");
        
        //list_txt.setText(dugumyedek.x+","+dugumyedek.y+" \n");
        
        //liste[l]=(dugumyedek.x+","+dugumyedek.y+" ");
       
        bul=(int) Math.sqrt(Math.pow((cemberx-i),2)+Math.pow((cembery-j),2));
            System.out.println("i>>"+i+"j>>"+j+"cemberx"+cemberx+"cembery"+cembery+"hesaplanan yaricap"+bul);
        
         r_int=Integer.parseInt(al_txt1.getText())/2;
        if(bul<=r_int) {
            yaz_Say++;
            tut=(yaz_Say+". ("+dugumyedek.x+" , "+dugumyedek.y+") \n ");
            g.setColor(Color.red);
            g.drawLine(QuadTree.x1_dizi[j]+14, QuadTree.y1_dizi[j]+76, QuadTree.x2_dizi[j]+14, QuadTree.y2_dizi[j]+76);
             g.drawLine(QuadTree.x3_dizi[j+1]+14, QuadTree.y3_dizi[j+1]+76, QuadTree.x4_dizi[j+1]+14, QuadTree.y4_dizi[j+1]+76);
            g.fillOval(i+14-5,j+76-5, 10, 10);
            
            list1.add(tut);
            l=l+1;
                    } 
        
         
        }
            }
            }
            list1.add("-----------------");
           
          ara_bulunan.setText(l+" Bulunan");
            System.out.println("sorgudaki nokta sayisi=> "+l);
           /* for(int s=0; s<l; s++){
                 tut=tut+(liste[s]+"\n");
                 
                
            }list_txt.setText(tut);*/
                System.out.println("ss>>"+tut);
       
       }
        
    }
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        quadtree_panel = new javax.swing.JPanel();
        konrol_panel = new javax.swing.JPanel();
        al_txt1 = new javax.swing.JTextField();
        reset_btn = new javax.swing.JButton();
        islem_combo = new javax.swing.JComboBox();
        list1 = new java.awt.List();
        jLabel2 = new javax.swing.JLabel();
        list_btn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        ara_bulunan = new javax.swing.JLabel();
        liste_panel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MUHAMMED ŞARA  © ");
        setBackground(new java.awt.Color(0, 255, 153));

        quadtree_panel.setBackground(new java.awt.Color(204, 204, 204));
        quadtree_panel.setPreferredSize(new java.awt.Dimension(512, 512));

        javax.swing.GroupLayout quadtree_panelLayout = new javax.swing.GroupLayout(quadtree_panel);
        quadtree_panel.setLayout(quadtree_panelLayout);
        quadtree_panelLayout.setHorizontalGroup(
            quadtree_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 512, Short.MAX_VALUE)
        );
        quadtree_panelLayout.setVerticalGroup(
            quadtree_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        konrol_panel.setBackground(new java.awt.Color(153, 153, 153));

        al_txt1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        al_txt1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        al_txt1.setText("0");

        reset_btn.setBackground(new java.awt.Color(255, 102, 102));
        reset_btn.setFont(new java.awt.Font("Trebuchet MS", 3, 14)); // NOI18N
        reset_btn.setText("RESET");
        reset_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_btnActionPerformed(evt);
            }
        });

        islem_combo.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        islem_combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seçim Yapınız", "Arama Yap", "Rastgele Nokta Ata", " " }));
        islem_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                islem_comboActionPerformed(evt);
            }
        });

        list1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        list1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                list1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Aranan Noktalar");

        list_btn.setBackground(new java.awt.Color(51, 51, 51));
        list_btn.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        list_btn.setForeground(new java.awt.Color(204, 255, 255));
        list_btn.setText("Temizle");
        list_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                list_btnActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel4.setText("Kontrol Paneli");

        ara_bulunan.setText("0 Bulunan");

        javax.swing.GroupLayout konrol_panelLayout = new javax.swing.GroupLayout(konrol_panel);
        konrol_panel.setLayout(konrol_panelLayout);
        konrol_panelLayout.setHorizontalGroup(
            konrol_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(konrol_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(konrol_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(konrol_panelLayout.createSequentialGroup()
                        .addGroup(konrol_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(al_txt1)
                            .addComponent(reset_btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(islem_combo, 0, 153, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, konrol_panelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(konrol_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(konrol_panelLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(list_btn))
                            .addComponent(list1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, konrol_panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(konrol_panelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(ara_bulunan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        konrol_panelLayout.setVerticalGroup(
            konrol_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(konrol_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(10, 10, 10)
                .addComponent(al_txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(islem_combo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reset_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ara_bulunan)
                .addGap(2, 2, 2)
                .addComponent(list1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(list_btn)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        liste_panel.setBackground(new java.awt.Color(153, 153, 153));

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 255, 255));
        jLabel3.setText("MUHAMMED ŞARA  150201123  ProLab2");

        javax.swing.GroupLayout liste_panelLayout = new javax.swing.GroupLayout(liste_panel);
        liste_panel.setLayout(liste_panelLayout);
        liste_panelLayout.setHorizontalGroup(
            liste_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, liste_panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
        );
        liste_panelLayout.setVerticalGroup(
            liste_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(liste_panelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel1.setBackground(new java.awt.Color(255, 255, 153));
        jLabel1.setFont(new java.awt.Font("Monotype Corsiva", 1, 18)); // NOI18N
        jLabel1.setText("         Quadtree ile Mouse Tiklamalarinin Modellenmesi ve Dairesel Aralik Sorgulama");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(liste_panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(quadtree_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(konrol_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(konrol_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(quadtree_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(liste_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reset_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_btnActionPerformed
       
    quadtree.reset();
    al_txt1.setText("0");
    ara_bulunan.setText("0 Bulunan");
    
   
    list1.clear();
    
        repaint();
    }//GEN-LAST:event_reset_btnActionPerformed

    private void islem_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_islem_comboActionPerformed
        //int getSelectedIndex( )   
    String a=islem_combo.getSelectedItem().toString();
    
      if(a=="Arama Yap"){
          String text_rnd = al_txt1.getText();
           int sayi = Integer.parseInt(text_rnd);
           
           if(sayi>=0 && sayi<=560){
           modarama=true;
           }
           else{
            JOptionPane.showMessageDialog(new JFrame(), "0 ile 560 arası sayı giriniz", "Dialog",
        JOptionPane.ERROR_MESSAGE);
            al_txt1.setText("0");
        }
          
    }
    else if(a=="Rastgele Nokta Ata"){
        
        
        String text_rnd = al_txt1.getText();
        int sayi = Integer.parseInt(text_rnd);
        if(sayi>=0 && sayi<=560){
            
            for(int i=0; i<sayi; i++){
             int X = (int) (Math.random( )*512);
             int Y = (int) (Math.random( )*512);
            quadtree.Ekle_Dugum(X, Y);
        }
        repaint();    
        }
        else{
            JOptionPane.showMessageDialog(new JFrame(), "0 ile 560 arası sayı giriniz", "Dialog",
        JOptionPane.ERROR_MESSAGE);
            al_txt1.setText("0");
        }
        
        
        modarama=false;
    }
    else if(a=="Seçim Yapınız"){
        
         modarama=false;
    }
       
        

  
// TODO add your handling code here:
    }//GEN-LAST:event_islem_comboActionPerformed

    private void list_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list_btnActionPerformed
       
 list1.clear();   
 ara_bulunan.setText("0 Bulunan");// TODO add your handling code here:
    }//GEN-LAST:event_list_btnActionPerformed

    private void list1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_list1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField al_txt1;
    private javax.swing.JLabel ara_bulunan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox islem_combo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel konrol_panel;
    private java.awt.List list1;
    private javax.swing.JButton list_btn;
    private javax.swing.JPanel liste_panel;
    private javax.swing.JPanel quadtree_panel;
    private javax.swing.JButton reset_btn;
    // End of variables declaration//GEN-END:variables

    private void jTextArea2(String tut) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
