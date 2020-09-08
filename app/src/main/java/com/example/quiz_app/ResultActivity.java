package com.example.quiz_app;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity {
	Button exit,egain;

	int score1;
	TextView show,scoreTotal,login;
	PieChart mChart;
	float scoretota=0;
	float reste;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);

		Intent i=getIntent();



		exit = (Button) findViewById(R.id.bt_exit);
		egain = (Button) findViewById(R.id.bt_trAgain);
		show = (TextView) findViewById(R.id.tv_show);
		scoreTotal = (TextView) findViewById(R.id.tv_score);

		//Reference the pie chart
		mChart = (PieChart) findViewById(R.id.piechart);

		score1 = getIntent().getExtras().getInt("correct");
		//score1=getIntent().hasExtra("correct");
		// Intent ttii=getIntent();

		//   String vvv = " " +  CalculeScore.score;
		scoreTotal.setText(String.format("%d/%d",score1, 5));



		exit.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(ResultActivity.this, Login.class);
				startActivity(intent);
			}
		});

		egain.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//correct=0;
				//  CalculeScore.score=0;
				Intent intent = new Intent(ResultActivity.this, MainActivity.class);
				startActivity(intent);
			}
		});




//use the pie chart to display percentage
		mChart.setUsePercentValues(true);

		//CREAte a description
		// Description desc=new Description("a");
		//show.setText("");
		//show.setTextSize(20f);
		mChart.setDescription("");

		// mChart.setHoleRadius(25f);
		// mChart.setTransparentCircleRadius(25f);

		//create a list of pie entries and
		final List<PieEntry> value = new ArrayList<>();
		//float scoretotal=100*(score/5);


		//   float scoretotal=100*score/5;
		// Log.i("hhh", String.valueOf(scoretotal));
		// float reste=100 - scoretotal;
		Intent ti = getIntent();
		if (ti.hasExtra("correct")) {

			int op =  score1;
			switch (op) {

				case 0:
					reste = 100 - 0;
					value.add(new PieEntry(0, ""));
					value.add(new PieEntry(reste, ""));

					// v.setText("0%");
					// break;
					mChart.setCenterTextSize(40);
					mChart.setCenterText("0%");
					break;
				case 1:
					reste = 100 - 20;
					value.add(new PieEntry(20, ""));
					value.add(new PieEntry(reste, ""));
					// v.setText("0%");
					// break;
					mChart.setCenterTextSize(40);
					mChart.setCenterText("20%");
					break;
				case 2:
					reste = 100 - 40;
					value.add(new PieEntry(40, ""));
					value.add(new PieEntry(reste, ""));
					// v.setText("0%");
					// break;
					mChart.setCenterTextSize(40);
					mChart.setCenterText("40%");
					break;
				case 3:
					reste = 100 - 60;
					value.add(new PieEntry(60, ""));
					value.add(new PieEntry(reste, ""));
					// v.setText("0%");
					// break;
					mChart.setCenterTextSize(40);
					mChart.setCenterText("60%");

					break;
				case 4:
					reste = 100 - 80;
					value.add(new PieEntry(80, ""));
					value.add(new PieEntry(reste, ""));
					// v.setText("0%");
					// break;
					mChart.setCenterTextSize(40);
					mChart.setCenterText("80%");
					break;
				case 5:
					reste = 100 - 100;
					value.add(new PieEntry(100, ""));

					mChart.setCenterTextSize(40);
					mChart.setCenterText("100%");
					break;

			}
			mChart.invalidate();

//set entry value to the pi data with the title
			PieDataSet pieDataSet = new PieDataSet(value, "SCORE");
			//next we create un objet pi data passing replied dataset

			final PieData pieData = new PieData(pieDataSet);
			pieData.setValueTextSize(19f);
			pieData.setValueTextColor(Color.WHITE);


			mChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
				@Override
				public void onValueSelected(Entry e, Highlight h) {
					if (e == null)
						return;
					// Toast.makeText(Score.this, (CharSequence) value,Toast.LENGTH_LONG);
				}

				@Override
				public void onNothingSelected() {

				}
			});
//we can run and see how the cat is displayed
			mChart.setData(pieData);

			//add the color
			pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);


//to animate the pie used and passing the time failure to make
			mChart.animateXY(1400, 1400);


		}

	}


	/*
		//get rating bar object
		RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1); 
		bar.setNumStars(5);
		bar.setStepSize(0.5f);
		//get text view
		TextView t=(TextView)findViewById(R.id.textResult);
		//get the score
		Bundle b = getIntent().getExtras();
		int score= b.getInt("score");
		//display score
		bar.setRating(score);
		switch (score)
		{
			case 0: t.setText("You scored 0%, this is bad");
				break;
		case 1: t.setText("You have 20%, medium");
			break;
		case 2: t.setText("You have 40%, keep learning");
		break;
		case 3: t.setText("You have 60%, good ");
			break;
		case 4:t.setText("You have 80% very good");
		break;
		case 5:t.setText("  you have 100%, very good");
		break;
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_result, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			Intent settingsIntent = new Intent(this, QuizActivity.class);
			startActivity(settingsIntent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
*/










}
