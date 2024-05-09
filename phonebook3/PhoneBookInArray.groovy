package phonebook

class PhoneBooklnArray implements IPhoneBook
{
	private Entry[] arrayPhoneBook;
	private int lastp;
	private final int maxentry=100;
	
	PhoneBooklnArray(){
		arrayPhoneBook=new Entry[maxentry];
		lastp=0;
	}
	public int findLoc(String name){
		for (int i=0; i<lastp; ++i){
			if (arrayPhoneBook[i].phoneName == name)
				return i;
		}
		return -1; // not found
	}
	public int findLoc(int number){
		for (int i=0; i<lastp; ++i){
			if (arrayPhoneBook[i].phoneNumber == number)
				return i;
		}
		return -1; // not found
	}
	public int find(String name){
		int loc = findLoc(name);
		if (loc == -1)
			return -1; // not found
		return arrayPhoneBook[loc].phoneNumber;
	}
	public String findbynum(int number) {
		int loc=findLoc(number);
		
		return arrayPhoneBook[loc].phoneName;
	}
	
	public int findPhoneNumber(String name){
		int loc = findLoc(name);
		if (loc == -1)
			return -1; // not found
		return arrayPhoneBook[loc].phoneNumber;
	}
	public boolean insert(String name, int number){
		int loc = findLoc(name);
		if (loc == -1){ // insert
			if (lastp >= maxentry){
				println "***Error -- PhoneBook Overflow";
				return false;
			}
			else {
				arrayPhoneBook[lastp] = new Entry(name, number);
				lastp++;
				return true;
			}
		}
		else {
			println "***Error -- Duplicated Name";
			return false;
		}
	}
	public boolean remove(String name){
		int loc = findLoc(name);
		if (loc != -1){ // there exist name
			// remove array entry at loc
			for (int i=loc+1; i<lastp; ++i){
				//arrayPhoneBook[i-1].phoneName = arrayPhoneBook[i].phoneName;
				//arrayPhoneBook[i-1].phoneNumber = arrayPhoneBook[i].phoneNumber;
				arrayPhoneBook[i-1] = arrayPhoneBook[i]
			}
			lastp--;
		}
		else {
			return false;
		}
	}
	public boolean update(String name, int number){
		int loc = findLoc(name);
		if(loc!=-1)
		{
			arrayPhoneBook[loc].phoneName=name;
			arrayPhoneBook[loc].phoneNumber=number;
			return true;
		}
		return false;
	}
	void listAll(){
		println "Name\tNumber";
		for (int i=0; i<lastp; ++i){
			println "${i}\t${arrayPhoneBook[i].phoneName}\t" +
					"${arrayPhoneBook[i].phoneNumber}"
		}
	}
}


// main
int incount = 10;
for (int i=0; i < incount; ++i){
	insert(nameData[i], numberData[i]);
}
println "List All Inserted Entry";
listAll();

remove("Kim KS");
insert("Kim CS", 5555);
update("Kang JH", 5999);
println "Find Phone Number By Name -- Kim CS	" +
		"${find("Kim CS").phoneNumber}";

println "List All Updated Entry";
listAll();
