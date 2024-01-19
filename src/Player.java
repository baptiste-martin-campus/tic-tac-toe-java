public abstract class Player {
    public String representation = "| O ";

    public String getRepresentation(){
        return representation;
    }

    public void setRepresentation(String representation){
        this.representation = representation;
    }

    protected Player(String representation) {
        this.representation = representation;
    }

}
