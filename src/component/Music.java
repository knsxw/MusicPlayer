
package component;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import org.bson.Document;


public class Music extends javax.swing.JPanel {
    
    public Music() {
        initComponents();
        init();
    }
    private String path;
    public static boolean isPlaying = false;
    public static Player player;
    
    private void init() {
        
        MongoClientURI uri = new MongoClientURI("mongodb://root:byteburst@freaks.dev/?authSource=admin");
        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase db = mongoClient.getDatabase("audioDatabase");
        MongoCollection<org.bson.Document> songs = db.getCollection("songs");
        ArrayList songList = db.getCollection("songs").find().into(new ArrayList());
        int i = 1;
        FindIterable<Document> results = songs.find();
        for (Document doc : results) {
            list.addItem(new ModelMusic(""+(i++), doc.getString("title"),doc.getString("duration")));
        }
        list.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                if(SwingUtilities.isLeftMouseButton(e)) {
                    ListMusic.playIndex = list.locationToIndex(e.getPoint());
                    repaint();
                    Document selectedSong = (Document) songList.get(ListMusic.playIndex);
                    System.out.println(selectedSong.getString("song_url"));
                    new Thread() {
                        @Override
                        public void run() {
                            path = System.getProperty("java.io.tmpdir") + ListMusic.playIndex +".mp3";
                            File file = new File(path);
                            try {
                            if (file.isFile()){
                            } else {
                                path = downloadSong(selectedSong.getString("song_url"),ListMusic.playIndex +".mp3");
                            }
                            System.out.println(path);
                            playSong(path);
                            System.out.println("play");
                            } catch (IOException | JavaLayerException ex) {
                            Logger.getLogger(Music.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }.start();
                    
                }
            }
        });
    }
    
    public static String downloadSong(String url, String localFilename) throws IOException {
        InputStream is = null;
        FileOutputStream fos = null;
        String tempDir = System.getProperty("java.io.tmpdir");
        String outputPath = tempDir + localFilename;
        try {
            URLConnection urlConn = new URL(url).openConnection();
            is = urlConn.getInputStream();
            fos = new FileOutputStream(outputPath);
            byte[] buffer = new byte[4096];
            int length;
            while ((length = is.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
            return outputPath;
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } finally {
                if (fos != null) {
                    fos.close();
                }
            }
        }
    }
    
    public static void playSong(String filepath) throws FileNotFoundException, JavaLayerException {
        FileInputStream fis = new FileInputStream(filepath);
        BufferedInputStream bis = new BufferedInputStream(fis);
        player = new Player(bis);
        player.play();
        isPlaying = true;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        list = new component.ListMusic<>();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Most Trending Music");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(90, Short.MAX_VALUE))
            .addComponent(list, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(list, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private component.ListMusic<String> list;
    // End of variables declaration//GEN-END:variables
}
