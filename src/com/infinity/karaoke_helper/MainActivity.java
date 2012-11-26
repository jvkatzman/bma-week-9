package com.infinity.karaoke_helper;


import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import android.view.View.OnClickListener;



public class MainActivity extends Activity implements OnClickListener {
	
	private int intCurLineVert ;
	private int intCurLineHor ;
	private String[] songLines;
	private int songName;
	private String songTitle;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.intCurLineVert = 0;
        this.intCurLineHor = 0;
        
        WindowManager wm;
        wm = this.getWindowManager();
        Display ds = getWindowManager().getDefaultDisplay();
        int width = ds.getWidth();
        int height = ds.getHeight();
        
        if (width > height) {
			// landscaped
        	songName = R.array.Danger_man;
        	songTitle="Danger Man";
		} else {
			//portrait
			songName = R.array.Casey_jones;
			songTitle = "Casey Jones";
		}
       
        this.songLines = getResources().getStringArray(songName);
    			
	    setContentView(R.layout.activity_main);
	 //   Toast.makeText(this, "started", Toast.LENGTH_LONG).show();
	    //set up click listener for all the buttons
        View btnGetLine = findViewById(R.id.btnGetNextLine);
        btnGetLine.setOnClickListener(this);
        
        setUp();
    }

    
    public void setUp(){
		TextView textSongName = (TextView) findViewById(R.id.txtSongName);
		textSongName.setText(songTitle);
    	
    }//setUp
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnGetNextLine:
			
			int max = songLines.length;
			
		//	Toast.makeText(getApplicationContext(),max +" " +   songLines[this.intCurLineVert], Toast.LENGTH_LONG).show();
			
			TextView textSong = (TextView) findViewById(R.id.txtNextLine);
			textSong.setText(songLines[this.intCurLineVert]);
		
			if (max-1 == this.intCurLineVert) {
				this.intCurLineVert = 0;
			} else {
				this.intCurLineVert++;
			}
			
			
			//Intent i = new Intent(this,About.class);
			//startActivity(i);
			break;

		default:
			break;
		}
	}//onClick

    
}// end class
