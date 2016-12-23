package personal.givemepass.gsondemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
	private String jsonStr = "[\n" +
			"    {\n" +
			"        \"chanel\":\"FM\",\n" +
			"        \"week\":\"日\",\n" +
			"        \"start_time\":\"09:00\",\n" +
			"        \"end_time\":\"10:00\",\n" +
			"        \"program\":\"勞動聲活\",\n" +
			"        \"DJ\":\"【北市勞動局合作】\"\n" +
			"    }\n" +
			"]";

	private TextView showGSon,showString;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		showString = (TextView) findViewById(R.id.show_string);
		showGSon = (TextView) findViewById(R.id.show_GSON);

		Gson gson = new Gson();
		Type listType = new TypeToken<ArrayList<MyJsonObj>>() {}.getType();
		ArrayList<MyJsonObj> jsonArr = gson.fromJson(jsonStr, listType);
		StringBuffer sb = new StringBuffer();
		for(MyJsonObj obj : jsonArr){
			sb.append("obj chanel:" + obj.getChanelStr() + "\n");
			sb.append("obj start time:" + obj.getStartTime() + "\n");
			sb.append("obj end time:" + obj.getEndTime() + "\n");
			sb.append("obj week:" + obj.getWeekStr() + "\n");
			sb.append("obj DJ:" + obj.getDjStr() + "\n");
		}

		showString.setText(jsonStr);

		showGSon.setText(sb.toString());
	}
}
