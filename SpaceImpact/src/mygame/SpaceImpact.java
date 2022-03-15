
package mygame;

import player.Player;
import enemy.CreepControl;
import graphics.Canvas;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import shell.ShellControl;


public class SpaceImpact extends JFrame implements KeyListener{

    private char lastChar = 0;
    
    public static final int HEIGHT = 565;
    public static final int WIDTH = 800;
    
    private Canvas canvas;
    private Player player;
    private CreepControl creepControl;
    private ShellControl shellControl;
//    private HighScore highscore;
    
    private List<SpaceObject> enemyList;
    private List<SpaceObject> shellList;
    private Random random;
    
    private Timer timer;
    public static int score;
    private boolean kill;
    
    public static String name;//toplistában szereplő név
    public static Map<Integer, String> map = new TreeMap<Integer, String>();

    public void setKill(boolean killl) {
        this.kill = killl;
    }
    public HighScorePlayer hg;
    public SpaceImpact(){
        
       
        
        
        kill = false;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH,HEIGHT + 35);
        
        enemyList = new LinkedList<>();
        shellList = new LinkedList<>();

        player = new Player(0, 160, 1, 2);
        random = new Random(40);
        score=0;
        
        shellControl = new ShellControl(shellList,player);
        creepControl = new CreepControl(enemyList,random);
        
        canvas = new Canvas( Arrays.asList( player ),shellList,enemyList, score);
//        highscore = new HighScore(score,name);
        hg = new HighScorePlayer(name, score);
        
        getContentPane().add(canvas);
        
        setVisible(true);
        setLocationRelativeTo(null);
        addKeyListener(this);
        
        startTimer();
    }

    
    

    public void startTimer(){        
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            hg.filemaker();    
            if (kill) {
            timer.stop();
            return;
            }
                canvas.setSzoveg(score);
                SpaceImpact.this.repaint();
                removeObjectsWithCollide();
                if(!creepControl.update() || isCollideWithPlayer() ) {
                    timer.stop();
                    nevbeker();
                }
                creepControl.updateCreeps();
                shellControl.update();  
            } 
        };
        timer = new Timer(10,al);
        timer.start();        
        this.repaint();
    }
    
    public void nevbeker(){
     String string;   
    JFrame frame = new JFrame("textfield");
    JPanel jp = new JPanel();
    frame.setSize(200,100);
    JTextField textfield = new JTextField(9);
    JLabel jl = new JLabel("Kérem adja meg a nevét!");
    JButton jb = new JButton("Ment");
    jb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                name = textfield.getText().toString();
                removeDiacritics(name);
                frame.setVisible(false);
                setVisible(false);
                hg.Open();
            }
    });
    jp.add(jl);
    jp.add(textfield);
    jp.add(jb);
    frame.add(jp);
    frame.setVisible(true);
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();//középre jelenik meg
    int jfrrameWidth = frame.getSize().width;
    int jfrrameHeight = frame.getSize().height;
    int locationX = (dim.width-jfrrameWidth)/2;
    int locationY = (dim.height-jfrrameHeight)/2;
    frame.setLocation(locationX,locationY);
    }//nevbeker()
    
    
    public static String removeDiacritics(String input)//ékezetkezelő
    {
    String nrml = Normalizer.normalize(input, Normalizer.Form.NFD);
    StringBuilder stripped = new StringBuilder();
    for (int i=0;i<nrml.length();++i)
    {
        if (Character.getType(nrml.charAt(i)) != Character.NON_SPACING_MARK)
        {
            stripped.append(nrml.charAt(i));
        }
    }
    return stripped.toString();
    }

    public boolean isCollideWithPlayer(){//collide ütközik
        for (int i = 0; i < enemyList.size(); i++) {
                if (enemyList.get(i).isCollision(player))  {
                    return true;
                }
        }
        return false;
    }
  
    public void removeObjectsWithCollide(){//ütközésnél törlünk
        for (int i = 0; i < enemyList.size(); i++) {
            for (int j = 0; j < shellList.size(); j++) {
                if (enemyList.get(i).isCollision(shellList.get(j)) ) { /////????;
                    enemyList.remove(i);//ellenfél eltünik
                    shellList.remove(j);//lövedék eltünik
                    score++;
                    break;
                }

            }
        }
    }
    
        public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                new SpaceImpact();
            }    
        });  
        }//main

    long timeLastShot = 0;
    long delay = 200;
    
    @Override
    public void keyTyped(KeyEvent e) {
                    switch(e.getKeyChar()){
                case 'w':
                    player.moveUp(15);
                    break;
                case 's':
                    player.moveDown(15);
                    break;
                case ' ': 
                    if (System.currentTimeMillis() - timeLastShot >= delay) {
                    shellControl.addShell();
                    timeLastShot = System.currentTimeMillis();
                    }
                    break;
        }            
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent ke) {
         
    }

}
