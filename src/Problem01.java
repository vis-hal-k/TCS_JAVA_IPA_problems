import java.lang.reflect.Array;
import java.util.* ;
public class Problem01 {
    public static void main(String[] args){
        Player[] player = new Player[4] ;
        System.out.println(player.length);
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < player.length; i++) {
            int playerId = sc.nextInt();
            sc.nextLine();  // Consume the remaining
            String playerName = sc.nextLine();
            int runs = sc.nextInt();
            sc.nextLine();  // Consume the remaining newline
            String playerType = sc.nextLine();
            String matchType = sc.nextLine();
            player[i] = new Player(playerId, playerName, runs, playerType, matchType);
        }
        String inpCatPlayerType = sc.nextLine() ;
        String inpCatMatchType = sc.nextLine() ;
        sc.close() ;
        int leastRun =  findPlayerWithLowestRuns(player, inpCatPlayerType) ;
        ArrayList<Integer> PlayerIdDesc = findPlayerByMatchType(player,inpCatMatchType) ;
        if(leastRun == 1000)
            System.out.println("No such Player");
        else
            System.out.println("Minimum Runs a/q to question is = " + leastRun);
//        For second part of the problem.
        if (PlayerIdDesc.isEmpty()) {
            System.out.println("No such player of the matchType");
        }
        else{
            for(int ele : PlayerIdDesc){
                System.out.println(ele);
            }
        }

    }
    public static int findPlayerWithLowestRuns(Player[] player, String category){
        int miniRun = 1000 ;
        int ans ;
        for(int i = 0 ; i < player.length ; i++) {
            if(miniRun >= player[i].getRun() && player[i].getPlayerType().equals(category))
                miniRun = player[i].getRun() ;
        }
        return miniRun ;
    }
    public static ArrayList<Integer> findPlayerByMatchType(Player[] player , String category) {
//    basically write the code for sorting
        ArrayList<Integer> arr = new ArrayList<>() ;
        for(Player play:player){
            if(play.getMatchType().equalsIgnoreCase(category)){
                arr.add(play.getPlayerID()) ;
            }
        }
        if(arr.isEmpty()) return arr ;
        Collections.sort(arr, Collections.reverseOrder()) ;
//        Collections.reverse(arr);
        return arr ;
    }
}

class Player {
    private int playerId;
    private String playerName;
    private int runs;
    private String playerType;
    private String matchType;

    public int getPlayerID() {
        return playerId;
    }

    public void setPlayerID(int playerId) {
        this.playerId = playerId;
    }
    public String getPlayerName(){
        return playerName;
    }
    public void setPlayerName (String playerName) {
        this.playerName = playerName;
    }
    public int getRun(){
        return runs ;
    }
    public void setRun(int runs) {
        this.runs = runs ;
    }
    public String getPlayerType() {
        return playerType;
    }
    public void setPlayerType (String playerType) {
        this.playerType = playerType;
    }
    public String getMatchType(){
        return matchType;
    }
    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }
    public Player (int playerId, String playerName, int runs , String playerType, String matchType) {
        super();
        this.playerId = playerId;
        this.playerName = playerName;
        this.runs = runs;
        this.playerType = playerType;
        this.matchType = matchType;
    }
}