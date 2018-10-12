package printers;

import printing.ColorCartridge;
import printing.BWCartridge;
import printing.Printer;

public class MyPrinter {
	public static void main(String[] arg){
		
		Printer<ColorCartridge> myPrinter = new Printer<ColorCartridge>(true, "MY PRINTER", new ColorCartridge());
		
		myPrinter.loadPaper(12);
		myPrinter.print(8);
		myPrinter.switchCartridge(new BWCartridge(), "Cartridge switched!");
		myPrinter.print(11);
		myPrinter.addInk(12);
	}
}
