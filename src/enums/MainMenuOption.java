package enums;

import exceptions.InvalidMenuOptionExcepiton;

public enum MainMenuOption {
	INIT("i"),
	CLEAR("c"),
	HISTORY("h"),
	QUIT("q");
	
	private final String option;
	
	private MainMenuOption(String option) {
		this.option = option;
	}

	public static MainMenuOption fromOptionLetter(String option) throws InvalidMenuOptionExcepiton {
		for (MainMenuOption mainMenuOption: values()) {
			if(option.equalsIgnoreCase(mainMenuOption.getOption())){
				return mainMenuOption;
			}
		}
		throw new InvalidMenuOptionExcepiton();
	}
	
	public String getOption() {
		return option;
	}
	
}
