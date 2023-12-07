import java.util.*;

class Lab6_GameLevel {
  
  static Scanner s = new Scanner(System.in);
  
  public static void main(String[] args) {
  
  }
  
}

abstract class Room {
  
  private String name;
  private boolean unlocked;
  private String[] validActions;
  
  private Room nextRoom = null;
  private Room previousRoom = null;

  public Room(String name, boolean unlocked, String[] validActions) {
    this.name = name;
    this.unlocked = false;
    this.validActions = validActions;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isUnlocked() {
    return unlocked;
  }

  public void setUnlocked(boolean unlocked) {
    this.unlocked = unlocked;
  }

  public String[] getValidActions() {
    return validActions;
  }
  
  public Room getNextRoom() {
    return this.nextRoom;
  }

  
  public void setNextRoom(Room nextRoom) {
    this.nextRoom = nextRoom;

  }

  public Room getPreviousRoom() {
    return previousRoom;
  }

  public void setPreviousRoom(Room previousRoom) {
    this.previousRoom = previousRoom;
  }
  
  

  public abstract void displayRoom();
}

class PuzzleRoom extends Room {
  
  private String question;
  private int answer;
  
  PuzzleRoom(String name, boolean unlocked, String question, int answer) {
    super(name, unlocked, new String[]{"next", "prev"});
    this.question = question;
    this.answer = answer;
  }
 
  public String getQuestion() {
    return question;
  }
  
  public int getAnswer() {
    return answer;
  }
  
  public boolean tryUnlockRoom(int userAnswer) {
    
    if(userAnswer == answer){
      this.setUnlocked(true);
      System.out.println("Congraduation! You solved the puzzle and unlocked the room!");
      return true;
    }
    return false;
  }

  
  
  public void displayRoom() {
    
    System.out.println("You are in a room: " + getName());
    System.out.println("Valid Actions are " + Arrays.toString(getValidActions()));
    
  }
}

class SpawnRoom extends Room {
  SpawnRoom(String name, boolean unlocked) {
    super(name, unlocked, new String[]{"next"});
  }
  
  public void displayRoom() {
    System.out.println("You are in a room: " + getName());
    System.out.println("Valid Actions are " + Arrays.toString(getValidActions()));
  }  
}

class GoalRoom extends Room {
  
  GoalRoom(String name, boolean unlocked) {
    super(name,unlocked,new String[]{"prev", "exit"});
  }
  
  public void displayRoom() {
    System.out.println("You are in a room: " + getName());
    System.out.println("Valid Actions are " + Arrays.toString(getValidActions()));
  }
  
  
}