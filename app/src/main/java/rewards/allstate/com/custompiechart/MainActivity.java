package rewards.allstate.com.custompiechart;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;


public class MainActivity extends ActionBarActivity {

    PieChart pieChart;
    LinearLayout linearLayout;
    //int[] data={6,5,8,4,7,6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int[] data={6,5,8,4,7,6};
        int[] color={Color.RED,Color.BLUE,Color.CYAN,Color.GREEN,Color.MAGENTA, Color.GREEN};
        linearLayout=(LinearLayout)findViewById(R.id.linearLayout);
        linearLayout.addView(new PieChart(this,6,data,color));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
