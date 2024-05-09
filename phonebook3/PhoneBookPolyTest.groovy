package phonebook

class PhoneBookPolyTest {

	static void testPhoneBook(IPhoneBook pbook) {

		println "***Test ${pbook.class} PhoneBook***";

		String[] nameData = ["Park SH", "Kang JH",
			"Kim KS", "Lee YH", "Kang SH","Bae JM",
			"Lee DI", "Lee BH", "Jang WH", "Chun WY"];
		int[] numberData = [5023, 5002, 5008,
			5067, 5038, 5381, 5125, 5165, 5684, 5752];

		for (int i=0; i < nameData.length; ++i){
			pbook.insert(nameData[i], numberData[i]);
		}
		println "List All Inserted Entry";
		pbook.listAll();

		if (!pbook.insert(nameData[9], numberData[9])){
			println "***Error in Insert -- ${nameData[9]} ***";
		};
		if (!pbook.remove("Kim KS")){
			println "***Error in Remove -- Kim KS ***";
		};
		if (!pbook.insert("Kim CS", 5555)){
			println "***Error in Insert -- Kim CS ***";
		};
		if (!pbook.update("Kang JH", 5999)){
			println "***Error in Update -- Kang JH ***";
		};
		println "Find Phone Number By Name -- Kim CS	${pbook.find("Kim CS")}";

		println "***List All Updated Entry";
		pbook.listAll();
		println"���� ��ġ"
		
		if (!pbook.insert("kim dk", 9424)){
			println "***Error in Insert -- kim dk ***";
		};
		if (!pbook.insert("yoon sen", 2536)){
			println "***Error in Insert -- yoon sen ***";
		};
		if (!pbook.insert("park yk", 4435)){
			println "***Error in Insert -- park yk ***";
		};
		if (!pbook.remove("Bae JM")){
			println "***Error in Remove -- Bae JM ***";
		};
		
		if (!pbook.update("Chun WY", 1234)){
			println "***Error in Update -- Chun WY ***";
		};
		println "Find Phone Name By Number -- 5038	${pbook.findbynum(5038)}";
		pbook.listAll();
	}
	static main(args) {
		println"����Ʈ"
		testPhoneBook(new PhoneBookList());
		println"��"
		testPhoneBook(new PhoneBookMap());
		println"���"
		testPhoneBook(new PhoneBooklnArray());
	}

}
