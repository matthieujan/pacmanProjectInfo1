package logic;
/**
 * A map containing items
 */
 public class Map {

   private char[][] map;

   public Map(String filename) {
     map = new char[10][10];
     String line;
     LineFileReader.open(filename);
     for (int i=0; i<10; i++) {
       line = LineFileReader.readLine();
       for (int j=0; j<10; j++) {
         map[i][j] = line.charAt(j);
         System.out.print(map[i][j]); // pour verifier si le fichier est lu correctement
       }
       System.out.println("");
     }
   }
 }
