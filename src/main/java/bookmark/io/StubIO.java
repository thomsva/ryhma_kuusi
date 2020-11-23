
package bookmark.io;

import java.util.ArrayList;
import java.util.List;

public class StubIO implements IO {

    private List<String> lines;
    private int i;
    private ArrayList<String> prints;

    public StubIO(List<String> values) {
        this.lines = values;
        prints = new ArrayList<>();
    }
    
    /**
     * adds string to a list for printing
     */
    @Override
    public void print(String toPrint) {
        prints.add(toPrint);
    }
    
    /**
     * reads integer value from the added lines
     */
    @Override
    public int readInt(String prompt) {
        print(prompt);
        return Integer.parseInt(lines.get(i++));
    }

    /**
     * returns a list of string sent for printing
     */
    public ArrayList<String> getPrints() {
        return prints;
    }
    
    /**
     * reads the lines added for printing
     */
    @Override
    public String readLine(String prompt) {
        print(prompt);
        if (i < lines.size()) {
            return lines.get(i++);
        }
        return "";
    }
}
