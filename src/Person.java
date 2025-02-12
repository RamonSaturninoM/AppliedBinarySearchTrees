public class Person implements Comparable<Person>{
    String name;
    String address;
    String phone;
    
    public Person(String name, String address, String phone){
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    
    @Override
    public int compareTo(Person other){
        return this.name.compareToIgnoreCase(other.name);
    }
    
    @Override
    public String toString(){
        return String.format("%-20s %-30s %-15s", name, address, phone);
    }
    
    
}
