package printing;

public class Printer<T extends ICartridge> implements IMachine{
	
	private String modelNumber;	
	private PaperTray paperTray = new PaperTray();
	private Machine machine;
	private T cartridge;
	
	public Printer(boolean isOn, String modelNumber, T cartridge){
		machine = new Machine(isOn);
		this.modelNumber = modelNumber;
		this.cartridge = cartridge;
	}
	
	@Override
	public void TurnOn(){
		System.out.println("Warming up printer");
		machine.TurnOn();
	}

	@Override
	public void TurnOff() {
		machine.TurnOff();
	}
	
	public <U extends ICartridge> void switchCartridge(U cartridge, String message){
		System.out.println(cartridge.toString());
		System.out.println(message);
		System.out.println(cartridge.getFillPercentage());
		this.cartridge = (T) cartridge;
	}
	
	public void print(int copies){
		System.out.println(cartridge.toString());
		System.out.println(cartridge.getFillPercentage());
		
		String onStatus = "is Off!";
		if(machine.isOn()){
			onStatus = " is On!";
		}

		String textToPrint = modelNumber + onStatus;
		
		while (copies > 0 && !paperTray.isEmpty() && !cartridge.emptyInk()){
			System.out.println(textToPrint);
			copies--;
			paperTray.usePage();
			cartridge.useInk();
		}
		
		if(paperTray.isEmpty()){
			System.out.println("Load more paper!");
		}
		
		if(cartridge.emptyInk()){
			System.out.println("Change cartridge! Out of ink!");
		}
	}

	
	public String getModelNumber(){
		return modelNumber;
	}

	public void loadPaper(int count) {
		paperTray.addPaper(count);
	}

	@Override
	public boolean isOn() {
		return machine.isOn();
	}
}