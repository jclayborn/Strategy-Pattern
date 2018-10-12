package printing;

public class BWCartridge implements ICartridge {
	
	int percentage = 10;
	String percentString = percentage + "%";
	
	@Override
	public String toString(){
		return "Black and White!";
	}
	
	@Override 
	public String getFillPercentage(){
		return percentString;
	}
	
	@Override
	public void useInk(){
		percentage--;
	}
	
	@Override
	public boolean emptyInk(){
		return percentage == 0;
	}
	
    @Override
    public String addInk(int inkToAdd){
        percentage += inkToAdd;
        return "Thanks for refilling the cartridge!"
    }
}
