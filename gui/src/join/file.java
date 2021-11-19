package join;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Vector;

public class file {
	public static Vector<Vector<String>> users = new Vector<>();
	private static String text = "";

	public static void save() {
		File file = new File("id.txt");
		text = "";
		for (int i = 0; i < users.size(); i++) {
			text += users.get(i).get(0) + "/";
			text += users.get(i).get(1) + "/";
			text += users.get(i).get(2) + "/";
			text += users.get(i).get(3) + "/";
			System.out.println(users.get(i).get(0));
			text += "\n";
		}

		try {
			FileWriter fw = new FileWriter(file);
			fw.write(text);
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void load() {
		text = "";
		users.clear();
		FileReader fr = null;
		BufferedReader br = null;
		try {
			File file = new File("id.txt");
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String data = "";
			while (data != null) {
				data = br.readLine();
				if (data != null) {
					text += data;
					text += "\n";
				}
			}
			if (text != null) {

				String arr[] = text.split("\n");
				for (int i = 0; i < arr.length; i++) {
					String arr2[] = arr[i].split("/");
					users.add(new Vector<String>());
					users.get(i).add(arr2[0]);
					users.get(i).add(arr2[1]);
					users.get(i).add(arr2[2]);
					users.get(i).add(arr2[3]);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
