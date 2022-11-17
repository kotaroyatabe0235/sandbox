import java.util.ArrayList;

public class Basement {
    
    int low = 15;
    final int column = 8;

    private ArrayList<String> view = null;

    public Basement() {
        view = new ArrayList<>();
        StringBuilder strOfLow = new StringBuilder();
        // 1行分を生成
        for (int i=0; i<=column ; i++) {
            strOfLow.append("□ ");
        }
        // 指定行まで設定
        for (int i=0; i<=low; i++) {
            view.add(strOfLow.toString());
        }
    }

    public void createView() {
        for (String str : view) {
            System.out.println(str);
        }
    }
}
