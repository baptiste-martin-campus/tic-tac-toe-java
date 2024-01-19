public class Cell {
    String representation = "|   ";
    public boolean empty = true;

    public String getRepresentation(){
        return representation;
    }

    public void setRepresentation(String representation){
        this.representation = representation;
    }

    public boolean isEmpty(){
        return empty;
    }
    public void setEmpty(boolean empty){
        this.empty = empty;
    }

}
