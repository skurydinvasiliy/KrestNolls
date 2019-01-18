package net.kolokol.krestikinolikitest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

public class MainActivity extends AppCompatActivity {
    public static Game game;
    private TableLayout layout;
    private static Button [][] buttons = new Button[3][3];
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        layout = (TableLayout) findViewById(R.id.main_l);
        buildGameField();
    }
   public MainActivity(){
        game = new Game();
        game.start();
   }
    private void buildGameField(){
        Square[][] field = game.getField();
        for (int i = 0, lenI = field.length; i < lenI; i++ ) {
            TableRow row = new TableRow(this);
            for (int j = 0, lenJ = field[i].length; j < lenJ; j++) {

                Button button = new Button(this);
                DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                int width = displayMetrics.widthPixels;
                int height = displayMetrics.heightPixels;
                button.setWidth((width * 32) / 100);
                button.setHeight(height / 5);
                buttons[i][j] = button;
                button.setOnClickListener(new Listener(i, j));
                row.addView(button, new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT));

            }
            layout.addView(row, new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT,
                    TableLayout.LayoutParams.WRAP_CONTENT));
    }
}
    public static void refresh() {
        Square[][] field = MainActivity.game.getField();

        for (int i = 0, len = field.length; i < len; i++) {
            for (int j = 0, len2 = field[i].length; j < len2; j++) {
                if (field[i][j].getPlayer() == null) {
                    buttons[i][j].setText("");
                } else {
                    buttons[i][j].setText(field[i][j].getPlayer().getName());
                }
            }
        }
    }
}