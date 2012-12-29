package com.lzh.farmbreak;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

    Context context = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	context = this;
	
	/**进入游戏世界**/
    Button botton0 = (Button)findViewById(R.id.startGame);
    botton0.setOnClickListener(new OnClickListener() {
    
    @Override
    public void onClick(View arg0) {
	 Intent intent = new Intent(context,GameActivity.class); 
	 startActivity(intent);
    }
}); 
}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
