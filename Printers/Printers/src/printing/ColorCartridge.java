package printing;

public class ColorCartridge implements ICartridge {
	int percentage = 7;
	String percentString = percentage + "%";
	@Override
	public String toString(){
		return "Color!";
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