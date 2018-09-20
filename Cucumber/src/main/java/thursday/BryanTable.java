package thursday;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

import org.openqa.selenium.WebElement;

public class BryanTable {

	public BryanTable(List<WebElement> paras, int columns) {
		HashMap<Integer, List<WebElement>> hashMap = new HashMap<Integer, List<WebElement>>();
		IntStream.range(0, columns).forEach(columnNum -> {
			int column = columnNum;
			List<WebElement> row = new LinkedList<WebElement>();
			for(int i = 1;i<columns;column *=i) {
				row.add(paras.get(column));
			}
			hashMap.put(columnNum, row);
			
		});
	}

}
