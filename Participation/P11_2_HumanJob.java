class P11_2_HumanJob {
  public static void main(String [] args) {
    
    Human DanielCui = new Child("Daniel Cui");
    DanielCui.haveParty();
    
    DanielCui = new YoungAdult("Daniel Cui");
    ((YoungAdult) DanielCui).goToWork();
    ((YoungAdult) DanielCui).haveParty();
    
    DanielCui = new Adult("Daniel Cui");
    ((Adult) DanielCui).goToWork();
    ((Adult) DanielCui).haveParty();
    ((Adult) DanielCui).drinkAlcohol();

  }
}

interface CanWork {
  public abstract void goToWork();
}

interface Legal {
  public abstract void drinkAlcohol();
}

abstract class Human {
  private String name;
  
  Human(String name) { this.name = name; }
  
  public String getName() { return this.name; }
  public void setName(String name) { this.name = name; }
  
  public abstract void haveParty();
}

class Child extends Human {
  
  Child (String name) {
    super(name);
  }
  
  public void haveParty() {
    System.out.println("Child" + getName() + "is having a party");
  }
}

class YoungAdult extends Human implements CanWork {
  YoungAdult (String name) {
    super(name);
  }
  
  public void haveParty() {    
    System.out.println("Young Adult" + getName() + "is having a party");
  }
  
  public void goToWork() {
    System.out.println("Young Adult" + getName() + "is going to work");
  }
}

class Adult extends Human implements CanWork, Legal {
  Adult (String name) {
    super(name);
  }
  
  public void haveParty() {    
    System.out.println(" Adult" + getName() + "is having a party");
  }
  
  public void goToWork() {
    System.out.println(" Adult" + getName() + "is going to work");
  }
  
  public void drinkAlcohol() {
    System.out.println("Adult" + getName() + "is ddrinking Alcohol");
  }

} 