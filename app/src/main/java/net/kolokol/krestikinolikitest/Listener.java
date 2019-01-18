package net.kolokol.krestikinolikitest;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static net.kolokol.krestikinolikitest.MainActivity.refresh;

public class Listener implements View.OnClickListener {
    private int x = 0;
    private int y = 0;

    public Listener(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public void onClick(View view) {

        Button button = (Button) view;
        Game g = MainActivity.game;
        Player player = g.getCurrentActivePlayer();
        if (MainActivity.game.makeTurn(x, y)) {
            button.setText(player.getName());
        }
        Player winner = g.checkWinner();
        if (winner != null) {
            gameOver(winner,view.getContext());
        }
        if (g.isFieldFilled()) {
            gameOver(view.getContext());
    }
    }
    public void gameOver(Player player, Context c) {
        CharSequence text = player.getName() + " победил!";
        Toast.makeText(c, text, Toast.LENGTH_SHORT).show();
        MainActivity.game.reset();
        refresh();
    }

    public void gameOver(Context c) {
        CharSequence text = "НИЧЬЯ...";
        Toast.makeText(c, text, Toast.LENGTH_SHORT).show();
        MainActivity.game.reset();
        refresh();
    }
}