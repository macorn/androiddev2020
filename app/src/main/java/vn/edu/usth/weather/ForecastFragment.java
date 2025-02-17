package vn.edu.usth.weather;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class ForecastFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final int days[] = {R.string.Mon,R.string.Tue,R.string.Wed,R.string.Thu,R.string.Fri,R.string.Sat,R.string.Sun};
        ViewGroup v = (ViewGroup) inflater.inflate(R.layout.fragment_forecast,null,false);
        Random rd = new Random();
        LinearLayout linearLayout = v.findViewById(R.id.fragmentForcast);
        for(int i=0; i<10; ++i){
            View row = inflater.inflate(R.layout.weather_row,container,false);
            ((TextView)row.findViewById(R.id.day)).setText(getContext().getString(days[i%7]));
            ((TextView)row.findViewById(R.id.city)).setText("Paris");
            ((TextView)row.findViewById(R.id.temp)).setText(String.valueOf(rd.nextInt()%10+10) + "°C - " + String.valueOf(rd.nextInt()%10 +20) +"°C");
            ((ImageView)row.findViewById(R.id.weather)).setImageResource(R.drawable.daycloudyful);
            linearLayout.addView(row);
        }
        return v;
    }
}
