
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;


public class Play {

	public static void main(String[] args) throws IOException {
		int start = 375;
		int end = 376;
		for (int i = start; i < end; i++) {
			String name = PMName.eng[i];
			String url = "https://wiki.52poke.com/wiki/" + name;
			Document doc = Jsoup.connect(url).get();
			//System.out.println(doc);
			Elements tabs = doc.select("table[class^=roundy at-c a-r]");
			if (tabs.size() == 0) {
				// only one table we wanted exists
				System.out.println("pokemon #" + (i + 1) + " " + PMName.chs[i] + " : only one table we wanted exists.");
				//Elements tables = doc.select("table[class^=roundy a-r at-c]");
			}
			else {
				// pokemon may have different forms
				// so figure out how many tabs are there
				Elements th = tabs.select("th");
				Elements hide = tabs.select("tr[class=hide]");
				System.out.println("pokemon #" + (i + 1) + " " + PMName.chs[i] + " : multiple tabs (" + (th.size() - hide.size() - 1) + " tabs) are active.");
			}
		}
	}

}
