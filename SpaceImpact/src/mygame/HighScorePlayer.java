
package mygame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HighScorePlayer {
    
    public String playert;
    public int scoret;
    HighScorePlayer[] hgsc = new HighScorePlayer[10];

    public HighScorePlayer(String playert, int scoret) {
        this.playert = playert;
        this.scoret = scoret;
    }

    @Override
    public String toString() {
        return playert + scoret;
    }
    
    
    
   public void sort(HighScorePlayer[] highscore)
    {

        int i = 8;

            while (highscore[i + 1].scoret > highscore[i].scoret && i != 0)//9 > 8
            {
                HighScorePlayer seged = highscore[i + 1];//seged = 9
                highscore[i + 1] = highscore[i];//9 = 8
                highscore[i] = seged;// 8 = 9
                i--;
            }
            if(highscore[1].scoret > highscore[0].scoret){
                HighScorePlayer seged = highscore[1];//seged = 9
                highscore[1] = highscore[0];//9 = 8
                highscore[0] = seged;
            }
   
    }

    public HighScorePlayer[] filemaker(){
        HighScorePlayer[] highscore = new HighScorePlayer[10];
        
        File f = new File("Highscore.txt");
        String fileoutput = "";
        if (!f.exists()) {

            try {
                FileWriter fw = new FileWriter("Highscore.txt");
                highscore[0] = new HighScorePlayer("Béla", 10);
                highscore[1] = new HighScorePlayer("Réka", 9);
                highscore[2] = new HighScorePlayer("Kati", 8);
                highscore[3] = new HighScorePlayer("aaaa", 7);
                highscore[4] = new HighScorePlayer("bbbb", 6);
                highscore[5] = new HighScorePlayer("asd", 5);
                highscore[6] = new HighScorePlayer("Elemér", 4);
                highscore[7] = new HighScorePlayer("Józsi", 3);
                highscore[8] = new HighScorePlayer("Nóri", 2);
                highscore[9] = new HighScorePlayer("Géza", 1);
                
                for (int i = 0; i < highscore.length; i++) {
                    fileoutput += highscore[i].playert+"&"+highscore[i].scoret+"\n";
                }
                fw.write(fileoutput);
                fw.close();
                
            } catch (IOException ex) {
                Logger.getLogger(HighScorePlayer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return highscore;
    }
    
        public HighScorePlayer[] Open()
    {

        String fileoutput2 = "";

            String input;
            
            try {
                Scanner sc = new Scanner(new File("HighScore.txt"));
                int i = 0;
                while(sc.hasNextLine()){
                    input = sc.nextLine();
                    String [] parts = input.split("&");
                    HighScorePlayer uj1 = new HighScorePlayer(playert, scoret);
                    uj1.playert = parts[0];
                    uj1.scoret = Integer.parseInt(parts[1]);
                    hgsc[i] = uj1;
                    i++;
                    
                }
                change();
                sort(hgsc);//sorbarendezés

            } catch (FileNotFoundException ex) {
                Logger.getLogger(HighScorePlayer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                FileWriter fw2;
                try {
                    fw2 = new FileWriter("HighScore.txt");
                        for (int j = 0; j < hgsc.length; j++) {
                            fileoutput2 += hgsc[j].playert+"&"+hgsc[j].scoret+"\n";
                        }
                    fw2.write(fileoutput2);
                    fw2.close();
                } catch (IOException ex) {
                    Logger.getLogger(HighScorePlayer.class.getName()).log(Level.SEVERE, null, ex);
                }
          return hgsc;
    }
        public void change(){
                if(hgsc[9].scoret < SpaceImpact.score){
                  HighScorePlayer uj = new HighScorePlayer(playert, scoret);
                    uj.playert = SpaceImpact.name;
                    uj.scoret = SpaceImpact.score;
                    hgsc[9] = uj;

                }
        }

}
